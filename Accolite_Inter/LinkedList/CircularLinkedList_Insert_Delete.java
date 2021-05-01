import java.util.*;

public class test {

    public static void main(String args[]) {
        Node head = null;
        head = push(head, 5);
        head = push(head, 10);
        head = push(head, 15);
        head = push(head, 25);
        head = push(head, 30);
        System.out.println(count(head));
        printList(head);

        head = deleteNodeByData(head, 10);
        System.out.println("");
        System.out.println(count(head));
        printList(head);

        head = deleteDataByPos(head, 3);
        System.out.println("");
        System.out.println(count(head));
        printList(head);

    }

    static class Node {

        int data, size;
        Node next;

        Node() {
            data = 0;
            size = 0;
            next = null;
        }

    }

    static Node push(Node head, int data) {
        Node newnode = new Node();
        newnode.data = data;
        newnode.next = head;
        Node temp = head;
        if (temp != null) {
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newnode;
        } else {
            newnode.next = newnode;
        }
        head = newnode;
        head.size++;
        return head;
    }

    static Node deleteNodeByData(Node head, int data) {
        Node curr = head, prev = new Node();

        // Just Check if data is present in linkedlist or not
        while (curr.data != data) {
            if (curr.next == head) { // reached end but still not found data
                System.out.println("Data is not found");
                break;
            }
            prev = curr; // counter for previous
            curr = curr.next; // counnter for current;
        }

        // If only one node is present and it is target node
        if (curr.next == head) {
            head = null;
            return head;
        }

        // If it is 1st node
        if (curr == head) {
            prev = head;
            while (prev.next != head) {
                prev = prev.next;
            }
            head = curr.next;
            prev.next = head;
        } // if it is last node
        else if (curr.next == head) { // Found of found operation curr reached to last node
            // and prev reached to second-last node
            prev.next = head;
        } else {
            prev.next = curr.next; // Middle one
        }

        return head;
    }

    static Node deleteDataByPos(Node head, int pos) {
        if (pos == 1) {
            Node curr = head;
            while (curr.next != head) {
                curr = curr.next;
            }
            head = head.next;
            curr.next = head;
        } else if (pos == head.size) {
            Node curr = head, prev = null;
            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = head;
        } else {
            Node curr = head;
            for (int i = 1; i < pos - 1; i++) {
                curr = curr.next;
            }
            Node temp = curr.next;
            curr.next = temp.next;
        }
        head.size--;
        return head;
    }

    static void printList(Node head) {
        Node temp = head;
        if (temp != null) {
            while (temp.next != head) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.print(temp.data);
        }
    }

    static int count(Node head) {
        if (head == null) {
            return -1;
        }
        Node temp = head;
        int count = 1;
        while (temp.next != head) {
            temp = temp.next;
            count++;
        }
        return count;
    }

}
