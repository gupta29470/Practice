import java.util.*;
import java.io.*;
import java.math.*;

public class Queue_with_array {

    static int front, rear, capacity;
    static int queue[];

    public static void main(String[] args) throws IOException {
        Queue<Integer> qu = new LinkedList<>();
        foss f=new foss(4);
        print();
        f.enqueue(10);
        f.enqueue(20);
        f.enqueue(30);
        f.enqueue(40);
        f.print();
        f.dequeue();
        f.print();
        f.front();
        f.rear();
    }

    foss (int c){
        front =rear=0;
        capacity =c;
        queue=new int[capacity];
    }
    static void enqueue(int data){
        if(rear==capacity){
            System.out.println("Queue is full");
        }
        else{
            queue[rear]=data;
            rear++;
        }
    }
    
    static void dequeue(){
        if(front==rear){
            System.out.println("Stack is empty");
        }
        else{
            for(int i=0;i<rear-1;i++){
                queue[i]=queue[i+1];
            }
            if(rear<capacity){
                queue[rear]=0;
            }
            rear--;
        }
        return;
    }
    static void print(){
        if(front==rear){
            System.out.println("Queue is empty");
        }
        else{
            for(int i=front;i<rear;i++){
                System.out.print(queue[i]+" ");
            }
        }
        System.out.println("");
    }
    static void front(){
        if(front==rear){
            System.out.println("Queue is empty");
        }
        else{
            System.out.println(queue[front]);
        }
    }
    static void rear(){
        if(front==rear){
            System.out.println("Queue is empty");
        }else{
        System.out.println(queue[rear]);
        }
    }
}
