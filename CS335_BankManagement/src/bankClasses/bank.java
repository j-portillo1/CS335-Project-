package bankClasses;

import java.util.ArrayList;

class bank{
	public static void main(String [] args) throws Exception{
		CustomerFactory cF = new CustomerFactory("data/CustomerList.csv");
		ArrayList<Customer> cusList = new ArrayList<Customer>();
		
		while (cF.hasMoreData()) {
			cusList.add(cF.getNextCustomer());
		}

		/*
		CustomerFactory cFCustomer = new CustomerFactory();
		Customer cus1 = cFCustomer.makeCustomer();
		System.out.println(cus1);*/
		
		logIn userLogIn = new logIn();
		for(Customer item: cusList) {
			userLogIn.addUser(item.getCustomerID(), item.getPassword());
		}
		
		userLogIn.authenticateUser();
	}
}