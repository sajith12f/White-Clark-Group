package com.autopark.domain;

/**
 * 
 * @author sajith
 *
 * Contains the parking request entity
 */
public class ParkingCordinates {

	private String cordinateValue = null;

	public ParkingCordinates() {
		
	}
	
	public ParkingCordinates(final String parkingRequest) {
		this.cordinateValue = parkingRequest;
	}

	public String getCordinateValue() {
		return this.cordinateValue;
	}

	public void setCordinateValue(final String parkingRequest) {
		this.cordinateValue = parkingRequest;
	}
	
	
}
