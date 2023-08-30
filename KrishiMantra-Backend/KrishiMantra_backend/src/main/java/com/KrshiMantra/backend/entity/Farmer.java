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
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="farmers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Farmer 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fid")
	private int fid;
	 

	 @NotBlank(message = "Firstname is mandatory")
	@Column(name="firstname",length = 20,nullable = false)
	private String firstname;
	
	
	 @NotBlank(message = "Lastname is mandatory")
		@Column(name="lastname",length = 20,nullable = false)
	private String lastname;
	

	 @Size(max=10,min=10,message = "size must be less than or equal to 10")
		@Column(name="contact",nullable = false )
	private String contact;
	
	@Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	@Column(name="email",nullable=true)
	private String email;
	

	@NotBlank(message = "Password is mandatory")
	@Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")
	@Column(name="password",nullable = false)
	private String password;

	@NotBlank(message = "Address is mandatory")
	@Column(name="address",nullable = false)
	private String address;
	
   
	@NotBlank(message = "Enter username")
	@Column(name="user_name",length = 30,nullable  = false,unique = true)
	 private String user_name;


	public Farmer(int fid) {
		this.fid=fid;
	}

}
