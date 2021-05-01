import java.util.*;
public class List_Iterator {

    public static void main(String[] args) throws IOException {
        LinkedList l1 = new LinkedList();
        // add heterogenous elements
        l1.add(21);
        l1.add("Aakash");
        l1.add(71);
        l1.set(0, 2947);
        ListIterator ltr=l1.listIterator();
        while(ltr.hasNext()){
            System.out.print(ltr.next()+" ");//2947 Aakash 71
        }
        System.out.println("");
        while(ltr.hasPrevious()){
            System.out.print(ltr.previous()+" ");//71 Aakash 2947
        }
        ltr.remove();
        System.out.println(l1);//[Aakash, 71]
        
        
        ltr.add(2947);
        System.out.println(l1);//[2947, Aakash, 71]
    }
}
