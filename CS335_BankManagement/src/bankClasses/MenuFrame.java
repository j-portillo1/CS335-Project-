package bankClasses;

import java.util.Date;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuFrame extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenuItem accountsItem;
    JMenuItem homeMenuItem;
    JMenuItem logOutItem;

    ImageIcon creditCardIcon;
    ImageIcon logOutIcon;

    JPanel homePage;
    Customer loggedInCustomer;
    JPanel accountInfoPanel;

    MenuFrame(Customer loginCus) {
        this.loggedInCustomer = loginCus;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLayout(new FlowLayout());
        menuBar = new JMenuBar();

        
        ImageIcon homeIcon = new ImageIcon ("data/homeIcon.png");
        Image image1 = homeIcon.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
        homeMenuItem = new JMenuItem("Home", new ImageIcon(image1));
        homeMenuItem.addActionListener(this);
        
        ImageIcon accountsIcon = new ImageIcon ("data/Accounts.png");
        Image image2 = accountsIcon.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
        accountsItem = new JMenuItem("Accounts",new ImageIcon(image2));

        creditCardIcon = new ImageIcon("data/creditcard.png");
        Image image3 = creditCardIcon.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
        JMenuItem creditCardMenuItem = new JMenuItem("Credit Card", new ImageIcon(image3));

        logOutIcon = new ImageIcon("data/log-out-icon.png");
        Image image4 = logOutIcon.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
        logOutItem = new JMenuItem("Log Out", new ImageIcon(image4));

        accountsItem.addActionListener(this);
        creditCardMenuItem.addActionListener(this);
        logOutItem.addActionListener(this);

        menuBar.add(homeMenuItem);
        menuBar.add(accountsItem);
        menuBar.add(creditCardMenuItem);
        menuBar.add(logOutItem);

        this.setJMenuBar(menuBar);
        
        displayHomePage();
        

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == accountsItem) {
            displayAccountsPage();
        } else if (e.getActionCommand().equals("Credit Card")) {
            System.out.println("Opening Credit Card Page...");
            new CreditCardPageGUI(loggedInCustomer);
        } else if (e.getSource() == logOutItem) {
            System.out.println("Logging out...");
            System.exit(0);
        }
    }
    
    private void displayHomePage() {
    	 homePage = new JPanel();
         //homePage.setLayout(new FlowLayout(FlowLayout.CENTER,100,100));
         ImageIcon logo = new ImageIcon("data/Logo.jpeg");
         Image imagelogo = logo.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
         JMenuItem logoItem = new JMenuItem("BANK",new ImageIcon(imagelogo));
         
         homePage.add(logoItem,BorderLayout.NORTH);
        
         add(homePage);
         
         JTextArea instructions = new JTextArea();
         instructions.setText("Instructions:\n"
                 + "1. To view your Savings and or Checking Account(s) Please click on Accounts tab Above.\n"
                 + "2. To Apply for a credit card, pay existing balance or deactivate card Please click on Credit Card tab Above .\n"
                 + "3. To Log Out Please Click on Log Out tab above\n"
                 + "Thank you for choosing MJA Bank! ");
         instructions.setEditable(false);
         
         
         getContentPane().add(instructions,BorderLayout.PAGE_END);

        

    	
    }

    private void displayAccountsPage() {
    	accountInfoPanel = new JPanel();
        accountInfoPanel.setLayout(new BoxLayout(accountInfoPanel, BoxLayout.Y_AXIS));
        addAccountInfo();
        add(accountInfoPanel);

        accountInfoPanel.removeAll();
        addAccountInfo();
        homeMenuItem.setForeground(Color.BLUE);
        homeMenuItem.setFont(homeMenuItem.getFont().deriveFont(Font.BOLD));
        accountInfoPanel.revalidate();
        accountInfoPanel.repaint();
    }

    public void addAccountInfo() {
        for (Account acc : loggedInCustomer.getAccountList()) {
            JPanel accountPanel = new JPanel();
            accountPanel.setLayout(new BorderLayout());

            JButton accountTypeButton = new JButton(acc.getAccType());
            accountTypeButton.setEnabled(false);
            accountPanel.add(accountTypeButton, BorderLayout.WEST);

            JPanel detailsPanel = new JPanel(new GridLayout(2, 1));
            detailsPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

            JLabel accountNumberLabel = new JLabel("Account Number: " + acc.getAccNum());
            detailsPanel.add(accountNumberLabel);

            JLabel balanceLabel = new JLabel("Balance: " + acc.getAccBal());
            detailsPanel.add(balanceLabel);

            accountPanel.add(detailsPanel, BorderLayout.CENTER);

            accountInfoPanel.add(accountPanel);
        }
    }

    public static void main(String[] args) {
        Customer dummyCustomer = new Customer("John", "Doe", "john@example.com", new Date(), "JD001", "password");
        dummyCustomer.addAccount(new Account(123456789, "Checking", 1000, "JD001"));
        dummyCustomer.addAccount(new Account(987654321, "Saving", 5000, "JD001"));

        new MenuFrame(dummyCustomer);
    }
}
