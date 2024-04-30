package bankClasses;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCardRegistration {
    CreditCardRegistration() {
    	
    	JFrame frame = new JFrame("Credit Card Registration Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 800);
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel personalInfoLabel = new JLabel("Personal Information ");
        personalInfoLabel.setBounds(10, 0, 150, 25);
        panel.add(personalInfoLabel);

        JLabel firstNameLabel = new JLabel("First name");
        firstNameLabel.setBounds(10, 20, 80, 25);
        panel.add(firstNameLabel);
        JTextField firstText = new JTextField(12);
        firstText.setBounds(100, 20, 165, 25);
        panel.add(firstText);

        JLabel lastNameLabel = new JLabel("Last name");
        lastNameLabel.setBounds(10, 50, 80, 25);
        panel.add(lastNameLabel);
        JTextField lastText = new JTextField(12);
        lastText.setBounds(100, 50, 165, 25);
        panel.add(lastText);

        JLabel identificationLabel = new JLabel("Identification ");
        identificationLabel.setBounds(10, 80, 150, 25);
        panel.add(identificationLabel);

        JLabel dobLabel = new JLabel("Date of Birth (MM/DD/YYYY)");
        dobLabel.setBounds(10, 110, 180, 25);
        panel.add(dobLabel);

        JFormattedTextField[] dobText = {null};
        try {
            MaskFormatter dobMask = new MaskFormatter("##/##/####");
            dobText[0] = new JFormattedTextField(dobMask);
            dobText[0].setBounds(200, 110, 120, 25);
            panel.add(dobText[0]);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JLabel ssnLabel = new JLabel("SSN (###-##-####)");
        ssnLabel.setBounds(10, 140, 150, 25);
        panel.add(ssnLabel);

        JFormattedTextField[] numberText = {null};
        try {
            MaskFormatter ssnMask = new MaskFormatter("###-##-####");
            numberText[0] = new JFormattedTextField(ssnMask);
            numberText[0].setBounds(200, 140, 120, 25);
            panel.add(numberText[0]);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JLabel homeLabel = new JLabel("Home address ");
        homeLabel.setBounds(10, 170, 150, 25);
        panel.add(homeLabel);

        JLabel address = new JLabel("Address: ");
        address.setBounds(10, 200, 100, 25);
        panel.add(address);
        JTextField homeaddressText = new JTextField(12);
        homeaddressText.setBounds(100, 200, 165, 25);
        panel.add(homeaddressText);

        JLabel cityLabel = new JLabel("City: ");
        cityLabel.setBounds(10, 230, 100, 25);
        panel.add(cityLabel);
        JTextField cityText = new JTextField(12);
        cityText.setBounds(100, 230, 165, 25);
        panel.add(cityText);

        JLabel stateLabel = new JLabel("State/Province: ");
        stateLabel.setBounds(10, 260, 100, 25);
        panel.add(stateLabel);
        JTextField stateText = new JTextField(12);
        stateText.setBounds(100, 260, 165, 25);
        panel.add(stateText);

        JLabel zipCodeLabel = new JLabel("Zip Code: ");
        zipCodeLabel.setBounds(10, 290, 100, 25);
        panel.add(zipCodeLabel);
        JTextField zipCodeText = new JTextField(12);
        zipCodeText.setBounds(100, 290, 165, 25);
        panel.add(zipCodeText);
        
        zipCodeText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if(zipCodeText.getText().length()>=10&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
                    evt.consume();
                 }
             }
        });

        JLabel contactLabel = new JLabel("Contact Information ");
        contactLabel.setBounds(10, 320, 150, 25);
        panel.add(contactLabel);

        JLabel emailLabel = new JLabel("Email address: ");
        emailLabel.setBounds(10, 350, 100, 25);
        panel.add(emailLabel);
        JTextField emailText = new JTextField(12);
        emailText.setBounds(100, 350, 165, 25);
        panel.add(emailText);

        JLabel phoneLabel = new JLabel("Phone number (###) ###-####");
        phoneLabel.setBounds(10, 380, 200, 25);
        panel.add(phoneLabel);

        JFormattedTextField[] phoneText = {null};
        try {
            MaskFormatter phoneMask = new MaskFormatter("(###) ###-####");
            phoneText[0] = new JFormattedTextField(phoneMask);
            phoneText[0].setBounds(210, 380, 120, 25);
            panel.add(phoneText[0]);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JLabel financialLabel = new JLabel("Financial Information ");
        financialLabel.setBounds(10, 410, 150, 25);
        panel.add(financialLabel);

        JLabel residenceLabel = new JLabel("Type of residence: ");
        residenceLabel.setBounds(10, 440, 150, 25);
        panel.add(residenceLabel);
        JTextField residenceText = new JTextField(12);
        residenceText.setBounds(135, 440, 165, 25);
        panel.add(residenceText);

        JLabel employmentLabel = new JLabel("Employment status: ");
        employmentLabel.setBounds(10, 470, 150, 25);
        panel.add(employmentLabel);
        JTextField employmentText = new JTextField(12);
        employmentText.setBounds(135, 470, 165, 25);
        panel.add(employmentText);

        JLabel incomeLabel = new JLabel("Total gross income: ");
        incomeLabel.setBounds(10, 500, 150, 25);
        panel.add(incomeLabel);
        JTextField incomeText = new JTextField(12);
        incomeText.setBounds(135, 500, 165, 25);
        panel.add(incomeText);

        JLabel cardInfoLabel = new JLabel("Credit Card Information ");
        cardInfoLabel.setBounds(10, 530, 200, 25);
        panel.add(cardInfoLabel);

        JLabel creditLabel = new JLabel("Type of credit card: ");
        creditLabel.setBounds(10, 560, 150, 25);
        panel.add(creditLabel);
        JTextField creditText = new JTextField(12);
        creditText.setBounds(130, 560, 165, 25);
        panel.add(creditText);

        JButton registrationButton = new JButton("Register");
        registrationButton.setBounds(10, 610, 120, 25);
        panel.add(registrationButton);

        JLabel messageLabel = new JLabel();
        messageLabel.setBounds(100, 640, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 20));
        panel.add(messageLabel);

        frame.setVisible(true);
        
        registrationButton.addActionListener(e -> {
	        String firstName = firstText.getText();
	        String lastName = lastText.getText();
	        String email = emailText.getText();
	        String dob = dobText[0].getText();
	        String number = numberText[0].getText();
	        String home = homeaddressText.getText();
	        String phone = phoneText[0].getText();
	        String city = cityText.getText();
	        String state = stateText.getText();
	        String zipCode = zipCodeText.getText();
	        String residence = residenceText.getText();
	        String employment = employmentText.getText();
	        String income = incomeText.getText();
	        String credit = creditText.getText();
	
	        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || dob.isEmpty() || number.isEmpty() || home.isEmpty() || phone.isEmpty() || credit.isEmpty()) {
	        	messageLabel.setText("Please fill in all fields");
	        } else if (!isValidEmail(email)) {
	            messageLabel.setText("Invalid email address");
	        } else if (!isValidSSN(number)) {
	            messageLabel.setText("Invalid SSN");
	        } else if (!isValidZipCode(zipCode)) {
	            messageLabel.setText("Invalid ZIP code");
	        } else {
	            messageLabel.setForeground(Color.blue);
	            messageLabel.setText("Registration successful!");
	            panel.repaint();
	            try (FileWriter writer = new FileWriter("data/CreditList.csv", true)) {
	                    writer.append(firstName + ",");
	                    writer.append(lastName + ",");
	                    writer.append(email + ",");
	                    writer.append(dob + ",");
	                    writer.append(phone + ",");
	                    writer.append(number + ",");
	                    writer.append(home + ",");
	                    writer.append(city + ",");
	                    writer.append(state + ",");
	                    writer.append(zipCode + ",");
	                    writer.append(residence + ",");
	                    writer.append(employment + ",");
	                    writer.append(income + ",");
	                    writer.append(credit);
	                    writer.append("\n");
	             } catch (IOException e1) {
	                    e1.printStackTrace();
	                    messageLabel.setText("Error occurred while writing to file");
	                }
	            }
	        try {
				cardApproval();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
        });
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean isValidSSN(String ssn) {
        String ssnRegex = "^(?!000|666|9\\d\\d)\\d{3}-(?!00)\\d{2}-(?!0000)\\d{4}$";
        Pattern pattern = Pattern.compile(ssnRegex);
        Matcher matcher = pattern.matcher(ssn);
        return matcher.matches();
    }

    private static boolean isValidZipCode(String zipCode) {
        String zipRegex = "^\\d{5}(?:[-\\s]\\d{4})?$";
        Pattern pattern = Pattern.compile(zipRegex);
        Matcher matcher = pattern.matcher(zipCode);
        return matcher.matches();
    }
    public static void main(String args[]) {
    	new CreditCardRegistration();
    }
    
    private static void cardApproval () throws FileNotFoundException {
    	File creditCSVFile = new File("data/CreditList.csv"); 
		File customerCSVFile = new File("data/CustomerList.csv");
		
		Scanner customer = new Scanner(customerCSVFile);
		Scanner credit = new Scanner(creditCSVFile);
        String line = "";
        String cusUsername ="";
        while (credit.hasNextLine()) {
        	line = credit.nextLine();
        	System.out.println(line);
        	String[] data = line.split(",");
            double income = Double.parseDouble(data[12]);
            String creditCardType = data[data.length - 1];
                
            while (customer.hasNextLine()) {
            	String customerData = customer.nextLine();
                String[] arrOfStr = customerData.split(",");
                String firstName = arrOfStr[0];
                if (firstName.equals(data[0])) {
                   cusUsername = arrOfStr[4];
                   System.out.println(cusUsername);
                }
            }
            
          //Create credit cards for users
    		VisaCard visaBalance500 = new VisaCard("4242424242424242", 200, 500, 233, cusUsername);
    		VisaCard visaBalance1000 = new VisaCard("4035501000000008", 680, 1000, 737, cusUsername);
    		
    		DiscoverCard discBalance500 = new DiscoverCard("6011000990139424", 75, 500, 264, cusUsername);
    		DiscoverCard discBalance1000 = new DiscoverCard("6011111111111117", 450, 500, 882, cusUsername);
    		
    		MasterCard masBalance500 = new MasterCard("5105105105105100", 300, 500, 321, cusUsername);
    		MasterCard masBalance1000 = new MasterCard("5555555555554444", 60, 500, 642, cusUsername);
              
            CreditCardApproval approvalProcess = new CreditCardApproval();
            String approvalDecision = approvalProcess.decideCreditCardApproval(data[0],
                		data[1],data[2],data[3],data[4],data[5],data[6],data[7],data[8],
                		data[9],data[10],data[11],income,creditCardType);
                
            if (!approvalDecision.equals("Denied")) {
            	System.out.println(approvalDecision);
				if (creditCardType.equals("Visa") && approvalDecision.equals("Approved with $500 balance")) {
                	VisaCard customerCard = visaBalance500;}
				else if (creditCardType.equals("Visa") && approvalDecision.equals("Approved with $1000 balance")) {
                	VisaCard customerCard = visaBalance1000;}
				else if (creditCardType.equals("Discover") && approvalDecision.equals("Approved with $500 balance")) {
                	DiscoverCard customerCard = discBalance500;}
				else if (creditCardType.equals("Discover") && approvalDecision.equals("Approved with $1000 balance")) {
                	DiscoverCard customerCard = discBalance1000;}
				else if (creditCardType.equals("Mastercard") && approvalDecision.equals("Approved with $500 balance")) {
                	MasterCard customerCard = masBalance500;}
                else {
                	MasterCard customerCard = masBalance1000;}
            }
            
            else {
                System.out.println("You were denied a credit card");
            } 
            customer.close();
            credit.close();
	    }
    }
}
