package MyStudies;

import java.io.*;

public class IOstreamChar {
    public static void main(String[] args){
        String message = "Hello git World Char Stream !!";
        try(FileWriter out = new FileWriter("src\\MyStudies\\Output.txt");
            FileReader in = new FileReader("src\\MyStudies\\Output.txt");
            FileWriter out2 = new FileWriter("src\\MyStudies\\Output2.txt")){
            out.write(message);
            out.flush();
            int i;
            StringBuilder message2 = new StringBuilder(" ");
            while( (i = in.read())!= -1){
                message2.append((char) i);
            }
            message2.append(" After reading");
            out2.write(message2.toString());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
