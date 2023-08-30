package com.KrshiMantra.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KrshiMantra.backend.entity.Admin;
import com.KrshiMantra.backend.entity.Buyer;
import com.KrshiMantra.backend.entity.Farmer;
import com.KrshiMantra.backend.entity.Order;
import com.KrshiMantra.backend.entity.Product;
import com.KrshiMantra.backend.service.AdminServ;
import com.KrshiMantra.backend.service.BuyerServ;
import com.KrshiMantra.backend.service.FarmerServ;
import com.KrshiMantra.backend.service.OrderServ;
import com.KrshiMantra.backend.service.ProductServ;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

	@Autowired
	AdminServ adminserv;

	@Autowired
	BuyerServ buyerserv;
	
	@Autowired
	FarmerServ farmerserv;
	@Autowired
	ProductServ productServ;
	@Autowired
	OrderServ orderserv;
	

	
	@PostMapping("/login")
	public ResponseEntity<?> Adminlogin(@RequestBody Admin admin){
		try {
			String username=admin.getUser_name();
			String password=admin.getPassword();
			Optional<Admin> adminlogin=adminserv.getAdminLogin(username, password);
			if(!adminlogin.isEmpty()) {
				return new ResponseEntity<>(username, HttpStatus.OK);
			}else
			{
				return new ResponseEntity<>("username or password invalid", HttpStatus.UNAUTHORIZED);
			}
			
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}

	
	
	@GetMapping("/getbuyers")
	public ResponseEntity<?> getall_buyers(){
		try {
			List<Buyer> allBuyers = buyerserv.getAllBuyers();
			if(!allBuyers.isEmpty()) {
				return new ResponseEntity<>(allBuyers,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(allBuyers,HttpStatus.NOT_FOUND);
				
			}
		} catch (Exception e) {
			//  handle exception
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/getfarmers")
	public ResponseEntity<?> getall_Farmers(){
		try {
			List<Farmer> allfarmers = farmerserv.getAllFarmers();
			if(!allfarmers.isEmpty()) {
				return new ResponseEntity<>(allfarmers,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(allfarmers,HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			//  handle exception
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/products")
	public ResponseEntity<?> getallproducts(){
		try {
			List<Product> products=productServ.getAllproducts();
			if(!products.isEmpty()) {
				return new ResponseEntity<>(products, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
	}
	@GetMapping("/orders")
	public ResponseEntity<?> getallOrders(){
		try {
			List<Order> orders=orderserv.getBuyerOrder();
			if(!orders.isEmpty()) {
				return new ResponseEntity<>(orders, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(orders, HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
	}
}
