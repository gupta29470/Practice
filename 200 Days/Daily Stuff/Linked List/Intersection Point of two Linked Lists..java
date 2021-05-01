/*
1. Using Hashing

The idea is to traverse the first list and store each node’s address in a 
hash set . Then traverse the second list and get the address of the first node 
present in the hash table. This node would be the intersection point.

*/


import java.util.HashSet;
import java.util.Set;
 
// A Linked List Node
class Node
{
    int data;
    Node next;
}
 
class Main
{
    // Utility function to create a new node with the given data and
    // pushes it onto the list's front
    public static Node push(Node head, int data)
    {
        Node node = new Node();
        node.data = data;
        node.next = head;
        return node;
    }
 
    // Function to find the intersection point of two linked lists using hashing
    public static Node findIntersection(Node first, Node second)
    {
        // maintain a set to store list nodes
        Set<Node> nodes = new HashSet<>();
 
        // traverse the first list and insert the address of each node into the set
        while (first != null)
        {
            nodes.add(first);
            first = first.next;
        }
 
        // now traverse the second list and find the first node that is
        // already present in the set
        while (second != null)
        {
            // return the current node if it is found in the set
            if (nodes.contains(second)) {
                return second;
            }
            second = second.next;
        }
 
        // we reach here if lists do not intersect
        return null;
    }
 
    public static void main(String[] args)
    {
        // construct the first linked list (1 —> 2 —> 3 —> 4 —> 5 —> null)
        Node first = null;
        for (int i = 5; i > 0; i--) {
            first = push(first, i);
        }
 
        // construct the second linked list (1 —> 2 —> 3 —> null)
        Node second = null;
        for (int i = 3; i > 0; i--) {
            second = push(second, i);
        }
 
        // link tail of the second list to the fourth node of the first list
        second.next.next.next = first.next.next.next;
 
        Node addr = findIntersection(first, second);
        if (addr != null) {
            System.out.println("The intersection point is " + addr.data);
        }
        else {
            System.out.println("The lists do not intersect.");
        }
    }
}
// Time --> O(n + m)    Space --> O(n)



/*
Create dummy nodes for both linked list i.e first and second

while first is not null or second is not null:
	-> if first is null means it reaches end of first linked list then update
	it with head of second linked list(opposite)
	-> if first is not null then move first to next
	
	-> if second is null means it reaches end of second linked list then update
	it with head of first linked list(opposite)
	-> if second is not null then move second to next
	
	-> if first and second is equal it reaches to intersection then return 
	either firts or second
	

At end return null means first and second both are null at same time that means
no intersection point.
*/


class Intersection {

    public static void main(String[] args) {

        Nodes nodes1 = new Nodes(1);
        nodes1.next = new Nodes(2);
        nodes1.next.next = new Nodes(3);
        nodes1.next.next.next = new Nodes(4);
        nodes1.next.next.next.next = new Nodes(6);

        Nodes nodes2 = new Nodes(2);
        nodes2.next = new Nodes(4);
        nodes2.next.next = new Nodes(6);
        nodes2.next.next.next = new Nodes(8);
        nodes2.next.next.next.next = nodes1.next.next.next;

        System.out.println(intersection(nodes1, nodes2).data);
    }
    
    public static Nodes intersection(Nodes nodes1, Nodes nodes2){
        
        Nodes first = nodes1, second = nodes2;
        
        while (first != null || second != null){
            if (first == null){
                first = nodes2;
            }
            else if (first != null){
                first = first.next;
            }
            
            if (second == null){
                second = nodes1;
            }
            else if (second != null){
                second = second.next;
            }
            
            if (first == second){
                return first;
            }
        }
        // first and second both become null means no intersection
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
