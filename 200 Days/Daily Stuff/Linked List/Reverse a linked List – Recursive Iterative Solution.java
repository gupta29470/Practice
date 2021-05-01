class LinkedList {

    public static void main(String[] args) {
        Nodes nodes = new Nodes(1);
        nodes.next = new Nodes(2);
        nodes.next.next = new Nodes(3);
        nodes.next.next.next = new Nodes(4);
        nodes.next.next.next.next = new Nodes(5);
        nodes.next.next.next.next.next = new Nodes(6);
        nodes.next.next.next.next.next.next = new Nodes(7);
        
        Nodes reverseNodes = reverse(nodes);
        
        while (reverseNodes.data != Integer.MAX_VALUE){
            System.out.print(reverseNodes.data + " ");
            reverseNodes = reverseNodes.next;
        }
    }

    public static Nodes reverse(Nodes nodes){
        if (nodes == null){
            return null;
        }
        
        Nodes reverseNodes = new Nodes(Integer.MAX_VALUE);
        Nodes temp = nodes;
        
        while (temp != null){
            reverseNodes = insertAtBeg(temp.data, reverseNodes);
            temp = temp.next;
        }
        return reverseNodes;
    }
    
    public static Nodes insertAtBeg(int data, Nodes reverseNodes){
        Nodes newNodes = new Nodes(data);
        newNodes.next = reverseNodes;
        reverseNodes = newNodes;
        
        return reverseNodes;
    }
}

class Nodes {

    int data;
    Nodes next;

    Nodes(int data) {
        this.data = data;
    }
}


/*
		********************* ITERATIVE SOLUTION **********************
The idea is to use three-pointers: next, current, previous  and move them down the 
list. Here, current is the main pointer running down the list, next  leads it, and 
previous trails it. For each step, reverse the current pointer and then advance 
all three to get the next node.

*/


// A Linked List Node
class Node
{
    int data;
    Node next;
 
    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
}
 
class Main
{
    // Helper function to print a given linked list
    public static void printList(Node head)
    {
        Node ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.data + " —> ");
            ptr = ptr.next;
        }
 
        System.out.println("null");
    }
 
    // Reverses a given linked list by changing its `.next` fields and
    // its head.
    public static Node reverse(Node head)
    {
        Node previous = null;
        Node current = head;
 
        // traverse the list
        while (current != null)
        {
            // tricky: note the next node
            Node next = current.next;
 
            current.next = previous;    // fix the current node
 
            previous = current;
            current = next;
        }
 
        // fix the head to point to the new front
        return previous;
    }
 
    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 1, 2, 3, 4, 5, 6 };
 
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
 
        head = reverse(head);
        printList(head);
    }
}
// Time --> O(n)



/*
		********************* RECURSIVE SOLUTION **********************
*/
// A Linked List Node
class Node
{
    int data;
    Node next;
 
    Node(int data) {
        this.data = data;
    }
}
 
class Main
{
    // Helper function to print a given linked list
    public static void printList(Node head)
    {
        Node ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.data + " —> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }
 
    // Helper function to insert a new node at the beginning of the linked list
    public static Node push(Node head, int data)
    {
        Node node = new Node(data);
        node.next = head;
        return node;
    }
 
    // Recursive function to reverse a given linked list. It reverses the
    // given linked list by fixing the head pointer and then `.next`
    // pointers of every node in reverse order
    public static Node reverse(Node head, Node headRef)
    {
        Node first, rest;
 
        // empty list base case
        if (head == null) {
            return headRef;
        }
 
        first = head;           // suppose first = {1, 2, 3}
        rest = first.next;      // rest = {2, 3}
 
        // base case: the list has only one node
        if (rest == null)
        {
            // fix the head pointer here
            headRef = first;
            return headRef;
        }
 
        // recursively reverse the smaller {2, 3} case
        // after: rest = {3, 2}
        headRef = reverse(rest, headRef);
 
        // put the first item at the end of the list
        rest.next = first;
        first.next = null;      // (tricky step — make a drawing)
 
        return headRef;
    }
 
    // Reverse a given linked list. The function takes a reference to
    // the head node
    public static Node reverse(Node head) {
        return reverse(head, head);
    }
 
    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 1, 2, 3, 4, 5, 6 };
 
        Node head = null;
        for (int i = keys.length - 1; i >=0; i--) {
            head = push(head, keys[i]);
        }
 
        head = reverse(head);
        printList(head);
    }
}
// Time --> O(n)
