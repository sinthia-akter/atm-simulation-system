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
            JOptionPane.showMessageDialog(null, "Invalid PIN entered!", "PIN Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void checkBalance() {
        JOptionPane.showMessageDialog(null, "Current Balance: $" + balance);
    }
    
    @Override
    public void withdraw(int amount) {
        if (amount <= 0) {
            JOptionPane.showMessageDialog(null, "Withdrawal amount must be positive!", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (amount > balance) {
            JOptionPane.showMessageDialog(null, "Insufficient balance!", "Balance Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        balance -= amount;
        JOptionPane.showMessageDialog(null, "Withdrawn $" + amount);
    }

    @Override
    public void deposit(int amount) {
        if (amount <= 0) {
            JOptionPane.showMessageDialog(null, "Deposit amount must be positive!", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        balance += amount;
        JOptionPane.showMessageDialog(null, "Deposited $" + amount);
    }
   
}
