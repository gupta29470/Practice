/*
	************************ ITERATIVE APPROACH *****************************
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
        Nodes slow = nodes;
        if (slow.next == null){
            return slow;
        }
        Nodes fast = slow.next;
        
        while (fast != null){
            while (fast != null && slow.data == fast.data){
                fast = fast.next;
            }
            slow.next = fast;
            slow = fast;
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
// Time --> O(n)



/*
	************************ RECURSIVE APPROACH *****************************
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
        if (nodes == null){
            return null;
        }
        if (nodes.next == null){
            return nodes;
        }
        
        if (nodes.next != null){
            if (nodes.data == nodes.next.data){
                nodes.next = nodes.next.next;
                removeDuplicates(nodes);
            }
            else{
                removeDuplicates(nodes.next);
            }
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
// Time --> O(n)
