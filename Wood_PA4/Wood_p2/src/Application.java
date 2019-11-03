/*
    Joshua Wood
    Problem 4 - Problem 2
    COP 3330 - Fall 2019
    November 2, 2019

    Create a class called DuplicateCounter. Create an instance method called count that takes a
    single parameter called dataFile (representing the path to a text file) and uses a Map of
    Strings to count how many times each word occurs in dataFile. The counts should be stored in
    an instance variable called wordCounter. Create an instance method called write that takes a
    single parameter called outputFile (representing the path to a text file) and writes the contents
    of wordCounter to the file pointed to by outputFile. The output file should be overwritten if it
    already exists, and created if it does not exist.

    Create a separate class called Application that contains a main method which illustrates the use of
    DuplicateCounter by calling both the remove and write methods. Your input file must be called problem2.txt
    and your output file must be called unique_word_counts.txt. You will not receive credit if you use different
    file names, as my graders will not modify your code to make it work with their test files.

    Your program should work on any text file. The TA's will provide their own version of problem1.txt when they run your code.
 */

import java.util.Scanner;

public class Application {
    // Get the file the user would like to open
    public static String openFile(Scanner scan) {
        String fileName;
        System.out.println("\nPlease enter text file to open: ");
        System.out.print("-> ");
        fileName = scan.next();
        return fileName;
    }

    // Get the file the user would like to transfer data
    public static String writeFile(Scanner scan) {
        String fileName;
        System.out.println("\nPlease enter text file to write to: ");
        System.out.print("-> ");
        fileName = scan.next();
        return fileName;
    }

    // Main Method
    public static void main(String[] args) {
        // Variable Declaration
        Scanner scan = new Scanner(System.in);
        DuplicateCounter duplicateCounter = new DuplicateCounter();
        String openFile;
        String writeFile;

        // Call duplicateCounter class
        openFile = openFile(scan);
        System.out.println();
        duplicateCounter.count(openFile);
        writeFile = writeFile(scan);
        System.out.println();
        duplicateCounter.write(writeFile);
    }
}
