package com.ust.app.customer1.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ust.app.customer1.model.Customer;



public interface CustomerRepo extends JpaRepository<Customer,Integer> {
	//jqpl
	public Optional<Customer> findByCustomerName(String CustomerName);
	@Query("from Customer where email=:email")
	public Optional<Customer> findByCustomerEmail(@Param("email") String email);

	@Query("from Customer where dob between:from and:to")
	public List<Customer> findDobRange(LocalDate from,LocalDate to);
	//native query
	@Query(value="select * from customer_data where id between :start and :end",nativeQuery=true)
	public List<Customer> findIdInRange(int start,int end);
	
}
 
