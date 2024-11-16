import java.io.*;
import java.util.Scanner;



public class Project3 {




    public static void main(String[] args){

        SortTest test = new SortTest();

        File file = test.create_file("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z");

        test.read_file_and_sort(file);

        // File paths
        String inputFilePath = "dictionary.txt";
        String outputFilePath = "almostPalOutput.txt";

        try {
            // Call the processFile method
            AlmostPalTest.processFile(inputFilePath, outputFilePath);
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }


        
        try {
            // Read the dictionary file and get the words
            String[] words = Composition.readDictionaryFile();

            // Check compositions for the words and write to composed.txt
            Composition.checkCompositions(words);

            System.out.println("Compositions have been written to composed.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // Read the dictionary file and get the words
            String[] words = Composition2.readDictionaryFile();

            // Check compositions for the words and write to composedMore.txt
            Composition2.checkCompositions(words);

            System.out.println("Compositions with three or more words have been written to composedMore.txt");
        } catch (IOException e) {
            e.printStackTrace();
        
        }
    }
}
