import java.util.*;

public class Find_pairs_with_given_sum_in_doubly_linked_list {

    public static void main(String args[]) {
        Node head = null;
        head = insert(head, 9);
        head = insert(head, 8);
        head = insert(head, 6);
        head = insert(head, 5);
        head = insert(head, 4);
        head = insert(head, 2);
        head = insert(head, 1);
        int x = 9;

        Find_sumPair(head, x);

    }

    static class Node {

        int data;
        Node next, prev;
    };

    static void Find_sumPair(Node head, int sum) {
        Node left = head, right = head;
        while (right.next != null) {
            right = right.next;
        }
        boolean found=false;
        while (left != null && right != null && left!=right && right.next!=left) {
            if((left.data+right.data)==sum){
                found=true;
                System.out.println("Pair is:("+left.data+","+right.data+")");
                left=left.next;
                right=right.next;
            }
            else if((left.data+right.data)<sum){
                left=left.next;
            }
            else{
                right=right.prev;
            }
        }
        if(found==false){
            System.out.println("No pair found");
        }

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
