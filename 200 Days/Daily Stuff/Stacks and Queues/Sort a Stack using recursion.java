/*
This problem is mainly a variant of Reverse stack using recursion.
The idea of the solution is to hold all values in Function Call Stack until the stack becomes empty. 
When the stack becomes empty, insert all held items one by one in sorted order. Here sorted order is important.

While inserting check if top element is less than or greater than value:
	1. If top element is greater than value then pop untill we find the value less than or equals to value and push value
	and above value push all elements we have popped
	2. If top element is less than value simply push on top
*/

import java.util.*;

public class practice_1 {
	public static void main(String args[]) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(5);
		stack.push(-2);
		stack.push(9);
		stack.push(-7);
		stack.push(3);
		
		System.out.println(stack.peek());
		
		System.out.println(stack);
		
		sort(stack);
		
		System.out.println(stack);
	}
	
	public static void sort(Stack<Integer> stack) {
		
		if (stack.isEmpty()) {
			return;
		}
		
		// popping all elements from stack
		int value = stack.pop();
		
		// calling function recursively
		sort(stack);
		
		// pushing element at bottom in sorted order
		insertAtBottom(stack, value);
	}

	public static void insertAtBottom(Stack<Integer> stack, int value) {
		
		// if stack is empty so at bottom we will add value
		if (stack.isEmpty()) {
			stack.push(value);
			return;
		}
		
		int greater = Integer.MAX_VALUE;
		
		// if value is less than top than only pop 
		if (value < stack.peek()) {
			greater = stack.pop();
			insertAtBottom(stack, value);
		}
		
		// if value is greater than simply push
		else {
			stack.push(value);
		}
		
		// if we pop elements then greater will not be max value so we have to push all pop elements above value
		// if we did not pop elements than greater will be max value
		if (greater != Integer.MAX_VALUE) {
			stack.push(greater);
		}
	}
}

// Time --> O(n ^ 2)











