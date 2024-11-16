import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Composition2 {

    // Method to check for compositions of three or more words
    public static void checkCompositions(String[] words) throws IOException {
        PrintWriter writer = new PrintWriter("composedMore.txt");

        for (String targetWord : words) {
            // Attempt to find combinations of three or more words forming the targetWord
            findCompositions(targetWord, words, "", 0, writer);
        }

        writer.close();
    }

    // Recursive method to find compositions of three or more words
    private static void findCompositions(String targetWord, String[] words, String currentComposition, int wordCount, PrintWriter writer) {
        // Base case: If the targetWord is empty and at least three words form it, write the result
        if (targetWord.isEmpty() && wordCount >= 3) {
            // Correctly format the output with the full word first, followed by a colon and space-separated components
            writer.println(currentComposition);
            return;
        }

        // Iterate over all words to check if they are a prefix of the targetWord
        for (String word : words) {
            if (targetWord.startsWith(word)) {
                // Build the new composition string: full word + colon + forming words
                String newComposition = currentComposition.isEmpty()
                        ? targetWord + ": " + word
                        : currentComposition + " " + word;

                // Recur with the remaining part of the targetWord and increment wordCount
                findCompositions(targetWord.substring(word.length()), words, newComposition, wordCount + 1, writer);
            }
        }
    }

    // Reads the words from the dictionary file using Scanner
    public static String[] readDictionaryFile() throws IOException {
        Scanner scanner = new Scanner(new File("dictionary.txt"));
        StringBuilder content = new StringBuilder();

        while (scanner.hasNext()) {
            content.append(scanner.next()).append(" ");
        }

        scanner.close();
        return content.toString().trim().split("\\s+"); // Split by any whitespace
    }
}



