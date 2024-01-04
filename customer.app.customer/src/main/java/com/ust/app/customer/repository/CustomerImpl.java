package com.ust.app.customer.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ust.app.customer.model.Customer;

@Repository
public class CustomerImpl implements CustomerRepo {
	List<Customer> customers=new ArrayList<>();

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customers.add(customer);
		
		return customer;
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
	    
		for(Customer c:customers)
		{
			if(c.getId()==id)
				
			{
				return c;
			}
		}
		
		return null;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		int id=customer.getId();
        Customer cus=getCustomer(id);
        cus.setId(customer.getId());
        cus.setCustomerName(customer.getCustomerName());
        cus.setEmail(customer.getEmail());
        cus.setDob(customer.getDob());
        customers.add(cus);
        customers.remove(customer);
        return cus;
		
	
	}
		// TODO Auto-generated method stub
		

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
	   Customer c=getCustomer(id);
	   customers.remove(c);
		
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customers;
	}

	@Override
	public Customer getCustomerByName(String name) {
		// TODO Auto-generated method stub
		for(Customer c:customers)
		{
			if(c.getCustomerName().equalsIgnoreCase(name))
			{
				return c;
			}
		}
		return null;
	}
    
}
