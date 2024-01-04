package com.ust.app.customer1.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customer_data")
public class Customer {
	@Id

	private int id;
	@Column(name="customer_name",length=50,nullable=false)
	private String customerName;
	
	private String email;
	private LocalDate dob;
	
	//@Enumerated(EnumType.STRING)
	private UserType type;
	

}
