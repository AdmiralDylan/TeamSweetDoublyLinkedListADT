package adts;

import java.util.Iterator;

import interfaces.ListInterface;
import iterators.DLLIterator;
import iterators.DLLRandomIterator;
import nodes.DLLNode;

public class DLLList<E> implements ListInterface<E>, Iterable<E>{


    int numElements;//number of items in list
    DLLNode<E> head;
    DLLNode<E> tail;

    boolean found;
    DLLNode<E> location;




    public Iterator<E> iterator() {
	return new DLLIterator<E>(head); // based on LLList class, AS 
	}

    public Iterator<E> iteratorRandom(){
        return new DLLRandomIterator<E>(head);
    }
      
  
    public void add(E element) {
	DLLNode<E> newNode = new DLLNode<>(element);
	
	if(head == null) {
		head = tail = newNode;
        //System.out.println("flag 1");
	} else if(((Comparable) element).compareTo(tail.getData()) > 0){
        newNode.setPrev(tail);
        tail.setNext(newNode);
        tail = newNode;

        //System.out.println("flag 2");
    } else if(((Comparable) element).compareTo(head.getData()) < 0){
        newNode.setNext(head);
        head.setPrev(newNode);
        head = newNode;
        //System.out.println("flag2.5");
    } else {
		DLLNode<E> ptr = head.getNext();
         
		while(((Comparable) element).compareTo(ptr.getData()) > 0) {

			ptr = ptr.getNext();

            //System.out.println("flag 3");
		}

        newNode.setPrev(ptr.getPrev());
        newNode.setNext(ptr);
        ptr.getPrev().setNext(newNode);
        ptr.setPrev(newNode);
        //System.out.println(ptr.getData());

	}
    //System.out.println(head.getData());
    //System.out.println(tail.getData());

    numElements++;
	    //AS & DHR
    }

        
    
    
    @Override
    public boolean remove(E element){
        find(element);
        if(found){
            if(head.getData().equals(element)){
                head = head.getNext();
                head.setPrev(null);
            }
            else if(tail.getData().equals(element)){
                tail = tail.getPrev();
                tail.setNext(null);
            }
            else{
                location.getPrev().setNext(location.getNext());
                location.getNext().setPrev(location.getPrev());
            }
            numElements--;
        }
        return found;
    }
    
   @Override
    public int size() {
       return numElements;
	    //AS
    }

    
    @Override
    public boolean isEmpty() {
        return head == null;
	    //AS & DHR
    }

   
    @Override
    public boolean contains(E element) {
        return binarySearch(element);
	    //AS
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

            if(((Comparable) key).compareTo(head.getData())==0){
                location = head;
                found = true;
                break;
            }else if(((Comparable) key).compareTo(head.getData()) == 0){
                location = tail;
                found = true;
                break;
            }else if(((Comparable) key).compareTo(location.getData()) == 0){
                found = true;
                break;
            }else if(((Comparable) key).compareTo(location.getData()) < 0){
                tail = location.getPrev();
            }else if(((Comparable) key).compareTo(location.getData()) > 0){
                head = location.getNext();
            }
        }
        head = OGhead;
        tail = OGtail;
        numElements = OGnumElements;
        return found;

        //DHR
    }

    private void find(E key){
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
            headPtr = headPtr.getNext();
            tailPtr = tailPtr.getPrev();
        }

        //DHR
    }

    public E get(E element) {
	if (binarySearch(element)){
		return location.getData();
	}else{
		return null;
	   }
	//AS	
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
    

    @Override
    public String toString(){
        StringBuilder stringConversion = new StringBuilder("[");
        DLLNode<E> pointer = head;
        while(pointer != null){
            if(stringConversion.length() > 1)
                stringConversion.append(", ");
            stringConversion.append(pointer.getData());
            pointer = pointer.getNext();
        }
        stringConversion.append("]");
        return stringConversion.toString();
    }

}
