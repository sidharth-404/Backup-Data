package com.ust.app.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ust.app.customer.model.Customer;
import com.ust.app.customer.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@ResponseStatus(code=HttpStatus.CREATED)
	@PostMapping()
	public Customer addCustomer(@RequestBody Customer customer)
	{
		return service.addCustomer(customer);
		
	}
	@ResponseStatus(code=HttpStatus.OK)
	@GetMapping()
	public List<Customer> getAllCustomer()
	{
		return service.getAllCustomer();
	}
	
	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable int id)
	{
		return service.getCustomer(id);
		
	}
	@GetMapping("/search")
	public Customer getCustomerByName(@RequestParam("name") String name)
	{
		return service.getCustomerByName(name);
		
	}
	@DeleteMapping("/{id}")
	
	public void deleteCustomer(@PathVariable int id)
	{
		service.deleteCustomer(id);
	}
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer cutsomer)
	{
		return service.updateCustomer(cutsomer);
	}

}
