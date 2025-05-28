package atm.system;

import javax.swing.JOptionPane;

public class SavingsAccount extends Account implements ATMOperations {
    private final String correctPIN = "1234";

    public SavingsAccount(String accNumber, int balance) {
        super(accNumber, balance);
    }

    @Override
    public void validatePIN(String pin) {
        if (!pin.equals(correctPIN)) {
            throw new InvalidPINException("Invalid PIN entered!");
        }
    }

    @Override
    public void checkBalance() {
        JOptionPane.showMessageDialog(null, "Current Balance: $" + balance);
    }

    @Override
    public void deposit(int amount) {
        balance += amount;
        JOptionPane.showMessageDialog(null, "Deposited $" + amount);
    }

    @Override
    public void withdraw(int amount) {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient balance!");
        }
        balance -= amount;
        JOptionPane.showMessageDialog(null, "Withdrawn $" + amount);
    }
}
