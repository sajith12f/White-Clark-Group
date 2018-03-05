package com.autopark.domain;

import com.autopark.util.Utility;

/**
 * 
 * @author sajith Contains a specific slot of the parking grid
 */
public class Slot {

	public enum Direction {
		NORTH, SOUTH, WEST, EAST;

	};

	private int yAxisCoordinateValue = -1;
	private int xAxisCoordinateValue = -1;
	private Direction direction = Direction.NORTH;

	public Slot(int yAxisCoordinateValue, int xAxisCoordinateValue, Direction direction) {

		this.yAxisCoordinateValue = yAxisCoordinateValue;
		this.xAxisCoordinateValue = xAxisCoordinateValue;
		this.direction = direction;
	}

	public Slot(Slot slot) {

		this.yAxisCoordinateValue = slot.yAxisCoordinateValue;
		this.xAxisCoordinateValue = slot.xAxisCoordinateValue;
		this.direction = slot.direction;
	}

	/**
	 * Go on step further in the grid
	 */
	public void goForward() {

		switch (direction) {
		case NORTH:
			yAxisCoordinateValue++;
			break;
		case SOUTH:
			yAxisCoordinateValue--;
			break;
		case WEST:
			xAxisCoordinateValue--;
			break;
		case EAST:
			xAxisCoordinateValue++;
			break;
		}
	}

	/**
	 * Turn left but do not move to next slot
	 */
	public void goLeft() {

		switch (direction) {
		case NORTH:
			direction = Direction.WEST;
			break;
		case WEST:
			direction = Direction.SOUTH;
			break;
		case SOUTH:
			direction = Direction.EAST;
			break;
		case EAST:
			direction = Direction.NORTH;
			break;
		}
	}

	/**
	 * Turn right but do not move to next slot
	 */
	public void goRight() {

		switch (direction) {
		case NORTH:
			direction = Direction.EAST;
			break;
		case EAST:
			direction = Direction.SOUTH;
			break;
		case SOUTH:
			direction = Direction.WEST;
			break;
		case WEST:
			direction = Direction.NORTH;
			break;
		}

	}

	/**
	 * Print the coordinates of the slot
	 */
	public String toString() {
		if (xAxisCoordinateValue < Utility.MIN_GRID_SIZE || xAxisCoordinateValue > Utility.MAX_GRID_SIZE) {

			return "Vehicle goes out of boundary in X-Axis";
		} else if (yAxisCoordinateValue < Utility.MIN_GRID_SIZE || yAxisCoordinateValue > Utility.MAX_GRID_SIZE) {
			return "Vehicle goes out of boundary in Y-Axis";

		}
		return "We should get the position " + yAxisCoordinateValue + "," + xAxisCoordinateValue + " ";
	}
}
