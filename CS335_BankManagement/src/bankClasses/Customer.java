package bankClasses;

import java.util.*;

class Customer{
	protected String firstName;
	protected String lastName;
	protected String email;
	protected Date birthday;
	protected String customerID;
	protected String password;
	protected ArrayList<Account> accList;
	
	
	Customer(String firstName, String lastName, String email, Date birthday, String customerID, String password){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.birthday = birthday;
		this.customerID = customerID;
		this.password = password;
		this.accList = new ArrayList<>();
	}
	
	public String getName(){
		return(this.firstName + " "+ this.lastName);
	}
	
	public String getFirstName(){return this.firstName;}
	public String getLastName(){return this.lastName;}
	public String getEmail() {return this.email;}
	public String getPassword() {return this.password;}
	public Date getDOB(){return this.birthday;}
	public String getCustomerID(){return this.customerID;}
	public ArrayList<Account> getAccountList(){return this.accList;}
	
	public void addAccount(Account cusAcc) {
		accList.add(cusAcc);
	}
	
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Account getCheckingAccount() {
        for (Account account : accList) {
            if (account.getAccType().equalsIgnoreCase("checking")) {
                return account;
            }
        }
        return null; // Return null if no checking account found
    }
    
    public Account getSavingAccount() {
        for (Account account : accList) {
            if (account.getAccType().equalsIgnoreCase("saving")) {
                return account;
            }
        }
        return null; // Return null if no saving account found
    }
	
	public String toString() {
		return("Name: "+ this.firstName + " "+ this.lastName + " ,email: " + this.email + " ,customer ID: "+ this.customerID);
	}
	
	public void withdrawFromChecking(double amount) {
        Account checkingAccount = getCheckingAccount();
        if (checkingAccount != null) {
            checkingAccount.withdraw(amount);
        } else {
            System.out.println("No checking account found for the customer.");
        }
    }

    public void insertIntoChecking(double amount) {
        Account checkingAccount = getCheckingAccount();
        if (checkingAccount != null) {
            checkingAccount.insert(amount);
        } else {
            System.out.println("No checking account found for the customer.");
        }
    }

    public void withdrawFromSaving(double amount) {
        Account savingAccount = getSavingAccount();
        if (savingAccount != null) {
            savingAccount.withdraw(amount);
        } else {
            System.out.println("No saving account found for the customer.");
        }
    }

    public void insertIntoSaving(double amount) {
        Account savingAccount = getSavingAccount();
        if (savingAccount != null) {
            savingAccount.insert(amount);
        } else {
            System.out.println("No saving account found for the customer.");
        }
    }
}