package com.hackthon.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.RouteMatcher.Route;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hackthon.dto.FlightDetails;
import com.hackthon.dto.FlightRouteDetails;
import com.hackthon.dto.GetDetailedItineraryResponse;
import com.hackthon.dto.MultiCityRouteRequestBody;
import com.hackthon.dto.MultiCityRouteResponse;
import com.hackthon.model.Airline;
import com.hackthon.model.Airports;
import com.hackthon.model.Routes;
import com.hackthon.repository.AirlineRepo;
import com.hackthon.repository.AirportRepo;
import com.hackthon.repository.RouteRepository;
import com.hackthon.service.FlightService;
import com.hackthon.service.JsonFileReader;

@RestController
@CrossOrigin("*")
public class AirlineController {

	@Autowired
	private JsonFileReader jsonFile;
	@Autowired
	FlightService flightService;
	


      @Autowired
	  private AirlineRepo repo;
      @Autowired
      private AirportRepo airportRepo;
      @Autowired
      private RouteRepository routeRepo;
	 
//	    @PostMapping("/addBook")
//	    public String saveBook(@RequestBody Airline airline){
//	        repo.save(airline);
//	       
//	        return "Added Successfully";
//	    }
//	    @GetMapping("/all")
//	    public List<Airline> getBooks() {
//	       
//	        return repo.findAll();
      
    @PostMapping("/multicity")
 	public List<MultiCityRouteResponse> fetchMulticityAirlineRoutes(
 			@RequestBody MultiCityRouteRequestBody multiCityReqBody) {
 		return flightService.getMultiCityRouteSearch(multiCityReqBody);
 	}
    
    
      
     @PostMapping("/route")
  	public List<Routes> getRoute(@RequestBody FlightDetails model){
    	 List<Routes> data = new ArrayList<>();
 		List<Boolean> category = Arrays.asList(false, false, false);
 		if (model.getClassType().equalsIgnoreCase("Business")) {
 			category.set(0, true);
 		} else if (model.getClassType().equalsIgnoreCase("Economy")) {
 			category.set(1, true);
 		} else if (model.getClassType().equalsIgnoreCase("first")) {
 			category.set(2, true);
 		}
 		List<String> dayStatus = Arrays.asList("no", "no", "no", "no", "no", "no", "no");
 		int day=model.getDate().getDayOfWeek().getValue();
 		dayStatus.set(day - 1, "yes");
 		for(Routes r:routeRepo.findAll()) {

  

 			if((r.getIataFrom().equalsIgnoreCase(model.getIataF())) && (r.getIataTo().equalsIgnoreCase(model.getIataT())) ) {

 				if((r.getDay1().equals(dayStatus.get(0)) || r.getDay2().equals(dayStatus.get(1))
 						|| r.getDay3().equals(dayStatus.get(2)) || r.getDay4().equals(dayStatus.get(3))
 						|| r.getDay5().equals(dayStatus.get(4)) || r.getDay6().equals(dayStatus.get(5))
 						|| r.getDay7().equals(dayStatus.get(6))&&
 						(r.isClassBusiness() == category.get(0) || r.isClassEconomy() == category.get(1)
 								 || r.isClassFirst() == category.get(2)))){
 					data.add(r);

 				}



 			}
 		}
 		return data;

 	}
  		
