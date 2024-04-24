package bankClasses;

import java.awt.FlowLayout;
import java.awt.Image;
import java.util.Date;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuFrame extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu accountsMenu;
    JMenuItem homeMenuItem;
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
        Image image = creditCardIcon.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
        JMenuItem creditCardMenuItem = new JMenuItem("Credit Card", new ImageIcon(image));

        logOutIcon = new ImageIcon("data/log-out-icon.png");
        Image image3 = logOutIcon.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
        logOutItem = new JMenuItem("Log Out", new ImageIcon(image3));

        creditCardMenuItem.addActionListener(this);
        logOutItem.addActionListener(this);

        menuBar.add(homeMenuItem);
        menuBar.add(accountsMenu);
        menuBar.add(creditCardMenuItem);
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
        if (e.getSource() == homeMenuItem) {
            displayHomePage();
        } else if (e.getActionCommand().equals("Credit Card")) {
            System.out.println("Opening Credit Card Page...");
            new CreditCardPageGUI(loggedInCustomer);
        } else if (e.getSource() == logOutItem) {
            System.out.println("Logging out...");
            System.exit(0);
        }
    }

    private void displayHomePage() {
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
