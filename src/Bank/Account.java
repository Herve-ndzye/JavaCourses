package Bank;

class depositException extends Exception{
    depositException(String message){
        super(message);
    }
}
class withdrawException extends Exception{
    withdrawException(String message){
        super(message);
    }
}
public class Account extends Person {
    private static int AccountNo = 1232131;
    private double balance = 0;
    Account(String name,String dob){
        setName(name);
        setDob(dob);
    }

    public double getBalance() {
        return balance;
    }

    void deposit(double money){
        try {
            if(money <= 0)
                throw new depositException("The money to deposit should be positive");
            this.balance += money;
            System.out.println("Deposited successfully!!");
        }catch(depositException e){
            System.out.println(e.getMessage());
        }
    }
    void withdraw(double money){
        try {
            if(money > this.balance)
                throw new withdrawException("The money to withdraw should not be greater than your balance "+this.balance);
            this.balance -= money;
            System.out.println("Successfully withdrawn !!");
        }catch(withdrawException e){
            System.out.println(e.getMessage());
        }
    }
}
