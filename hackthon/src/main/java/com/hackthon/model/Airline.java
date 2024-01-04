package com.hackthon.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airline {
	
	@Id
	private String code;
	private String name;
	private boolean is_lowcost;
	private String logo;
	@Column(name = "created_on", columnDefinition = "TIMESTAMP")
	private LocalDateTime createdOn;
    @Column(name = "updated_on", columnDefinition = "TIMESTAMP")
	private LocalDateTime updatedOn;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isIs_lowcost() {
		return is_lowcost;
	}
	public void setIs_lowcost(boolean is_lowcost) {
		this.is_lowcost = is_lowcost;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	
	
	
	

}
