import java.io.*;


public class SortTest {
    
    public void create_file(){
        File myFile = new File("./input.txt");
        try{
            PrintWriter file = new PrintWriter(myFile);
            file.close();
        }

        catch(FileNotFoundException e){
            
        }


    }
   


}
