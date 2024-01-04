package com.ust.app.customer1.service;

import java.time.LocalDate;
import java.util.List;

import com.ust.app.customer1.model.Customer;



public interface CustomerService {
	public Customer addCustomer(Customer customer);
	 public Customer getCustomer(int id);
	 public Customer updateCustomer(Customer cutsomer);
	 public void deleteCustomer(int id);
	 public List<Customer> getAllCustomer();
	 public Customer findByCustomerName(String name);
	 public Customer findByCustomerEmail(String email);
	public List<Customer> findByDobRange(LocalDate from,LocalDate to);
	 public List<Customer> findIdRange(int start,int end);
	

}
