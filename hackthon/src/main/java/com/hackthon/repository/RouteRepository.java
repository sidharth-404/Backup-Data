package com.hackthon.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hackthon.model.Routes;

public interface RouteRepository extends JpaRepository<Routes,Integer> {
	
	@Query(value = "SELECT * FROM routes WHERE iata_from= :iataFrom AND iata_to=:iataTo", nativeQuery = true)
	public Optional<List<Routes>> getFlightByDetails(@Param("iataFrom") String iataFrom,@Param("iataTo") String iataTo );
	
	@Query(value="select * FROM routes WHERE iata_from = :arrival AND iata_to = :destination AND air_line_iata IN :airlines",nativeQuery=true)
	public List<Routes> searchRouteForGivenSourceDestinationAirlines(
	    @Param("arrival") String arrival,
	    @Param("destination") String destination,
	    @Param("airlines") List<String> airlines
	);
	
	

}
