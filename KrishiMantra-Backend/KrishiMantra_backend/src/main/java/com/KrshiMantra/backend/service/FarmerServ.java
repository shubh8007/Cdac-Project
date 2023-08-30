package com.KrshiMantra.backend.service;

import java.util.List;
import java.util.Optional;

import com.KrshiMantra.backend.entity.Farmer;

public interface FarmerServ {
	Optional<Farmer> getbyId(int id);

	Farmer getByUsername(String username);

	 int getFarmerIdFromName(String username);
	
	void deleteFarmer(int id);

	void addFarmer(Farmer farmer);

	void updateById(String firstname, String lastname, String email, String address, String contact, String password,
			String username, int id);

	void updateByUserName(String firstname, String lastname, String email, String address, String contact,
			String password, String username);

	List<Farmer> getAllFarmers();
	Farmer findByEmail(String email);

	int getFarmerId(String username);

	void deleteByusername(String username);

	Optional<Farmer> getFarmerLogin(String username, String password);

	void updatepassword(String username, String newpassword);
	void forgotPassword(Farmer farmer);
}
