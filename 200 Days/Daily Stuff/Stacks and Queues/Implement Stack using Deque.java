import java.util.*;

public class practice_1 {
	static Deque<Integer> deque = new ArrayDeque<>();
	
	public static void main(String args[]) {
		push(1);
		push(2);
		push(3);
		push(4);
		push(5);
		
		peek();
		
		poll();
		
		peek();
		
		poll();
		
		peek();
	}
	
	public static void push(int data) {
		deque.addFirst(data);
	}
	
	public static void poll() {
		int poppedElement = deque.pollFirst();
		
		System.out.println("Popped element is : " + poppedElement);
	}
	
	public static void peek() {
		int topElement = deque.peekFirst();
		
		System.out.println("Top element is : " + topElement);
	}
}

// Time --> O(1)   Space --> O(n)










