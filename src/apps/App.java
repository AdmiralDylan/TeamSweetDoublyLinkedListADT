package apps;

import java.util.Iterator;

import adts.DLLList;
import iterators.DLLIterator;
import iterators.DLLRandomIterator;
import nodes.DLLNode;

public class App {
    public static void main(String[] args) throws Exception {

        final int TESTING_TIME_IN_ms = 0;
        
        
        String[] strList = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        
        DLLList<String> list = new DLLList<String>();
        
        

        for(String a:strList){
            list.add(a);
            System.out.println(list.size());
            System.out.println(list.toString());
            Thread.sleep(TESTING_TIME_IN_ms);
        }


        for(String a:list){
            System.out.println(a + list.contains(a));

        }

        for(int i = list.size()-1;i>=0;i--){
            System.out.println(list.get(i));
        }
        list.iteratorRandom();
        System.out.println("\nRandom Iterations\n");
        for(String a:list){
            System.out.print(list.get(a));
        }
        list.iteratorLinear();
        System.out.println("\nLinear Iterations\n");
        for(String a:list){
            System.out.print(list.get(a));
        }
        
        list.iteratorRandom();
        for(String a:list){
            System.out.println(list.toString());
            System.out.println(a);

            list.remove(a);
        }
        System.out.println(list.toString());

        //Int lis

        DLLList<Integer> intList = new DLLList<Integer>();
        System.out.println("\n");
        for(int i = 0;i<255;i++){
            intList.add((int) (Math.random()*100));            
        }


        //System.out.println(intList.isEmpty());
        //System.out.println(intList.toString());
        Integer f = 1;
        Integer q = 0;
        //System.out.println(f.compareTo(q));
        //System.out.println(intList.get(5));
        //System.out.println(intList.get((Integer) (-1)));

        System.out.println(intList.toString());

        for(Integer i:intList){
            System.out.println("get " + intList.get(i));
            System.out.println("contains " + intList.contains(i));

        }

        intList.iteratorRandom();
        int j = 0;
        for(Integer a:intList){

            intList.remove(a);
            j++;
        }
        System.out.println(intList.toString());

    }
}
