import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestFI {

	public static void main(String[] args) {
		
		Bank b1 = new Bank("My Bank");
		System.out.println("My Bank's interest rate: " + b1.getInterestRate() + "%");

		List<FinancialInstitution> fiList = new LinkedList<>();
		fiList.add(b1);
		fiList.add(new CreditUnion("MyCU"));
		fiList.add(new NonLender("Useless FI"));
		
		fiList.get(0).setFiId(2);
		fiList.get(1).setFiId(3);
		fiList.get(2).setFiId(1);
		
		if(fiList.get(0) instanceof Bank) {
			((Bank)fiList.get(0).setSavings());
		}
		
		Collections.sort(fiList);
	}

}
