class ReverseK {

    public static void main(String[] args) {

        Nodes nodes = null;
        nodes = push(nodes, 6);
        nodes = push(nodes, 5);
        nodes = push(nodes, 4);
        nodes = push(nodes, 3);
        nodes = push(nodes, 2);
        nodes = push(nodes, 1);

        Nodes head = reverseK(nodes, 2);

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static Nodes reverseK(Nodes nodes, int k) {
       Nodes current = nodes;
       Nodes root = new Nodes(0);
       root.next = nodes;
       Nodes previous = root;
       
       while (current != null){
           Nodes tail = current; 
           int count = 0;
           
           while (current != null && count < k){
               current = current.next;
               count++;
           }
           
           if (count != k){
               previous.next = tail;
               tail.prev = previous;
           }
           else{
               Nodes reversed = reverse(tail, k);
               previous.next = reversed;
               reversed.prev = previous;
               previous = tail;
           }
       }
       return root.next;
    }

    public static Nodes reverse(Nodes nodes, int k) {
        Nodes current = nodes, previous = null;
        int count = 0;
        while (current != null && count < k) {
            Nodes next = current.next;
            current.prev = next;
            current.next = previous;
            previous = current;
            current = next;
            count++;
        }
        return previous;
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
// Time --> O(n * k)  