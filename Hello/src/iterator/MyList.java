package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyList<E> implements Iterable<E>{
	@SuppressWarnings("unchecked")
	private E [] data = (E[])new Object [10];
	private int count;
	
	public void add(E o) {
		data[count++] = o;
	}
	
	public E get(int idx) {
		if (idx < count) {
			return data[idx];
		}
		throw new NoSuchElementException();
	}

	private class MyIterator implements Iterator<E> {
		private int progress = 0;
		
		@Override
		public boolean hasNext() {
			return progress < count;
		}

		@Override
		public E next() {
			return data[progress++];
		}
		
	}
	
	@Override
	public Iterator<E> iterator() {
		return new MyIterator();
	}
}
