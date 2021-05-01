import java.util.*;

public class ArrayList_implementation {

    public static void main(String[] args) throws IOException {
        ArrayList a1 = new ArrayList();
        LinkedList l1=new LinkedList();
        // add heterogenous elements
        
        a1.add("Aakash Gupta");
        a1.add(null);
        a1.add(21);
        a1.add(71);
        System.out.println(a1);//[Aakash Gupta, null, 21, 71]
        a1.add(1,"Male");
        System.out.println(a1);//[Aakash Gupta, Male, null, 21, 71]
        
        System.out.println(a1 instanceof Serializable);//true
        System.out.println(l1 instanceof Serializable);//true
        System.out.println(a1 instanceof Cloneable);//true
        System.out.println(l1 instanceof Cloneable);//true
        System.out.println(a1 instanceof RandomAccess);//true
        System.out.println(l1 instanceof RandomAccess);//false
        
        List l=Collections.synchronizedList(l1);
        
    }
}
