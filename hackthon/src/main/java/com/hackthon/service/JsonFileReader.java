package com.hackthon.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackthon.model.Airline;
import com.hackthon.model.Airports;
import com.hackthon.model.Routes;
import com.hackthon.repository.AirlineRepo;
import com.hackthon.repository.AirportRepo;
import com.hackthon.repository.RouteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class JsonFileReader {
	@Autowired
	AirlineRepo airlineRepo;
	@Autowired
	AirportRepo airportRepo;
	@Autowired
	RouteRepository routeRepo;
	
    public List<Airline> readJsonFile() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Replace "example.json" with your JSON file's path
            File jsonFile = new File("C:\\JAVA_BATCH_2\\Hackthon\\airlines.json");
            List<Airline> airlines = objectMapper.readValue(jsonFile, new TypeReference<List<Airline>>() {});
            for(Airline a:airlines)
            {
            	airlineRepo.save(a);
            }

            // Now, you have a list of Airline objects
          return airlines;
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately
           return null;
        }
    }
    
    public List<Airports> readJsonAirportFile() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Replace "example.json" with your JSON file's path
            File airportFile = new File("C:\\JAVA_BATCH_2\\Hackthon\\airports.json");
            List<Airports> airports = objectMapper.readValue(airportFile, new TypeReference<List<Airports>>() {});
            for(Airports p:airports)
            {
            	
             airportRepo.save(p);
            }

            // Now, you have a list of Airline objects
          return airports;
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately
           return null;
        }
}
    
    public List<Routes> getAllAirlineRoutes() {
		List<Routes> dataList = new ArrayList<>();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			// Specify the path to your JSON file
			File jsonFile = new File("C:\\JAVA_BATCH_2\\Hackthon\\routes.json");

 

			// Read JSON data into a List of MyJsonObject
			dataList = objectMapper.readValue(jsonFile, new TypeReference<List<Routes>>() {
			});

 
//
//			// Now you can work with the 'dataList' which contains a list of JSON objects.
			for (Routes obj : dataList) {
				routeRepo.save(obj);
				
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataList;

 

	}
    
    
    
    
}
