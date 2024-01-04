package com.ust.app.customer1.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ust.app.customer1.Exception.CustomerNotFoundException;
import com.ust.app.customer1.model.Customer;
import com.ust.app.customer1.model.UserType;

@SpringBootTest
class CustomerServiceImplTest {
	@Autowired
	CustomerService service;
//	@BeforeEach
//	public void setUp()
//	{
//		Customer c1=new Customer(101,"anu","anu@gmail",LocalDate.of(2000,02,01),UserType.GENERAL);
//		Customer c2=new Customer(102,"ram","ram@gmail",LocalDate.of(2001,02,01),UserType.GENERAL);
//		Customer c3=new Customer(103,"umesh","umesh@gmail",LocalDate.of(2002,02,01),UserType.PREMIUM);
//		//Customer c5=new Customer(105,"ansi","ansih@gmail",LocalDate.of(2003,02,03),UserType.PREMIUM);
//		service.addCustomer(c1);
//		service.addCustomer(c2);
//		service.addCustomer(c3);
//		//service.addCustomer(c5);
//	}
//  @AfterEach
//  public void tearDown()
//  {
//	  service.deleteCustomer(101);
//	  service.deleteCustomer(102);
//	  service.deleteCustomer(103);
//  }
	@Test
	void testAddCustomer() {
		Customer c4=new Customer(104,"watson","watson@gmail",LocalDate.of(2000,02,01),UserType.GENERAL);
		Customer saved=service.addCustomer(c4);
		assertEquals(c4,saved);
	}

	@Test
	void testGetCustomer() {
		int id=101;
		
		Customer c5=service.getCustomer(id);
		assertNotNull(c5);
		assertThrows(CustomerNotFoundException.class,()->service.getCustomer(107));
		
}

	@Test
	void testUpdateCustomer() {
		Customer c9=new Customer(101,"Shalini","shalu@gmail.com",LocalDate.of(2000,11,21),UserType.GENERAL);
        Customer updated=service.updateCustomer(c9);
        assertEquals(c9,updated);
	}

	@Test
    void testDeleteCustomer() {
		service.deleteCustomer(104);
		assertThrows(CustomerNotFoundException.class,()->service.getCustomer(104));
	}

	@Test
	void testGetAllCustomer() {
		Customer c1=service.getCustomer(101);
		assertNotNull(c1);
		
	}

	@Test
	void testFindByCustomerName() {
		String name="Hari";
        String names="ram";
        //When

       Customer c6=service.findByCustomerName(names);

        //Then
        assertNotNull(c6);
        assertThrows(CustomerNotFoundException.class,()->service.findByCustomerName(name));
	}

	@Test
	void testFindByCustomerEmail() {
		  String email="ram@gmail";

	        // when
	        Customer c2 = service.findByCustomerEmail(email);

	        // then
	        assertNotNull(c2);
	        assertEquals(c2,c2);      
	}
//	@Test
//	void testFindByDobRange() {
//		fail("Not yet implemented");
//	}
//	@Test
//	void testFindIdRange() {
//		fail("Not yet implemented");
//	}

}
