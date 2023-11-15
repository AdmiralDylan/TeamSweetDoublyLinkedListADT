package apps;



import adts.DLLList;


public class App {
    public static void main(String[] args) throws Exception {
        
        final int TESTING_TIME_IN_ms = 100;

        DLLList<String> listString = new DLLList<>();
        DLLList<Boolean> listBool = new DLLList<>();
        DLLList<Integer> listInt = new DLLList<>();

        String[] stringArray = new String[]{"a","z","c","z","d","e","k","g","h","i","j"};
        boolean[] boolArray = new boolean[]{false, true, false, true, true, false, false};
        int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("------------------");
        System.out.println("String List Test\n");

        for(String a:stringArray){
            listString.add(a);
            System.out.println("Size: " + listString.size());
            System.out.println("List: " + listString);
            Thread.sleep(TESTING_TIME_IN_ms);
        }

        System.out.println("Removed 'a'? " + listString.remove("a"));
        System.out.println("List after removing 'a': " + listString);
        System.out.println("List size after removing 'a': " + listString.size());

        System.out.println("Contains 'a'? " + listString.contains("a"));

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
        listString.add("b");
        System.out.println("List after adding 'b': " + listString);
        System.out.println("List size after adding 'b': " + listString.size());
        

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
        }
        listString.add("a");
        System.out.println("List after adding 'a': " + listString);
        System.out.println("List size after adding 'a': " + listString.size());

        Thread.sleep(TESTING_TIME_IN_ms);

        System.out.print("Get 'a': ");
        System.out.println(listString.get("a"));

        System.out.println(listString.get("q"));

        System.out.println(listString.contains("a"));
        System.out.println(listString.contains("q"));

        Thread.sleep(TESTING_TIME_IN_ms);

        int i = 0;
        System.out.println("Enhanced for-loop:");
        for(String a:listString){
            System.out.print(a + " Index:" + i + ", ");
            i++;
            Thread.sleep(TESTING_TIME_IN_ms);
        }

        Iterator<String> stringLinItr = listString.iterator();
        Iterator<String> stringRandItr = listString.iteratorRandom();

        System.out.println("\nLinear iteration: ");
        while(stringLinItr.hasNext()){
            System.out.print(stringLinItr.next() + ",");
            Thread.sleep(TESTING_TIME_IN_ms);
        }

        System.out.println("\nRandom iteration: ");
        while(stringRandItr.hasNext()){
            System.out.print(stringRandItr.next() + ",");
            Thread.sleep(TESTING_TIME_IN_ms);
        }

        System.out.println("\n\n------------------");
        System.out.println("Boolean List Test\n");

        for(boolean a:boolArray){
            listBool.add(a);
            System.out.println("Size: " + listBool.size());
            System.out.println("List: " + listBool);
            Thread.sleep(TESTING_TIME_IN_ms);
        }

        System.out.println("Removed first 'true' value?: " + listBool.remove(true));
        System.out.println("List after removing first 'true' value: " + listBool);
        System.out.println("List size after removing first 'true' value: " + listBool.size());

        Thread.sleep(TESTING_TIME_IN_ms);

        for(boolean a:listBool) {
            if(a == false) {
                listBool.remove(a);
            }
        }
        System.out.println("List after removing all 'false' values: " + listBool);
        //System.out.println("Contains 'false'?: " + listBool.contains(false));
        System.out.println("List size after removing all false values: " + listBool.size());

        Thread.sleep(TESTING_TIME_IN_ms);

        listBool.add(false);
        System.out.println("List after adding a 'false' value: " + listBool);
        System.out.println("List size after adding a 'false' value: " + listBool.size());

        Thread.sleep(TESTING_TIME_IN_ms);

        listBool.add(true);
        System.out.println("List after adding a 'true' value: " + listBool);
        System.out.println("List size after adding a 'true' value: " + listBool.size());

        Thread.sleep(TESTING_TIME_IN_ms);

        listBool.add(false);
        System.out.println("List after adding a 'false' value: " + listBool);
        System.out.println("List size after adding a 'false' value: " + listBool.size());

        Thread.sleep(TESTING_TIME_IN_ms);

        System.out.print("Get 'false': ");
        System.out.println(listBool.get(false));

        System.out.println("Enhanced for-loop:");
        int j = 0;
        for(boolean a:listBool){
            System.out.print(a + " Index:" + j + ", ");
            j++;
            Thread.sleep(TESTING_TIME_IN_ms);
        }

        Iterator<Boolean> boolLinItr = listBool.iterator();
        Iterator<Boolean> boolRandItr = listBool.iteratorRandom();

        System.out.println("\nLinear iteration: ");
        while(boolLinItr.hasNext()){
            System.out.print(boolLinItr.next() + ",");
            Thread.sleep(TESTING_TIME_IN_ms);
        }

        System.out.println("\nRandom iteration");
        while(boolRandItr.hasNext()){
            System.out.print(boolRandItr.next() + ",");
            Thread.sleep(TESTING_TIME_IN_ms);
        }

        System.out.println("\n\n------------------");
        System.out.println("Integer List Test\n");

        for(int a:intArray){
            listInt.add(a);
            System.out.println("Size: " + listInt.size());
            System.out.println("List: " + listInt);
            Thread.sleep(TESTING_TIME_IN_ms);
        }

        System.out.println("Removed '3'?: " + listInt.remove(3));
        System.out.println("List after removing '3': " + listInt);
        System.out.println("List size after removing '3': " + listInt.size());
        System.out.println("Contains '3'? " + listInt.contains(3));

        Thread.sleep(TESTING_TIME_IN_ms);

        listInt.add(11);
        System.out.println("List after adding '11': " + listInt);
        System.out.println("List size after adding '11': " + listInt.size());

        Thread.sleep(TESTING_TIME_IN_ms);

        listInt.add(3);
        System.out.println("List after adding '3': " + listInt);
        System.out.println("List size after adding '3': " + listInt.size());

        Thread.sleep(TESTING_TIME_IN_ms);

        /*
        System.out.print("Get '4': ");
        System.out.println(listInt.get(4));
        */
        System.out.print("Get '18': ");
        System.out.println(listInt.get(18));


        System.out.println("Contains '6'? " + listInt.contains(6));

        System.out.println("Contains '12'? " + listInt.contains(12));

        System.out.println("Enhanced for-loop:");
        int k = 0;
        for(int a:listInt){
            System.out.print(a + " Index:" + k + ", ");
            k++;
            Thread.sleep(TESTING_TIME_IN_ms);

            list.remove(a);
        }
        System.out.println(list.toString());

        //Int lis

        DLLList<Integer> intList = new DLLList<Integer>();
        System.out.println("\n");
        for(int i = 0;i<225;i++){
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
            System.out.print(i);
            System.out.print("get " + intList.get(i));
            System.out.print("contains " + intList.contains(i));

        }

        intList.iteratorRandom();
        int j = 0;
        for(Integer a:intList){
             intList.remove(a);
            j++;
        }
        System.out.println(intList.toString());
        System.out.println(j);
        System.out.println(1/2);

        Iterator<Integer> intLinItr = listInt.iterator();
        Iterator<Integer> intRandItr = listInt.iteratorRandom();

        System.out.println("\nLinear iteration: ");
        while(intLinItr.hasNext()){
            System.out.print(intLinItr.next() + ",");
            Thread.sleep(TESTING_TIME_IN_ms);
        }

        System.out.println("\nRandom iteration");
        while(intRandItr.hasNext()){
            System.out.print(intRandItr.next() + ",");
            Thread.sleep(TESTING_TIME_IN_ms);
        }

    }
       
}
