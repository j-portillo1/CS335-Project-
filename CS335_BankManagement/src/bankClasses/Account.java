package bankClasses;

class Account{
	
	protected int accNum;
	protected String accType;
	protected int accBal;
	protected String customerID;
	
	Account(int num, String type, int bal, String cusID){
		this.accNum = num;
		this.accType = type;
		this.accBal = bal;
		this.customerID = cusID;
	}
	
	public int getAccNum(){
		return this.accNum;
	}
	
	public String getAccType(){
		return this.accType;
	}
	
	public int getAccBal(){
		return this.accBal;
	}
	
	public String getCustomerID(){
		return this.customerID;
	}
	
	
	public void setAccBal(int newBal){
		this.accBal = newBal;
	}
	
	public void addBal(int baltransfer) {
		this.accBal += baltransfer;
	}
	
	public void subtractBal(int baltransfer) {
		this.accBal -= baltransfer;
	}
	
	public String toString(){
		return("Account Number: " + this.accNum + ", type: " + this.accType + ", balance: " + this.accBal + ", customer ID: "+ this.customerID);
	}
	
	public void withdraw(Integer amount) { // Updated to accept double
		if (amount > 0 && amount <= accBal) {
            accBal -= amount;
            System.out.println("Withdrawal of $" + amount + " successful. Current balance: $" + accBal);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public void insert(Integer amount) { // Added insert method, accepts double
        if (amount > 0) {
            accBal += amount;
            System.out.println("Insertion of $" + amount + " successful. Current balance: $" + accBal);
        } else {
            System.out.println("Invalid insertion amount.");
        }
    }
	
}