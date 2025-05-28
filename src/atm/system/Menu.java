package atm.system;

import javax.swing.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener {
    private final JTextField amountField;
    private final JButton checkButton;
    private final JButton depositButton;
    private final JButton withdrawButton;
    private final SavingsAccount account;

    public Menu(SavingsAccount account) {
        this.account = account;

        setTitle("ATM Menu");
        setSize(420, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel amountLabel = new JLabel("Enter Amount:");
        amountLabel.setBounds(50, 30, 120, 30);
        add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(180, 30, 150, 30);
        add(amountField);

        depositButton = new JButton("Deposit $");
        depositButton.setBounds(40, 90, 140, 30);
        depositButton.addActionListener(this);
        add(depositButton);

        withdrawButton = new JButton("Withdraw $");
        withdrawButton.setBounds(210, 90, 140, 30);
        withdrawButton.addActionListener(this);
        add(withdrawButton);

        checkButton = new JButton("Check Balance");
        checkButton.setBounds(120, 150, 160, 30);
        checkButton.addActionListener(this);
        add(checkButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == checkButton) {
                account.checkBalance();
                return;
            }

            String amtText = amountField.getText().trim();
            int amount = Integer.parseInt(amtText);

            if (amount <= 0) {
                JOptionPane.showMessageDialog(this, "Amount must be positive.");
                return;
            }

            if (e.getSource() == depositButton) {
                account.deposit(amount);
            } else if (e.getSource() == withdrawButton) {
                account.withdraw(amount);
            }

        } catch (InsufficientFundsException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Balance Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid positive number!", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
