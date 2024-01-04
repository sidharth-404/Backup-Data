package com.ust.app.customer1.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ust.app.customer1.Exception.CustomerNotFoundException;
import com.ust.app.customer1.Exception.DuplicateCustomerException;
import com.ust.app.customer1.model.Customer;
import com.ust.app.customer1.model.UserType;
import com.ust.app.customer1.repository.CustomerRepo;
@ExtendWith(MockitoExtension.class)
class CustomerServiceImplUnitTest {
	@Mock
	private CustomerRepo repo;
	@InjectMocks
	CustomerServiceImpl service;
//
	@Test
	void testAddCustomer() {
		Customer c1=new Customer(100,"watson","watson@gmail",LocalDate.of(2000,02,01),UserType.GENERAL);
		Customer c2=new Customer(109,"emma","emma@gmail",LocalDate.of(2000,10,11),UserType.GENERAL);
		//when
		when(repo.save(c1)).thenReturn(c1);
		when(repo.save(c2)).thenThrow(new DuplicateCustomerException("duplicate customer"));
		Customer savedCustomer=service.addCustomer(c1);
		//then
		assertEquals(c1,savedCustomer);
		assertThrows(DuplicateCustomerException.class,()->service.addCustomer(c2));
		verify(repo,times(1)).save(c1);
		verify(repo,times(1)).save(c2);

		
	}


	@Test
	void testGetCustomer() {
		
	
		int id=100;
		int id2=102;
		Customer c1=new Customer(100,"watson","watson@gmail",LocalDate.of(2000,02,01),UserType.GENERAL);
		when(repo.findById(id)).thenReturn(Optional.of(c1));
		when(repo.findById(id2)).thenThrow(new CustomerNotFoundException("Customer not found"));
		assertEquals(c1,service.getCustomer(id));
		assertThrows(CustomerNotFoundException.class,()->service.getCustomer(id2));
		verify(repo,times(1)).findById(id);
		
		verify(repo,times(1)).findById(id2);
	}

	

		


//
//	@Test
//	void testUpdateCustomer() {
//		Customer c9=new Customer(101,"Shalini","shalu@gmail.com",LocalDate.of(2000,11,21),UserType.GENERAL);
//        Customer updated=service.updateCustomer(c9);
//        assertEquals(c9,updated);
//	}
//////
    @Test
    void testDeleteCustomer() {
    	int id1=101;
    	int id2=232;
    	//when
    	when(repo.existsById(id1)).thenReturn(true);
    	when(repo.existsById(id2)).thenReturn(false);
    	//then
    assertDoesNotThrow(()->service.deleteCustomer(id1));
    assertThrows(CustomerNotFoundException.class,()->service.deleteCustomer(id2));
    //verify
    verify(repo,times(1)).deleteById(id1);
    verify(repo,times(1)).existsById(id2);
    
    	
		
       }
    

	@Test
	void testGetAllCustomer() {
		Customer c1=new Customer(100,"watson","watson@gmail",LocalDate.of(2000,02,01),UserType.GENERAL);
		when(repo.findById(100)).thenReturn(Optional.of(c1));
		assertEquals(c1,service.getCustomer(100));
		verify(repo,times(1)).findById(100);
	}

	@Test
	void testFindByCustomerName() {
		String name="watson";
		String name2="maya";
		Customer c1=new Customer(100,"watson","watson@gmail",LocalDate.of(2000,02,01),UserType.GENERAL);
		when(repo.findByCustomerName(name)).thenReturn(Optional.of(c1));
		when(repo.findByCustomerName(name2)).thenThrow(new CustomerNotFoundException("Customer not found"));
		assertEquals(c1,service.findByCustomerName(name));
		assertThrows(CustomerNotFoundException.class,()->service.findByCustomerName(name2));
		verify(repo,times(1)).findByCustomerName(name);
		verify(repo,times(1)).findByCustomerName(name2);
	}
	
	
  @Test	
   void testFindByCustomerEmail() {
	  String email="watson@gmail";
	  Customer c1=new Customer(100,"watson","watson@gmail",LocalDate.of(2000,02,01),UserType.GENERAL);
	  when(repo.findByCustomerEmail(email)).thenReturn(Optional.of(c1));
	  assertEquals(c1,service.findByCustomerEmail(email));
		verify(repo,times(1)).findByCustomerEmail(email);
	  
    
}
}

////
////	@Test
////	void testFindByDobRange() {
////		fail("Not yet implemented");
////	}
////
////	@Test
////	void testFindIdRange() {
////		fail("Not yet implemented");
////	}
//
//}
