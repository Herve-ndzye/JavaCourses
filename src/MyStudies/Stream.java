package MyStudies;

import java.io.*;
import java.util.Scanner;

public class Stream {
    public static void main(String[] args){
        Scanner c =new Scanner(System.in);
        String userInput;
        System.out.println("Enter your inputs, type ' exit '  to quit ");
        while(c.hasNext()){
            userInput = c.next();
            if(userInput.equalsIgnoreCase("exit"))
                break;
            System.out.println("you entered : "+ userInput);
        }
    }
}
class Printer{
    public static void main(String[] args){
        File file = new File("./src/MyStudies/Output.txt");
        try(PrintWriter writer = new PrintWriter(new FileWriter(file,true))){
            writer.println("\ndon't miss ");
            writer.println("see you then.. ");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
class Display{
    public static void main(String[] args){
        File file = new File("./src/MyStudies/Output.txt");
        try(BufferedReader read = new BufferedReader(new FileReader(file))){
            Scanner c = new Scanner(System.in);
            String Text;
            while((Text= read.readLine())!=null){
                System.out.println(Text);
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
