import java.util.*;

public class Circular_queue_using_Linkedlist {

    Nodess front, rear;

    public static void main(String[] args) {
        JavaApplication1 j = new JavaApplication1();

       Queue q =new Queue();
       q.front=null;q.rear=null;
       j.enqueue(q,10);
       j.enqueue(q,20);
       j.enqueue(q,30);
       j.enqueue(q,40);
       j.print(q);
       j.dequeue(q);
       j.print(q);
       j.enqueue(q, 10);
       j.print(q);
    }

    JavaApplication1() {
        this.front = this.rear = null;
    }

    void enqueue(Queue q, int data) {
        Nodess newnode = new Nodess();
        newnode.data=data;
        if (q.front == null) {
            q.front = newnode;
        } else {
            q.rear.next = newnode;
        }
        q.rear = newnode;
        q.rear.next = q.front;

    }

    void dequeue(Queue q) {
        if (q.front == null) {
            System.out.println("Queue is empty");
            return;
        } if (q.front == q.rear) {
            System.out.println(q.front.data + " ");
            q.front = null;
            q.rear = null;
        } else {
            Nodess temp = q.front;
            q.front = q.front.next;
            q.rear.next=q.front;
            System.out.println(temp.data);
        }

    }

    void print(Queue q) {
        if(q.front==null){
            System.out.println("Queue is empty");
            return;
        }
        else{
            Nodess temp=q.front;
            while(temp.next!=q.front){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
            System.out.println(temp.data);
        }

    }

}

class Nodess {

    int data;
    Nodess next; //reference of node
    Nodess prev;

    public Nodess() {
        data = 0;
        next = null;
        prev = null;
    }
}

class Queue {

    Nodess front, rear;
}