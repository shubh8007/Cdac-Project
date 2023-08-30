 package com.KrshiMantra.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="buyercart")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BuyerCart 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="cartid")
	private int cartid;
	
	@Column(name="Buyer_username")
	private String buyer_username;
	
	

	private String crop;
	
	@Column(name="quantity")
	private double quantity;
	
	@Column(name="expectedprice")
	private double expectedprice;
	
	@Column(name="farmername")
	private String farmername;
	
	
	
	
	
	
}
