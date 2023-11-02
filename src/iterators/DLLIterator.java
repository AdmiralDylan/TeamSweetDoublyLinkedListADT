package iterators;

import nodes.DLLNode;
import java.util.Iterator;

public class DLLIterator<E> implements Iterator<E>
{

	private DLLNode<E> head;
	private DLLNode<E> current;

	public DLLIterator(DLLNode<E> collection) // collection is a reference to the head of the LinkedList
	{
		this.head = collection;
		current = collection;
	}

	@Override
	public boolean hasNext()
	{
		return current != null;
	}

	@Override
	public E next()
	{
		E temp = current.getData();
		current = current.getNext();
		return temp;
	}
	
	public boolean hasPrev()
	{
		return current.getPrev() != null;
	}
	public E prev()
	{
		E temp = current.getData();
		current = current.getPrev();
		return temp;
	}

}
