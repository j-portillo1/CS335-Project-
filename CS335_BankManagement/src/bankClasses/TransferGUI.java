package bankClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

public class TransferGUI {

    private Customer loggedInCustomer;

    public TransferGUI(Customer loggedInCustomer) {
        this.loggedInCustomer = loggedInCustomer;

        JFrame frame = new JFrame("Internal Transfer");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 200);
        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(new GridLayout(4, 2));

        JLabel fromAccountLabel = new JLabel("From Account:");
        JComboBox<String> fromAccountDropdown = new JComboBox<>(new String[]{"Checking", "Saving"});
        JLabel toAccountLabel = new JLabel("To Account:");
        JComboBox<String> toAccountDropdown = new JComboBox<>(new String[]{"Checking", "Saving"});
        JLabel amountLabel = new JLabel("Amount:");
        JTextField amountField = new JTextField();

        panel.add(fromAccountLabel);
        panel.add(fromAccountDropdown);
        panel.add(toAccountLabel);
        panel.add(toAccountDropdown);
        panel.add(amountLabel);
        panel.add(amountField);

        JButton transferButton = new JButton("Transfer");
        panel.add(transferButton);

        JLabel messageLabel = new JLabel();
        panel.add(messageLabel);

        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fromAccountType = (String) fromAccountDropdown.getSelectedItem();
                String toAccountType = (String) toAccountDropdown.getSelectedItem();
                int amount;
                try {
                    amount = Integer.parseInt(amountField.getText());
                } catch (NumberFormatException ex) {
                    messageLabel.setText("Invalid amount.");
                    return;
                }

                try {
                    InternalTransfer.transferBetweenAccounts(loggedInCustomer, fromAccountType, toAccountType, amount);
                    messageLabel.setText("Transfer successful.");
                } catch (Exception ex) {
                    messageLabel.setText("Error: " + ex.getMessage());
                }
            }
        });

        frame.setVisible(true);
    }
}
