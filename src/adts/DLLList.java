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
	
    private boolean binarySearch (E key){
        //since the underlying data structure is an doublly linked list, why create an array just for a search?
        //That would change the time complexity of this binary search to a O(n log n), which defeats the purpose
        //Linear search in the find helper method has a better complexity O(n)
        //Worst case for this binarySearch is N

        // used to set back to original positions after search
        DLLNode<E> OGhead = head;
        DLLNode<E> OGtail = tail;
        int OGnumElements = numElements;
        //don't remake the wheel with pointers vars everything is still referenced since its doubly linked (chopping doesn't really chop unless an element is set to null)
        
        //position is used as an index value for the .get(index) method
        //.get(index) is based on the head and tail .getNext() or .getPrev(), in this case it will always use the head
        int position=numElements;
        
        boolean found = false;

        while(position > 0){//
            //checks if head or tail already contain locaiton and are used as a part of the search
            // since these are moving parts, why not use them?

            position/=2;
            get(position);

            if(((Comparable) key).compareTo(head)==0){
                location = head;
                found = true;
                break;
            }else if(((Comparable) key).compareTo(tail) == 0){
                location = tail;
                found = true;
                break;
            }else if(((Comparable) key).compareTo(location) == 0){
                found = true;
                break;
            }else if(((Comparable) key).compareTo(location) < 0){
                tail = location.getPrev();
            }else if(((Comparable) key).compareTo(location) > 0){
                head = location.getNext();
            }
        }
        head = OGhead;
        tail = OGtail;
        numElements = OGnumElements;
        return found;
    }

    public void find(E key){
        DLLNode<E> headPtr = head;
        DLLNode<E> tailPtr = tail;
        for(int i = 0;i<numElements/2;i++){
            if(headPtr.getData().equals(key)){
                location = headPtr;
                found = true;
            } else if(tailPtr.getData().equals(key)){
                location = tailPtr;
                found = true;
            }
            headPtr.getNext();
            tailPtr.getPrev();
        }
    }

    public E get(E element) {
	if (binarySearch(element)){
		return location.getData();
	}else{
		return null;
	   }
	//AS	
	   // throw new UnsupportedOperationException("Unimplemented method 'get'");
	}
	


    @Override
    public E get(int index) {
        DLLNode<E> ptr;
        
        if(numElements-index < numElements/2){
            ptr = tail;
            index = numElements - index;
                for(int i = 0;i<index;i++){
                    tail.getPrev();
                    location = tail;
            }
        } else {
            ptr = head;
                for(int i = 0;i<index;i++){
                    head.getNext();
                    location = head;            
            }
        }
        
        return ptr.getData();
    }
    
}
