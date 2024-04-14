package bankClasses;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class logIn{
	protected HashMap<String, String> userPasswords;
    private int maxAttempts = 3;
    
    public logIn() {
        userPasswords = new HashMap<>();
        loadUserCredentials("data/CustomerList.csv");
    }
    
    public void addUser(String username, String password) {
        userPasswords.put(username, password);  
    }
    
    public boolean login(String username, String password) {
        
        if(!userPasswords.containsKey(username)) {
            System.out.println("Username does not exist"); 
            return false;
        }
        
        String storedPassword = userPasswords.get(username);
        
        if(!password.equals(storedPassword)) {
            System.out.println("Incorrect password");
            return false; 
        }
        
        return true;
    }
    
    public void authenticateUser() {
    
        Scanner scanner = new Scanner(System.in); 
        
        int attempts = 0;
        while (attempts < maxAttempts) {
            System.out.printf("Enter username: ");
            String username = scanner.nextLine();
            System.out.printf("Enter password: ");
            String password = scanner.nextLine();

            if (login(username, password)) {
                System.out.println("Login successful!");
                return;
            } else {
                System.out.println("Login failed. Please try again.");
            }
            attempts++;
        }

        scanner.close();
        System.out.println("Max attempts exceeded"); 
    }
    private void loadUserCredentials(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            // Skip the header line
            reader.readLine();

            // Read remaining lines
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by commas
                String[] parts = line.split(",");

                // Ensure the line has enough elements (username and password)
                if (parts.length >= 6) {
                    String username = parts[4].trim(); // Extract username from the 5th element
                    String password = parts[5].trim(); // Extract password from the 6th element
                    userPasswords.put(username, password);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}