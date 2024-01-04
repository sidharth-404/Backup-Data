package com.ust.app.customer1.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;


import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ust.app.customer1.model.Customer;
import com.ust.app.customer1.model.UserType;
import com.ust.app.customer1.service.CustomerService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(value=CustomerController.class)
class CustomerControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	CustomerService service;
	
	@Test
	void testgetCustomerById() throws Exception {
		Customer c1=new Customer(104,"watson","watson@gmail",LocalDate.of(2000,02,01),UserType.GENERAL);
		int id=c1.getId();
		//when
	when(service.getCustomer(c1.getId())).thenReturn(c1);
	//then
	mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/"+id)).andExpect(status().isOk())
	.andExpect(jsonPath("$.id",Matchers.is(104)))
	.andExpect(jsonPath("$.customerName",Matchers.is("watson")))
	.andExpect(jsonPath("$.email",Matchers.is("watson@gmail")))
	.andExpect(jsonPath("$.dob",Matchers.is("2000-02-01")))
	.andExpect(jsonPath("$.type",Matchers.is("GENERAL")));
	
	}


	@Test
	void testAddCustomer() throws Exception {
		Customer c1=new Customer(105,"watson","watson@gmail",LocalDate.of(2000,02,01),UserType.GENERAL);
		//when
		when(service.addCustomer(c1)).thenReturn(c1);
	//then
	mockMvc.perform(post("/api/customers/")
	.contentType(MediaType.APPLICATION_JSON)
	.content(asJsonString(c1)))
	.andExpect(status().isCreated())
	.andExpect(jsonPath("$.id", Matchers.is(105)))
	.andExpect(jsonPath("$.customerName", Matchers.is("watson")))
	.andExpect(jsonPath("$.email", Matchers.is("watson@gmail")))
	.andExpect(jsonPath("$.dob", Matchers.is("2000-02-01")))
	.andExpect(jsonPath("$.type", Matchers.is("GENERAL")));
	

	
	}

//	@Test
//	void testGetAllCustomer() {
//		fail("Not yet implemented");
//	}
//
	//@Test
//	void testGetCustomer() {
//		fail("Not yet implemented");
//	}
//
	@Test
	void testGetCustomerByNameString() throws Exception {
		Customer c1=new Customer(104,"watson","watson@gmail",LocalDate.of(2000,02,01),UserType.GENERAL);
		String name=c1.getCustomerName();
		//when
	when(service.findByCustomerName(name)).thenReturn(c1);
	//then
	mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/name/"+name)).andExpect(status().isOk())
	.andExpect(jsonPath("$.id",Matchers.is(104)))
	.andExpect(jsonPath("$.customerName",Matchers.is("watson")))
	.andExpect(jsonPath("$.email",Matchers.is("watson@gmail")))
	.andExpect(jsonPath("$.dob",Matchers.is("2000-02-01")))
	.andExpect(jsonPath("$.type",Matchers.is("GENERAL")));
	}

//	@Test
//	void testDeleteCustomer() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUpdateCustomer() {
//		fail("Not yet implemented");
//	}
//
	@Test
	void testGetCustomerByEmail() throws Exception {
		Customer c1=new Customer(104,"watson","watson@gmail",LocalDate.of(2000,02,01),UserType.GENERAL);
		String email=c1.getEmail();
		//when
	when(service.findByCustomerEmail(email)).thenReturn(c1);
	//then
	mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/email/"+email)).andExpect(status().isOk())
	.andExpect(jsonPath("$.id",Matchers.is(104)))
	.andExpect(jsonPath("$.customerName",Matchers.is("watson")))
	.andExpect(jsonPath("$.email",Matchers.is("watson@gmail")))
	.andExpect(jsonPath("$.dob",Matchers.is("2000-02-01")))
	.andExpect(jsonPath("$.type",Matchers.is("GENERAL")));
	}
//
//	@Test
//	void testGetCustomerByNameStringString() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFindIdInRange() {
//		fail("Not yet implemented");
//	}

	// Helper Method for converting a Java Object to JSON String
	private String asJsonString(Object object) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.writeValueAsString(object);


}
}
