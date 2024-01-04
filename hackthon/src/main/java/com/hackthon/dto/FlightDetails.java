package com.hackthon.dto;

import java.time.LocalDate;

public class FlightDetails {
	private int id;
	private String iataF;
	private String iataT;
	private String classType;
	private LocalDate date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIataF() {
		return iataF;
	}
	public void setIataF(String iataF) {
		this.iataF = iataF;
	}
	public String getIataT() {
		return iataT;
	}
	public void setIataT(String iataT) {
		this.iataT = iataT;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
	
	
	
	

}
