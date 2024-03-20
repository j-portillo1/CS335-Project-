import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

public class LoginGUI {
	public static void main(String args[]) {

        //Creating the Frame
        JFrame frame = new JFrame("User Login Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(null);

        //Box for username
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(10, 20, 80, 25);
        panel.add(usernameLabel);
        JTextField userText = new JTextField(12);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        //Box for password
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);
        JTextField passwordText = new JPasswordField(12);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        //Login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 120, 25);
        panel.add(loginButton);

        //Display message
        JLabel messageLabel = new JLabel();
        messageLabel.setBounds(100,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,20));
        panel.add(messageLabel);

        frame.setVisible(true);

        loginButton.addActionListener((ActionEvent e) -> {
            String username = userText.getText();
            String password = passwordText.getText();
            if (username.isEmpty() || password.isEmpty()) {
                // If any of the fields are empty, display an error message
                messageLabel.setText("Please fill in all fields");
            } else {
                messageLabel.setForeground(Color.blue);
                messageLabel.setText("Login successful!");
            }
            
        });
    }

}
