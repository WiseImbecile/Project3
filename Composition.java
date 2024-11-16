import java.io.*;

public class Composition {

    // This method will read words from the dictionary and check for possible compositions
    public static void checkCompositions(String[] words) throws IOException {
        // Create the output file
        BufferedWriter bw = new BufferedWriter(new FileWriter("composed.txt"));

        // For each word in the dictionary, check if it can be formed by concatenating two other words
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            // Check all combinations of two words
            for (int j = 0; j < words.length; j++) {
                for (int k = 0; k < words.length; k++) {
                    if (j != k) { // Avoid checking the same word twice
                        String combined = words[j] + words[k];
                        if (combined.equals(word)) {
                            bw.write(word + ":" + words[j] + " " + words[k]);
                            bw.newLine();
                        }
                    }
                }
            }
        }

        // Close the BufferedWriter
        bw.close();
    }

    // This helper method reads the file and returns the words as an array
    public static String[] readDictionaryFile() throws IOException {
        // Read the file and split the words
        BufferedReader br = new BufferedReader(new FileReader("dictionary.txt"));
        String line = br.readLine();
        String[] words = line.split("\\s+");  // Split by any whitespace
        br.close();
        return words;
    }
}





