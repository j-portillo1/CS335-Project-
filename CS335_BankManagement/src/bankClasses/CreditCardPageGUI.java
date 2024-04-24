package bankClasses;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;


public class CreditCardPageGUI{
	
	private GetCreditCardInfo creditHandler; // Declare the creditHandler

    CreditCardPageGUI(Customer loginCustomer) {
        this.creditHandler = new GetCreditCardInfo(); // Initialize the creditHandler

        CreditCard customerCard = creditHandler.findCreditCard(loginCustomer);

        JFrame frame = new JFrame("User Credit Card Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Use BoxLayout with Y_AXIS

        JLabel titleLabel = new JLabel("Credit Card Information");
        panel.add(titleLabel);

        // Display card type on a separate line
        JLabel cardTypeLabel = new JLabel("Card Type: " + customerCard.getClass().getSimpleName());
        panel.add(cardTypeLabel);

        // Display card number on a separate line
        JLabel cardNumberLabel = new JLabel("Card Number: " + customerCard.getCardNumber());
        panel.add(cardNumberLabel);

        // Display credit limit on a separate line
        JLabel cardLimitLabel = new JLabel("Limit: " + customerCard.getCreditLimit());
        panel.add(cardLimitLabel);

        // Display balance on a separate line
        JLabel cardBalLabel = new JLabel("Balance: " + customerCard.getBalance());
        panel.add(cardBalLabel);
        
        // Pay Balance
        JButton balanceButton = new JButton("Paying balance");
        balanceButton.addActionListener(e -> customerCard.payBalance(loginCustomer));
        panel.add(balanceButton);
        
        // Deactivate card
        JButton deactivateButton = new JButton("Deactivate your card");
        deactivateButton.addActionListener(e -> customerCard.changeStatus("Inactive"));
        panel.add(deactivateButton);
       
        // Create a button to open a new credit card
        JButton openNewCardButton = new JButton("Open New Credit Card");
        openNewCardButton.addActionListener(e -> new CreditCardRegistration());
        panel.add(openNewCardButton);

        frame.setVisible(true);
    }
}