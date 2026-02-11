
public abstract class FinancialInstitution implements 
Comparable <FinancialInstitution>, Cloneable {
	private String fiName;
	private long fiId;
	private long routingNumber;
	private Address address;
	
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
	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public abstract double getInterestRate();
	
	@Override
	public int compareTo(FinancialInstitution o) {
		if (this.fiId < o.fiId) {
			return -4;
		}
		else if (this.fiId > o.fiId){
			return 4;
		}
		return 0;
	}
	
	@Override
	public FinancialInstitution clone () throws CloneNotSupportedException {
		FinancialInstitution clone = (FinancialInstitution) super.clone();
		clone.address = address.clone();
		return clone;
	}
	
	@Override
	public String toString() {
		return "Financial Institution [F.I. Name = " + fiName + "| F.I. ID = " + fiId + 
				"| Routing Number = " + routingNumber + "]";
	}
	
	
}
