package com.hackthon.dto;

import java.util.List;



public class MultiCityRouteRequestBody {
	private List<String> classList;
    private List<String> airlineList;
    private List<RouteInput> routesList;
    
    
	public MultiCityRouteRequestBody(List<String> classList, List<String> airlineList, List<RouteInput> routesList) {
		super();
		this.classList = classList;
		this.airlineList = airlineList;
		this.routesList = routesList;
	}
	public List<String> getClassList() {
		return classList;
	}
	public void setClassList(List<String> classList) {
		this.classList = classList;
	}
	public List<String> getAirlineList() {
		return airlineList;
	}
	public void setAirlineList(List<String> airlineList) {
		this.airlineList = airlineList;
	}
	public List<RouteInput> getRoutesList() {
		return routesList;
	}
	public void setRoutesList(List<RouteInput> routesList) {
		this.routesList = routesList;
	}
    
    

}
