import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {
    private Set<String> uniqueWords;

    public DuplicateRemover() {
        uniqueWords = new HashSet<>();
    }

    // Print error message
    public void errorMessage(IOException ex) {
        System.out.println("\nERROR! IO Exception caught! ** " + ex.getMessage() + " **");
        System.exit(1);
    }
    // Clean code and close fileReader
    public void closeFileReader(FileReader file) {
        try {
            if (file != null) {
                System.out.println("\n< Closing file reader! >");
                file.close();
            }
        } catch (IOException exc) {
            errorMessage(exc);
        }
    }
    // Clean code and close fileWriter
    public void closeFileWriter(FileWriter writeFile) {
        try {
            if (writeFile != null) {
                System.out.println("\n< Closing file writer! >");
                writeFile.close();
            }
        } catch (IOException ex) {
            errorMessage(ex);
        }
    }
    // Remove duplicates from file
    public void remove(String dataFile) {
        String fileContent;
        try {
            FileReader file = new FileReader(dataFile);
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                fileContent = scan.next();
                uniqueWords.add(fileContent);
            }
            System.out.println("\nALL DUPLICATES REMOVED!");
            closeFileReader(file);
            scan.close();
        } catch (IOException ex) {
            errorMessage(ex);
        }
    }
    // Write to file without duplicates
    public void write(String outputFile) {
        String fileName = outputFile;
        File file = new File(outputFile);
        if (file.exists()) {
            System.out.println("\nFILE EXISTS! ADDING TO " + fileName.toUpperCase() + "!");
        } else {
            System.out.println("\nFILE DOES NOT EXIST, CREATING " + fileName.toUpperCase() + "!");
        }
        try {
            FileWriter writeFile = new FileWriter(file);
            for (String writeToFile : uniqueWords) {
                writeFile.write(writeToFile + "\n");
            }
            System.out.println("\nALL UNIQUE WORDS ADDED!");
            closeFileWriter(writeFile);
        } catch (IOException ex) {
            errorMessage(ex);
        }
    }
}
