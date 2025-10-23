package MyStudies;

import java.io.*;

public class Books implements Serializable {
    private String title;
    private String author;
    private double price;

    public Books(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
class seriliaze{
    public static void main(String[] args){
        File file = new File("./src/MyStudies/books.ser");
        Books Java = new Books("Java Basics","Larisse",100.50);
        Books Web3 = new Books("Web3 Basics","Awet",120.10);
        Books DSA = new Books("DSA Basics","Damascene",90.00);
        Books DevOps = new Books("DevOps Basics","Awet",125.30);
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
            out.writeObject(Java);
            out.writeObject(Web3);
            out.writeObject(DSA);
            out.writeObject(DevOps);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
            System.out.println("Title          Author       Price\n");
            Books readJava = (Books)in.readObject();
            System.out.printf("%-15s",readJava.getTitle());
            System.out.printf("%-13s",readJava.getAuthor());
            System.out.printf("%-13s\n",readJava.getPrice());
            Books readWeb3 = (Books)in.readObject();
            System.out.printf("%-15s",readWeb3.getTitle());
            System.out.printf("%-13s",readWeb3.getAuthor());
            System.out.printf("%-13s\n",readWeb3.getPrice());
            Books readDSA = (Books)in.readObject();
            System.out.printf("%-15s",readDSA.getTitle());
            System.out.printf("%-13s",readDSA.getAuthor());
            System.out.printf("%-13s\n",readDSA.getPrice());
            Books readDevOps = (Books)in.readObject();
            System.out.printf("%-15s",readDevOps.getTitle());
            System.out.printf("%-13s",readDevOps.getAuthor());
            System.out.printf("%-13s\n",readDevOps.getPrice());
            System.out.println("\n");
        }catch(IOException e){
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
