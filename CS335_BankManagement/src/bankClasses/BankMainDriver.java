
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
			
	}
		

}