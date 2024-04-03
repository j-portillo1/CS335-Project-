package bankClasses;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;



public class MenuFrame extends JFrame implements ActionListener{

	JMenuBar menuBar;
	JMenu homeMenu;
	JMenu accountsMenu;
	JMenu helpMenu;
	JMenuItem creditCardItem;
	JMenuItem documentsItem;
	JMenuItem logOutItem;
	//ImageIcon creditCardIcon;
	//ImageIcon documentsIcon;
	//ImageIcon logOutIcon;
	MenuFrame(){		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,300);
		this.setLayout(new FlowLayout());
		
		//creditCardIcon = new ImageIcon(".png");
		//documentsIcon = new ImageIcon(".png");
		//logOutIcon = new ImageIcon(".png");
		
		menuBar = new JMenuBar();
		
		homeMenu = new JMenu("Home");
		accountsMenu = new JMenu("Accounts");
		helpMenu = new JMenu("Help");
		
		creditCardItem = new JMenuItem("Open Credit Card");
		documentsItem = new JMenuItem("Documents");
		logOutItem = new JMenuItem("Log Out");
		
		creditCardItem.addActionListener(this);
		documentsItem.addActionListener(this);
		logOutItem.addActionListener(this);
		
		//creditCardIcon.setIcon(creditCardIcon);
		//documentsIcon.setIcon(documentsIcon);
		//logOutIcon.setIcon(logOutIcon);
		
		homeMenu.setMnemonic(KeyEvent.VK_F); // Alt + f for file
		accountsMenu.setMnemonic(KeyEvent.VK_E); // Alt + e for edit
		helpMenu.setMnemonic(KeyEvent.VK_H); // Alt + h for help
		creditCardItem.setMnemonic(KeyEvent.VK_L); // l for load
		documentsItem.setMnemonic(KeyEvent.VK_S); // s for save
		logOutItem.setMnemonic(KeyEvent.VK_E); // e for exit
		
		homeMenu.add(creditCardItem);
		homeMenu.add(documentsItem);
		homeMenu.add(logOutItem);
		
		menuBar.add(homeMenu);
		menuBar.add(accountsMenu);
		menuBar.add(helpMenu);
		
		this.setJMenuBar(menuBar);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==creditCardItem) {
			System.out.println("you will be navigated to Credit card Registration");
		}
		if(e.getSource()==documentsItem) {
			System.out.println("Statements, documents etc.. ");
		}
		if(e.getSource()==logOutItem) {
			System.exit(0);
		}
	}
public static void main(String[] args) {
		
		new MenuFrame();
		
		
	}

}

