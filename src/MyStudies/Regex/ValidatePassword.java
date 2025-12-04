package MyStudies.Regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidatePassword {
    public static void main(String[] args){
        String password;
        System.out.print("Enter the password to be validated : ");
        Scanner c = new Scanner(System.in);
        password = c.nextLine();
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_+=<>?/.,-]).{8,}$";
        boolean state = Pattern.matches(regex,password);
        if(state)
            System.out.println("This password "+ password+" is Strong!!");
        else
            System.out.println("This password "+ password+" is weak.");
    }
}
