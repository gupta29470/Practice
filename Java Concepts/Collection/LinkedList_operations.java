import java.util.*;

public class LinkedList_operations {

    public static void main(String[] args) throws IOException {
        ArrayList a1 = new ArrayList();
        ArrayList a2 = new ArrayList(a1);
        LinkedList l1 = new LinkedList();
        // add heterogenous elements
        l1.add(21);
        l1.add("Aakash");
        l1.add(71);
        l1.set(0, 2947);

        // Special Methods applicable for linkedlist only
        l1.addFirst("Crack Google");
        l1.addLast("Yes I will");
        System.out.println(l1);//[Crack Google, 21, Aakash, 71, Yes I will]
        System.out.println("Get First Method: " + l1.getFirst());//Get First Method: Crack Google
        System.out.println("Get Last Method: " + l1.getLast());//Get Last Method: Yes I will
        System.out.println("Remove First: " + l1.removeFirst());//Remove First: Crack Google
        System.out.println("Remove Last: " + l1.removeLast());//Remove Last: Yes I will
        l1.set(0, 2947);//[Crack Google, 2947, Aakash, 71, Yes I will]

    }
}
