package MyStudies.Regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateEmail {
    public static void main(String[] args){
        String email;
        System.out.print("Enter the email to be validated : ");
        Scanner c = new Scanner(System.in);
        email = c.nextLine();
        boolean state = Pattern.matches("^[A-Za-z0-9+._-]+@[A-Za-z0-9+.-]+$",email);
        if(state)
            System.out.println("This email "+ email+" is well structured!!");
        else
            System.out.println("This email "+ email+" is bad structured.");
    }
}
