import java.io.*;



public class Project3 {




    public static void main(String[] args){

        SortTest test = new SortTest();

        File file = test.create_file("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z");

        test.read_file_and_sort(file);





    }
    
}
