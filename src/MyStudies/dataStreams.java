package MyStudies;

import java.io.*;

public class dataStreams {
    public static void main(String[] args){
        File file = new File("./src/MyStudies/DataStorage.dat");
        try(DataOutputStream dos  = new DataOutputStream(new FileOutputStream(file))){
            dos.write(7);
            dos.writeBoolean(true);
            dos.writeUTF("Hello There");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        try(DataInputStream inFile = new DataInputStream(new FileInputStream(file))){
            int a = inFile.read();
            boolean b = inFile.readBoolean();
            String c = inFile.readUTF();
            //what is data output Stream and Its function readUTF meaning.
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
