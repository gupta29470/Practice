/*
			*********************** Using TWO LOOPS ***********************
*/

class RemoveDuplicates {

    public static void main(String[] args) {
        Nodes nodes = new Nodes(1);
        nodes.next = new Nodes(2);
        nodes.next.next = new Nodes(3);
        nodes.next.next.next = new Nodes(3);
        nodes.next.next.next.next = new Nodes(3);
        nodes.next.next.next.next.next = new Nodes(6);
        nodes.next.next.next.next.next.next = new Nodes(7);
        nodes.next.next.next.next.next.next.next = new Nodes(8);

        Nodes head = removeDuplicates(nodes);
        
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static Nodes removeDuplicates(Nodes nodes) {
        Nodes once = nodes;
        
        while (once.next != null){
            Nodes again = once;
            while (again.next != null){
                if (once.data == again.next.data){
                    again.next = again.next.next;
                }
                else{
                    again = again.next;
                }
            }
            once = once.next;
        }
        return nodes;
    }

}

class Nodes {

    int data;
    Nodes next;

    Nodes(int data) {
        this.data = data;
    }
}
// Time --> O(n ^ 2)



/*
	    ************************* Using HASH SET *************************
*/
import java.util.*;

class RemoveDuplicates {

    public static void main(String[] args) {
        Nodes nodes = new Nodes(1);
        nodes.next = new Nodes(2);
        nodes.next.next = new Nodes(3);
        nodes.next.next.next = new Nodes(3);
        nodes.next.next.next.next = new Nodes(3);
        nodes.next.next.next.next.next = new Nodes(6);
        nodes.next.next.next.next.next.next = new Nodes(7);
        nodes.next.next.next.next.next.next.next = new Nodes(8);

        Nodes head = removeDuplicates(nodes);
        
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static Nodes removeDuplicates(Nodes nodes) {
        Nodes current = nodes;
        Nodes previous = null;
        Set<Integer> set = new HashSet<>();
        
        while (current != null){
            if (set.contains(current.data)){
                previous.next = current.next;
            }
            else{
                set.add(current.data);
                previous = current;
            }
            current = previous.next;
        }
        return nodes;
    }

}

class Nodes {

    int data;
    Nodes next;

    Nodes(int data) {
        this.data = data;
    }
}
// Time --> O(n)  Space --> O(n)
