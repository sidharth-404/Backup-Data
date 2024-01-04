package com.hackthon.dto;

import java.time.LocalDate;
import java.util.List;

import com.hackthon.model.Routes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class MultiCityRouteResponse {
	private LocalDate date;
	private String iataFrom;
	private String iataTo;
	private List<Routes> routeResults;
	
	
	
	public MultiCityRouteResponse(LocalDate date, String iataFrom, String iataTo, List<Routes> routeResults) {
		super();
		this.date = date;
		this.iataFrom = iataFrom;
		this.iataTo = iataTo;
		this.routeResults = routeResults;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getIataFrom() {
		return iataFrom;
	}
	public void setIataFrom(String iataFrom) {
		this.iataFrom = iataFrom;
	}
	public String getIataTo() {
		return iataTo;
	}
	public void setIataTo(String iataTo) {
		this.iataTo = iataTo;
	}
	public List<Routes> getRouteResults() {
		return routeResults;
	}
	public void setRouteResults(List<Routes> routeResults) {
		this.routeResults = routeResults;
	}
	
	

}
