package bankClasses;


abstract class CreditCard {

    protected String card_number;
    protected int balance;
    protected int limit;
    protected Customer owner;

    public CreditCard(String card_number, int balance, int limit, Customer owner){
        this.card_number = card_number;
        this.balance = balance;
        this.limit = limit;
        this.owner = owner;
    }

    public abstract String validateCardType(String card_number);
    public  int getBalance(){
    	return this.balance;
    }

    public  int getCreditLimit()
    {
    	return this.limit;
    }

    public  String getPersonals(){
    	return this.owner.toString();
    }

}