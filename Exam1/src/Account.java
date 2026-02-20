import java.time.LocalDate;

public class Account {
	private int id;
	private double balance = 0.0;
	private double annualInterestRate = 0.0;
	private LocalDate dateCreated = java.time.LocalDate.now();
	private String customerName;
	public double transaction;
	
	public Account() {}
	
	public Account(int id, double balance) {}
	
	public Account(int id, double balance, String customerName) {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double setAnnualInterestRate(double interestRate) {
		return annualInterestRate / 100;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate / 100;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}
	
	double monthlyInterestRate = annualInterestRate % 12;
	
	double getMonthlyInterestRate(){
		return monthlyInterestRate;
	}
	
	private double withdraw = 0.00;
	private double deposit = 0.00;

	public double getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}
	
	public double getDeposit() {
		return deposit;
	}
	
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	

	@Override
	public String toString() {
		return "\nAccount ID: " + id +
				"\nBalance = " + balance +
				"\nAnnual Interest Rate = " + annualInterestRate +
				"\nDate Created: " + dateCreated +
				"\n Withdraw Amount = " + withdraw +
				"\n Deposit Amount = " + deposit;
	}

}
