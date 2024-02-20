package bankClasses;

import java.util.HashMap;
import java.util.Scanner;

class logIn{
	protected HashMap<String, String> userPasswords;
    private int maxAttempts = 3;

    public logIn() {
        userPasswords = new HashMap<>();
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
}