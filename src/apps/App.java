package apps;

import java.util.Iterator;

import adts.DLLList;
import iterators.DLLIterator;
import iterators.DLLRandomIterator;
import nodes.DLLNode;

public class App {
    public static void main(String[] args) throws Exception {

        final int TESTING_TIME_IN_ms = 100;
        
        String[] numList = new String[]{"a","z","c","z","d","e","k","g","h","i","j"};
        DLLList<String> list = new DLLList<String>();
        

        for(String a:numList){
            list.add(a);
            System.out.println(list.size());
            System.out.println(list.toString());
            Thread.sleep(TESTING_TIME_IN_ms);
        }

        System.out.println(list.toString());

        list.remove("a");
        System.out.println(list.toString());
        System.out.println(list.size());
        
        list.add("b");
        System.out.println(list.toString());
        System.out.println(list.size());

        list.add("a");
        System.out.println(list.toString());
        System.out.println(list.size());

        int i = 0;

        System.out.println("Enhanced for" + "\n");
        for(String a:list){
            System.out.println(a + i);
            i++;
        }

        System.out.println("linear iter");
        Iterator<String> itrLine = list.iterator(); 
        Iterator<String> itrRand = list.iteratorRandom(); 
        while(itrLine.hasNext()){
            System.out.print(itrLine.next() + ",");
        }

        System.out.println("\nrandom iter");
        while(itrRand.hasNext()){
            System.out.print(itrRand.next() + ",");
        }

    }
}
