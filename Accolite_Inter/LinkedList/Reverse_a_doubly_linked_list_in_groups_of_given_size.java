import java.util.*;

public class Reverse_a_doubly_linked_list_in_groups_of_given_size {

    public static void main(String args[]) {
        Node head = null;
        head = insert(head, 9);
        head = insert(head, 8);
        head = insert(head, 6);
        head = insert(head, 5);
        head = insert(head, 4);
        head = insert(head, 2);
        head = insert(head, 1);

       head= reverse(head,2);
       printList(head);

    }

    static class Node {

        int data;
        Node next, prev;
    };

    static Node reverse(Node head,int size){
        // Method: Change next pointer to previous and previous pointer to next
       Node curr=head,nextptr=null,prevptr=null;
       int count=0;
       while(count<size && curr!=null){
           nextptr=curr.next; // storing next
           curr.next=prevptr; // assigning prev
           curr.prev=nextptr;
           prevptr=curr;
           curr=nextptr;
           count++;
       }
       if(nextptr!=null){
           head.next=reverse(nextptr,size);
       }
       head=prevptr;
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
