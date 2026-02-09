
public abstract class FinancialInstitution {
	private String fiName;
	private long fiId;
	private long routingNumber;
	
	public FinancialInstitution(String name) {
		fiName = name;
	}

	public String getFiName() {
		return fiName;
	}

	public void setFiName(String fiName) {
		this.fiName = fiName;
	}

	public long getFiId() {
		return fiId;
	}

	public void setFiId(long fiId) {
		this.fiId = fiId;
	}

	public long getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(long routingNumber) {
		this.routingNumber = routingNumber;
	}
	
	// Force any concrete method that inherits has to from getInterestRate
	public abstract double getInterestRate();
	
	@Override
	public String toString() {
		return "FinancialInstitution [fiName=" + fiName + ", fiId=" + fiId + 
				", routingNumber=" + routingNumber + "]";
	}
	
	
}
