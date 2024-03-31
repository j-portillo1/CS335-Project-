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
	
}