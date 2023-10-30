package adts;

import interfaces.ListInterface;
import iterators.ArrayIterator;
import java.util.Iterator;

public class ArrayBasedList<E> implements ListInterface<E>, Iterable<E> {
	
	protected E[] list;
	
	protected int numElements;
	protected final int DEFAULT_CAPACITY = 100;
	protected int initialCapacity;
	
	// find helper method will set ...
	protected boolean found;
	protected int location; // location only valid when found == true
	
	public ArrayBasedList() {
		list = (E[]) new Object[DEFAULT_CAPACITY];
		initialCapacity = DEFAULT_CAPACITY;
		numElements = 0;
	}
	
	public ArrayBasedList(int initialCapacity) {
		list = (E[]) new Object[initialCapacity];
		this.initialCapacity = initialCapacity;
		numElements = 0;
	}
	
	
	protected void enlarge() {
		E[] newBiggerArray = (E[]) new Object[list.length + initialCapacity];
		for (int i = 0; i < numElements; i++) {
			newBiggerArray[i] = list[i];
		}
		list = newBiggerArray;
	}

	@Override
	public void add(E element) {
		if (numElements == list.length) {
			enlarge();
		}
		list[numElements] = element;
		numElements++;
	}

	protected void find(E target) {
		found = false;
		for (location = 0; location < numElements; location++) {
			if (list[location].equals(target)) {
				found = true;
				break;
			}
		}
	}
	
	@Override
	public boolean remove(E element) {
		find(element);
		if (found) {
			list[location] = list[numElements - 1];
			list[numElements - 1] = null;
			numElements--;
		}
		return found;
	}

	@Override
	public int size() {
		return numElements;
	}

	@Override
	public boolean isEmpty() {
		return numElements == 0;
	}

	@Override
	public boolean contains(E element) {
		find(element);
		return found;
	}

	@Override
	public E get(E element) {
		find(element);
		if (found) {
			return list[location];
		}
		else {
			return null;
		}
	}

	@Override
	public E get(int index) {
		if (index < 0 || index > numElements - 1) {
			return null;
		}
		return list[index];
	}
	
	public Iterator<E> iterator() {
		return new ArrayIterator<E>(list, numElements);
	}
	
	public String toString() {
		StringBuilder listStr = new StringBuilder("\n--------\n");
		for (int i = 0; i < numElements; i++) {
			listStr.append(list[i] + "\n");
		}
		return listStr.toString();
	}

}










