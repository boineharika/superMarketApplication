package com.learning.supermarket.freshmarket.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="up_coming_products")
public class UpComingProducts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String productType;
	private String productName;
	private float productPrice;
	private String priceType;
	private String productCode;
	private String status;

	

}
