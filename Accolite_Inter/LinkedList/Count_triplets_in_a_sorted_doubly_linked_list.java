import java.util.*;
// Method 1: Time complexity O(n^3) . Space O(1)
public class Count_triplets_in_a_sorted_doubly_linked_list{

    public static void main(String args[]) {
        Node head = null;
        head = insert(head, 9);
        head = insert(head, 8);
        head = insert(head, 6);
        head = insert(head, 5);
        head = insert(head, 4);
        head = insert(head, 2);
        head = insert(head, 1);

        int x = 17;

        System.out.println(Count_Triplets(head, x));

    }

    static class Node {

        int data;
        Node next, prev;
    };

    static int Count_Triplets(Node head, int sum) {
        Node a, b, c;
        int count = 0;
        for (a = head; a != null; a = a.next) {
            for (b = a.next; b != null; b = b.next) {
                for (c = b.next; c != null; c = c.next) {
                    if ((a.data + b.data + c.data) == sum) {
                        count++;
                    }
                }
            }
        }
        return count;
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
}


// Method 2: Time complexity O(n^2) . Space O(1) using Two pointers
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

        int x = 17;

        System.out.println(Count_Triplets(head, x));

    }

    static class Node {

        int data;
        Node next, prev;
    };

    static int Count_Triplets(Node head, int sum) {
        if(head==null){
            return 0;
        }
        Node current,left,right;
        right=head; int count=0;
        while(right.next!=null){
            right=right.next;
        }
        for(current=head;current!=null;current=current.next){
            left=current.next;
            count+=pairsCount(left,right,(sum-current.data));
        }
        return count;
        
    }
    static int pairsCount(Node left,Node right,int sum){
       int count=0;
       while(left!=null && right!=null && left!=right && right.next!=left){
           if((left.data+right.data)==sum){
               count++;
               left=left.next;
               right=right.prev;
           }
           else if((left.data+right.data)<sum){
               left=left.next;
           }
           else{
               right=right.prev;
           }
       }
       return count;
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
}
