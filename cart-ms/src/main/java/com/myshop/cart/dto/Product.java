package com.myshop.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	private String productId;
	private String ProductName;
	private float ProductPrice;
	private String ProductDescription;

}
