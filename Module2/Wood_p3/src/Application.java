
/*
 * ----------------------------
 * |	Joshua Wood			  |
 * |	Problem 3			  |
 * |	COP 3330 - Fall 2019  |
 * |	September 21, 2019	  |
 * ----------------------------
 */

import java.util.Scanner;

public class Application {
	//Main Method
	public static void main(String[] args) {

		// Initialize scanner to scan
		Scanner scan = new Scanner(System.in);

		// Constants
		final int MAX_ROW = 5;
		final int MAX_COL = 10;

		// Arrays
		String[] topics = new String[MAX_ROW];
		int[][] responses = new int[MAX_ROW][MAX_COL];
		int rateAvg[] = new int[MAX_ROW];

		// Variable declaration
		int userNum = 0;
		int userRate;
		int i;
		int j;
		int error = 1; // ** If user enters an invalid number, error sets to zero and stops program **
		int highPoint = 0;
		int lowPoint = 0;
		
		String highIssue = " ";
		String lowIssue = " ";

		// Topics to rate
		topics[0] = "Video Games";
		topics[1] = "Reading";
		topics[2] = "Music";
		topics[3] = "Politics";
		topics[4] = "Coding";
		
		// Call setZero
		setZero(responses);
		
		// Introduction to program
		System.out.println("The topics to choose from are as follows: \n");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		for (i = 0; i < MAX_ROW; i++) {
			System.out.println("\t" + topics[i]);
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		// Get amount of users/amount of entries
		System.out.println("\nPlease enter the amount of users who wish to give rating: ");
		userNum = scan.nextInt();

		System.out.println("\n" + userNum
				+ " user(s) will enter a rating on a scale of 1 (least important) to 10 (most important)");
		// Get ratings (runs until each topic is given a rating by each user)
		for (i = 0; i < MAX_ROW; i++) {
			System.out.println("\n------------");
			System.out.println(topics[i]);
			System.out.println("------------");

			for (j = 0; j < userNum; j++) {
				// Prompt the user to give a rating
				System.out.print("Please enter your rating for user " + (j + 1) + ": ");
				userRate = scan.nextInt();

				// Check to see if user has entered a valid number
				if (userRate < 1 || userRate > 10) {
					System.out.println("ERROR! INVALID ENTRY! NOT IN RANGE!\n\n");
					i = MAX_ROW; // STOP PROGRAMMING FROM LOOPING FURTHER
					j = userNum;
					error = 0; // STOP PROGRAM FROM DISPLAYING TABLE
					break;
				}

				else {
					responses[i][userRate - 1]++;
				}
			}
		}
		for (i = 0; i < responses.length; i++) {
			rateAvg[i] = 0;

			for (j = 0; j < responses[i].length; j++) {
				rateAvg[i] = rateAvg[i] + (responses[i][j] * (j + 1));
			}
			if (i == 0) {
				highIssue = topics[i];
				lowIssue = topics[i];
				highPoint = rateAvg[i];
				lowPoint = rateAvg[i];
			} else if (rateAvg[i] < lowPoint) {
				// Sets lowest issue with lowest points
				lowIssue = topics[i];
				lowPoint = rateAvg[i];
			}

			else if (rateAvg[i] > highPoint) {
				// Sets high issue with highest points
				highIssue = topics[i];
				highPoint = rateAvg[i];
			}
			// average 
			rateAvg[i] = rateAvg[i] / userNum;
		}
		
		if (error != 0) {
			// Calls printTable
			printTable(topics, responses, rateAvg);

			// Display the highest point total
			System.out.println("The highest issue was " + highIssue + " with a total of " + highPoint);

			// Display the lowest point total
			System.out.println("\nThe lowest issue was " + lowIssue + " with a total of " + lowPoint);
		}
	}
	// Sets values to zero
	public static void setZero(int responses[][]) {// Put all values at 0
		final int MAX_COL = 10;
		int i;
		int j;
		
		for (i = 0; i < responses.length; i++) {
			responses[i] = new int[MAX_COL];

			for (j = 0; j < responses[i].length; j++) {
				responses[i][j] = 0;
			}
		}
	}
	
	// Prints the 5 x 10 table
	public static void printTable(String topics[], int responses[][], int rateAvg[]) {
		// Variables 
		final int MAX_COL = 10;
		final int MAX_ROW = 5;
		int i;
		int j;

		System.out.println("\n\n------------------------------------------------------------------------"
				+ "------------------------------------------------------------------------");
		System.out.printf("\t");
		// Displays 1 - 10 on across top of the table (represents the column amount)
		for (i = 0; i < MAX_COL; i++) {
			System.out.printf("\t%d", (i + 1));

			// Makes average rating column
			if (i == 9) {
				System.out.printf("\tAverage Rating\n");
			}
		}

		for (i = 0; i < MAX_ROW; i++) {
			System.out.println("\n------------");
			// Displays the topics down the left side of table
			System.out.printf("%-10s", topics[i]);
			// Displays all the responses with either 0 or the amount of times the user
			// entered a value (across the top of the table)
			for (j = 0; j < responses[i].length; j++) {
				System.out.printf("\t%d", responses[i][j]);
			}
			// Displays the average per topic
			System.out.printf("\t\t%d", rateAvg[i]);
		}
		System.out.println("\n\n------------------------------------------------------------------------"
				+ "------------------------------------------------------------------------");
	}
}