/*
 * ----------------------------
 * |	Joshua Wood			  |
 * |	Problem 1			  |
 * |	COP 3330 - Fall 2019  |
 * |	September 21, 2019	  |
 * ----------------------------
 */

/* 	A company that wants to send data over the Internet has asked you to write a program 
 * 	that will encrypt it so that it may be transmitted more securely. 
 * 	All the data is transmitted as four-digit integers. Your application should read a 
 * 	four-digit integer entered by the user and encrypt it as follows: 
 * 		
 * 		Replace each digit with the result of adding 7 to the digit and getting the 
 * 		remainder after dividing the new value by 10. 
 * 		
 * 		Then swap the first digit with the third, and swap the second digit with the fourth. 
 * 		Then print the encrypted integer. 
 * 
 * 		Write a separate application that inputs an encrypted 
 * 		four-digit integer and decrypts it (by reversing the encryption scheme) to form the 
 * 		original number.
 */

import java.util.Scanner;

public class Application {
	// Main Method
	public static void main(String[] args) {
		// Call Encrypt and Decrypt to main
		Encrypt();
		Decrypt();
	}

	// Encrypts users number
	public static void Encrypt() {
		// Initialize scanner to scan
		Scanner scan = new Scanner(System.in);
		// Constants
		final int NUM_DIVIDE = 10;
		final int INCREASE_SEVEN = 7;

		// Variable Declaration
		int userNum;
		int digit1;
		int reduce1;
		int digit2;
		int reduce2;
		int digit3;
		int reduce3;
		int increaseSeven1;
		int increaseSeven2;
		int increaseSeven3;
		int increaseSeven4;
		
		// Prompt user for a four digit number
		System.out.println("Please enter a four digit integer to encrypt: ");
		userNum = scan.nextInt();

		// Get access to each individual digit  (Gets the remainder then divides to reduce integer)
		digit1 = userNum % NUM_DIVIDE;
		reduce1 = userNum / NUM_DIVIDE; 
		digit2 = reduce1 % NUM_DIVIDE; 
		reduce2 = reduce1 / NUM_DIVIDE; 
		digit3 = reduce2 % NUM_DIVIDE; 
		reduce3 = reduce2 / NUM_DIVIDE;
		
		// Adds seven to each digit then divides 10 to use the remainder for encrypted value 
		increaseSeven1 = (reduce3 + INCREASE_SEVEN) % NUM_DIVIDE; // 8 -> 15 = 5
		increaseSeven2 = (digit3 + INCREASE_SEVEN) % NUM_DIVIDE; // 7 -> 14 = 4
		increaseSeven3 = (digit2 + INCREASE_SEVEN) % NUM_DIVIDE; // 6 -> 13 = 3
		increaseSeven4 = (digit1 + INCREASE_SEVEN) % NUM_DIVIDE; // 5 -> 12 = 2
		
		// Prints out the encrypted value (the third digit replaces the first digit, the fourth digit replaces the second)
		System.out.println("New digit: " + increaseSeven3 + increaseSeven4 + increaseSeven1 + increaseSeven2);
	}

	public static void Decrypt() {
		// Initialize scanner with scan
		Scanner scan = new Scanner(System.in);
		
		// Constants
		final int NUM_ADD = 10;
		final int NUM_DIVIDE = 10;
		final int DECREASE_SEVEN = 7;
		
		// Variable declaration
		int userNum;
		int digit1;
		int reduce1;
		int digit2;
		int reduce2;
		int digit3;
		int reduce3;
		int decreaseSeven1;
		int decreaseSeven2;
		int decreaseSeven3;
		int decreaseSeven4;
		
		// Prompt user for a four digit number 
		System.out.println("\nPlease enter a four digit integer to decrypt: ");
		userNum = scan.nextInt();

		// Get access to each individual digit  (Gets the remainder then divides to reduce integer)
		digit1 = userNum % NUM_DIVIDE;
		reduce1 = userNum / NUM_DIVIDE;
		digit2 = reduce1 % NUM_DIVIDE;
		reduce2 = reduce1 / NUM_DIVIDE;
		digit3 = reduce2 % NUM_DIVIDE;
		reduce3 = reduce2 / NUM_DIVIDE;
		
		// Adds ten then subtracts by seven then gets the remainder after dividing by ten to get decrypted value 
		decreaseSeven1 = (reduce3 - DECREASE_SEVEN + NUM_ADD) % NUM_DIVIDE;
		decreaseSeven2 = (digit3 - DECREASE_SEVEN + NUM_ADD) % NUM_DIVIDE;
		decreaseSeven3 = (digit2 - DECREASE_SEVEN + NUM_ADD) % NUM_DIVIDE;
		decreaseSeven4 = (digit1 - DECREASE_SEVEN + NUM_ADD) % NUM_DIVIDE;
		
		// Prints out the decrypted value (the third digit replaces the first digit, the fourth digit replaces the second)
		System.out.println("New digit: " + decreaseSeven3 + decreaseSeven4 + decreaseSeven1 + decreaseSeven2);
		scan.close();
	}
}
