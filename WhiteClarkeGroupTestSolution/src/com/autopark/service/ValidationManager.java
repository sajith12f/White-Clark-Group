package com.autopark.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.autopark.util.Utility;

/**
 * 
 * @author sajith
 * Validates user input
 */
public class ValidationManager {

	public static boolean isValidInput(String inputExpression) {
		boolean isValid = false;
		Matcher matcher = Pattern.compile(Utility.PARKING_COORDINATE_EXPRESSION).matcher(inputExpression);
		isValid = matcher.matches();
		return isValid;
	}
	
	
}
