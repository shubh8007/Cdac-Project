package com.KrshiMantra.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KrshiMantra.DTO.AuthResp;
import com.KrshiMantra.DTO.FarmerLoginDto;
import com.KrshiMantra.backend.entity.Farmer;
import com.KrshiMantra.backend.entity.Order;
import com.KrshiMantra.backend.entity.Product;
import com.KrshiMantra.backend.service.EmailService;
import com.KrshiMantra.backend.service.FarmerServ;
import com.KrshiMantra.backend.service.OrderServ;
import com.KrshiMantra.backend.service.ProductServ;
import com.KrshiMantra.jwtUtils.JwtUtils;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/farmer")

public class FarmerController {
	@Autowired
	ProductServ productserv;
	@Autowired
	FarmerServ farmerserv;
	@Autowired
	OrderServ orderserv;
	@Autowired
	private JwtUtils utils;
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private com.KrshiMantra.backend.service.DaoBasedUserDetailsService DaoBasedUserDetailsService;
@Autowired
EmailService emailserv;
	@PostMapping("/login")
	public ResponseEntity<?> Farmerlogin(@RequestBody FarmerLoginDto farmer) {
		
		UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(farmer.getUser_name(), farmer.getPassword());
		
		try {
			Authentication authDetails=manager.authenticate(authToken);
			
			Farmer farmer1=farmerserv.getByUsername(authDetails.getName());
			String generateJwtToken = utils.generateJwtToken(authDetails);
			System.out.println(generateJwtToken);
			
		return ResponseEntity.ok(new AuthResp("auth successful!",generateJwtToken,farmer1));
		
//		try {
//			String username = farmer.getUser_name();
//			String password = farmer.getPassword();
//			Optional<Farmer> farmerlogin = farmerserv.getFarmerLogin(username, password);
//			if (!farmerlogin.isEmpty()) {
//				return new ResponseEntity<>(username, HttpStatus.OK);
//			} else {
//				return new ResponseEntity<>("username or password invalid", HttpStatus.UNAUTHORIZED);
//			}

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
//		UserDetails loadUserByUsername = DaoBasedUserDetailsService.loadUserByUsername(farmer.getUser_name());
//		return ResponseEntity.ok(new AuthResp("auth successful!",utils.generateJwtToken(loadUserByUsername),farmer));
//	
	}

	@GetMapping("/{username}")
	public Farmer getFarmer(@PathVariable String username) {
		System.out.println("in get controller");
		return farmerserv.getByUsername(username);
	}

	@DeleteMapping("/delete/{username}")
	public String deletebyId(@PathVariable String username) {
		try {
			int id = farmerserv.getFarmerId(username);
			List<Product> products = productserv.findMyProduct(new Farmer(id));
			if (products.isEmpty()) {
				Optional<Farmer> farmer = farmerserv.getbyId(id);
				if (farmer.isPresent()) {
					farmerserv.deleteFarmer(id);
					System.out.println("in controller");
					return "id delete with id=" + id;

				} else {
					return "Farmer is not found";
				}
			} else {
				productserv.deleteproductById(new Farmer(id));
				Optional<Farmer> farmer = farmerserv.getbyId(id);
				if (farmer.isPresent()) {
					farmerserv.deleteFarmer(id);
					System.out.println("in controller");
					return "id delete with id=" + id;

				} else {
					return "Farmer is not found";
				}
			}

		} catch (Exception e) {
			return "" + e.getMessage();
		}

	}

	@PostMapping("/add")
	public String addFarmer(@Valid @RequestBody Farmer farmer, BindingResult bind) {
		try {
			farmerserv.addFarmer(farmer);
			String email=farmer.getEmail();
			emailserv.sendEmail("krishimantra8007@gmail.com", email, "Welcome to KRISHIMANTRA", "you are successfully registerd to KRISHIMANTRA with username="+farmer.getUser_name()+" and password="+farmer.getPassword());
			return "data added";
		} catch (Exception e) {

			if (bind.hasErrors()) {
				String message = bind.getFieldError().getDefaultMessage();
				return message;
			}

		}
		return "duplicate email or username";
	}

//	@PutMapping("/updateById/{id}")
//	public  String updateAll(@Valid @RequestBody Farmer farmer, @PathVariable int id) {
//	try{
//		
//		Optional< Farmer> farmer1=farmerserv.getbyId(id);
//		if(farmer1.isPresent()) {
//	farmerserv.updateById(farmer.getFirstname(), farmer.getLastname(), farmer.getEmail(), farmer.getAddress(), farmer.getContact(), farmer.getPassword(),farmer.getUser_name(),id);   
//	return "update succesfully";
//		}
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "Id is not Valid";
//	}
	@PutMapping("/update/{username}")
	public String updateAll(@Valid @RequestBody Farmer farmer, @PathVariable String username) {
		try {
			  Farmer oldfarmer = farmerserv.getByUsername(username);
			if (oldfarmer!=null) {
				farmerserv.updateByUserName(farmer.getFirstname(), farmer.getLastname(), farmer.getEmail(),
						farmer.getAddress(), farmer.getContact(), farmer.getPassword(), username);
				return "update succesfully";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "User is not Valid";
	}

	@GetMapping("/orders/{username}")
	public ResponseEntity<?> getAllOrder(@PathVariable String username) {
		try {
			int fid = farmerserv.getFarmerId(username);
			List<Order> list = orderserv.getFarmerOrder(fid);
			if (!list.isEmpty()) {
				return new ResponseEntity<>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/forgot-password")
	public ResponseEntity<?> forgotpassword(@RequestBody Farmer farmer) {
		try {
//			String username = farmer.getUser_name();
//			String newpassword = farmer.getPassword();

			farmerserv.forgotPassword(farmer);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/orders/change-status")
	public ResponseEntity<?> changestatus(@RequestBody Order order) {
		try {

			int oid = order.getOid();
			System.out.println("oid"+oid);
			int fid = order.getFarmer().getFid();
			System.out.println("fid="+fid);
			String crop = order.getCrop_category();
			System.out.println("crop:"+crop);
			double quantityAvailable = productserv.availableQuantity(fid, crop);
			System.out.println(quantityAvailable);
			double quatitytOrdered = order.getQuantity();
			System.out.println(quatitytOrdered);
			double quantityRemains = (quantityAvailable) - (quatitytOrdered);
			if (quantityRemains < 0) {
				quantityRemains = 0;
			}
			if (quantityRemains == 0) {
				productserv.deleteQuantityCompletly(fid, crop);
			} else {
				productserv.deductQuantity(fid, quantityRemains, crop);
			}
                 orderserv.changeStatus(oid);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
