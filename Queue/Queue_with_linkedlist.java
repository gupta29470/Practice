import java.util.*;
import java.io.*;
import java.math.*;

public class Queue_with_linkedlist {

    Node front, rear;
    int capacity;
    static int queue[];

    public static void main(String[] args) throws IOException {
        Queue<Integer> qu = new LinkedList<>();
        qu.add(11);
        qu.add(12);
        qu.add(13);
        qu.add(14);
        System.out.println(qu);
        System.out.println(qu.remove());
        System.out.println(qu);
        foss f = new foss();
        f.print();
        f.enqueue(10);
        f.enqueue(20);
        f.enqueue(30);
        f.enqueue(40);
        f.print();
        f.dequeue();
        f.print();
        System.out.println("Front:" + f.front.data);
        System.out.println("Front:" + f.rear.data);

    }

    foss() {
        this.front = this.rear = null;
    }

    void enqueue(int data) {
        Node newnode = new Node(data);
        if (this.rear == null) {
            this.front = this.rear = newnode;
            return;
        }

        this.rear.next = newnode;
        this.rear = newnode;

    }

    void dequeue() {
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }

        this.front = this.front.next;

    }

    void print() {
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }

        Node temp = front;
        while (temp != rear) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(temp.data);

    }

}

class Node {

    int data;
    Node next;

    Node() {
        data = 0;
        next = null;
    }

    Node(int data) {
        this.data = data;
        next = null;
    }
}
