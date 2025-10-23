package MyStudies;

import java.io.*;

public class StudentMain {
    public static void main(String[] args){
        Student s1 = new Student("Herve","Ndizeye");
        File file = new File("./src/MyStudies/Student.ser");
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
            out.writeObject(s1);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
            Student read = (Student)in.readObject();
            String fname = read.getFirstName();
            String lname = read.getLastName();
            System.out.println(fname);
            System.out.println(lname);
            //in our LMS keep objects in files
        }catch(IOException e){
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
