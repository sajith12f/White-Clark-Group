package com.autopark.util;
 
public class Utility {
	
	public final static String PARKING_COORDINATE_EXPRESSION = "([0-9]|1[0-5]),([0-9]|1[0-5]):([FfLlRr]*)|-1";
	
	public final static String RIGHT_TURN = "R";
	
	public final static String LEFT_TURN = "L";
	
	public final static String FORWARD = "F";
	
	public final static int MAX_GRID_SIZE = 15;
	
	public final static int MIN_GRID_SIZE = 0;
	
	/**
	 * Shows the user to enter inputs
	 */
	public static void displayKeyBoardEntry() {
		
		System.out.print("Enter cordinates: or -1 for exit: [Input pattern: 0-15,0-15:(Mandatory)FLR(Optional case insensitive)] \n ");
		

	}
	
	/**
	 * Shows invalid input error message
	 */
	public static void displayKeyBoardEntryErrorMessage() {
		System.out.println("Invalid Entry "+'\n');
	
	}
	
	
}
