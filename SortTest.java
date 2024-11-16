import java.io.*;
import java.util.*;


public class SortTest {
    //creating file path
    File file_path = new File("./input.txt");
    
    PrintWriter file = null;

    /**
     * 
     * @param file_content string of user input for file content
     * @return PrintWriter object
     */
    public File create_file(String file_content){
        try{
            //actually creating file using file_path
            PrintWriter file = new PrintWriter(file_path);
            //printing user defined contents into file
            file.println(file_content);
            file.close();
            
        }
        //catch the file not found error
        catch(FileNotFoundException e){
            
        }
        finally {
            // closing the file
            if (file != null) {
                file.close();
            }
        }
        
        return file_path;
    }

    //new method

    public void read_file_and_sort(File file){
        int count = 0;
        //reading file
        Scanner scnr = null;
        PrintWriter create_file = null;
        try{
                scnr = new Scanner(file);
                //figuring out how many words are in the file
                while(scnr.hasNext()){
                    scnr.next();
                    count++;
                }
                //close scanner to start over
                scnr.close();

                // Re-create the Scanner to read from the beginning of the file
                scnr = new Scanner(file);
                //initialize myWord array to size count
                myWord my_word_array [] = new myWord[count];
                //
                for(int i = 0; i < count; i++){
                    String word = scnr.next();
                    myWord convert_word = new myWord(word);
                    my_word_array[i] = convert_word;

                }
                
              

                Arrays.sort(my_word_array);


                // TODO: implement output.txt file 
                File output_file = new File("./output.txt");
                create_file = new PrintWriter(output_file);

                for(int i = 0; i < my_word_array.length; i++){
                    create_file.print(my_word_array[i] + " ");
                }




        }

        catch(FileNotFoundException e){

        }
        finally{
            if(scnr != null && create_file != null){
                scnr.close();
                create_file.close();
            }
        }


        

       

    }


   


}
