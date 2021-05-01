public class Exchange_First_Last {
    public static void main(String args[]) {
        Node head = null;
        head = push(head, 5);
        head = push(head, 10);
        head = push(head, 15);
        head = push(head, 25);
        head = push(head, 30);
        System.out.println(count(head));
        printList(head);
        head=exchangeFirst_Last(head);
        System.out.println("");
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

    static Node exchangeFirst_Last(Node head) {
        Node first = head;
        Node second = head;
        while (second.next != first) {
            second = second.next;
        }
        int  temp=second.data;
        second.data=first.data;
        first.data=temp;
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
