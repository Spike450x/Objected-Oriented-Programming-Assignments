import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {
    public Map<String, Integer> wordCounter;

    public DuplicateCounter() {
        wordCounter = new HashMap<>();
    }

    // Print error message if there is an IOException
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

    // Get unique words
    public void getUniqueWords(String words) {
        if (wordCounter.containsKey(words)) {
            wordCounter.put(words, wordCounter.get(words) + 1);
        } else {
            wordCounter.put(words, 1);
        }
    }
    // Method to call unique words to get unique count for each word
    public void count(String dataFile) {
        try {
            FileReader file = new FileReader(dataFile);
            Scanner scan = new Scanner(file);

            while (scan.hasNext()) {
                String words = scan.next();
                getUniqueWords(words);
            }
            System.out.println("\nCOUNT FOR WORDS COMPLETE!");
            closeFileReader(file);
            scan.close();
        } catch (IOException ex) {
            errorMessage(ex);
        }
    }
    // Write data to a new file
    public void write(String outputFile) {
        String fileName = outputFile;
        File file = new File(outputFile);
        try {
            FileWriter writeFile = new FileWriter(file);

            if (file.exists()) {
                System.out.println("\nFILE EXISTS! ADDING TO " + fileName.toUpperCase() + "!");
            } else {
                System.out.println("\nFILE DOES NOT EXIST, CREATING " + fileName.toUpperCase() + "!");
            }

            for (Map.Entry entry : wordCounter.entrySet()) {
                writeFile.write("\"" + entry.getKey() + "\" was used " + entry.getValue() + " times\n");
            }
            System.out.println("\nCOMPLETE!!!");
            closeFileWriter(writeFile);
        } catch (IOException ex) {
            errorMessage(ex);
        }
    }
}

