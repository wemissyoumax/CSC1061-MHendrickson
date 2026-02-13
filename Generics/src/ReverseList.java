import java.util.ArrayList;
import java.util.List;

public class ReverseList<E> implements Comparable<E>{
	private List<E> list = new ArrayList<E>();
	
	public void add(E input) {
		list.add(0, input);
	}
	
	public List<E> getList(){
		return list;
	}
	
	public int size() {
		return list.size();
	}
	
	public E get(int index) {
		return list.get(index);
	}

	@Override
	public int compareTo(E o) {
		return 0;
	}
}
