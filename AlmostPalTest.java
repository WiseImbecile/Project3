import java.io.*;
import java.util.Scanner;

public class AlmostPalTest {

   /**
     * Processes the input file and writes almost palindromes to the output file.
     *
     * @param inputFilePath  Path to the input file.
     * @param outputFilePath Path to the output file.
     * @throws FileNotFoundException If the input file cannot be found.
     */
    public static void processFile(String inputFilePath, String outputFilePath) throws FileNotFoundException {
        try (
            Scanner fileReader = new Scanner(new File(inputFilePath));
            PrintWriter fileWriter = new PrintWriter(new File(outputFilePath))
        ) {
            while (fileReader.hasNext()) {
                String currentWord = fileReader.next();
                if (isAlmostPalindrome(currentWord, 0, currentWord.length() - 1, 1)) {
                    fileWriter.println(currentWord);
                }
            }
        }
    }

    /**
     * Recursively determines if a word is an almost palindrome.
     *
     * @param word The word to check.
     * @param leftIndex The left index of the word.
     * @param rightIndex The right index of the word.
     * @param changesAllowed The number of changes allowed.
     * @return True if the word is an almost palindrome, false otherwise.
     */
    private static boolean isAlmostPalindrome(String word, int leftIndex, int rightIndex, int changesAllowed) {
        if (leftIndex >= rightIndex) {
            return changesAllowed == 0; // Exactly 1 change should have been made
        }

        if (word.charAt(leftIndex) == word.charAt(rightIndex)) {
            return isAlmostPalindrome(word, leftIndex + 1, rightIndex - 1, changesAllowed);
        } else if (changesAllowed > 0) {
            // Allow one character change and continue checking
            return isAlmostPalindrome(word, leftIndex + 1, rightIndex - 1, changesAllowed - 1);
        } else {
            return false;
        }
    }
}
