package bankClasses;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OpenBankAccountGUI {
    
    private Customer customer;

    OpenBankAccountGUI(Customer newCustomer) throws IOException {
        this.customer = newCustomer;
        // Creating the Frame
        JFrame frame = new JFrame("Open Bank Account");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 300);
        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(null);

        // Dropdown for checking account
        JLabel checkingLabel = new JLabel("Open Checking Account (Yes/No): ");
        checkingLabel.setBounds(10, 20, 225, 25);
        panel.add(checkingLabel);
        String[] yesNoOptions = { "Yes", "No" };
        JComboBox<String> checkingDropdown = new JComboBox<>(yesNoOptions);
        checkingDropdown.setBounds(225, 20, 150, 25);
        panel.add(checkingDropdown);

        // Box for checking account deposit amount
        JLabel checkingBalLabel = new JLabel(
                "Enter amount of money you want to deposit into your checking account: ");
        checkingBalLabel.setBounds(10, 50, 475, 25);
        panel.add(checkingBalLabel);
        JTextField checkingBalText = new JTextField(12);
        checkingBalText.setBounds(475, 50, 165, 25);
        panel.add(checkingBalText);
        checkingBalText.setEnabled(false); // Initially disabled

        // Dropdown for saving account
        JLabel savingLabel = new JLabel("Open Saving Account (Yes/No):");
        savingLabel.setBounds(10, 80, 225, 25);
        panel.add(savingLabel);
        JComboBox<String> savingDropdown = new JComboBox<>(yesNoOptions);
        savingDropdown.setBounds(225, 80, 150, 25);
        panel.add(savingDropdown);

        // Box for saving account deposit amount
        JLabel savingBalLabel = new JLabel(
                "Enter amount of money you want to deposit into your saving account:");
        savingBalLabel.setBounds(10, 110, 460, 25);
        panel.add(savingBalLabel);
        JTextField savingBalText = new JTextField(12);
        savingBalText.setBounds(460, 110, 165, 25);
        panel.add(savingBalText);
        savingBalText.setEnabled(false); // Initially disabled

        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(10, 150, 120, 25);
        panel.add(createAccountButton);

        JLabel messageLabel = new JLabel();
        messageLabel.setBounds(250, 200, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 20));
        panel.add(messageLabel);

        frame.setVisible(true);

        checkingDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkingDropdown.getSelectedItem().equals("Yes")) {
                    checkingBalText.setEnabled(true);
                } else {
                    checkingBalText.setEnabled(false);
                    checkingBalText.setText(""); // Clear the text field
                }
            }
        });

        savingDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (savingDropdown.getSelectedItem().equals("Yes")) {
                    savingBalText.setEnabled(true);
                } else {
                    savingBalText.setEnabled(false);
                    savingBalText.setText(""); // Clear the text field
                }
            }
        });
        
        createAccountButton.addActionListener((ActionEvent e) -> {
            String checking = (String) checkingDropdown.getSelectedItem();
            String checkingBalStr = checkingBalText.getText();
            String saving = (String) savingDropdown.getSelectedItem();
            String savingBalStr = savingBalText.getText();

            if (checking.isEmpty() || (checking.equals("Yes") && checkingBalStr.isEmpty()) || saving.isEmpty()
                    || (saving.equals("Yes") && savingBalStr.isEmpty())) {
                messageLabel.setText("Please fill in all fields");
            } else {
                // Successfully created account
                if (checking.equals("Yes")) {
                    int accCheckingNum = generateAccountNumber();
                    int checkingDeposit = Integer.parseInt(checkingBalStr);
                    Account checkingAccount = new Account(accCheckingNum, "Checking", checkingDeposit,
                            customer.getCustomerID());
                    customer.addAccount(checkingAccount);
                }
                if (saving.equals("Yes")) {
                    int accSavingNum = generateAccountNumber();
                    int savingDeposit = Integer.parseInt(savingBalStr);
                    Account savingAccount = new Account(accSavingNum, "Saving", savingDeposit,
                            customer.getCustomerID());
                    customer.addAccount(savingAccount);
                }
                messageLabel.setText("Successfully created account(s)");
            }
            
            try (FileWriter pw = new FileWriter("data/CustomerList.csv", true)) {
            	
            	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            	String formattedDate = dateFormat.format(customer.getDOB());
            	pw.append("\n");
                pw.append(customer.getFirstName() + ",");
                pw.append(customer.getLastName() + ",");
                pw.append(customer.getEmail() + ",");
                pw.append(formattedDate + ",");
                pw.append(customer.getCustomerID() + ",");
                pw.append(customer.getPassword() + ",");

                if (customer.getCheckingAccount()!=null&& customer.getSavingAccount()!=null) {
                    Account cusCheckAcc = customer.getCheckingAccount();
                    Account cusSavAcc = customer.getSavingAccount();
                    pw.append(cusCheckAcc.getAccNum() + ",");
                    pw.append(cusCheckAcc.getAccBal() + ",");
                    pw.append(cusSavAcc.getAccNum() + ",");
                    pw.append(cusSavAcc.getAccBal() +"\n");
                } else {
                    if (customer.getCheckingAccount()!=null) {
                        Account cusCheckAcc = customer.getCheckingAccount();
                        pw.append(cusCheckAcc.getAccNum() + ",");
                        pw.append(cusCheckAcc.getAccBal() + ",");
                        pw.append("0" + ",");
                        pw.append("0" + "\n");
                    } else if (customer.getSavingAccount()!=null) {
                        Account cusSavAcc = customer.getSavingAccount();
                        pw.append("0" + ",");
                        pw.append("0" + ",");
                        pw.append(cusSavAcc.getAccNum() + ",");
                        pw.append(Integer.toString(cusSavAcc.getAccBal()));
                        pw.append("\n");
                    } else {
                        pw.append("0" + ",");
                        pw.append("0" + ",");
                        pw.append("0" + ",");
                        pw.append("0" + "\n");
                    }
                }
            } catch (IOException e2) {
                System.out.println("Error writing to file ");
                e2.printStackTrace();
            }
        });
    }

    private int generateAccountNumber() {
        Random random = new Random();
        return random.nextInt(999999 - 100000 + 1) + 100000;
    }
}