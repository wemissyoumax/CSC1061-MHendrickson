import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

public class ListTest {
    public static void main(String[] args) {
        
        List<Integer> myArrList = new ArrayList<>();
        
        if(myArrList instanceof Iterable) {
            System.out.println("You can iterate thru this");
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
            System.out.print(num + " ");
        }
        System.out.println();
        
        // This is what happens in the for-each loop above
        Iterator<Integer> iter = myArrList.iterator();
        while(iter.hasNext()) {
            Integer ans = iter.next();
            System.out.print(ans + " ");
        }
        System.out.println();
        
        // Test Linked List
        List<Integer> ll = new LinkedList<>();
        ll.add(6);
        ll.add(7);
        ll.add(8);
        ll.add(9);
        ll.add(10);
        
        for(int i = 0; i < ll.size(); i++) {
            System.out.print(ll.get(i) + " ");
        }
        System.out.println();
        
        iter = ll.iterator();
        while(iter.hasNext()) {
        	System.out.println(iter.next() + " ");
        }
        System.out.println();
        
        for(Integer x : ll) {
        	System.out.println(x + " ");
        }
        System.out.println();
    }
}