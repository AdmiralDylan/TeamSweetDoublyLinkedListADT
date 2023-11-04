package adts;

import java.util.Iterator;

import interfaces.ListInterface;
import nodes.DLLNode;

public class DLLList<E> implements ListInterface<E>, Iterable<E>{

    //needs to look like LLList but with sorted add/removes for binary sort

    int numElements;//number of items in list
    DLLNode<E> head;
    DLLNode<E> tail;

    boolean found;
    DLLNode<E> location;


    //we need to return DLLList object in get() for binary sort I think maybe use the find helper (which sounds dumb)
    DLLNode<E> current;

    public Iterator<E> iterator() {
	return new DLLIterator<E>(head); // based on LLList class, AS 
	    // throw new UnsupportedOperationException("Unimplemented method 'iterator'");
	}
      
  
    public void add(E element) {
	DLLNode<E> newNode = new DLLNode<>(element);
			
	if(head == null) {
		head = tail = newNode;
	} else {
		DLLNode<E> location = head; 
		while(location != null) {
			if ((newNode.compareTo(location.getData()) > 0)) { 
				location = location.getNext();
			} else {
				break;
			}
		}
	}
	    //AS
	    //throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

        
    
    
    @Override
    public boolean remove(E element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
    
   @Override
    public int size() {
       return numElements;
	    //AS
        //throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    
    @Override
    public boolean isEmpty() {
        return false;
	    //AS
       // throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

   
    @Override
    public boolean contains(E element) {
        return binarySearch(element);
	    //AS
       // throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }
	
    public boolean binarySearch(E key){
        DLLNode<E> OGhead = head;// used to set back to original positions after search
        DLLNode<E> OGtail = tail;
        int position=numElements;
        while(position > 0){
            if(key.compareTo(head.getData())==0){
                location = head;
                found = true;
                break;
            }else if(key.compareTo(tail.getData() == 0)){
                location = tail;
                found = true;
                break;
            }else if(key.compareTo(location.getData() == 0)){
                found = true;
                break;
            }else if(key.compareTo(location.getData() < 0)){
                tail = location.getPrev();
            }else if(key.comparTo(location.getData() > 0)){
                head = location.getNext();
            }
            position/=2;
            get(position);
            location=current;
            
        }
    }

    public E get(E element) {
	if (binarySearch(element)){
		return location.getInfo();
	}else{
		return null;
	   }
	//AS	
	   // throw new UnsupportedOperationException("Unimplemented method 'get'");
	}
	
    @Override
    public E get(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }
    
}
