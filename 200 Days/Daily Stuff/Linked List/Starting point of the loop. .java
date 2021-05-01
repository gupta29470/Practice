import java.util.*;

class StartingPontLoop {

    public static void main(String[] args) {
        Nodes nodes = new Nodes(1);
        nodes.next = new Nodes(2);
        nodes.next.next = new Nodes(3);
        nodes.next.next.next = new Nodes(4);
        nodes.next.next.next.next = new Nodes(5);
        nodes.next.next.next.next.next = new Nodes(6);
        nodes.next.next.next.next.next.next = nodes.next.next;
        //nodes.next.next.next.next.next.next = new Nodes(7);

        Nodes head = loop(nodes);

        System.out.println(head.data);
    }

    public static Nodes loop(Nodes nodes) {
        Set<Nodes> set = new HashSet<>();
        Nodes current = nodes;
        set.add(current);
        
        while (current != null) {
            current = current.next;

            if (set.contains(current)) {
                return current;
            }
            set.add(current);
        }
        return null;
    }

}

class Nodes {

    int data;
    Nodes next;

    Nodes(int data) {
        this.data = data;
    }
}



class StartingPontLoop {

    public static void main(String[] args) {
        Nodes nodes = new Nodes(1);
        nodes.next = new Nodes(2);
        nodes.next.next = new Nodes(3);
        nodes.next.next.next = new Nodes(4);
        nodes.next.next.next.next = new Nodes(5);
        nodes.next.next.next.next.next = new Nodes(6);
        nodes.next.next.next.next.next.next = nodes.next.next;
        //nodes.next.next.next.next.next.next = new Nodes(7);
        //nodes.next.next.next.next.next.next.next = new Nodes(8);

        System.out.println(removeLoop(nodes).data);
    }

    public static Nodes removeLoop(Nodes nodes) {
        if (nodes == null || nodes.next == null){
            return null;
        }
        
        Nodes fast = nodes, slow = nodes;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if (fast == slow) {
                break;
            }
        }
        
        // If loop does not exist
        if (fast != slow) {
            return null;
        }

        slow = nodes;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }

}

class Nodes {

    int data;
    Nodes next;

    Nodes(int data) {
        this.data = data;
    }
}
// Time --> O(n)