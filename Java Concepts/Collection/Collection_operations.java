import java.io.*;
import java.math.*;
import java.util.*;

public class Collection_operations {

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> a1 = new ArrayList<>();
        // add method
        a1.add(3);
        a1.add(17);
        a1.add(6);
        a1.add(9);
        a1.add(7);
        System.out.println("Add method:" + a1); //Add method:[3, 17, 6, 9, 7]

        // addAll method - append a2 in a1
        ArrayList<Integer> a2 = new ArrayList<>();//Add All method:[3, 17, 6, 9, 7, 3, 17, 6, 9, 7]
        a2.add(3);
        a2.add(17);
        a2.add(6);
        a2.add(9);
        a2.add(7);
        a1.addAll(a2);
        System.out.println("Add All method:" + a1);

        // remove method
        a1.remove(3);
        System.out.println("After remove method 3:" + a1);//After remove method 3:[3, 17, 6, 7, 3, 17, 6, 9, 7]

        //removeAll method
        a1.removeAll(a1);
        System.out.println("After remove all method :" + a1); //After remove all method :[]

        //retainAll method
        a1.add(3);
        a1.add(17);
        a1.add(6);
        a1.add(9);
        a1.add(7);
        a2.add(3);
        a2.add(17);
        a2.add(16);
        a2.add(9);
        a2.add(7);
        a1.retainAll(a2);
        System.out.println("After retain all method:" + a1); //After retain all method:[3, 17, 6, 9, 7]

        //clear method
        a1.clear();
        System.out.println("Clear method:" + a1); //Clear method:[]

        // contains method
        System.out.println("Contains Method: " + a2.contains(17));//Contains Method: true

        //containsAll method
        a1.clear();
        a2.clear();
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a1.add(4);
        a1.add(5);
        a2.add(1);
        a2.add(2);
        a2.add(3);
        System.out.println("Contains all method: " + a1.containsAll(a2));//Contains all method: true

        //isEmpty method
        System.out.println("Is Empty: " + a1.isEmpty()); //Is Empty: false

        // size method
        System.out.println("Size method: " + a1.size()); //Size method: 5

        //ArrayList to Array 
        Object obj[] = a1.toArray();
        System.out.print("ArrayList to Array: ");
        for (Object i : obj) {
            System.out.print(i + " "); //ArrayList to Array: 1 2 3 4 5 
        }
        System.out.println("");
        //Iterator 
        Iterator<Integer> itr = a1.listIterator();
        System.out.print("Iterare array list using iterator:");
        while (itr.hasNext()) {
            System.out.print(itr.next() + " "); //Iterare array list using iterator:1 2 3 4 5
        }

    }
}
