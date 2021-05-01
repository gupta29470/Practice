import java.util.*;

public class test {

    public static void main(String args[]) {
        Node head = null;
        head = insert(head, 9);
        head = insert(head, 8);
        head = insert(head, 6);
        head = insert(head, 5);
        head = insert(head, 4);
        head = insert(head, 2);
        head = insert(head, 1);

       head= roatate(head,2);
       printList(head);

    }

    static class Node {

        int data;
        Node next, prev;
    };

    static Node roatate(Node head,int rotate_limit){
        Node curr=head;int count=1;
        // data: 1 2 3 4 5  roatate=2   result = 3 4 5 1 2 
        while(count<rotate_limit && curr!=null){ // reached till  curr=2
            curr=curr.next;
            count++;
        }
        if(curr==null){
            return curr;
        }
        Node nth_Node=curr; // storing 2 in nth 
        while(curr.next!=null){ // curr reached till 5
            curr=curr.next;
        }
        curr.next=head; // 5 next will be 1
        head.prev=curr; // 1 prev will be 5
        head=nth_Node.next; // head =3
        head.prev=null; // head node prev is always null
        nth_Node.next=null; // last node next is always null
        return head;
    }

    static Node insert(Node head, int data) {
        Node temp = new Node();
        temp.data = data;
        temp.next = temp.prev = null;
        if (head == null) {
            (head) = temp;
        } else {
            temp.next = head;
            (head).prev = temp;
            (head) = temp;
        }
        return temp;
    }

    static void printList(Node node) {
        while (node != null && node.next != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        if (node != null) {
            System.out.print(node.data);
        }
    }

}
