package com.hackthon.repository;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hackthon.model.Airline;

public interface AirlineRepo extends  JpaRepository <Airline,String> {
	@Query(value = "select * from airline where code = :code",nativeQuery = true)
	Optional<Airline> getAirlineByCode(String code);
	

}
