package com.hackthon.dto;

import com.hackthon.model.Airline;
import com.hackthon.model.Airports;




public class GetDetailedItineraryResponse {
	public int id;
	public Airports flyingFrom;
	public Airports flyingTo;
	public Airline airline;
	public GetDetailedItineraryResponse(int id, Airports flyingFrom, Airports flyingTo, Airline airline) {
		super();
		this.id = id;
		this.flyingFrom = flyingFrom;
		this.flyingTo = flyingTo;
		this.airline = airline;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Airports getFlyingFrom() {
		return flyingFrom;
	}
	public void setFlyingFrom(Airports flyingFrom) {
		this.flyingFrom = flyingFrom;
	}
	public Airports getFlyingTo() {
		return flyingTo;
	}
	public void setFlyingTo(Airports flyingTo) {
		this.flyingTo = flyingTo;
	}
	public Airline getAirline() {
		return airline;
	}
	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	
	
	
	
	

}
