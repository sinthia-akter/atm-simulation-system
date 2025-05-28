package atm.system;

public abstract class Account {
    protected int balance;
    protected String accountNumber;

    public Account(String accNumber, int balance) {
        this.accountNumber = accNumber;
        this.balance = balance;
    }

    public abstract void deposit(int amount);
    public abstract void withdraw(int amount);
}
