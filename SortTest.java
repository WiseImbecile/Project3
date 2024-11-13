import java.io.*;


public class SortTest {
    //creating file path
    File file_path = new File("./input.txt");
    
    PrintWriter file = null;
    public PrintWriter create_file(String file_content){
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
            // Closing the file safely
            if (file != null) {
                file.close();
            }
        }
        
        return file;
    }

    public void read_file(PrintWriter file){



    }


   


}
