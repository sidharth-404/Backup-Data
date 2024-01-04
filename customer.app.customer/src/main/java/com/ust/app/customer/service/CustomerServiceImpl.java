package com.ust.app.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.app.customer.model.Customer;
import com.ust.app.customer.repository.CustomerRepo;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepo repo;
	

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return repo.addCustomer(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return repo.getCustomer(id);
	}

	@Override
	public Customer updateCustomer(Customer cutsomer) {
		// TODO Auto-generated method stub
		return repo.updateCustomer(cutsomer);
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		repo.deleteCustomer(id);
		
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return repo.getAllCustomer();
	}

	@Override
	public Customer getCustomerByName(String name) {
		// TODO Auto-generated method stub
		return repo.getCustomerByName(name);
	}

}
