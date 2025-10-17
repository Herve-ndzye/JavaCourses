package MyStudies;

import java.io.*;

public class CopyFileContent {
    public static void main(String[] args){
        File inputFile = new File("./src/MyStudies/Output.txt");
        File outputFile = new File("./src/MyStudies/Output2.txt");
        try(BufferedReader read = new BufferedReader(new FileReader(inputFile));
            PrintWriter printer = new PrintWriter(new FileWriter(outputFile))
        ){
            String line;
            while((line = read.readLine())!=null){
                printer.print(line);
                printer.print("\n");
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
