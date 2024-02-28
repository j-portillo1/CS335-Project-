
package bankClasses;

import java.util.ArrayList;
import java.util.Scanner;

class BankMainDriver{
	public static void main(String [] args) throws Exception{
		//test login 
		CustomerFactory cF = new CustomerFactory("data/CustomerList.csv");
		ArrayList<Customer> cusList = new ArrayList<Customer>();
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Please enter L to logIn or enter C if you are a new customer:  ");
	    String choice = scanner.nextLine();
	    if (choice.equals("L")){
	    	logIn userLogIn = new logIn();
			for(Customer item: cusList) {
				userLogIn.addUser(item.getCustomerID(), item.getPassword());
			}
			
			userLogIn.authenticateUser();
	    	
	    	
	    	
	    }if (choice.equals("C")) {
	    	
			while (cF.hasMoreData()) {
				cusList.add(cF.getNextCustomer());
			}

			
			CustomerFactory cFCustomer = new CustomerFactory();
			Customer cus1 = cFCustomer.makeCustomer();
			System.out.println(cus1);
	    	
	    	
	    }else {
	    	System.out.println("Invalid entry. Please try again.");
	    } 
			
	}
		

}