package adts;
import nodes.LLNode;

import java.util.Iterator;

import interfaces.ListInterface;
import iterators.LLIterator;

public class LLList<E> implements ListInterface<E>, Iterable<E>{
	
	protected LLNode<E> head;
	protected LLNode<E> tail;
	
	protected int numElements;
	
	// find helper method will set ...
	protected boolean found;
	protected LLNode<E> location; // location only valid when found == true
	protected LLNode<E> previous; // node before location


	@Override
	public void add(E element) {
		LLNode<E> newNode = new LLNode<>(element);
		if (head == null) {  // adding first element to empty list
			head = newNode;
			tail = newNode;
		}
		else {
			tail.setNext(newNode);
			tail = newNode;
		}
		numElements++;
	}
	
	private void find(E target) {
		found = false;
		location = head;
		previous = null;
		while (location != null) {
			if (location.getData().equals(target)) {
				found = true;
				break;
			}
			else {
				previous = location;
				location = location.getNext();
			}
		}
	}

	@Override
	public boolean remove(E element) {
		find(element);
		if (found) {
			if (location == head) {
				head = head.getNext();
				if (head == null) {
					tail = null;
				}
			}
			else {
				if (location == tail) {
					tail = previous;
					tail.setNext(null);
					// or
					// previous.setNext(null)
					// tail = previous;
				}
				else { // general case
					previous.setNext(location.getNext());
				}
			}
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
		// or
		// return head == null;
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
			return location.getData();
		}
		else {
			return null;
		}
	}

	@Override
	public E get(int index) {
		LLNode<E> ptr = head;
		if(index < numElements){
			for(int i=index;i>0;i--){
				if(ptr != null){
					ptr = ptr.getNext();
				}
			}
			
			return ptr.getData();
		}
		return null;
	}
	
	public String toString() {
		StringBuilder listStr = new StringBuilder("\n--------\n");
		LLNode<E> ptr = head;
		// for (int i = 0; i < numElements; i++) {
		while (ptr != null) {
			listStr.append(ptr.getData() + "\n");
			ptr = ptr.getNext();
		}
		return listStr.toString();
	}

	@Override
	public Iterator<E> iterator() {
		
		return new LLIterator<E>(head);
	}

}










