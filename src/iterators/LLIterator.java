package iterators;

import nodes.LLNode;
import java.util.Iterator;

public class LLIterator<E> implements Iterator<E>{

    private LLNode<E> collection;
    private LLNode<E> current;
    

    public LLIterator(LLNode<E> collection) {
		this.collection = collection;
		current = collection;
	}

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public E next() {
        E temp = collection.getData();
        current = current.getNext();
        return temp;
    }
    
    //needs enhanced forloop funcationality



}