  		//---------------------------------------------------
     
     
     @PostMapping("/route/airport")
  	public List<FlightRouteDetails> getRouteModern(@RequestBody FlightDetails model){
    	 List<FlightRouteDetails> data = new ArrayList<>();
 		List<Boolean> category = Arrays.asList(false, false, false);
 		if (model.getClassType().equalsIgnoreCase("Business")) {
 			category.set(0, true);
 		} else if (model.getClassType().equalsIgnoreCase("Economy")) {
 			category.set(1, true);
 		} else if (model.getClassType().equalsIgnoreCase("first")) {
 			category.set(2, true);
 		}
 		List<String> dayStatus = Arrays.asList("no", "no", "no", "no", "no", "no", "no");
 		int day=model.getDate().getDayOfWeek().getValue();
 		dayStatus.set(day - 1, "yes");
 		for(Routes r:routeRepo.findAll()) {

  

 			if((r.getIataFrom().equalsIgnoreCase(model.getIataF())) && (r.getIataTo().equalsIgnoreCase(model.getIataT())) ) {

 				if((r.getDay1().equals(dayStatus.get(0)) || r.getDay2().equals(dayStatus.get(1))
 						|| r.getDay3().equals(dayStatus.get(2)) || r.getDay4().equals(dayStatus.get(3))
 						|| r.getDay5().equals(dayStatus.get(4)) || r.getDay6().equals(dayStatus.get(5))
 						|| r.getDay7().equals(dayStatus.get(6))&&
 						(r.isClassBusiness() == category.get(0) || r.isClassEconomy() == category.get(1)
 								 || r.isClassFirst() == category.get(2)))){
 					Airline air=repo.getAirlineByCode(r.getAirLineIata()).get();
 					
 					FlightRouteDetails demmy=new FlightRouteDetails(r,air);
 					data.add(demmy);

 				}



 			}
 		}
 		return data;

 	}
     
     
     
     
     
     
     
     
     
     
     
     //--------------------------------------------------
     
	  
	 @GetMapping("/airline/getAll")
    public ResponseEntity<List<Airline>> getAllAirline()
		{
			return ResponseEntity.ok().body(repo.findAll());
		}
		
	 @GetMapping("/airline/getByCode/{code}")
	 public ResponseEntity<Airline> getAirline(@PathVariable String code)
	 {
		 return ResponseEntity.ok().body(repo.getAirlineByCode(code).get());
	 }
	 
	 @GetMapping("/airport/getByCode/{code}")
	 public ResponseEntity<Airports> getAirport(@PathVariable String code)
	 {
		 return ResponseEntity.ok().body(airportRepo.getAirportByCode(code).get());
	 }
	 
//	 @GetMapping("/airport/autocomplete/{city}")
//	 public ResponseEntity<List<Map>> autoCompleteSearch(@PathVariable String city)
//	 {
//		Optional<List<Airports>> airports=airportRepo.getAirportCodeByCityName(city);
//		Map<String,String> l1=new HashMap<>();
//		List<Map> map=new ArrayList<>();
//		for(Airports s:airports.get())
//		{
//			l1.put("code",s.getCode());
//			l1.put("city",s.getCity());
//			map.add(l1);
//		}
//		
//		 return ResponseEntity.ok().body(map);
//	 }
		@GetMapping("/suggest/{starting}")
		public ResponseEntity<List<Airports>> getAirportSuggestions(@PathVariable String starting) {
			
			return ResponseEntity.ok().body(airportRepo.getAirportSuggestions(starting).get());
		}


	 

	  
	 

	@GetMapping("/airlines")
	public List<Airline> getDataFromJsonFile() {
		return jsonFile.readJsonFile();
	}
	@GetMapping("/routes")
	public List<Routes> getAirports()
	{
		return jsonFile.getAllAirlineRoutes();
	}

//	@GetMapping("/airlines")
//	public String getUser() {
//		String uri = "https://cdn.jsdelivr.net/gh/besrourms/airlines@latest/airlines.json";
//		RestTemplate restTemplate = new RestTemplate();
//
//		String data = restTemplate.getForObject(uri, String.class);
//		// System.out.println("User: " + user);
//
//		return data;
//	}

	@GetMapping("/airport")
	public List<Airports> getAirport()
	{
		return jsonFile.readJsonAirportFile();
	}
	
	@PostMapping("/getdetaileditinerary")
	public List<GetDetailedItineraryResponse> fetchDetailedItinerary(@RequestBody List<Integer> routeIds){
		return flightService.getDetailedItinerary(routeIds);
	}
	
	
	
}
