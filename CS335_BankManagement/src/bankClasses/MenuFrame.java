package bankClasses;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;

public class MenuFrame extends JFrame implements ActionListener{

	JMenuBar menuBar;
	JMenu homeMenu;
	JMenu accountsMenu;
	JMenu helpMenu;
	JButton creditCardItem;
	JMenuItem documentsItem;
	JMenuItem logOutItem;
	ImageIcon creditCardIcon;
	ImageIcon documentsIcon;
	ImageIcon logOutIcon;
	
	Customer loggedInCustomer; // Store the logged-in customer
	JPanel accountInfoPanel; // Panel to display account information
	
	MenuFrame(Customer loginCus){		
		this.loggedInCustomer = loginCus; // Store the logged-in customer
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,400);
		this.setLayout(new FlowLayout());
		
		menuBar = new JMenuBar();
		
		homeMenu = new JMenu("Home");
		accountsMenu = new JMenu("Accounts");
		helpMenu = new JMenu("Help");
		
		creditCardIcon = new ImageIcon("data/creditcard.png");
		Image image = creditCardIcon.getImage();
		Image newimg = image.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
		creditCardItem = new JButton("Open Credit Card", new ImageIcon(newimg));
		
		documentsIcon = new ImageIcon("data/document-icon.png");
		Image image2 = documentsIcon.getImage();
		Image newimg2 = image2.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
		documentsItem = new JMenuItem("Documents", new ImageIcon(newimg2));
		
		logOutIcon = new ImageIcon("data/log-out-icon.png");
		Image image3 = logOutIcon.getImage();
		Image newimg3 = image3.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
		logOutItem = new JMenuItem("Log Out", new ImageIcon(newimg3));
		
		creditCardItem.addActionListener(this);
		documentsItem.addActionListener(this);
		logOutItem.addActionListener(this);
		
		homeMenu.setMnemonic(KeyEvent.VK_F);
		accountsMenu.setMnemonic(KeyEvent.VK_E);
		helpMenu.setMnemonic(KeyEvent.VK_H);
		creditCardItem.setMnemonic(KeyEvent.VK_L);
		documentsItem.setMnemonic(KeyEvent.VK_S);
		logOutItem.setMnemonic(KeyEvent.VK_E);
		
		homeMenu.add(creditCardItem);
		homeMenu.add(documentsItem);
		homeMenu.add(logOutItem);
		
		menuBar.add(homeMenu);
		menuBar.add(accountsMenu);
		menuBar.add(helpMenu);
		
		this.setJMenuBar(menuBar);
		
		// Create and add the account info panel
		accountInfoPanel = new JPanel();
		accountInfoPanel.setLayout(new BoxLayout(accountInfoPanel, BoxLayout.Y_AXIS));
		addAccountInfo();
		add(accountInfoPanel);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == creditCardItem) {
			System.out.println("Opening Credit Card Registration...");
			new CreditCardRegistration();
		} else if(e.getSource() == documentsItem) {
			System.out.println("Viewing statements and documents...");
		} else if(e.getSource() == logOutItem) {
			System.out.println("Logging out...");
			System.exit(0);
		}
	}
	
	// Method to add account information to the panel
	public void addAccountInfo() {
	    for (Account acc : loggedInCustomer.getAccountList()) {
	        if (acc.getAccType().equalsIgnoreCase("Checking")) {
	            JLabel checkingLabel = new JLabel("Checking: " + acc.getAccBal());
	            accountInfoPanel.add(checkingLabel);
	        } else if (acc.getAccType().equalsIgnoreCase("Saving")) {
	            JLabel savingLabel = new JLabel("Saving: " + acc.getAccBal());
	            accountInfoPanel.add(savingLabel);
	        }
	    }
	}
	
	public static void main(String[] args) {
		// Create a dummy customer for testing
		Customer dummyCustomer = new Customer("John", "Doe", "john@example.com", new Date(), "JD001", "password");
		dummyCustomer.addAccount(new Account(123456789, "Checking", 1000, "JD001"));
		dummyCustomer.addAccount(new Account(987654321, "Saving", 5000, "JD001"));
		
		// Create and display the MenuFrame with the dummy customer
		new MenuFrame(dummyCustomer);
	}

}
