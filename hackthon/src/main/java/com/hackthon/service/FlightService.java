package com.hackthon.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hackthon.Exception.CategoryNotFoundException;
import com.hackthon.dto.GetDetailedItineraryResponse;
import com.hackthon.dto.MultiCityRouteRequestBody;
import com.hackthon.dto.MultiCityRouteResponse;
import com.hackthon.dto.RouteInput;
import com.hackthon.model.Airline;
import com.hackthon.model.Airports;
import com.hackthon.model.Routes;
import com.hackthon.repository.AirlineRepo;
import com.hackthon.repository.RouteRepository;

@Service
public class FlightService {
	@Autowired
	AirlineRepo airlineRepo;
	@Autowired
	RouteRepository routeRepo;
	@Autowired
	RestTemplate airportConfig;
	
	public List<GetDetailedItineraryResponse> getDetailedItinerary(List<Integer> routeId) {
		List<GetDetailedItineraryResponse> itineraryList = new ArrayList<>();
		for (int id : routeId) {

 

			Routes getRoute = routeRepo.findById(id).get();
			String airlineIata = getRoute.getAirLineIata();
			String airportToIata = getRoute.getIataTo();
			String airportFromIata = getRoute.getIataFrom();
			Airline getAirline = airportConfig
					.getForObject("http://localhost:8000/airline/getByCode/" + airlineIata, Airline.class);
			Airports getAirportTo = airportConfig
					.getForObject("http://localhost:8000/airport/getByCode/" + airportToIata, Airports.class);
			Airports getAirportFrom = airportConfig
					.getForObject("http://localhost:8000/airport/getByCode/" + airportFromIata, Airports.class);
			GetDetailedItineraryResponse itineraryResponse = new GetDetailedItineraryResponse(id, getAirportFrom,
					getAirportTo, getAirline);
			itineraryList.add(itineraryResponse);
		}

 

		return itineraryList;
	}
	
	
	public List<MultiCityRouteResponse> getMultiCityRouteSearch(MultiCityRouteRequestBody multiCityReqBody) {
		List<MultiCityRouteResponse> multiCityResponseList = new ArrayList<>();
		for (RouteInput route : multiCityReqBody.getRoutesList()) {
			String destination = route.getDestination();
			String arrival = route.getArrival();
			List<String> airlines = multiCityReqBody.getAirlineList();
			LocalDate date = route.getDate();
			List<Boolean> categoryList = Arrays.asList(false, false, false);
			List<Routes> resultRoute = routeRepo.searchRouteForGivenSourceDestinationAirlines(arrival,
					destination, airlines);
			int dayNumeric = date.getDayOfWeek().getValue();
			List<String> dayStatus = Arrays.asList("", "", "", "", "", "", "");
			dayStatus.set(dayNumeric - 1, "yes");
			for (String category : multiCityReqBody.getClassList()) {
				if (category.equalsIgnoreCase("bussiness")) {
					categoryList.set(0, true);
				}
				else if (category.equalsIgnoreCase("economy")) {
					categoryList.set(1, true);
				}
				else if (category.equalsIgnoreCase("first")) {
					categoryList.set(2, true);
				} else {
					throw new CategoryNotFoundException("Category not found");
				}
			}
			List<Routes> searchedMulticityAirlineRouteList = new ArrayList<>();
			for (Routes airlineRoute : resultRoute) {
				if (airlineRoute.getIataTo().equals(destination) && airlineRoute.getIataFrom().equals(arrival)
&& (airlineRoute.getDay1().equals(dayStatus.get(0))
								|| airlineRoute.getDay2().equals(dayStatus.get(1))
								|| airlineRoute.getDay3().equals(dayStatus.get(2))
								|| airlineRoute.getDay4().equals(dayStatus.get(3))
								|| airlineRoute.getDay5().equals(dayStatus.get(4))
								|| airlineRoute.getDay6().equals(dayStatus.get(5))
								|| airlineRoute.getDay7().equals(dayStatus.get(6)))
&& (airlineRoute.isClassBusiness() == categoryList.get(0)
								|| airlineRoute.isClassEconomy() == categoryList.get(1)
								|| airlineRoute.isClassFirst() == categoryList.get(2))) {
					searchedMulticityAirlineRouteList.add(airlineRoute);
				}
			}

 

			MultiCityRouteResponse multicityRespone = new MultiCityRouteResponse(date, arrival, destination,
					searchedMulticityAirlineRouteList);
			multiCityResponseList.add(multicityRespone);

 

		}
		return multiCityResponseList;
	}

}
