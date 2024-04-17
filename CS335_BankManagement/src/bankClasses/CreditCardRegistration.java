package bankClasses;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCardRegistration {
    public static void main(String args[]) {
    	Scanner scanner = new Scanner(System.in);
        System.out.println("Personal Information");
        
        System.out.print("First name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last name: ");
        String lastName = scanner.nextLine();

        System.out.println();

        System.out.println("Identification");
        
        System.out.print("Date of Birth (MM/DD/YYYY): ");
        String dob = scanner.nextLine();
        System.out.print("SSN (###-##-####): ");
        String ssn = scanner.nextLine();

        System.out.println();
        
        System.out.println("Home Address");
        System.out.print("Address: ");
        String homeAddress = scanner.nextLine();
        System.out.print("City: ");
        String city = scanner.nextLine();
        System.out.print("State/Province: ");
        String state = scanner.nextLine();
        System.out.print("Zip Code: ");
        String zipCode = scanner.nextLine();
        
        System.out.println();

        System.out.println("Contact Information");
        System.out.print("Email address: ");
        String email = scanner.nextLine();
        System.out.print("Phone number (###) ###-####: ");
        String phone = scanner.nextLine();

        System.out.println();

        System.out.println("Financial Information");
        System.out.print("Type of residence (Apartment/Condo/House): ");
        String residence = scanner.nextLine();
        System.out.print("Employment status (Yes/No): ");
        String employment = scanner.nextLine();
        System.out.print("Total gross income: ");
        double income = scanner.nextInt();

        System.out.println();

        System.out.println("Credit Card Information");
        System.out.print("Type of credit card (Visa/Mastercard/Discover): ");
        String credit = scanner.nextLine();

        // Validation

        if (!isValidEmail(email)) {
            System.out.println("Invalid email address");
        } else if (!isValidSSN(ssn)) {
            System.out.println("Invalid SSN");
        } else if (!isValidZipCode(zipCode)) {
            System.out.println("Invalid ZIP code");
        } else {
            System.out.println("Registration successful!");
            // Write to file
            try (FileWriter writer = new FileWriter("data/CreditList.csv", true)) {
                writer.append(firstName + ",");
                writer.append(lastName + ",");
                writer.append(email + ",");
                writer.append(dob + ",");
                writer.append(phone + ",");
                writer.append(ssn + ",");
                writer.append(homeAddress + ",");
                writer.append(city + ",");
                writer.append(state + ",");
                writer.append(zipCode + ",");
                writer.append(residence + ",");
                writer.append(employment + ",");
                writer.append(income + ",");
                writer.append(credit);
                writer.append("\n");
            } catch (IOException e) {
                System.out.println("Error occurred while writing to file");
            }
        }
        scanner.close();

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
}