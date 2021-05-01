import java.util.*;
public class List_operations {

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> a1 = new ArrayList<>();
        // add method
        a1.add(3);
        a1.add(17);
        a1.add(6);
        a1.add(9);
        a1.add(7);
        System.out.println("Add method:" + a1); //Add method:[3, 17, 6, 9, 7]
        
        //add specific index
        a1.add(2,55);
        System.out.println("Add 55 at index 2: " + a1);//Add specific index method:[3, 17, 55, 6, 9, 7]

        // addAll
        ArrayList<Integer> a2 = new ArrayList<>();//Add All method:[3, 17, 6, 9, 7, 3, 17, 6, 9, 7]
        a2.add(3);
        a2.add(17);
        a2.add(6);
        a2.add(9);
        a2.add(7);
        a1.addAll(2,a2);
        System.out.println("Adding a2 at index 2 in a1: "+a1);//Adding a2 at index 2 in a1: [3, 17, 3, 17, 6, 9, 7, 55, 6, 9, 7]
        
        
        //getIndex
        System.out.println("Get data on index 7: "+a1.get(7)); //Get data of index 7: 55
        
        // remove
        System.out.println("Remove object using index 7: "+a1.remove(7));//Remove object using index 7: 55
        System.out.println("After removing: "+a1);//After removing: [3, 17, 3, 17, 6, 9, 7, 6, 9, 7]
        
        
        //set method
        System.out.println("Setting 55 at index 7");
        a1.set(7, 55);
        System.out.println("After setting 55 at inex 7: "+a1); //After setting 55 at inex 7: [3, 17, 3, 17, 6, 9, 7, 55, 9, 7]
        
        
        //indexOf
        System.out.println("Index of 17: "+a1.indexOf(17));//Index of 17: 1(first occurance)
        
        
        //lastindex of data
        System.out.println("Last Index of 17: "+a1.lastIndexOf(17));//Last Index of 17: 3(last occurance of 17)
        

    }
}
