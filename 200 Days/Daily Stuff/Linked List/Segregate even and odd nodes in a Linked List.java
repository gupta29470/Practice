/*
							By changing links 
*/
clas
class Segregate {

    public static void main(String[] args) {

        Nodes nodes = null;
        nodes = push(nodes, 6);
        nodes = push(nodes, 7);
        nodes = push(nodes, 1);
        nodes = push(nodes, 4);
        nodes = push(nodes, 5);
        nodes = push(nodes, 10);
        nodes = push(nodes, 12);
        nodes = push(nodes, 8);
        nodes = push(nodes, 15);
        nodes = push(nodes, 17);

        Nodes head = oddEven(nodes);

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static Nodes oddEven(Nodes head) {
        Nodes oddTail = new Nodes(0), evenTail = new Nodes(0);
        Nodes oddHead = oddTail, evenHead = evenTail;
        Nodes current = head;
        
        while (current != null){
            if (current.data % 2 == 0){
                evenTail.next = current;
                evenTail = evenTail.next;
            }
            else{
                oddTail.next = current;
                oddTail = oddTail.next;
            }
            current = current.next;
        }
        
        if (evenHead.next != null){
            evenTail.next = oddHead.next;
            head = evenHead.next;
        }
        else{
            head = oddHead.next;
        }
        
        if (oddTail != null){
            oddTail.next = null;
        }
        return head;
    }
   
    public static Nodes push(Nodes nodes, int data) {
        if (nodes == null) {
            nodes = new Nodes(data);
        } else {
            Nodes newNodes = new Nodes(data);
            nodes.prev = newNodes;
            newNodes.next = nodes;
            nodes = newNodes;
        }
        return nodes;
    }

}

class Nodes {

    int data;
    Nodes next, prev;

    Nodes(int data) {
        this.data = data;
    }
}
// Time --> O(n)
