package com.KrshiMantra.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="oid")
	private int oid;
	
	@ManyToOne
	@JoinColumn(name="fid")
	private Farmer farmer;
	
	
	@Column(name= "crop_category")
	private String crop_category;
	
	@Column(name ="quantity")
	private double quantity;
	
	@Column(name="total_amount")
	private double total_amount;
	
	@Column(name="status")
	private String status;
	

	@ManyToOne
	@JoinColumn(name="bid")
	private Buyer buyer;


	
	
}
