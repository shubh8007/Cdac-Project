package com.KrshiMantra.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.KrshiMantra.backend.entity.Admin;
import com.KrshiMantra.backend.entity.Buyer;
import com.KrshiMantra.backend.repository.AdminRepo;
@Service
@Transactional
public class AdminServImpl implements AdminServ{

	
	@Autowired
	AdminRepo admin_repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public String add_Admin(Admin admin) {
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		admin_repo.save(admin);
		return "admin added successfully";
	}

	@Override
	public void delete_AdminbyUserName(String userName) {
	admin_repo.deleteByUsername(userName);
		
	}

	@Override
	public void update_admin(String email, String firstname, String lastname, String password, String username) {
	admin_repo.updateByUsername(email, firstname, lastname, password, username);	
		
	}

	@Override
	public Optional<Admin> getAdminLogin(String username, String password) {
		
		return admin_repo.getAdminLogin(username, password);
	}

}
