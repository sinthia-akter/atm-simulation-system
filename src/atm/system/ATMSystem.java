package atm.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATMSystem extends JFrame implements ActionListener {
    private final JPasswordField pinField;
    private final JButton loginBtn;
    private final SavingsAccount account;

    public ATMSystem() {
        account = new SavingsAccount("ACC1234", 0); 

        setTitle("ATM Login");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel pinLabel = new JLabel("Enter PIN:");
        pinLabel.setBounds(50, 45, 100, 25);
        add(pinLabel);

        pinField = new JPasswordField();
        pinField.setBounds(120, 45, 150, 25);
        add(pinField);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(130, 90, 80, 30);
        loginBtn.addActionListener(this);
        add(loginBtn);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pin = String.valueOf(pinField.getPassword());

        if (pin.equals("1234")) {
            this.dispose(); 
            new Menu(account); 
        } else {
            JOptionPane.showMessageDialog(this, "Invalid PIN!", "PIN Error", JOptionPane.ERROR_MESSAGE);
            pinField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ATMSystem::new);
    }
}
