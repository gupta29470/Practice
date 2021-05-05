/*
Using two Queues

1. To push an item into the stack, enqueue the item to the first queue.

2. To pop an item from the stack, move all elements from the first queue to the second queue except the last element, 
and then return the last element after moving all elements back to the first queue.
*/

import java.util.*;

public class practice_1 {
	static Queue<Integer> queue1 = new ArrayDeque<>();
	static Queue<Integer> queue2 = new ArrayDeque<>();
	
	public static void main(String args[]) {
		push(1);
		push(2);
		push(3);
		push(4);
		push(5);
		
		peek();
		
		pop();
		
		peek();
		
		pop();
		
		peek();
	}
	
	public static void push(int data) {
		queue1.add(data);
	}
	
	public static void pop() {
		if (queue1.isEmpty()) {
			System.out.println("Stack underflow");
		}
		
		int top = 0;
		
		while (queue1.size() != 1) {
			queue2.add(queue1.poll());
		}
		
		top = queue1.poll();
		
		
		while (!queue2.isEmpty()) {
			queue1.add(queue2.poll());
		}
		
		System.out.println("Popped element is : " + top);
	}
	
	public static void peek() {
		if (queue1.isEmpty()) {
			System.out.println("Stack underflow");
		}
		
		int top = 0;
		
		while (!queue1.isEmpty()) {
			if (queue1.size() == 1) {
				top = queue1.peek();
			}
			
			queue2.add(queue1.poll());
		}
		
		while (!queue2.isEmpty()) {
			queue1.add(queue2.poll());
		}
		
		System.out.println("Top element is : " + top);
	}
}

/*
Time --> O(4n)   Space --> O(2n) 
	1. For pushing O(1)
	2. For popping O(n) + O(n)
	3. For peeking O(n) + O(n)
	
*/





/*
Using one Queue and recursive call stack.

1. For pushing we simply put data

2. For popping :
	-> reverse queue
	-> poll element
	-> reverse queue to get original 

3. For peeking : 
	-> reverse queue
	-> peek element
	-> reverse queue to get original
*/
import java.util.*;

public class practice_1 {
	static Queue<Integer> queue = new ArrayDeque<>();
	
	public static void main(String args[]) {
		push(1);
		push(2);
		push(3);
		push(4);
		push(5);
		
		peek();
		
		pop();
		
		peek();
		
		pop();
		
		peek();
	}
	
	public static void push(int data) {
		queue.add(data);
	}
	
	public static void pop() {
		if (queue.isEmpty()) {
			System.out.println("Stack underflow");
		}
		
		reverseQueue();
		
		int top = queue.poll();
		
		reverseQueue();
		
		System.out.println("Popped element is : " + top);
	}
	
	public static void peek() {
		if (queue.isEmpty()) {
			System.out.println("Stack underflow");
		}
		
		reverseQueue();
		
		int top = queue.peek();
		
		reverseQueue();
		
		System.out.println("Top element is : " + top);
	}
	
	public static void reverseQueue() {
		if (queue.isEmpty()) {
			return;
		}
		
		int value = queue.poll();
		
		reverseQueue();
		
		queue.add(value);
	}
}

/*
Time --> O(4n)    Space --> O(n) for queue and O(n) for recursive call stack
	-> for pushing : O(1)
	-> for popping : O(n) + O(n)
	-> for peeking : O(n) + O(n)
*/












