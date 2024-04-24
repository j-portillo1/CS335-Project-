package bankClasses;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InsertMoneyGUI {
    private Customer loginCustomer; // Customer object passed to the constructor

    public InsertMoneyGUI(Customer loginCustomer) {
        this.loginCustomer = loginCustomer;

        JFrame frame = new JFrame("Insert Money Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 200);
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel moneyInfoLabel = new JLabel("Enter amount of money you want to deposit: ");
        moneyInfoLabel.setBounds(10, 20, 300, 25);
        panel.add(moneyInfoLabel);
        JTextField moneyText = new JTextField(12);
        moneyText.setBounds(300, 20, 175, 25);
        panel.add(moneyText);

        JLabel accNameLabel = new JLabel("Choose account you want to insert (Checking/Saving): ");
        accNameLabel.setBounds(10, 50, 350, 25);
        panel.add(accNameLabel);
        JTextField accText = new JTextField(12);
        accText.setBounds(360, 50, 175, 25);
        panel.add(accText);

        JButton insertButton = new JButton("Insert");
        insertButton.setBounds(10, 100, 120, 25);
        panel.add(insertButton);

        JLabel messageLabel = new JLabel();
        messageLabel.setBounds(250, 130, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 20));
        panel.add(messageLabel);

        frame.setVisible(true);

        insertButton.addActionListener((ActionEvent e) -> {
            String money = moneyText.getText();
            String acc = accText.getText();

            if (money.isEmpty() || acc.isEmpty()) {
                messageLabel.setText("Please fill in all fields");
            } else {
                // Find the selected account in the customer's account list
                Account account = null;
                if (acc.equalsIgnoreCase("Checking")) {
                    account = loginCustomer.getCheckingAccount();
                } else if (acc.equalsIgnoreCase("Saving")) {
                    account = loginCustomer.getSavingAccount();
                }

                if (account != null) {
                    Integer amount = Integer.parseInt(money);
                    account.insert(amount);
                    messageLabel.setText("Money inserted successfully.");
                } else {
                    messageLabel.setText("No account found. Please check your account type.");
                }
            }
        });
    }
}