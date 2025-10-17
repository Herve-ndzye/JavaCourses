package MyStudies;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LineToUpper {
    public static void main(String[] args){
        File file = new File("./src/MyStudies/Output.txt");
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
