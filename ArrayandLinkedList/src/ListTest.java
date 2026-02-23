import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class ListTest {

	public static void main(String[] args) {
		
		List<Integer> myArrList = new MyArrayList<>();
		
		if(myArrList instanceof Iterable) {
			System.out.println("Yuo can iterate thru this");
		}
		
		myArrList.add(1);
		myArrList.add(2);
		myArrList.add(3);
		myArrList.add(4);
		myArrList.add(5);
		
		for(int i = 0; i < myArrList.size(); i++) {
			System.out.print(myArrList.get(i) + " ");
		}
		System.out.println();
		
		for(Integer num : myArrList) {
			System.out.println(num + " ");
		}
		System.out.println();
		
		//This is what happens in the for each loop above
		//Compiler just substitutes this code in there
		Iterator iter = myArrList.iterator();
		while(iter.hasNext()) {
			Integer ans = (Integer)iter.next();
			System.out.println(ans + " ");
		}
		System.out.println();
	}

}
