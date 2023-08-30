package com.KrshiMantra.backend.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.KrshiMantra.backend.entity.Buyer;


@SuppressWarnings("serial")
//@ToString
public class CustomUserDetailsBuyer implements UserDetails {
	@Override
	public String toString() {
		return buyer.toString();
	}

	private Buyer buyer;

	
	public CustomUserDetailsBuyer(Buyer buyer) {
		super();
		this.buyer = buyer;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// Meaning : This method should ret Collection(List) of granted authorities ,
		// for a specific user --which will be later stored in Auth obj
		// SimpleGrantedAuthority(String roleName) imple GrantedAuthority
		// UserEntity ---> Role
		List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
		list.add(new SimpleGrantedAuthority(buyer.getUser_name()));
		return list;
		/*
		 * user.getRole() // Set<Role> .stream() // Stream<Role> .map(role -> new
		 * SimpleGrantedAuthority(role.getRoleName().name())) //
		 * Stream<SimpleGrantedAuthority> .collect(Collectors.toList());
		 */
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return buyer.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return buyer.getUser_name();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
