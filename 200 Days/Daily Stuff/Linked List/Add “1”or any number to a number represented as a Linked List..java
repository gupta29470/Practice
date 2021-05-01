/*
	************************* ITERATIVE SOLUTION ***************************

The idea is to solve this problem using the basic algorithm for the addition of 
two numbers. But since the given list is singly linked, we can’t iterate it in 
the backward direction. Therefore, to facilitate the addition, we can 
reverse the list

We start by adding the given single-digit number to the digit at the first node 
in the reversed list. If the resultant sum is a 2-digit number, update the node 
with a single-digit sum and move the carry to the next node. 
This process is repeated while there is a carry. If we reach the last node and a 
carry exists, add a new node at the end of the linked list with carry as the value.
Finally, reverse the list again to restore the original order.


In short :
1. Reverse linked list
2. Start adding digit from first node and pass carry to next .. continue till
carry becomes 0. If carry is left and we iterate whole linked list, add new node
at end and initialize carry with that new node
3. Again reverse linked list
*/

// A Linked List Node
class Node
{
    int data;
    Node next = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
class Main
{
    // Helper function to print a given linked list
    public static void printList(String msg, Node head)
    {
        System.out.print(msg);
        while (head != null)
        {
            System.out.print(head.data + " —> ");
            head = head.next;
        }
 
        System.out.println("null");
    }
 
    // Function to reverse a given linked list
    public static Node reverse(Node head)
    {
        Node prev = null;
        Node current = head;
        Node next;
 
        // traverse the list
        while (current != null)
        {
            // tricky: note the next node
            next = current.next;
 
            // fix the current node
            current.next = prev;
 
            // advance the two pointers
            prev = current;
            current = next;
        }
 
        // fix the head pointer to point to the new front
        head = prev;
        return head;
    }
 
    // Function to add a single-digit number to a singly linked list
    // whose nodes represent digits of a number
    public static Node addDigit(Node head, int digit)
    {
        // empty list
        if (head == null) {
            return head;
        }
 
        // reverse the linked list
        head = reverse(head);
 
        // initialize carry with the given digit
        int carry = digit;
 
        // traverse the reversed list
        Node curr = head;
        while (carry > 0)
        {
            // get a sum of the current node and carry
            int sum = curr.data + carry;
 
            // update value of the current node with the single-digit sum
            curr.data = sum % 10;
 
            // set carry for the next node
            carry = sum / 10;
 
            // break if the current node is the last
            if (curr.next == null) {
                break;
            }
 
            // move to the next node
            curr = curr.next;
        }
 
        // add a new node at the end of the linked list if there is any carry left
        if (carry > 0) {
            curr.next = new Node(carry);
        }
 
        // reverse the list again to restore the original order
        head = reverse(head);
        return head;
    }
 
    public static void main(String[] args)
    {
        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);
        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(3);
 
        int digit = 7;
 
        printList("Original linked list: ", head);
        head = addDigit(head, digit);
        printList("Resultant linked list: ", head);
    }
}
// Time --> O(3n)



/*
************************* RECURSIVE SOLUTION ***************************

The idea is to recursively reach the end of the linked list and pass the carry 
information to each parent node as the recursion unfolds.

1. Go to last lode using recursive calls
2. generate sum by current data + digit(if last node) or current data + carry
(if carry is greater than 0 and for other nodes)
3. update current data by mod of sum
4. return remaining carry sum / 10
*/


// A Linked List Node
class Node
{
    int data;
    Node next = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
class Main
{
    // Helper function to push a new node at the beginning of the linked list
    public static Node push(Node head, int data)
    {
        Node node = new Node(data);
        node.next = head;
 
        head = node;
        return head;
    }
 
    // Helper function to print a given linked list
    public static void printList(String msg, Node head)
    {
        System.out.print(msg);
        while (head != null)
        {
            System.out.print(head.data + " —> ");
            head = head.next;
        }
 
        System.out.println("null");
    }
 
    // Recursive function to add a given digit to the linked list representing
    // a number.
    public static int add(Node head, int digit)
    {
        // base case: end of the linked list is reached
        if (head == null) {
            return digit;
        }
 
        // stores the carry returned by the recursive call of the next node
        int carry = add(head.next, digit);
 
        // optimization: terminate the recursion if carry is 0 at any point
        if (carry == 0) {
            return 0;
        }
 
        // get the sum of the current node and the carry
        int sum = head.data + carry;
 
        head.data = sum % 10;   // update value of the current node
        return sum/10;          // return carry
    }
 
    // Function to add a single-digit number to a singly linked list
    // whose nodes represent digits of a number
    public static Node addDigit(Node head, int digit)
    {
        // Add a given digit to the linked list using recursion
        int carry = add(head, digit);
 
        // if there is any carry left, add a new node at the beginning of the list
        if (carry > 0) {
            head = push(head, carry);
        }
 
        return head;
    }
 
    public static void main(String[] args)
    {
        int[] number = { 9, 9, 9, 9, 3 };
 
        Node head = null;
        for (int i = number.length - 1; i >= 0; i--) {
            head = push(head, number[i]);
        }
 
        int digit = 7;
 
        printList("Original linked list: ", head);
        head = addDigit(head, digit);
        printList("Resultant linked list: ", head);
    }
}
// Time --> O(n)  Space --> O(n)

