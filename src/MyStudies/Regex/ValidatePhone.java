package MyStudies.Regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidatePhone {
    public static void main(String[] args){
        String phone;
        System.out.print("Enter the phone number to be validated : ");
        Scanner c = new Scanner(System.in);
        phone = c.nextLine();
        boolean local = Pattern.matches("^07[0-9]{8}$",phone);
        boolean international = Pattern.matches("^\\+2507[0-9]{8}$",phone);
        if(local)
            System.out.println("The phone number "+phone+" is Local Number Format!");
        else if(international)
            System.out.println("The phone number "+phone+" is in International Number Format!");
        else
            System.out.println("The phone number "+phone+ " is in neither International or Local Number Format");
    }
}
