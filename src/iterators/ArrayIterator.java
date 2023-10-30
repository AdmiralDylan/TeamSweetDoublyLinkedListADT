package iterators;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E> {
	
	private E[] collection;
	private int current;
	private int size;
	
	public ArrayIterator(E[] collection, int size) {
		this.collection = collection;
		this.size = size;
		current = 0;
	}

	@Override
	public boolean hasNext() {
		return current < size;
	}

	@Override
	public E next() {
		E temp = collection[current];
		current++;
		return temp;
	}

}




