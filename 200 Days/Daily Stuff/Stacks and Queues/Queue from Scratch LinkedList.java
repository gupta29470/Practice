import java.util.*;

public class practice_1 {
	
	static Node front = null, rear = null;
	
	public static void main(String args[]) {
		deQueue();
		
		enQueue(1);
		enQueue(2);
		enQueue(3);
		enQueue(4);
		enQueue(5);
		enQueue(6);
		enQueue(7);
		enQueue(8);
		enQueue(9);
		enQueue(10);
		enQueue(11);
		
		displayQueue();
		
		deQueue();
		
		displayQueue();
		
		enQueue(1);
		
		displayQueue();
	}
	
	public static void enQueue(int data) {
		Node newNode = new Node(data);
		
		if (front == null && rear == null) {
			front = rear = newNode;
		}
		else {
			rear.next = newNode;
			rear = newNode;
		}
	}
	
	public static void deQueue() {
		if (front == null) {
			System.out.println("Queue is empty");
		}
		else {
			front = front.next;
		}
	}
	
	public static void displayQueue() {
		if (front == null) {
			System.out.println("Queue is empty");
		}
		
		Node temp = front;
		
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}

class Node{
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
	}
}















