package MyStudies;

import java.io.*;

public class BufferedBytes {
    public static void main(String[] args){
        String message = "Hello git World buffered bytes!!";
        try(BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("C:\\Users\\HP\\IdeaProjects\\StudentController\\src\\MyStudies\\Output.txt"));
            BufferedInputStream in = new BufferedInputStream(new FileInputStream("C:\\Users\\HP\\IdeaProjects\\StudentController\\src\\MyStudies\\Output.txt"));
            BufferedOutputStream out2 = new BufferedOutputStream(new FileOutputStream("C:\\Users\\HP\\IdeaProjects\\StudentController\\src\\MyStudies\\Output2.txt"))){
            byte[] bytes= message.getBytes();
            out.write(bytes);
            out.flush();
            int i;
            StringBuilder message2 =new StringBuilder(" ");
            while( (i = in.read())!= -1){
                message2.append((char)i);
            }
            message2.append("After reading");
            byte[] bytes2 = message2.toString().getBytes();
            out2.write(bytes2);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
