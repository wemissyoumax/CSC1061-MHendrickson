
public class Transactions {
	private String date;
	private String typeOfTransaction;
	private double amountofTransaction;
	private double newBalance;
	
	public Transactions() {}

	public Transactions(String date, String typeOfTransaction, double amountofTransaction, double newBalance) {
		super();
		this.date = date;
		this.typeOfTransaction = typeOfTransaction;
		this.amountofTransaction = amountofTransaction;
		this.newBalance = newBalance;
	}

	public String getDate() {
		return date;
	}


	public String getTypeOfTransaction() {
		return typeOfTransaction;
	}

	public void setTypeOfTransaction(String typeOfTransaction) {
		this.typeOfTransaction = typeOfTransaction;
	}

	public double getAmountofTransaction() {
		return amountofTransaction;
	}

	public void setAmountofTransaction(double amountofTransaction) {
		this.amountofTransaction = amountofTransaction;
	}

	public double getNewBalance() {
		return newBalance;
	}
	
	
}
