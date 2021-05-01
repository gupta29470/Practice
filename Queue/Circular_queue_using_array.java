import java.util.*;

public class practice_1 {
	
	static int front = -1, rear = -1;
	static int max = 10;
	static int queue[] = new int[max];
	
	public static void main(String args[]) {
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
		
		displayQueue();
		
		deQueue();
		
		displayQueue();
		
		enQueue(1);
		
		displayQueue();
		
	}
	
	public static void enQueue(int data) {
		// queue is empty
		if (front == -1 && rear == -1) {
			front = rear = 0;
			queue[rear] = data;
		}
		// queue is full
		else if ((rear + 1 % max) == front) {
			System.out.println("Queue is full");
		}
		// have space then add
		else {
			rear = (rear + 1) % max;
			queue[rear] = data;
		}
	}
	
	public static void deQueue() {
		// queue is empty
		if (front == -1 && rear == -1) {
			System.out.println("Queue is empty");
		}
		// only one element is present
		else if (front == rear) {
			System.out.println("Dequed element is : " + queue[front]);
			front = rear = -1;
		}
		else {
			front = (front + 1) % max;
		}
	}
	
	public static void displayQueue() {
		if (rear >= front) {
			for (int index = front; index <= rear; index++) {
				System.out.print(queue[index] + " ");
			}
			System.out.println();
		}
		else {
			for (int index = front; index < max; index++) {
				System.out.print(queue[index] + " ");
			}
			for (int index = 0; index <= rear; index++) {
				System.out.print(queue[index] + " ");
			}
			System.out.println();
		}
	}
}

















