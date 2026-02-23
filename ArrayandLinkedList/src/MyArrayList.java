import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;

public abstract class MyArrayList<T> implements List {
	private T[] array;
	private int size;
	
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		array = (T[]) new Object[4];
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
//		if (size ==0) {
//			return true;
//		}
//		return false;
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator();
	}
	
	//Nested class for Iterator behavior
	private class MyIterator implements Iterator<T> {
		
		private int index = 0;
		
		//"Do I have another element to return to you?"
		@Override
		public boolean hasNext() {
			if (index < size) {
				return true;
			}
			return false;
		}
		
		//Gets the next element and gives it to you
		@Override
		public T next() {
			if (index >= size) {
				throw new IndexOutOfBoundsException("Index exceeds size");
			}
			return array[index];
		}
		
	}

	@Override
	public T[] toArray() {
		return null;
	}

	@Override
	public T[] toArray(Object[] a) {
		return null;
	}


	@Override
	public boolean add(T e) {
		if (size >= array.length) {
			@SuppressWarnings("unchecked")
			T[] bigger = (T[])new Object[array.length * 2];
			for(int i = 0; i < array.length; i++) {
				bigger[i] = array[i];
			}
			array = bigger;
		}
		array[size++] = e;
		size++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		int index = indexOf(o);
		if(index < 0) {
			return false;
		}
		remove(index);
		return true;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean flag = true;
		for(Object obj: c) {
			if (remove(obj)) {
				flag = true;
			}
			
		}
		return flag;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		size = 0;
	}

	@Override
	public T get(int index) {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		return array[index];
	}

	@Override
	public T set(int index, T element) {
		T old = get(index);
		array[index] = element;
		return old;
	}

	@Override
	public void add(int index, T element) {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		add(element);
		for (int i = size -1; i > index; i--) {
			array[i] = array[i -1];
		}
		array[index] = element;
		
	}

	@Override
	public T remove(int index) {
		T old = get(index);
		for(int i = index; i < size; i++) {
			array[i] = array[i + 1];
		}
		size--;
		return old;
	}

	@Override
	public int indexOf(Object o) {
		for (int i = 0; i < size; i++) {
			if (equals(array[i], o)) {
				return i;
			}
		}
		return -1;
	}
	
	private boolean equals(Object o1, Object o2) {
		if (o1 == null || o2 == null) {
			return false;
		}
		return o1.equals(o2);
	}

	@Override
	public int lastIndexOf(Object o) {
		for (int i = size -1; i >= 0; i--) {
			if(equals(array, o)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
