import java.util.*;

/**
 *
 * @author Aakash
 */
public class JavaApplication1 {

    public static void main(String[] args) {

        JavaApplication1 li = new JavaApplication1();
        LinkedList l=new LinkedList();
        l.insert_at_first(66);
        l.insert_at_first(88);
        l.insert_at_first(897);
        l.circular();
        l.print();

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

    public void size() {
        System.out.println(size);
    }

    public void insert_at_first(int data){
        Node newnode=new Node();
        newnode.setData(data);
        newnode.setNext(start);
        start=newnode;
        size++;
        
    }
    public void  circular(){
        Node temp=start;
        while(temp.getNext()!=null){
            temp=temp.getNext();
        }
        temp.setNext(start);
    }
}
