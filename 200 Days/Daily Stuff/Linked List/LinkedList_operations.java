import java.util.*;

/**
 *
 * @author Aakash
 */
public class LinkedList_operations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList l = new LinkedList();
        boolean flag=true;
        while (flag) {
            System.out.println("");
            System.out.println("1.Insert at begin\n2.Insert at given pos\n3.Insert at last\n4.Delete at first\n5.Insert at given pos\n6.Delete at last\n7.print\n8.Size\n9.Exit");
            System.out.println("Enter your choice:");
            System.out.println("");
            int choice = sc.nextInt();
            int pos;
            int data;
            switch (choice) {
                case 1:
                    System.out.println("Enter data:");
                    data = sc.nextInt();
                    l.insert_at_first(data);
                    break;
                case 2:
                    System.out.println("Enter pos:");
                    pos = sc.nextInt();
                    System.out.println("Enter data:");
                    data = sc.nextInt();
                    l.insert_at_pos(pos, data);
                    break;
                case 3:
                    System.out.println("Insert data:");
                    data = sc.nextInt();
                    l.insert_at_last(data);
                    break;
                case 4:
                    l.delete_first();
                    break;
                case 5:
                    System.out.println("Enter position:");
                    pos = sc.nextInt();
                    l.delete_at_pos(pos);
                    break;
                case 6:
                    l.delete_last();
                    break;
                case 7:
                    l.print();
                    break;
                case 8: 
                   l.size();
                case 9:
                    flag=false;
                    
                    
                default:
                    System.out.println("Invalid Choice");

            }
        }

    }
}

class Node {

    private int data;
    private Node next; //reference of node

    public Node() {
        data = 0;
        next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public static void main(String[] args) {

    }
}

class LinkedList {

    private int size;
    private Node start;

    LinkedList() {
        size = 0;
        start = null;
    }

    public boolean isEmpty() {
        return start == null;
    }

    public int getListsize() {
        return size;
    }

    public void print() {
        Node temp = start;
        if (isEmpty()) {
            System.out.println("No elements in list");
        }
        for (int i = 1; i <= size; i++) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
    public void  size(){
        System.out.println(size);
    }

    public void insert_at_first(int data) {
        Node newnode = new Node();
        newnode.setData(data);
        newnode.setNext(start);
        start = newnode;
        size++;
    }

    public void insert_at_last(int data) {
        Node newnode = new Node();
        newnode.setData(data);
        Node temp = start;
        if (temp == null) {
            start = newnode;

        }
        else{
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(newnode);
        }
        size++;

    }

    public void insert_at_pos(int pos, int data) {
        if (pos == 1) {
            insert_at_first(data);
        } else if (pos == size + 1) {
            insert_at_last(data);
        } else if (pos > 1 && pos < size) {
            Node newnode = new Node(data, null);
            Node temp = start;
            for (int i = 1; i < pos - 1; i++) {
                temp = temp.getNext();
            }
            newnode.setNext(temp.getNext());
            temp.setNext(newnode);
            size++;

        } else {
            System.out.println("Insertion not possible");
        }
    }

    public void delete_first() {
        if (start == null) {
            System.out.println("List is Empty");
        } else {
            start = start.getNext();
            size--;
        }
    }

    public void delete_last() {
        if (start == null) {
            System.out.println("List is Empty");
        } else if (size == 1) {
            start = null;
            size--;
        } else {
            Node temp = start;
            for (int i = 1; i < size - 1; i++) {
                temp = temp.getNext();
            }
            temp.setNext(null);
            size--;
        }
    }

    public void delete_at_pos(int pos) {
        if (start == null) {
            System.out.println("List is Empty");
        } else if (pos > size || pos < 1) {
            System.out.println("Delete not possible");
        } else if (pos == 1) {
            delete_first();
        } else if (pos == size) {
            delete_last();
        }
        Node temp = start;
        for (int i = 1; i < pos - 1; i++) {
            temp = temp.getNext();
        }
        Node t = temp.getNext();
        temp.setNext(t.getNext());
        size--;
    }
}
