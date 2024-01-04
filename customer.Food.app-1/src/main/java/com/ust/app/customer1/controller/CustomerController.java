package com.ust.app.customer1.controller;

import java.time.LocalDate;
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

import com.ust.app.customer1.model.Customer;
import com.ust.app.customer1.service.CustomerService;



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
	@GetMapping("/name/{name}")
	public Customer getCustomerByName(@PathVariable String name)
	{
		return service.findByCustomerName(name);
		
	}
	@DeleteMapping("/{id}")
	
	public void deleteCustomer(@PathVariable int id)
	{
		service.deleteCustomer(id);
	}
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	@PutMapping
	public Customer updateCustomer(@RequestBody Customer cutsomer)
	{
		return service.updateCustomer(cutsomer);
	}
	@GetMapping("/email/{email}")
	public Customer getCustomerByEmail(@PathVariable String email)
	{
		return service.findByCustomerEmail(email);
		
	}
     
	@GetMapping("/dob/from/{from}/to/{to}")
	public List<Customer> getCustomerByName(@PathVariable String from,@PathVariable String to )
	{
		return service.findByDobRange(LocalDate.parse(from),LocalDate.parse(to));
		
	}
	@GetMapping("/id/from/{from}/to/{to}")
	public List<Customer> findIdInRange(@PathVariable int from,@PathVariable int to )
	{
		return service.findIdRange(from,to);
		
	}
}
