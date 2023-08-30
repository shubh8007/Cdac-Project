package com.KrshiMantra.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="admins")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Admin 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="aid")
	private int aid;

	@Column(name="firstname" ,nullable = false)
	private String firstname;
	
	@Column(name="lastname",nullable = false)
   private String lastname;
	@Email
	@Column(name="email" ,unique = true)
	private String email;
	
	@NotBlank(message = "Password is mandatory")
	@Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")
	@Column(name="password",nullable = false)
	private String password;
	
	@NotBlank(message = "username is mandatory")
	@Column(name="user_name",unique = true,nullable = false)
	private String user_name;
	
	
}
