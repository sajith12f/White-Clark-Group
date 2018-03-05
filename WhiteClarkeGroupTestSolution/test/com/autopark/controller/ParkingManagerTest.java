package com.autopark.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.autopark.domain.ParkingCordinates;
import com.autopark.domain.Slot;
import com.autopark.service.ParkingManager;

public class ParkingManagerTest {

	private ParkingCordinates parkingCordinates;
	@Before
	public void setUp() throws Exception {
		
		parkingCordinates = new ParkingCordinates();
	}

	@Test
	public void testFirstScenario() {
		parkingCordinates.setCordinateValue("5,5:RFLFRFLF");
		Slot slot =ParkingManager.processParkingRequest(parkingCordinates);
		assertEquals("We should get the position 7,7 ", slot.toString());
	}
	
	@Test
	public void testSecondScenario() {
		parkingCordinates.setCordinateValue("6,6:FFLFFLFFLFF");
		Slot slot =ParkingManager.processParkingRequest(parkingCordinates);
		assertEquals("We should get the position 6,6 ", slot.toString());
	}
	
	@Test
	public void testThirdScenario() {
		parkingCordinates.setCordinateValue("5,5:FLFLFFRFFF");
		Slot slot =ParkingManager.processParkingRequest(parkingCordinates);
		assertEquals("We should get the position 4,1 ", slot.toString());
	}
	

	@Test
	public void testYMaxSize() {
		parkingCordinates.setCordinateValue("15,0:");
		Slot slot =ParkingManager.processParkingRequest(parkingCordinates);
		assertEquals("We should get the position 15,0 ", slot.toString());
	}
	
	@Test
	public void testXMaxSize() {
		parkingCordinates.setCordinateValue("0,15:");
		Slot slot =ParkingManager.processParkingRequest(parkingCordinates);
		assertEquals("We should get the position 0,15 ", slot.toString());
	}
	
	
	@Test
	public void testYZero() {
		parkingCordinates.setCordinateValue("0,5:");
		Slot slot =ParkingManager.processParkingRequest(parkingCordinates);
		assertEquals("We should get the position 0,5 ", slot.toString());
	}
	
	@Test
	public void testXZero() {
		parkingCordinates.setCordinateValue("5,0:");
		Slot slot =ParkingManager.processParkingRequest(parkingCordinates);
		assertEquals("We should get the position 5,0 ", slot.toString());
	}
	
	@Test
	public void testYMinus() {
		parkingCordinates.setCordinateValue("0,5:RRF");
		Slot slot =ParkingManager.processParkingRequest(parkingCordinates);
		assertEquals("Vehicle goes out of boundary in Y-Axis", slot.toString());
	}
	
	@Test
	public void testXMinus() {
		parkingCordinates.setCordinateValue("5,0:LF");
		Slot slot =ParkingManager.processParkingRequest(parkingCordinates);
		assertEquals("Vehicle goes out of boundary in X-Axis", slot.toString());
	}
	
	@Test
	public void testYMaxSizeOver() {
		parkingCordinates.setCordinateValue("15,0:F");
		Slot slot =ParkingManager.processParkingRequest(parkingCordinates);
		assertEquals("Vehicle goes out of boundary in Y-Axis", slot.toString());
	}
	
	@Test
	public void testXMaxSizeOver() {
		parkingCordinates.setCordinateValue("0,15:RF");
		Slot slot =ParkingManager.processParkingRequest(parkingCordinates);
		assertEquals("Vehicle goes out of boundary in X-Axis", slot.toString());
	}
	

}
