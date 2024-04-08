package bankClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreditCardApproval {

    // Method to read customer list from CSV file
    private static List<String> readCustomerList() {
        List<String> customerList = new ArrayList<>();
        String csvFile = "data/CustomerList.csv";
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                customerList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    // Method to check if a customer is in the customer list
    private static boolean isInCustomerList(String email) {
        List<String> customerList = readCustomerList();
        for (String customer : customerList) {
            if (customer.contains(email)) {
                return true;
            }
        }
        return false;
    }

    // Method to decide credit card approval based on customer information
    public static String decideCreditCardApproval(String firstName, String lastName, String email, String dob,
                                                  String phoneNumber, String ssn, String address, String city,
                                                  String state, String zipCode, String residence, String employmentStatus,
                                                  double income, String creditCardType) {
        // Check if the customer is in the customer list
        if (isInCustomerList(email)) {
            double checkingAccountBalance = getCheckingAccountBalance(email); // Method to get checking account balance
            if (checkingAccountBalance > 10000) {
                return "Approved with $1000 balance";
            } else if (checkingAccountBalance > 5000) {
                return "Approved with $500 balance";
            } else {
                return "Denied";
            }
        } else {
            // New customer, decide based on income, employment, and residence
            if (income > 50000) {
                return "Approved with $1000 balance";
            } else if (income > 30000 && employmentStatus.equals("Yes")) {
                return "Approved with $500 balance";
            } else {
                return "Denied";
            }
        }
    }

    // Dummy method to get checking account balance (replace with actual implementation)
    private static double getCheckingAccountBalance(String email) {
        // Dummy implementation, replace with actual logic to retrieve checking account balance
        return 10000.0; // Assuming checking account balance is $10,000
    }
    /*
    public static void main(String[] args) {
        // Example customer information
        String firstName = "Anh";
        String lastName = "Tran";
        String email = "anhtran@simmons.edu";
        String dob = "12/15/2001";
        String phoneNumber = "(987) 654-3210";
        String ssn = "123-45-6789";
        String address = "300 The Fenway";
        String city = "Boston";
        String state = "Massachusetts";
        String zipCode = "02215";
        String residence = "Renter";
        String employmentStatus = "Yes";
        double income = 70000.0;
        String creditCardType = "Visa";

        // Decide credit card approval
        String approvalStatus = decideCreditCardApproval(firstName, lastName, email, dob, phoneNumber, ssn, address,
                city, state, zipCode, residence, employmentStatus, income, creditCardType);
        System.out.println("Credit card approval status: " + approvalStatus);
    } */
}
