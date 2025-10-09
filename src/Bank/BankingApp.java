package Bank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args){
        String userInput = "";
        Scanner c = new Scanner(System.in);
        System.out.println("creating Account!!");
        System.out.println("Enter the account name : ");
        String name = c.nextLine();
        System.out.println("Enter your date of birth : ");
        String dob = c.nextLine();
        Account Holder = new Account(name,dob);
        System.out.println("Welcome to Our Bank App !!");
        while(!userInput.equals("N")){
            System.out.println("Choose among the below Options :");
            System.out.println("1.see your balance");
            System.out.println("2.deposit");
            System.out.println("3.Withdraw");
            System.out.println("Or type N to exit the App");
            userInput = c.nextLine();
            switch (userInput){
                case "1": {
                    System.out.println("Your balance is " + Holder.getBalance());
                    System.out.println("");
                    break;
                }
                case "2": {
                    System.out.println("Enter the amount of money to deposit :");
                    double money = 0;
                    try{
                        money = c.nextDouble();
                    }catch(InputMismatchException e){
                        System.out.println("Enter numbers!!\n");
                    }
                    c.nextLine();
                    Holder.deposit(money);
                    System.out.println("");
                    break;
                }
                case "3": {
                    System.out.println("Enter the amount of money to withdraw :");
                    double money2 = 0;
                    try{
                        money2 = c.nextDouble();
                    }catch(InputMismatchException e){
                        System.out.println("Enter numbers!!\n");
                    }
                    c.nextLine();
                    Holder.withdraw(money2);
                    System.out.println("");
                }
            }
        }
        c.close();
    }
}
