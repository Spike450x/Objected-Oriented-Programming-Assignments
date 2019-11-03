/*
    Joshua Wood
    Problem 4 - Problem 1
    COP 3330 - Fall 2019
    November 2, 2019

    Create a class called DuplicateRemover. Create an instance method called remove
    that takes a single parameter called dataFile (representing the path to a text file)
    and uses a Set of Strings to eliminate duplicate words from dataFile.
    The unique words should be stored in an instance variable called uniqueWords.
    Create an instance method called write that takes a single parameter called
    outputFile (representing the path to a text file) and writes the words contained
    in uniqueWords to the file pointed to by outputFile. The output file should be overwritten
    if it already exists, and created if it does not exist.

    Create a separate class called Application that contains a main method which illustrates
    the use of DuplicateRemover by calling both the remove and write methods. Your input file
    must be called problem1.txt and your output file must be called unique_words.txt. You will
    not receive credit if you use different file names, as my graders will not modify your code
    to make it work with their test files.

    Your program should work on any text file. The TA's will provide their own version of problem1.txt when they run your code.
*/

import java.io.IOException;
import java.util.Scanner;

public class Application {
    // Get file to open
    public static String openFile(Scanner scan) {
        String fileName;
        System.out.println("\nPlease enter text file to open: ");
        System.out.print("-> ");
        fileName = scan.next();
        return fileName;
    }
    // Get file to write to
    public static String writeFile(Scanner scan) {
        String fileName;
        System.out.println("\nPlease enter text file to write to: ");
        System.out.print("-> ");
        fileName = scan.next();
        return fileName;
    }
    // Main method
    public static void main(String[] args) throws IOException {
        // Variable declaration
        Scanner scan = new Scanner(System.in);
        DuplicateRemover duplicateRemover = new DuplicateRemover();
        String openFile;
        String writeFile;

        // Call duplicateRemove class
        openFile = openFile(scan);
        System.out.println();
        duplicateRemover.remove(openFile);
        writeFile = writeFile(scan);
        System.out.println();
        duplicateRemover.write(writeFile);
    }
}