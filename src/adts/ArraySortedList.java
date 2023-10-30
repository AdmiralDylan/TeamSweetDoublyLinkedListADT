package adts;

import java.util.Comparator;

import javax.swing.text.html.parser.Element;

import interfaces.ListInterface;

public class ArraySortedList<E> extends ArrayBasedList<E> implements ListInterface<E>{

    public ArraySortedList(){
        super();
    }

    public ArraySortedList(int initialCapacity){
        super(initialCapacity);
    }

    @Override
    public boolean remove(E element) {
		find(element);
		if (found){
			for(int i = location;i<numElements-1;i++){
                list[location] = list[i + 1];
            }
            list[numElements-1]=null;
			numElements--;
		}
		return found;
	}

    @Override
    public void add(E element){
        int location =0;
        while(location < numElements){
            if(((Comparable)element).compareTo(list[location])<0){
                break;
            }else{
                location++;
            }
        }

        for(int i = numElements;i>location;i--){
            list[i] =list[i-1];
        }
        list[location] = element;
        numElements++;
        
        if (numElements == list.length) {
		    	enlarge();
		    }
		
    }
}
