package bankClasses;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class MenuFrame extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu accountsMenu;
    JMenuItem homeMenuItem; // New menu item for the Home page
    JButton creditCardMenu;
    JMenuItem logOutItem;

    ImageIcon creditCardIcon;
    ImageIcon logOutIcon;

    Customer loggedInCustomer;
    JPanel accountInfoPanel;

    MenuFrame(Customer loginCus) {
        this.loggedInCustomer = loginCus;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLayout(new FlowLayout());
        
        homeMenuItem = new JMenuItem("Home");
        homeMenuItem.addActionListener(this);

        menuBar = new JMenuBar();
        accountsMenu = new JMenu("Accounts");

        creditCardIcon = new ImageIcon("data/creditcard.png");
        Image image = creditCardIcon.getImage();
        Image newimg = image.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
        creditCardMenu = new JButton("Open Credit Card", new ImageIcon(newimg));

        logOutIcon = new ImageIcon("data/log-out-icon.png");
        Image image3 = logOutIcon.getImage();
        Image newimg3 = image3.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
        logOutItem = new JMenuItem("Log Out", new ImageIcon(newimg3));

        creditCardMenu.addActionListener(this);
        logOutItem.addActionListener(this);
        
        menuBar.add(homeMenuItem); // Add Home menu item to the menu bar
        menuBar.add(accountsMenu);
        menuBar.add(creditCardMenu);
        menuBar.add(logOutItem);

        this.setJMenuBar(menuBar);

        accountInfoPanel = new JPanel();
        accountInfoPanel.setLayout(new BoxLayout(accountInfoPanel, BoxLayout.Y_AXIS));
        addAccountInfo();
        add(accountInfoPanel);
        
        displayHomePage();

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homeMenuItem) { // If Home menu item is clicked
            displayHomePage(); // Display the Home page
        } else if (e.getSource() == creditCardMenu) {
            System.out.println("Opening Credit Card Registration...");
            new CreditCardRegistration();
        } else if (e.getSource() == logOutItem) {
            System.out.println("Logging out...");
            System.exit(0);
        }
    }

    // Method to display the Home page
    private void displayHomePage() {
        // Clear the panel
        accountInfoPanel.removeAll();
             
        // Re-add the account information
        addAccountInfo();
        
        // Change appearance of "Home" menu item
        homeMenuItem.setForeground(Color.BLUE); // Change text color
        homeMenuItem.setFont(homeMenuItem.getFont().deriveFont(Font.BOLD)); // Make text bold
        
        // Repaint the panel
        accountInfoPanel.revalidate();
        accountInfoPanel.repaint();
    }


    public void addAccountInfo() {
        for (Account acc : loggedInCustomer.getAccountList()) {
        	JPanel accountPanel = new JPanel(); // Panel to hold account information
            accountPanel.setLayout(new BorderLayout()); // Use BorderLayout for left and right alignment
            
            // Button for account type
            JButton accountTypeButton = new JButton(acc.getAccType());
            accountTypeButton.setEnabled(false); // Disable button to prevent interaction
            accountPanel.add(accountTypeButton, BorderLayout.WEST); // Align to the left
            
            // Panel to hold account details (account number and balance)
            JPanel detailsPanel = new JPanel(new GridLayout(2, 1)); // 2 rows, 1 column
            detailsPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Add padding
            
            // Label for account number
            JLabel accountNumberLabel = new JLabel("Account Number: " + acc.getAccNum());
            detailsPanel.add(accountNumberLabel);
            
            // Label for account balance
            JLabel balanceLabel = new JLabel("Balance: " + acc.getAccBal());
            detailsPanel.add(balanceLabel);
            
            accountPanel.add(detailsPanel, BorderLayout.CENTER); // Align details to the right
            
            accountInfoPanel.add(accountPanel); // Add account panel to main panel
        }
    }

    public static void main(String[] args) {
        Customer dummyCustomer = new Customer("John", "Doe", "john@example.com", new Date(), "JD001", "password");
        dummyCustomer.addAccount(new Account(123456789, "Checking", 1000, "JD001"));
        dummyCustomer.addAccount(new Account(987654321, "Saving", 5000, "JD001"));

        new MenuFrame(dummyCustomer);
    }
}
