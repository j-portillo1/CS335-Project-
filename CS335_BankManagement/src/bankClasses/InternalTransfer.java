package bankClasses;

public class InternalTransfer {

    public static void transferBetweenAccounts(Customer customer, String fromAccountType, String toAccountType, int amount) {
        Account fromAccount = getAccountByType(customer, fromAccountType);
        Account toAccount = getAccountByType(customer, toAccountType);

        if (fromAccount != null && toAccount != null) {
            if (fromAccount.getAccBal() >= amount) {
                fromAccount.subtractBal(amount);
                toAccount.addBal(amount);
                System.out.println("Transfer successful.");
            } else {
                System.out.println("Insufficient funds in the " + fromAccountType + " account.");
            }
        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    public static void transferBetweenCustomers(Customer fromCustomer, String fromAccountType,
                                                Customer toCustomer, String toAccountType, int amount) {
        Account fromAccount = getAccountByType(fromCustomer, fromAccountType);
        Account toAccount = getAccountByType(toCustomer, toAccountType);

        if (fromAccount != null && toAccount != null) {
            if (fromAccount.getAccBal() >= amount) {
                fromAccount.subtractBal(amount);
                toAccount.addBal(amount);
                System.out.println("Transfer successful.");
            } else {
                System.out.println("Insufficient funds in the " + fromAccountType + " account.");
            }
        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    private static Account getAccountByType(Customer customer, String accountType) {
        for (Account account : customer.getAccountList()) {
            if (account.getAccType().equalsIgnoreCase(accountType)) {
                return account;
            }
        }
        return null;
    }
}
