package com.autopark.main;

import static com.autopark.service.ParkingManager.processParkingRequest;
import static com.autopark.util.Utility.displayKeyBoardEntry;
import static com.autopark.util.Utility.displayKeyBoardEntryErrorMessage;

import java.util.Scanner;

import com.autopark.domain.ParkingCordinates;
import com.autopark.domain.Slot;
import com.autopark.service.ValidationManager;

/**
 * 
 * @author sajith This is the main entry point to execute the application.
 */
public class Main {

	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		displayKeyBoardEntry();

		while (sc.hasNext()) {
			String parkingRequest = sc.nextLine();
			if (parkingRequest.equalsIgnoreCase("-1")) {
				System.exit(0);
			} else if (!ValidationManager.isValidInput(parkingRequest)) {
				displayKeyBoardEntryErrorMessage();

			} else {

				ParkingCordinates cordinates = new ParkingCordinates(parkingRequest);
				Slot finalLocation = processParkingRequest(cordinates);
				System.out.println(finalLocation + "\n");
			}
			displayKeyBoardEntry();

		}
		sc.close();

	}

}
