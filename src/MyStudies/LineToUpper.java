package MyStudies;

import java.io.*;

public class LineToUpper {
    public static void main(String[] args){
        File file = new File("./src/MyStudies/Output.txt");
        StringBuilder content = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String Line;
            while((Line = reader.readLine())!=null){
                content.append(Line.toUpperCase());
                content.append("\n");
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        try(PrintWriter write = new PrintWriter(new FileWriter(file))){
            write.print(content);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
