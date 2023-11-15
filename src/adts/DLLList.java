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

    boolean IsRandIter = false; 

    @Override
    public Iterator<E> iterator() {
        if(IsRandIter){
            return new DLLRandomIterator<>(head);
        } else{
            return new DLLIterator<>(head);
        }
	}


    public Iterator<E> iteratorLinear() {
    	IsRandIter = false; 
        return new DLLIterator<>(head);
	}

    
    public Iterator<E> iteratorRandom(){
        IsRandIter = true;
        return new DLLRandomIterator<>(head);
    }
      
  
    public void add(E element) {
	DLLNode<E> newNode = new DLLNode<>(element);
	
	if(head == null) {//set head and tail nodes then generic case
		head = tail = newNode;
	} else if(((Comparable) element).compareTo(tail.getData()) >= 0){
        newNode.setPrev(tail);
        tail.setNext(newNode);
        tail = newNode;

    } else if(((Comparable) element).compareTo(head.getData()) <= 0){
        newNode.setNext(head);
        head.setPrev(newNode);
        head = newNode;
    } else {
		DLLNode<E> ptr = head.getNext();
         
		while(((Comparable) element).compareTo(ptr.getData()) >= 0) {

			ptr = ptr.getNext();

		}

        //connect new node then set existing nodes
        newNode.setPrev(ptr.getPrev());
        newNode.setNext(ptr);
        ptr.getPrev().setNext(newNode);
        ptr.setPrev(newNode);

	}


    numElements++;
	    //AS & DHR
    }

        
    
    
    @Override
    public boolean remove(E element){
        //find(element);
        binarySearch(element);
        if(found){
            if(head == location){
                head = head.getNext();
                if(head == null){
                    tail = null;
                } else {
                    head.setPrev(null);
                }
            }
            else if(tail == location){
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
        //Worst case for this binarySearch is O(n)

        // used to set back to original positions after search
        DLLNode<E> OGhead = head;
        DLLNode<E> OGtail = tail;
        
        //position is used as an index value for the .get(index) method
        //.get(index) is based on the head and tail .getNext() or .getPrev(), in this case it will always use the head
        int position=(numElements);
        
        found = false;

        while(position > 0){//
            //checks if head or tail already contain locaiton and are used as a part of the search
            // since these are moving parts, why not use them?
            
            /*
            System.out.println(toString()); 
            System.out.println("num elements " + position);
            System.out.println("head " + head.getData());
            System.out.println("tail " + tail.getData());
            */
            position = (int) (position/2); 
            //System.out.println("position" + position);
            get(position);
            
            if(((Comparable) key).compareTo(head.getData())==0){
                location = head;
                found = true;
                break;
            }else if(((Comparable) key).compareTo(tail.getData()) == 0){
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
        return found;

        //DHR
    }

    private void find(E key){
        DLLNode<E> headPtr = head;
        DLLNode<E> tailPtr = tail;
        for(int i = 0;i<=(numElements)/2;i++){
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
        DLLNode<E> ptr = head;
		if(index < numElements){
			for(int i=0;i<index;i++){
				if(ptr != null && ptr != tail){
					ptr = ptr.getNext();
                    location = ptr;
				}
			}
			
			return ptr.getData();
		}
		return null;
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
