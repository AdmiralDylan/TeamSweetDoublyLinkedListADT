package apps;

import java.util.Iterator;

import adts.DLLList;
import iterators.DLLIterator;
import iterators.DLLRandomIterator;
import nodes.DLLNode;

public class App {
    public static void main(String[] args) throws Exception {

        final int TESTING_TIME_IN_ms = 200;
        
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
        
        System.out.println(list.contains("a"));

        Thread.sleep(TESTING_TIME_IN_ms);

        list.add("b");
        System.out.println(list.toString());
        System.out.println(list.size());

        Thread.sleep(TESTING_TIME_IN_ms);

        list.add("a");
        System.out.println(list.toString());
        System.out.println(list.size());

        Thread.sleep(TESTING_TIME_IN_ms);

        System.out.println(list.get("a"));
        System.out.println(list.get("q"));
        System.out.println(list.contains("a"));
        System.out.println(list.contains("q"));

        Thread.sleep(TESTING_TIME_IN_ms);


        int i = 0;

        System.out.println("Enhanced for" + "\n");
        for(String a:list){
            System.out.println(a + " index at " + i);
            i++;
            Thread.sleep(TESTING_TIME_IN_ms);
        }

        System.out.println(list.size());

        System.out.println("linear iter");
        Iterator<String> itrLine = list.iterator(); 
        Iterator<String> itrRand1 = list.iteratorRandom(); 
        Iterator<String> itrRand2 = list.iteratorRandom(); 

        while(itrLine.hasNext()){
            System.out.print(itrLine.next() + ",");
            Thread.sleep(TESTING_TIME_IN_ms);
        }

        System.out.println("\nrandom iter1");
        while(itrRand1.hasNext()){
            System.out.print(itrRand1.next() + ",");
            Thread.sleep(TESTING_TIME_IN_ms);
        }

        System.out.println("\nrandom iter2");
        while(itrRand2.hasNext()){
            System.out.print(itrRand2.next() + ",");
            Thread.sleep(TESTING_TIME_IN_ms);
        }
    
        try{
            System.out.print(itrLine.next());
        } catch (Exception e){
            System.out.println("\n" + e);
        }
    }
}
