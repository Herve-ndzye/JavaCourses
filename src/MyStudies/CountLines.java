package MyStudies;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CountLines {
    public static void main(String[] args){
        int count = 0;
        File file = new File("./src/MyStudies/Output.txt");
        try(BufferedReader read= new BufferedReader(new FileReader(file))){
            while(read.readLine()!=null) count++;
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println("We have "+count+" lines in this file.");
    }
}
