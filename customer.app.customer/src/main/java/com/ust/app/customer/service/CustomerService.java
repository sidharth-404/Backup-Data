package com.ust.app.customer.service;

import java.util.List;

import com.ust.app.customer.model.Customer;

public interface CustomerService {
	public Customer addCustomer(Customer customer);
	 public Customer getCustomer(int id);
	 public Customer updateCustomer(Customer cutsomer);
	 public void deleteCustomer(int id);
	 public List<Customer> getAllCustomer();
	 public Customer getCustomerByName(String name);
	

}
