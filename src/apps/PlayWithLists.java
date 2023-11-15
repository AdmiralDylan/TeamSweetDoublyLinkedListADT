package apps;

import adts.*;

public class PlayWithLists {

	public static void main(String[] args) {
		
		// StringList list1 = new StringList();
		// ArrayBasedList<String> list1 = new ArrayBasedList(3);
		// LLList<String> list1 = new LLList<>();
		DLLList<String> list1 = new DLLList<>();
		
		System.out.println(list1.isEmpty() ? "The list is empty." : "The list is not empty.");
	      
	    list1.add("Dysktra");
		list1.add("Liskov");
	    list1.add("Dahl");
	    list1.add("Nygaard");
	    list1.add("Liskov");
	    list1.add("DePasquale");


		System.out.println(list1.isEmpty() ? "The list is empty." : "The list is not empty.");
		System.out.println("There are " + list1.size() + " items on the list");

		System.out.println("\nComputer Scientists: " + list1);
	    
	    System.out.println("Dahl removed? " + list1.remove("Dahl"));

	    System.out.println("\nupdated Computer Scientists: " + list1);
	    
	    System.out.println("Dysktra removed? " + list1.remove("Dykstra"));

	    System.out.println("\nupdated Computer Scientists: " + list1);
	    
	    System.out.println("DePasquale removed? " + list1.remove("DePasquale"));

	    System.out.println("\nupdated Computer Scientists: " + list1);
	    
	    System.out.println("Liskov on the list? " + list1.contains("Liskov"));
	    System.out.println("Holl on the list?   " + list1.contains("Holl"));
	    
	    System.out.println("get Nygaard:  " + list1.get("Nygaard"));
	    System.out.println("get 3rd item: " + list1.get(2));
	    
	    

	    //ArrayBasedList<Integer> list2 = new ArrayBasedList<Integer>();
	    DLLList<Integer> list2 = new DLLList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			list2.add(i);
		}
		      
	    System.out.println("\nDecimal Digits: " + list2);
	    
	    System.out.print("\nDecimal Digits using for loop: ");
	    for (int j : list2) {
	    	System.out.print(j + " ");
	    }
	    System.out.println("\n");
	    
   
	    System.out.println(list2.remove(0) ? "0 removed" : "0 not found on the list");
	    System.out.println(list2.remove(2) ? "2 removed" : "2 not found on the list");
	    System.out.println(list2.remove(4) ? "4 removed" : "4 not found on the list");
	    System.out.println(list2.remove(6) ? "6 removed" : "6 not found on the list");
	    System.out.println(list2.remove(8) ? "8 removed" : "8 not found on the list");
	    System.out.println(list2.remove(0) ? "0 removed" : "0 not found on the list");
	    System.out.println(list2.remove(4) ? "4 removed" : "4 not found on the list");
	    

	    System.out.println("\nDecimal Digits after removing evens: " + list2);
		
		// remove all of the items from the list
		while (!list2.isEmpty()) {
			list2.remove(list2.get(0));
		}
	    System.out.println("\nWhere have all the digits gone?" + list2);

	    /**/
	}
      
}
