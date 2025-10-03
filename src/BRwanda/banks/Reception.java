package BRwanda.banks;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Reception {

    public static void main(String[] args){
        Scanner c = new Scanner(System.in);

        System.out.println("Enter your account name:");
        String Name = c.nextLine();

        BankAccount newUser = new BankAccount(Name);
        System.out.println("Your user name is " + newUser.getAccountHolder());
        System.out.println("Your Account number is " + newUser.getAccountNo());

        while(true){
            System.out.println("\n1. Your Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("Type No to exit or enter your choice:");
            String userChoice = c.nextLine();
            try{
                if (!Objects.equals(userChoice, "1") &&
                        !Objects.equals(userChoice, "2") &&
                        !Objects.equals(userChoice, "3") &&
                        !Objects.equals(userChoice, "No")) {
                    throw new choiceException("Your choice is invalid !");
                }

            }catch(choiceException e){
                System.out.println(e);
            }

            if(Objects.equals(userChoice, "No")) {
                System.out.println("Exiting program. Goodbye!");
                c.close();
                break;
            }

            switch(userChoice) {
                case "1":
                    System.out.println("Your balance is " + newUser.getBalance());
                    break;
                case "2":
                    try{
                        System.out.println("Enter the money to Deposit:");
                        int money = c.nextInt();
                        newUser.Deposit(money);
                        System.out.println("Your balance is " + newUser.getBalance());
                    }catch(InputMismatchException e){
                        System.out.println("Enter a number !");
                    }
                    c.nextLine();
                    break;
                case  "3":
                    try{
                        System.out.println("Enter the money to Withdraw:");
                        int mon = c.nextInt();
                        newUser.withdraw(mon);
                        System.out.println("Your balance is " + newUser.getBalance());
                    }catch(InputMismatchException e){
                        System.out.println("Enter number !");
                    }
                    c.nextLine();
                    break;
            }
        }
        c.close();


    }
}
