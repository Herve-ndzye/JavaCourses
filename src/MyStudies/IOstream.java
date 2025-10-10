package MyStudies;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOstream {
    public static void main(String[] args){
        String message = "Hello git World !!";
        try(FileOutputStream out = new FileOutputStream("C:\\Users\\HP\\IdeaProjects\\StudentController\\src\\MyStudies\\Output.txt");
            FileInputStream in = new FileInputStream("C:\\Users\\HP\\IdeaProjects\\StudentController\\src\\MyStudies\\Output.txt");
            FileOutputStream out2 = new FileOutputStream("C:\\Users\\HP\\IdeaProjects\\StudentController\\src\\MyStudies\\Output2.txt")){
            byte[] bytes= message.getBytes();
            out.write(bytes);
            int i;
            String message2 = " ";
            while( (i = in.read())!= -1){
                 message2 += (char)i;
            }
            message2+=" After reading";
            byte[] bytes2 = message2.getBytes();
            out2.write(bytes2);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
