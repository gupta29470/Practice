/*
The idea is to make the linked list circular and then break the chain before the 
last node after making its head to point to the last node.
*/

class MoveLastToFirst {

    public static void main(String[] args) {
        Nodes nodes = new Nodes(1);
        nodes.next = new Nodes(2);
        nodes.next.next = new Nodes(3);
        nodes.next.next.next = new Nodes(4);
        nodes.next.next.next.next = new Nodes(5);
        nodes.next.next.next.next.next = new Nodes(6);
        nodes.next.next.next.next.next.next = new Nodes(7);
        nodes.next.next.next.next.next.next.next = new Nodes(8);

        Nodes head = moveFirstToLast(nodes);
        
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static Nodes moveFirstToLast(Nodes nodes) {
        // proceed only when the list is valid
        if (nodes == null || nodes.next == null) {
            return null;
        }
        
        Nodes secondLast = nodes;
        
        // move to the second last node
        while (secondLast.next.next != null){
            secondLast = secondLast.next;
        }
        
        // transform the list into a circular list
        secondLast.next.next = nodes;
        
        // Fix head = last node
        nodes = secondLast.next;
        
        // break the chain i.e after second last make null
        secondLast.next = null;
        
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
