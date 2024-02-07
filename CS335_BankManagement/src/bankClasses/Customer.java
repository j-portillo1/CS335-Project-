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
	
    private static int customerIDCounter = 1; 
	
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
	
	public String toString() {
		return("Name: "+ this.firstName + " "+ this.lastName + " ,email: " + this.email + " ,customer ID: "+ this.customerID);
	}
}