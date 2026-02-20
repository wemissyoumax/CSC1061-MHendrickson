
public class CheckingAccount extends Account {
	
	private double overdraft = 30.00;
	
	public CheckingAccount() {
		super();
	}

	public CheckingAccount(int id, double balance) {
		super(id, balance);
	}


	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}

	@Override
	public String toString() {
		return "/nChecking Account Overdraft: " + overdraft;
	}

	public void setBalance(double d) {
		// TODO Auto-generated method stub
		
	}

	public char[] getTypeofTransaction() {
		return null;
	}

}
