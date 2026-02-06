import java.util.ArrayList;
import java.util.List;

public class BreakStatement {
	public static void main (String[] args) {
		// Initialize two-dimensional array
		int[][] intArray = 
			{{1,2,3},
			 {4,8}, // To make a ragged array, delete one from this column
			 {7,8,9}
	};
		List<Integer> intList = new ArrayList<>();
		
		intList.add(Integer.valueOf(1));
		intList.add(2); //Auto boxing
		intList.add(3);
		intList.add(4);
		intList.add(5);
		
		for (int i = 0; i < intList.size(); i++) {
			System.out.println(intList.get(i));
		}
		
		//for each loop
		for(int x: intList) {
			System.out.println(x);
		}
		
		int index = findIndex(intList, 3);
		System.out.println("Found at index: " + index);
		
		// Call initialized two-dimensional array
		int rowIndex = -1;
		int columnIndex = -1;
		boolean found = false;
		for (int i = 0; i < intArray.length; i++) {
			for(int j = 0; j < intArray[0].length; j++) {
				if (intArray[i][j] == 8) {
					rowIndex = i;
					columnIndex = j;
					found = true;
					break;
				}
			}
			if(found) {
				break;
			}
		}
		System.out.println("Row = " + rowIndex + " | Column = " + columnIndex);
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		// If the number is even:
		for (int i = 0; i < 10; i++) {
			System.out.println("Start of iteration");
			// If number is odd:
			if (arr[i] % 2 > 0) {
				// continue skips the next bit of code and goes to the next 
				// iteration, instead of break, which stops at the next iteration
				continue;
			}
			System.out.println("");
			System.out.println("Print something...");
		}
		
	} //Main ends here
	
	public static int findIndex(List<Integer> ints, int num) {
		int index = -1;
		for(int i = 0; i < ints.size(); i++) {
			if (num == ints.get(i)) {
				index = i;
				break;
			}
		}
		return index;
	}
	
}
