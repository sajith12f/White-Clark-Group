package com.autopark.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.autopark.service.ValidationManager;

public class ValidationManagerTest {

    	


	@Test
	public void testIsValidInput() {
		assertTrue(ValidationManager.isValidInput("15,0:RFLFRFLF"));
	}
	
	@Test
	public void testInvalidDirection() {
		assertFalse(ValidationManager.isValidInput("5,5:RFLFRFLFX"));
	}
	
	@Test
	public void testInvalidStartY() {
		assertFalse(ValidationManager.isValidInput("16,5:RFLFRFLF"));
	}
	
	@Test
	public void testInvalidStartX() {
		assertFalse(ValidationManager.isValidInput("15,16:RFLFRFLF"));
	}
	
	@Test
	public void testMinusStartY() {
		assertFalse(ValidationManager.isValidInput("-1,0:RFLFRFLF"));
	}
	
	@Test
	public void testMinusStartX() {
		assertFalse(ValidationManager.isValidInput("0,-1:RFLFRFLF"));
	}

}
