/*
Using 3 loops
*/
class ReverseDoubly {

    public static void main(String[] args) {

        Nodes nodes = null;
        nodes = push(nodes, 9);
        nodes = push(nodes, 8);
        nodes = push(nodes, 6);
        nodes = push(nodes, 5);
        nodes = push(nodes, 4);
        //nodes = push(nodes, 3);
        nodes = push(nodes, 2);
        nodes = push(nodes, 1);
        
        triplets(nodes, 17);
    }
    
    public static void triplets(Nodes nodes, int sum){
        Nodes current1 = nodes;
        while (current1.next.next != null){
            Nodes current2 = current1.next;
            while (current2.next != null){
                Nodes current3 = current2.next;
                while (current3 != null){
                    if (current1.data + current2.data + current3.data == 
                            sum){
                        System.out.println("(" + current1.data + ", " + current2.data 
                                + ", " + current3.data +")");
                    }
                    current3 = current3.next;
                }
                current2 = current2.next;
            }
            current1 = current1.next;
        }
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
// Time --> O(n ^ 3)




/*
Using two pointers.

Do one loop to list i.e outer loop.
Start next loop from current's next to end.

if current's data + start's data + end's data == sum then print and advance start 
and retreat end

else if current's data + start's data + end's data < sum advance start 

else if current's data + start's data + end's data > sum retreat end 


*/
class ReverseDoubly {

    public static void main(String[] args) {

        Nodes nodes = null;
        nodes = push(nodes, 9);
        nodes = push(nodes, 8);
        nodes = push(nodes, 6);
        nodes = push(nodes, 5);
        nodes = push(nodes, 4);
        //nodes = push(nodes, 3);
        nodes = push(nodes, 2);
        nodes = push(nodes, 1);

        triplets(nodes, 17);
    }
    
    public static void triplets(Nodes nodes, int sum) {
        Nodes current = nodes;
        Nodes _end = tail(nodes);
        
        while (current != null) {
            Nodes start = current.next, end = _end;
            
            while (start != null && end != null && (start != end)){
                if (current.data + start.data + end.data == sum){
                    System.out.println("(" + current.data + ", " + start.data 
                                + ", " + end.data +")");
                    start = start.next;
                    end = end.prev;
                }
                else if (current.data + start.data + end.data < sum){
                    start = start.next;
                }
                else{
                    end = end.prev;
                }
            }
            current = current.next;
        }
    }

    public static Nodes tail(Nodes nodes) {
        Nodes end = nodes;

        while (end.next != null) {
            end = end.next;
        }
        return end;
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
// Time --> O(n ^ 2)
