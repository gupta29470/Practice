class ReverseDoubly {

    public static void main(String[] args) {

        Nodes nodes = null;
        nodes = push(nodes, 8);
        nodes = push(nodes, 7);
        nodes = push(nodes, 6);
        nodes = push(nodes, 5);
        nodes = push(nodes, 4);
        nodes = push(nodes, 3);
        nodes = push(nodes, 2);
        nodes = push(nodes, 1);

        Nodes reverse = reverse(nodes);
        
        while (reverse != null){
            System.out.print(reverse.data + " ");
            reverse = reverse.next;
        }
        System.out.println("");
    }
    
    public static Nodes reverse(Nodes nodes){
        Nodes current = nodes, previous = null;
        
        while (current != null){
            Nodes next = current.next;
            current.prev = next;
            current.next = previous;
            previous = current;
            current = next;
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
// Time --> O(n)