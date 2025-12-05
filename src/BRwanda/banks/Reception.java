package BRwanda.banks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reception {

    private enum MenuOption {
        BALANCE("1"),
        DEPOSIT("2"),
        WITHDRAW("3"),
        STATEMENT("4"),
        SAVE("5"),
        LOAD("6"),
        EXIT("No");

        private final String code;

        MenuOption(String code) {
            this.code = code;
        }

        public static Optional<MenuOption> fromInput(String input) {
            return Arrays.stream(values())
                    .filter(opt -> Objects.equals(opt.code, input))
                    .findFirst();
        }
    }

    public static void main(String[] args){
        final String DATA_FILE = "src/BRwanda/banks/accounts.dat";

        Scanner c = new Scanner(System.in);
        DecimalFormat moneyFormat = new DecimalFormat("#,##0.00$");
        ArrayList<BankAccount> accounts = new ArrayList<>();

        System.out.print("Enter your account name (letters and spaces only):");
        String namePattern = "^[A-Za-z ]{3,30}$";
        Pattern pattern = Pattern.compile(namePattern);
        String Name;
        while (true) {
            Name = c.nextLine().trim();
            Matcher matcher = pattern.matcher(Name);
            if (matcher.matches()) {
                break;
            }
            System.out.print("Invalid name. Use only letters/spaces (3-30 chars). Try again:");
        }

        AccountType type = askAccountType(c);

        BankAccount newUser = new BankAccount(Name, type);
        accounts.add(newUser);
        System.out.println("Your user name is " + newUser.getAccountHolder());
        System.out.println("Your Account number is " + newUser.getAccountNo());
        System.out.println("Your Account type is " + newUser.getAccountType());

        Thread interestThread = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Thread.sleep(10_000);
                    double rate = (newUser.getAccountType() == AccountType.SAVINGS) ? 0.02 : 0.01;
                    newUser.applyInterest(rate);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        interestThread.setDaemon(true);
        interestThread.start();

        while(true){
            System.out.println("\n1. Your Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Print Statement");
            System.out.println("5. Save Accounts");
            System.out.println("6. Load & Show Accounts (sorted by holder name)");
            System.out.print("Type No to exit or enter your choice:");
            String userChoice = c.nextLine();

            Optional<MenuOption> menuOption = MenuOption.fromInput(userChoice);
            if (!menuOption.isPresent()) {
                System.out.println("Your choice is invalid!");
                continue;
            }

            if(menuOption.get() == MenuOption.EXIT) {
                System.out.println("Exiting program. Goodbye!");
                interestThread.interrupt();
                c.close();
                break;
            }

            switch(menuOption.get()) {
                case BALANCE:
                    System.out.println("Your balance is " + moneyFormat.format(newUser.getBalance()));
                    break;
                case DEPOSIT:
                    try{
                        System.out.println("Enter the money to Deposit:");
                        int money = c.nextInt();
                        if(money > 0){
                        newUser.deposit(money);
                        System.out.println("Your balance is " + moneyFormat.format(newUser.getBalance()));
                        }else
                            throw new negativeMoneyException("Input money greater than zero.");
                    }catch(InputMismatchException e){
                        System.out.println("Enter a number !");
                    } catch (negativeMoneyException e) {
                        System.out.println(e.getMessage());
                    }
                    c.nextLine();
                    break;
                case WITHDRAW:
                    try{
                        System.out.println("Enter the money to Withdraw:");
                        int mon = c.nextInt();
                        if(mon > 0){
                            newUser.withdraw(mon);
                            System.out.println("Your balance is " + moneyFormat.format(newUser.getBalance()));
                        }else
                            throw new negativeMoneyException("Input money greater than zero.");
                    }catch(InputMismatchException e){
                        System.out.println("Enter number !");
                    } catch (negativeMoneyException e) {
                        System.out.println(e.getMessage());
                    }
                    c.nextLine();
                    break;
                case STATEMENT:
                    newUser.printStatement();
                    break;
                case SAVE:
                    saveAccounts(DATA_FILE, accounts);
                    break;
                case LOAD:
                    ArrayList<BankAccount> loaded = loadAccounts(DATA_FILE);
                    if (loaded != null) {
                        loaded.sort(Comparator.comparing(BankAccount::getAccountHolder));
                        System.out.println("\nLoaded accounts (sorted by holder name):");
                        loaded.forEach(acc -> System.out.println(
                                acc.getAccountNo() + " - " + acc.getAccountHolder() +
                                        " (" + acc.getAccountType() + ") balance=" +
                                        moneyFormat.format(acc.getBalance())
                        ));
                    }
                    break;
            }
        }
    }

    private static AccountType askAccountType(Scanner scanner) {
        while (true) {
            System.out.println("Choose account type: 1. SAVINGS  2. CURRENT");
            String choice = scanner.nextLine();
            if (Objects.equals(choice, "1")) {
                return AccountType.SAVINGS;
            } else if (Objects.equals(choice, "2")) {
                return AccountType.CURRENT;
            } else {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }
    }

    private static void saveAccounts(String fileName, ArrayList<BankAccount> accounts) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(accounts);
            System.out.println("Accounts saved to " + new File(fileName).getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to save accounts: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static ArrayList<BankAccount> loadAccounts(String fileName) {
        File f = new File(fileName);
        if (!f.exists()) {
            System.out.println("No saved accounts found.");
            return null;
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj = in.readObject();
            if (obj instanceof ArrayList) {
                return (ArrayList<BankAccount>) obj;
            }
            System.out.println("Unexpected data in file.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Failed to load accounts: " + e.getMessage());
        }
        return null;
    }
}
