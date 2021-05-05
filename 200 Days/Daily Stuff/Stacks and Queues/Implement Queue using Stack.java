/*
1. To enqueue an item into the queue, push the item into the first stack.
2. To dequeue an item from the queue, move elements from the first stack to the second stack if it is empty, 
and return the top item from the second stack.
*/

import java.util.*;

public class practice_1 {
	
	static Stack<Integer> stack1 = new Stack<>();
	static Stack<Integer> stack2 = new Stack<>();
	
	public static void main(String args[]) {
		add(1);
		add(2);
		add(3);
		add(4);
		add(5);
		
		peek();
		
		poll();
		
		peek();
		
		poll();
		
		peek();
		
		
	}
	
	public static void add(int data) {
		stack1.push(data);
	}
	
	public static void poll() {
		if (stack1.isEmpty()) {
			System.out.println("Queue is empty");
		}
		int polledData = 0;
		
		while (!stack1.isEmpty()) {
			if (stack1.size() == 1) {
				polledData = stack1.pop();
			}
			else {
				stack2.push(stack1.pop());
			}
		}
		
		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		
		System.out.println("Polled data is : " + polledData);
	}
	
	public static void peek() {
		if (stack1.isEmpty()) {
			System.out.println("Queue is empty");
		}
		
		int frontData = 0;
		
		while (stack1.size() != 1) {	
			stack2.push(stack1.pop());
		}
		
		frontData = stack1.peek();
		
		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		
		System.out.println("Front data is : " + frontData);
	}
}
// Time --> O(2n) + O(2n) = O(4n)   Space --> O(2n)




/*
Using recursive calls: Make recursive calls to stack and pop and peek last element from stack.
*/
import java.util.*;

public class practice_1 {
	
	static Stack<Integer> stack = new Stack<>();
	
	public static void main(String args[]) {
		enQueue(1);
		enQueue(2);
		enQueue(3);
		enQueue(4);
		enQueue(5);
		
		peek();
		
		deQueue();
		
		peek();
		
		deQueue();
		
		peek();
		
		
	}
	
	public static void enQueue(int data) {
		stack.push(data);
	}
	
	public static void deQueue() {
		if (stack.isEmpty()) {
			System.out.println("Queue is empty");
		}
		
		int polledData = deQueueUtil();
		
		System.out.println("Deque element : " + polledData);
	}
	
	public static void peek() {
		if (stack.isEmpty()) {
			System.out.println("Queue is empty");
		}
		
		int peekData = peekUtil();
		
		System.out.println("Front element : " + peekData);
	}
	
	public static int deQueueUtil() {
		if (stack.size() == 1) {
			return stack.pop();
		}
		
		int value = stack.pop();
		
		int temp = deQueueUtil();
		
		stack.push(value);
		
		return temp;
	}
	
	public static int peekUtil() {
		if (stack.size() == 1) {
			return stack.peek();
		}
		
		int value = stack.pop();
		
		int temp = peekUtil();
		
		stack.push(value);
		
		return temp;
	}
}

// Time --> O(4n)   Space --> O(n)



















