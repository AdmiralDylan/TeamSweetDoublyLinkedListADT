package iterators;

import nodes.DLLNode;

import java.util.ArrayList;
import java.util.Iterator;

public class DLLRandomIterator<E> implements Iterator<E> {
    private DLLNode<E> head;
    private DLLNode<E> current;

    // adds iterables into arr list
    private ArrayList<E> list = new ArrayList<>();


    public DLLRandomIterator(DLLNode<E> head)
    {
        this.head = head;
        current = head;

        while(current != null){
            list.add(current.getData());
            current = current.getNext();
        }
        current = head;
        
        /*
        //Creates a shuffled array list using the data from DLList nodes.
        createRandList();
        //Creates boolean array to mark what elements have been 'returned'
        createBoolArray();
        */
    }


    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }

    @Override
    public E next() {
        //Return data from a random array index using 'Math.random'
        //Variable type 'E' to hold data
        E data = null;
        int numElements = list.size();
        int newIteration = (int) (Math.random() * numElements);
        data = list.get(newIteration);
        list.remove(newIteration);

        return data;

        /*

        //Loop through boolean array
        for(int i = 0; i < tempBoolArray.length; i++) {
            //If the boolean value in the 'tempBoolList' is false, continue
            if (!tempBoolArray[i]) {
                //Set current element in 'tempDLList' equal to data
                data = tempDLList.get(i);
                //Set the same index in the 'tempBoolList' equal to true;
                tempBoolArray[i] = true;
                //Decided to keep this in for the 'hasNext()' method
                current = current.getNext();
                return data;
            }
        }
        return data;

        */
    }

/*
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

    protected void createBoolArray() {
        //Instantiate boolean array (auto-fills with false values)
        tempBoolArray = new boolean[tempDLList.size()];
    }

    */

}
