import java.util.*;

public class double_ended_queue_with_array {

    int front = -1, rear = -1, n = 5;
    int queue[] = new int[n];

    public static void main(String[] args) {
//        ArrayDeque<Integer> ad=new ArrayDeque<>();
//        ad.addLast(55);
//        ad.addFirst(95);
//        ad.offer(105);
//        ad.offerFirst(120);
//        ad.pollFirst();
//        System.out.println(ad);
//        System.out.println(ad.peek());
        prat p = new prat();
        p.enqueueFront(5);
        p.enqueueFront(10);
        p.enqueueFront(15);
        p.enqueueRear(20);
        p.enqueueRear(25);
        p.display();
        p.dequeueFront();
        p.dequeueRear();
        p.display();

    }

    void enqueueFront(int data) {
        if(front==0 && rear==n-1 || front==rear+1){
            System.out.println("Queue is full");
        }
        else if(front==-1 && rear==-1){
            front=rear=0;
            queue[front]=data;
        }
        else if(front==0){
            front=n-1;
            queue[front]=data;
        }
        else{
            front--;
            queue[front]=data;
        }
    }

    void enqueueRear(int data) {
       if(front==-1 && rear==-1 || front==rear+1){
           System.out.println("Queue is full");
       }
       else if(front==-1 && rear==-1){
           front=rear=0;
           queue[rear]=data;
       }
       else if(rear==n-1){
           rear=0;
           queue[rear]=data;
       }
       else{
           rear++;
           queue[rear]=data;
       }
    }

    void display() {
        int i=front;
        while(i!=rear){
            System.out.print(queue[i]+" ");
            i=(i+1)%n;
        }
        System.out.println(queue[rear]);
       
    }
    void dequeueFront(){
       if(front==-1 && rear==-1){
           System.out.println("Queue is empty");
       }
       else if(front==rear){
           System.out.println(queue[front]);
           front=rear=-1;
       }
       else if(front==n-1){
           System.out.println(queue[front]);
           front=0;
       }
       else{
           System.out.println(queue[front]);
           front++;
       }
    }
    void dequeueRear(){
        if(front==-1 && rear==-1){
           System.out.println("Queue is empty");
       }
        else if(front==rear){
           System.out.println(queue[rear]);
           front=rear=-1;
       }
        else if(rear==0){
           System.out.println(queue[front]);
           rear=n-1;
       }
        else{
            System.out.println(queue[rear]);
            rear--;
        }
        
    }

}
