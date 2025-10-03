package MyStudies;

public class OOPClass {
    private int balance = 2;

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int deposited) {
        this.balance += deposited;
    }

    OOPClass() {
        this.balance = this.getBalance();
    }
}
