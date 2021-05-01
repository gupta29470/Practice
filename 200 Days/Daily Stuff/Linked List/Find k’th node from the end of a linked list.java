/*
Calculate size of linked list.

Loop till index < size - k  and advance current 

return current
*/

class Last {

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

        Nodes kthNode = fromEnd(nodes, 5);
        
        System.out.println(kthNode.data);
    }

    public static Nodes fromEnd(Nodes head, int k) {
        int size = size(head);
        Nodes current = head;
        
        for (int index = 0; index < (size - k); index++){
            current = current.next;
        }
        return current;
    }
    
    public static int size(Nodes head){
        int size = 0;
        Nodes current = head;
        
        while (current != null){
            current = current.next;
            size++;
        }
        return size;
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
// Time --> O(2n)




/*
First move k nodes ahead in list. Loop till index < k and advance current 

if current == null return null

while current is not null advance current and advance head

return head
*/
class Last {

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

        Nodes kthNode = fromEnd(nodes, 5);
        
        System.out.println(kthNode.data);
    }

    public static Nodes fromEnd(Nodes head, int k) {
        Nodes current = head;
        
		// move `k` nodes ahead in the linked list
        for (int index = 0; index < k; index++){
            current = current.next;
        }
        
		// return if `k` is more than the total number of nodes in the list
        if (current == null){
            return null;
        }
        
		// move the `head` and `curr` parallelly till `curr` reaches the list's end
        while (current != null){
            current = current.next;
            head = head.next;
        } 
		
		// `head` will now contain the k'th node from the end
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
