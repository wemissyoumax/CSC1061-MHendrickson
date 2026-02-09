
public class NonLender extends FinancialInstitution{

	public NonLender(String name) {
		super(name);
	}

	@Override
	public double getInterestRate() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("This bank is a non-lender.");
	}
	
	
}
