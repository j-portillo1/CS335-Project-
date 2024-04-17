package bankClasses;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
//import java.awt.event.ActionListener;
import java.io.IOException;

public class CustomerRegistrationGUI {
	
	CustomerRegistrationGUI(){
	

        //Creating the Frame
        JFrame frame = new JFrame("User Registration Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(null);

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

        //Box for email
        JLabel emailLabel = new JLabel("Email address");
        emailLabel.setBounds(10, 80, 100, 25);
        panel.add(emailLabel);
        JTextField emailText = new JTextField(12);
        emailText.setBounds(100,80,165,25);
        panel.add(emailText);

        //Box for DOB
        JLabel dobLabel = new JLabel("Date of birth");
        dobLabel.setBounds(10, 110, 80, 25);
        panel.add(dobLabel);
        JTextField dobText = new JTextField(12);
        dobText.setBounds(100,110,165,25);
        panel.add(dobText);

        //Box for password
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,140,80,25);
        panel.add(passwordLabel);
        JPasswordField passwordText = new JPasswordField(12);
        passwordText.setBounds(100,140,165,25);
        panel.add(passwordText);

        //Registration button
        JButton registrationButton = new JButton("Register");
        registrationButton.setBounds(10, 170, 120, 25);
        panel.add(registrationButton);

        //Display message
        JLabel messageLabel = new JLabel();
        messageLabel.setBounds(100,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,20));
        panel.add(messageLabel);

        frame.setVisible(true);

        registrationButton.addActionListener((ActionEvent e) -> {
            String firstName = firstText.getText();
            String lastName = lastText.getText();
            String email = emailText.getText();
            String dob = dobText.getText();
            String password = new String(passwordText.getPassword());
            frame.dispose();
        	new LoginGUI();
        	


            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || dob.isEmpty() || password.isEmpty()) {
                // If any of the fields are empty, display an error message
                messageLabel.setText("Please fill in all fields");
            } else {
                messageLabel.setForeground(Color.blue);
                messageLabel.setText("Registration successful!");
                
                try {
                    String firstColumn;
                    String secondColumn;
                    FileReader reader = new FileReader("data/CustomerList.csv");
                    BufferedReader buffReader = new BufferedReader(reader);
                    		
                    String fline;
                    while((fline =buffReader.readLine() ) != null) {
            			String[] columns = fline.split(",");
            			if (columns.length >= 2) {
                    		firstColumn = columns[0].trim();
                    		secondColumn = columns[0].trim();
            				if((firstName.equals(firstColumn)) & (lastName.equals(secondColumn))){
                    			System.out.println("Customer Account already exist. Please login with your credentials");}
            					}

            				}
            				buffReader.close();
            			}catch(IOException er){
            				er.printStackTrace();
            			}
                    			
                    			
            
            
          //File file = new File("data/CustomerList.csv");		
     	   try(FileWriter writer = new FileWriter("data/CustomerList.csv", true)){
     	      //FileWriter output = new FileWriter( file );
     	      //BufferedWriter writer = new BufferedWriter(output);
     	        writer.append(firstName + ",");
     	        writer.append(lastName + ",");
     	        writer.append(email + ",");
     	        writer.append(dob + ",");
     	        writer.append(password + ",");
     	        writer.append("\n");
     	        
     	    } catch(IOException e1){
     	       e1.printStackTrace();
     	      messageLabel.setText("Error occurred while writing to file");}
            }
     	


            
        });
        
	}
        public static void main(String[] args) {
    		
    		new CustomerRegistrationGUI();
    		
    		
    	}


}
