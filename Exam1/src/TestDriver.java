
public class TestDriver {

	public static void main(String[] args) {
		//First Checking Account
		CheckingAccount account1 = new CheckingAccount();
		account1.setId(1111);
		account1.setBalance(2000.00);
		account1.setOverdraft(200.00);
		account1.setAnnualInterestRate(.5);
		account1.setWithdraw(2100.00);
		account1.setDeposit(3000.00);
		//Output first Checking Account
		System.out.println("Account ID: " + account1.getId());
		System.out.println("Date Created: " + account1.getDateCreated());
		System.out.println("Account Balance: " + account1.getBalance());
		System.out.println("Monthly Interest Rate: " + account1.getAnnualInterestRate());
		System.out.println();
		
		//Object of Savings Account
		SavingsAccount account2 = new SavingsAccount();
		account2.setId(1100);
		account2.setBalance(500.00);
		account2.setMinBalance(200.00);
		account2.setAnnualInterestRate(1.0);
		account2.setWithdraw(300.00);
		//Output Savings Account
		System.out.println("Account ID: " + account2.getId());
		System.out.println("Date Created: " + account2.getDateCreated());
		System.out.println("Acount Balance: " + account2.getBalance());
		System.out.println("Monthly Interest Rate: " + account2.getAnnualInterestRate());
		System.out.println();
		
		//Checking Account 2
		CheckingAccount account3 = new CheckingAccount();
		account3.setAnnualInterestRate(1.5);
		account3.setBalance(1000.00);
		account3.setId(2222);
		account3.setOverdraft(200.00);
		account3.setCustomerName("George");
		account3.setDeposit(30.00);
		account3.setDeposit(40.00);
		account3.setDeposit(50.00);
		account3.setWithdraw(5.00);
		account3.setWithdraw(4.00);
		account3.setWithdraw(2.00);
		//Output Checking Account 2 (account3)
		System.out.println("Account ID: "+ account3.getId());
		System.out.println("Customer Name: " + account3.getCustomerName());
		System.out.println("Annual Interest Rate: " + account3.getAnnualInterestRate());
		System.out.println("Acount Balance: " + account3.getBalance());
		System.out.println();
		
	}

}
