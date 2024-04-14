package bankClasses;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.*;
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
	MenuFrame(){		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,400);
		this.setLayout(new FlowLayout());
		
		//creditCardIcon = new ImageIcon("data/creditcard.png");
		//documentsIcon = new ImageIcon("data/document-icon.png");
		//logOutIcon = new ImageIcon("data/log-out-icon.png");
		
		menuBar = new JMenuBar();
		
		homeMenu = new JMenu("Home");
		accountsMenu = new JMenu("Accounts");
		helpMenu = new JMenu("Help");
		
		
		ImageIcon creditCardIcon = new ImageIcon("data/creditcard.png");
		Image image = creditCardIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it smoothly  
		ImageIcon newImageIcon = new ImageIcon(newimg);
		creditCardItem = new JButton("Open Credit Card",newImageIcon);
		
		
		
		ImageIcon documentsIcon = new ImageIcon("data/document-icon.png");
		Image image2 = documentsIcon.getImage(); // transform it 
		Image newimg2 = image2.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it smoothly  
		ImageIcon docImageIcon = new ImageIcon(newimg2);
		documentsItem = new JMenuItem("Documents",docImageIcon);
		
		
		ImageIcon logOutIcon = new ImageIcon("data/log-out-icon.png");
		Image image3 = logOutIcon.getImage(); // transform it 
		Image newimg3 = image3.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it smoothly  
		ImageIcon logImageIcon = new ImageIcon(newimg3);
		logOutItem = new JMenuItem("Log Out",logImageIcon);
		
		creditCardItem.addActionListener(this);
		documentsItem.addActionListener(this);
		logOutItem.addActionListener(this);
		
		//creditCardIcon.setImage(creditCardIcon);
		//documentsIcon.setImage(documentsIcon);
		//logOutIcon.setIconImage(logOutIcon);
		
		
		
		
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
		
		
		 creditCardItem.addActionListener((ActionEvent ae) -> {
				JFrame jFrame = new JFrame();
				jFrame.dispose();
	        	new CreditCardRegistration();
	      
	        	
	     	   
	      	  
	        });
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
