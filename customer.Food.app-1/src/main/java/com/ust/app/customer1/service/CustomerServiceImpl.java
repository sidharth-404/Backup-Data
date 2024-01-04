package com.ust.app.customer1.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.app.customer1.Exception.CustomerNotFoundException;
import com.ust.app.customer1.Exception.DuplicateCustomerException;
import com.ust.app.customer1.model.Customer;
import com.ust.app.customer1.repository.CustomerRepo;


@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepo repo;
	

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		for(Customer m:repo.findAll())
		{
			if(m.getId()==customer.getId())
			{
				throw new DuplicateCustomerException("Dupliacte customer");
			}
		}
		return repo.save(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer not found"));	
		}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return repo.save(customer);
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
//		repo.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer not found"));
//		repo.deleteById(id);
		if(!repo.existsById(id))
		{
			throw new CustomerNotFoundException("Customer not found");
		}
		repo.deleteById(id);
		
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Customer findByCustomerName(String name) {
		// TODO Auto-generated method stub
		return repo.findByCustomerName(name).orElseThrow(()->new CustomerNotFoundException("Customer not found"));
	}

	@Override
	public Customer findByCustomerEmail(String email) {
		// TODO Auto-generated method stub
		return repo.findByCustomerEmail(email).get();
	}

	@Override
	public List<Customer> findByDobRange(LocalDate from, LocalDate to) {
		// TODO Auto-generated method stub
		return repo.findDobRange(from, to);
	}

	@Override
	public List<Customer> findIdRange(int start, int end) {
		// TODO Auto-generated method stub
		return repo.findIdInRange(start, end);
	}

}
