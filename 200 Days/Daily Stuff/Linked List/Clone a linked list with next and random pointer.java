/*
To clone a linked list with random pointers, maintain a hash map  for storing the 
mappings from a linked list node to its clone. We create a new node with the same 
data for each node in the original linked list and recursively set its next 
pointers. We also create a mapping from the original node to the duplicate node 
in the hash map. Finally, traverse the original linked list again and update 
the duplicate nodes’ random pointers using the hash map.
*/

import java.util.HashMap;
import java.util.Map;
 
// A linked list node with a random pointer
class Node
{
    int data;
    Node next, random;
 
    // Constructor
    Node(int data) {
        this.data = data;
    }
}
 
class Main
{
    // Recursive function to print a linked list
    public static void traverse(Node head)
    {
        if (head == null)
        {
            System.out.println("null");
            return;
        }
 
        // print current node data and random pointer data
        if (head.random != null) {
            System.out.print(head.data + "(" + head.random.data + ") —> ");
        }
        else {
            System.out.print(head.data + "(" + "X" + ") —> ");
        }
 
        // recur for the next node
        traverse(head.next);
    }
 
    // Recursive function to copy random pointers from the original linked list
    // into the cloned linked list using the map
    public static void updateRandomPointers(Node head, Map<Node, Node> map)
    {
        // base case
        if (map.get(head) == null) {
            return;
        }
 
        // update the random pointer of the cloned node
        map.get(head).random = map.get(head.random);
 
        // recur for the next node
        updateRandomPointers(head.next, map);
    }
 
    // Recursive function to clone the data and next pointer for each node
    // of the linked list into a given map
    public static Node cloneLinkedList(Node head, Map<Node, Node> map)
    {
        // base case
        if (head == null) {
            return null;
        }
 
        // clone all fields of the head node except the random pointer
 
        // create a new node with the same data as the head node
        map.put(head, new Node(head.data));
 
        // clone the next node
        map.get(head).next = cloneLinkedList(head.next, map);
 
        // return cloned head node
        return map.get(head);
    }
 
    // Function to clone a linked list having random pointers
    public static Node cloneLinkedList(Node head)
    {
        // create a map to store mappings from a node to its clone
        Map<Node, Node> map = new HashMap<>();
 
        // clone data and next pointer for each node of the original
        // linked list and put references into the map
        cloneLinkedList(head, map);
 
        // update random pointers from the original linked list in the map
        updateRandomPointers(head, map);
 
        // return the cloned head node
        return map.get(head);
    }
 
    public static void main(String[] args)
    {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
 
        head.random = head.next.next.next;
        head.next.next.random = head.next;
 
        System.out.println("Original Linked List:");
        traverse(head);
 
        Node clone = cloneLinkedList(head);
 
        System.out.println("\nCloned Linked List:");
        traverse(clone);
    }
}

// Time --> O(n)  Space --> O(n)




/*
The idea is to create a duplicate of each linked list node and associate each 
duplicate node with the original node’s next child. Then iterate the modified 
list and update the random pointers of the new nodes. Finally, extract the 
duplicate nodes from the modified list, hence restoring the original linked list.
*/

// A linked list node with a random pointer
class Node
{
    int data;
    Node next, random;
 
    // Constructor
    Node(int data) {
        this.data = data;
    }
}
 
class Main
{
    // Recursive function to print a linked list
    public static void traverse(Node head)
    {
        // traverse the linked list
        while (head != null)
        {
            // print current node data and random pointer data
            if (head.random != null) {
                System.out.print(head.data + "(" + head.random.data + ") —> ");
            }
            else {
                System.out.print(head.data + "(" + "X" + ") —> ");
            }
 
            // advance to the next node
            head = head.next;
        }
 
        System.out.println("null");
    }
 
    // Function to clone a linked list having random pointers
    public static Node cloneLinkedList(Node head)
    {
        /* 1. Create a duplicate of each node of the original linked list */
 
        // traverse the original linked list
        Node curr = head;
        while (curr != null)
        {
            // take a pointer to the next node in the original list
            Node next = curr.next;
 
            // duplicate each node of the linked list
            Node dup = new Node(curr.data);
 
            // associate each duplicate node with the next child of the original node
            curr.next = dup;
            dup.next = next;
 
            // advance to the next node in the original list
            curr = next;
        }
 
        /* 2. Update the random pointers of the duplicated nodes */
 
        // traverse the modified list
        curr = head;
        while (curr != null)
        {
            // if a random pointer for the original node exists, set it for the clone
            if (curr.random != null) {
                (curr.next).random = (curr.random).next;
            }
 
            // advance to the next node in the original list
            curr = (curr.next).next;
        }
 
        /* 3. Extract the duplicate nodes from the modified list */
 
        // construct a dummy node whose next pointer points to the head
        // of the cloned linked list
        Node dummy = new Node(-1);
 
        // maintain a tail node for the clone
        Node tail = dummy;
 
        // traverse the modified list
        curr = head;
        while (curr != null)
        {
            // take a pointer to the next node in the original list
            Node next = curr.next.next;
 
            // extract the duplicate
            Node dup = curr.next;
            tail.next = dup;
            tail = dup;
 
            // restore the original linked list
            curr.next = next;
 
            // advance to the next node in the original list
            curr = next;
        }
 
        // return head node of the cloned list
        return dummy.next;
    }
 
    public static void main(String[] args)
    {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
 
        head.random = head.next.next.next;
        head.next.next.random = head.next;
 
        System.out.print("Original linked list:\n");
        traverse(head);
 
        Node clone = cloneLinkedList(head);
 
        System.out.print("\nCloned linked list:\n");
        traverse(clone);
    }
}
// Time --> O(n)   Space --> O(1)
