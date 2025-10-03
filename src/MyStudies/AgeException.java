package MyStudies;

import java.util.Scanner;

public class AgeException extends Exception {
    public AgeException(String message) {
        super(message);
    }
}
class mainClass {
    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);

        try(c){
                System.out.println("Enter your age :");
                int age = c.nextInt();
                if (age < 18)
                    throw new AgeException("you are under 18");

                System.out.println("watch movie");
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

