//class myWord implementing the Comparable class that takes in a generic reference type(in this case the myWord class itself)
public class myWord implements Comparable<myWord>{

    String word;
    public myWord(String word){
    
        this.word = word;
    }
    /**
     * overriding object method we're reversing alphabetical order here
     * @param otherWord object being compared
     * 
     */
    @Override
    public int compareTo(myWord otherWord){

        int num = 0;
        int other_Length = otherWord.word.length();
        int word_length = this.word.length();
        int smallestLength;

        //finding smallest word length to know when to stop the loop
        if(other_Length < word_length){
            smallestLength = other_Length;
        }
        else{
            smallestLength = word_length;
        }

        for(int i = 0; i < smallestLength; i++){
            //setting variable for charAt(i)
            char thisChar = this.word.charAt(i);
            char otherChar = otherWord.word.charAt(i);
            
            //if char is uppercase value, convert to lowercase value by adding 32
            if (thisChar >= 'A' && thisChar <= 'Z') {
                thisChar = (char) (thisChar + 32);
            }
            if (otherChar >= 'A' && otherChar <= 'Z') {
                otherChar = (char) (otherChar + 32);
            }

            //if thischar is alphabetically after other char, than return -1 since that will come first in sort method
            if(thisChar < otherChar){
                return num = 1;
            }
            //if thischar is alphabetically before otherchar than return 1 since that will come after in sort method
            else if (thisChar > otherChar){
                return num = -1;
            }
        }

        // If all characters matched up to the minLength, compare by length in reverse order
        if (word_length > other_Length) {
            // "this" comes first because it's longer
            return -1; 
        } else if (word_length < other_Length) {
            // "other" comes first because it's longer
            return 1; 
        }

        //if thisChar equal otherChar
        return num;
    }

    
    @Override
    public String toString() {
        
        return word;
    }
}