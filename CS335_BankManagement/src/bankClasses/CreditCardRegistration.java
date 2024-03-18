package bankClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CreditCardRegistration{
	
	public static void main(String args[]) {

        //Creating the Frame
        JFrame frame = new JFrame("Credit Card Registration Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(null);
        
        // Label for personal information
        JLabel personalInfoLabel = new JLabel("Personal Information:");
        personalInfoLabel.setBounds(10, 0, 150, 25); // Adjust the position and size as needed
        panel.add(personalInfoLabel);
        //Box for first name
        JLabel firstNameLabel = new JLabel("First name");
        firstNameLabel.setBounds(10, 20, 80, 25);
        panel.add(firstNameLabel);
        JTextField firstText = new JTextField(12);
        firstText.setBounds(100,20,165,25);
        panel.add(firstText);

        //Box for last name
        JLabel lastNameLabel = new JLabel("Last name");
        lastNameLabel.setBounds(10, 50, 80, 25);
        panel.add(lastNameLabel);
        JTextField lastText = new JTextField(12);
        lastText.setBounds(100,50,165,25);
        panel.add(lastText);
        
        // Label for identification
        JLabel identificationLabel = new JLabel("Identification: ");
        personalInfoLabel.setBounds(10, 80, 150, 25); // Adjust the position and size as needed
        panel.add(identificationLabel);

        //Box for DOB
        JLabel dobLabel = new JLabel("Date of birth");
        dobLabel.setBounds(10, 110, 80, 25);
        panel.add(dobLabel);
        JTextField dobText = new JTextField(12);
        dobText.setBounds(100,110,165,25);
        panel.add(dobText);

        //Box for SSN
        JLabel numberLabel = new JLabel("SSN");
        numberLabel.setBounds(10,140,80,25);
        panel.add(numberLabel);
        JTextField numberText = new JTextField(12);
        numberText.setBounds(100,140,165,25);
        panel.add(numberText);
        
        // Label for identification
        JLabel homeLabel = new JLabel("Home address: ");
        homeLabel.setBounds(10, 170, 150, 25); // Adjust the position and size as needed
        panel.add(homeLabel);
        
        //Box for home address
        JLabel address = new JLabel("Address: ");
        address.setBounds(10, 200, 100, 25);
        panel.add(address);
        JTextField homeaddressText = new JTextField(12);
        homeaddressText.setBounds(100,200,165,25);
        panel.add(homeaddressText);
        
        // Label for contact
        JLabel contactLabel = new JLabel("Contact Information: ");
        contactLabel.setBounds(10, 230, 150, 25); // Adjust the position and size as needed
        panel.add(contactLabel);

        //Box for email
        JLabel emailLabel = new JLabel("Email address");
        emailLabel.setBounds(10, 260, 100, 25);
        panel.add(emailLabel);
        JTextField emailText = new JTextField(12);
        emailText.setBounds(100, 260, 165, 25);
        panel.add(emailText);
        
        //Box for phone number
        JLabel phoneLabel = new JLabel("Phone number: ");
        phoneLabel.setBounds(10, 290, 100, 25);
        panel.add(phoneLabel);
        JTextField phoneText = new JTextField(12);
        phoneText.setBounds(100, 290, 165, 25);
        panel.add(phoneText);
     
        //Registration button
        JButton registrationButton = new JButton("Register");
        registrationButton.setBounds(10, 330, 120, 25);
        panel.add(registrationButton);

        //Display message
        JLabel messageLabel = new JLabel();
        messageLabel.setBounds(100,400,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,20));
        panel.add(messageLabel);

        frame.setVisible(true);

        registrationButton.addActionListener((ActionEvent e) -> {
            String firstName = firstText.getText();
            String lastName = lastText.getText();
            String email = emailText.getText();
            String dob = dobText.getText();
            String number = numberText.getText();
            String home = homeaddressText.getText();   
            String phone = phoneText.getText();
           
            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || dob.isEmpty() || number.isEmpty()||home.isEmpty()||phone.isEmpty()) {
                // If any of the fields are empty, display an error message
                messageLabel.setText("Please fill in all fields");
            } else {
                messageLabel.setForeground(Color.blue);
                messageLabel.setText("Registration successful!");
            }
            
        });
    }

}
