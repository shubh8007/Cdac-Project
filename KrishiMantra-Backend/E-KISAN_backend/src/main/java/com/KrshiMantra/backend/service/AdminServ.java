package com.KrshiMantra.backend.service;

import java.util.Optional;

import com.KrshiMantra.backend.entity.Admin;

public interface AdminServ {
	String add_Admin(Admin admin);

	void delete_AdminbyUserName(String userName);

	void update_admin(String email, String firstname, String lastname, String password, String username);

	Optional<Admin> getAdminLogin(String username, String password);
}
