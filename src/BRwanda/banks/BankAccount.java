package BRwanda.banks;

public class BankAccount {
     static int starter = 0001;
    public int AccountNo;
    private String AccountHolder;
    private double balance = 0;

    public String getAccountHolder() {
        return AccountHolder;
    }

    public int getAccountNo() {
        return AccountNo;
    }

    public  BankAccount(String holder){
        this.AccountHolder = holder;
        starter+=1;
        this.AccountNo = starter;
    }
    public void Deposit(double amount){
        this.balance+=amount;
    }
    public void withdraw(double amount){
        this.balance-=amount;
    }
    public double getBalance(){
        return this.balance;
    }
}
class choiceException extends Exception{
    public choiceException(String message) {
        super(message);
    }
}
