package atm.system;

import javax.swing.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener {
    private final JTextField amountField;
    private final JButton depositBtn, withdrawBtn, checkBtn;
    private final SavingsAccount account;

    public Menu(SavingsAccount account) {
        this.account = account;

        setTitle("ATM Menu");
        setSize(400, 250);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel amtLabel = new JLabel("Enter Amount:");
        amtLabel.setBounds(70, 30, 120, 30);
        add(amtLabel);

        amountField = new JTextField();
        amountField.setBounds(170, 30, 150, 30);
        add(amountField);

        depositBtn = new JButton("Deposit");
        depositBtn.setBounds(40, 90, 140, 30);
        depositBtn.addActionListener(this);
        add(depositBtn);

        withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(210, 90, 140, 30);
        withdrawBtn.addActionListener(this);
        add(withdrawBtn);

        checkBtn = new JButton("Check Balance");
        checkBtn.setBounds(120, 150, 160, 30);
        checkBtn.addActionListener(this);
        add(checkBtn);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String amtText = amountField.getText().trim();

        if (e.getSource() == checkBtn) {
            account.checkBalance();
            return;
        }

        if (amtText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an amount.");
            return;
        }

        try {
            int amount = Integer.parseInt(amtText);

            if (e.getSource() == depositBtn) {
                account.deposit(amount);
            } else if (e.getSource() == withdrawBtn) {
                account.withdraw(amount);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid number format!", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
