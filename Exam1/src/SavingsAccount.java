
public class SavingsAccount extends Account {
	
	public SavingsAccount() {}
	
	public SavingsAccount(int id, double balance) {
		super(id, balance);
	}

	private double minBalance = 0.0;

	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

	@Override
	public String toString() {
		return "\nSavings Account Minumum Balance: " + minBalance;
	}

	public double setAnnualInterestRate(double interestRate) {
		return interestRate;
		
	}
}
