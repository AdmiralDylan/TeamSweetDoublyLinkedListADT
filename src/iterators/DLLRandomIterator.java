package iterators;

import nodes.DLLNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class DLLRandomIterator <E> implements Iterator<E> {
    private DLLNode<E> head;
    private DLLNode<E> current;

    private ArrayList<E> tempDLList;

    private ArrayList<Boolean> tempBoolList;

    public DLLRandomIterator(DLLNode<E> head)
    {
        this.head = head;
        current = head;

        //Creates a shuffled array list using the data from DLList nodes.
        createRandList();
        //Creates boolean array list to mark what elements have been 'returned'
        createBoolList();
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public E next() {
        //Return data from a random array index using 'Math.random'
        //Variable type 'E' to hold data
        E data = null;
        //Loop through both array lists (same size)
        for(int i = 0; i < tempBoolList.size(); i++) {
            //If the boolean value in the 'tempBoolList' is false, continue
            if (!tempBoolList.get(i)) {
                //Set current element in 'tempDLList' equal to data
                data = tempDLList.get(i);
                //Set the same index in the 'tempBoolList' equal to true;
                tempBoolList.set(i, true);
                //Decided to keep this in for the 'hasNext()' method
                current = current.getNext();
                break;
            }
        }
        return data;
    }

    protected void createRandList() {
        //Temporary initial array list size
        int initSize = 10;
        //Instantiate new iterator object
        DLLIterator<E> iterator = new DLLIterator<>(head);
        //Instantiate array list object to hold dll data
        tempDLList = new ArrayList<>(initSize);
        //Add the head's data due to it being ignored in the while loop
        tempDLList.add(head.getData());
        //While loop w/ 'hasNext()' method as the condition to stop the loop when the list is empty
        while(iterator.hasNext()) {
            //Add data from each node to array element
            tempDLList.add((E) iterator.next());
        }
        //Use 'shuffle()' static method to randomly shuffle array list elements
        Collections.shuffle(tempDLList); //Time complexity: O(n)
    }

    protected void createBoolList() {
        //Instantiate array list used to hold the boolean values
        tempBoolList = new ArrayList<>(tempDLList.size());
        //Fill array list with 'false' boolean values
        Collections.fill(tempBoolList, Boolean.FALSE); //Time complexity: O(n)
    }
}