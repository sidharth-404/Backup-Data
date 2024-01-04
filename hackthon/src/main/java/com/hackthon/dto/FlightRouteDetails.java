package com.hackthon.dto;

import com.hackthon.model.Airline;
import com.hackthon.model.Routes;

public class FlightRouteDetails {
	private Routes routes;
	private Airline airline;
	
	
	public FlightRouteDetails(Routes routes, Airline airline) {
		super();
		this.routes = routes;
		this.airline = airline;
	}
	public Routes getRoutes() {
		return routes;
	}
	public void setRoutes(Routes routes) {
		this.routes = routes;
	}
	public Airline getAirline() {
		return airline;
	}
	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	
}
