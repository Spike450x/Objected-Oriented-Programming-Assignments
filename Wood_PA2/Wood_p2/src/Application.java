/*
 * ----------------------------
 * |	Joshua Wood			  |
 * |	Problem 2			  |
 * |	COP 3330 - Fall 2019  |
 * |	September 21, 2019	  |
 * ----------------------------
 */

/*										DESCRIPTION
 * Create a BMI calculator that reads the user’s weight and height (providing an option for the user 
 * to select which formula to use), and then calculates and displays the user’s body mass index. 
 * Also, display the BMI categories and their values from the National Heart Lung and Blood Institute: 
 * http://www.nhlbi.nih.gov/health/educational/lose_wt/BMI/bmicalc.htm (Links to an external site.) 
 * so the user can evaluate his/her BMI.
 */

import java.util.Scanner;

public class Application {
	// Main method
	public static void main(String[] args) {
		// Initialize scanner to scan
		Scanner scan = new Scanner(System.in);

		// Constant (703 is part of the equation and is never changed)
		final int NUM_MULT = 703;

		// Variable declarations
		int userChoice;
		int error = 1; // ** If user enters an invalid number, error sets to zero and stops program **
		double weightInPounds;
		double heightInInches;
		double weightInKilograms;
		double heightInMeters;
		double BMI;

		// Prompt for calculation mode
		System.out.println("Which formula would you like to use (lbs/inch or kg/meters)?");
		System.out.println("\nPlease enter 1 for lbs and 2 for kgs: ");

		// Get calculation mode
		userChoice = scan.nextInt();

		// Prompt for weight and height (lbs/inch)
		if (userChoice == 1) {
			// Get weight from user
			System.out.println("Please enter weight in pounds: ");
			weightInPounds = scan.nextDouble();
			// Get height from user
			System.out.println("Please enter height in inches: ");
			heightInInches = scan.nextDouble();
			// Equation for BMI calculation
			BMI = (NUM_MULT * weightInPounds) / Math.pow(heightInInches, 2);
			// Display BMI value
			System.out.printf("\nYour BMI is: %.1f!\n", BMI);
		}

		// Prompt for weight and height (kg/meters)
		else if (userChoice == 2) {
			// Get weight from user
			System.out.println("Please enter weight in kilograms: ");
			weightInKilograms = scan.nextDouble();
			// Get height from user
			System.out.println("Please enter height in meters: ");
			heightInMeters = scan.nextDouble();
			// Equation for BMI calculation
			BMI = weightInKilograms / Math.pow(heightInMeters, 2);
			// Display BMI value
			System.out.printf("\nYour BMI is: %.1f!\n\n", BMI);
		}

		// User must enter a valid choice
		else {
			System.out.println("ERROR!! INVALID ENTRY!");
			error = 0; // Exits program
		}
		// Call categoryValues if there is a valid entry
		if (error == 1)
			categoryValues();
		
		scan.close();
	}

	// Display BMI category
	public static void categoryValues() {
		System.out.println("\nBMI Categories: \n");
		System.out.println("Underweight = 18.5");
		System.out.println("Normal weight = 18.5 - 24.9");
		System.out.println("Overweight = 25 - 29.9");
		System.out.println("Obesity = BMI of 30 or greater");
	}

}
