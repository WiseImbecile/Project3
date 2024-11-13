import java.io.*;



public class Project3 {




    public static void main(String[] args){

        SortTest test = new SortTest();

        File file = test.create_file("This is a file. What's uppppp");

        test.read_file_and_sort(file);





    }
    
}
