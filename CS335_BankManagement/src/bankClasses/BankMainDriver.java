
package bankClasses;

import java.util.ArrayList;
import java.util.Scanner;

class BankMainDriver{
	public static void main(String [] args) throws Exception{
		//test login 
		
		CustomerFactory cF = new CustomerFactory("data/CustomerList.csv");
		CustomerFactory cFCustomer = new CustomerFactory();
		ArrayList<Customer> cusList = new ArrayList<Customer>();
		
		while (cF.hasMoreData()) {
			cusList.add(cF.getNextCustomer());
		}
		
		logIn userLogIn = new logIn();
		for(Customer item: cusList) {
			userLogIn.addUser(item.getCustomerID(), item.getPassword());
		}
		
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Please enter L to logIn or enter C if you are a new customer:  ");
	    String choice = scanner.nextLine();
	    if (choice.equals("L")){
	   
			userLogIn.authenticateUser();
		
	    	
	    }if (choice.equals("C")) {
	   
			Customer cus1 = cFCustomer.makeCustomer();
			System.out.println(cus1);
	    	
	    }
	    
	  //test card validation for ATM - First attempt

	    DiscoverCard disCard = new DiscoverCard("6011000990139424", 200, 500, 199, cusList.get(0));
	    String validateDisc = disCard.validateCardType("6011000990139424");

	    VisaCard visCard = new VisaCard("4012888888881881", 650, 1000, 321, cusList.get(3));
	    String validateVis = visCard.validateCardType("4012888888881881");

	    MasterCard masCard = new MasterCard("5413330089010640", 90, 200, 002, cusList.get(7));
	    String validateMas = masCard.validateCardType("5413330089010640");

	    if (!validateDisc.equals("Invalid") || !validateVis.equals("Invalid") || !validateMas.equals("Invalid")) {
	    	System.out.println("You have entered your account on the ATM");
	    } else {
	    	System.out.println("The card is invalid");
	    }
	
	}
		
}