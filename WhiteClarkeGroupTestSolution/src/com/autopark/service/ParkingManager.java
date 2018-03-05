package com.autopark.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.autopark.domain.ParkingCordinates;
import com.autopark.domain.Slot;
import com.autopark.domain.Slot.Direction;
import com.autopark.util.Utility;

/**
 * 
 * @author sajith Handles the parking request - Main business logic class
 */
public class ParkingManager {

	/**
	 * Starts the processing request
	 * 
	 * @param request
	 *            starts the parking request processing
	 * @return final parking slot
	 */
	public static Slot processParkingRequest(final ParkingCordinates request) {

		Slot startingSlot = getStartPoint(request);

		Slot endSlot = processFlow(startingSlot, request);
		return endSlot;

	}

	/**
	 * Processes the directions
	 * 
	 * @param startingSlot
	 *            - starting point
	 * @param request
	 *            - parking request
	 * @return final location
	 */
	private static Slot processFlow(final Slot startingSlot, final ParkingCordinates request) {
		Matcher matcher = Pattern.compile(Utility.PARKING_COORDINATE_EXPRESSION).matcher(request.getCordinateValue());
		matcher.find();
		String directions = matcher.group(3);
		Slot currentSlot = startingSlot;

		for (int i = 0; i < directions.length(); i++) {
			Character direct = directions.charAt(i);

			if (Utility.LEFT_TURN.equalsIgnoreCase(direct.toString())) {
				currentSlot.goLeft();
			} else if (Utility.RIGHT_TURN.equalsIgnoreCase(direct.toString())) {
				currentSlot.goRight();
			} else {
				currentSlot.goForward();
			}

		}

		return currentSlot;
	}

	/**
	 * Gets start start location of the slot from the request
	 * 
	 * @param request
	 *            - contains starting point
	 * @return start slot
	 */
	private static Slot getStartPoint(final ParkingCordinates request) {

		Matcher matcher = Pattern.compile(Utility.PARKING_COORDINATE_EXPRESSION).matcher(request.getCordinateValue());
		matcher.find();
		int startUpDirectionValue = Integer.parseInt(matcher.group(1));
		int startSideDirectionvalue = Integer.parseInt(matcher.group(2));

		Slot startSlot = new Slot(startUpDirectionValue, startSideDirectionvalue, Direction.NORTH);
		return startSlot;
	}

}
