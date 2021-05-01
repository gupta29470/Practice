/*
Creating two stack one is used to store all elements and another is used to store minimum element after each insertion.

1. If both stacks are empty then simply push element in both stacks
2. Else If current elementr is less than top of minStack then again push current element in both stacks
3. Else push current element in general stack and push top element of minStack in minStack itself, which signifies that after pushing
current element the min element is still same.
*/

import java.util.*;

public class practice_1 {
	public static void main(String args[]) {
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> minStack = new Stack<>();
		
		push(18, stack,  minStack);
		push(19, stack,  minStack);
		push(29, stack,  minStack);
		push(15, stack,  minStack);
		push(16, stack,  minStack);

		
		getMin(minStack);
		
		pop(stack, minStack);
		pop(stack, minStack);
		
		getMin(minStack);
	}
	
	public static void push(int data, Stack<Integer> stack, 
			Stack<Integer> minStack) {
		
		if (stack.isEmpty() && minStack.isEmpty()) {
			stack.push(data);
			minStack.push(data);
		}
		else if (data < minStack.peek()) {
			stack.push(data);
			minStack.push(data);
			
		}
		else {
			stack.push(data);
			minStack.push(minStack.peek());
			
		}
	}
	
	public static void pop(Stack<Integer> stack, Stack<Integer> minStack) {
		stack.pop();
		minStack.pop();
	}
	
	public static void getMin( Stack<Integer> minStack) {
		System.out.println("Minimum element of stack is : " 
				+ minStack.peek());
	}
}
// Time --> O(1)    Space --> O(n)



/**************************** EFFICIENT APPROACH **************************/

/*
In this we are going to reduce extra O(n) space.

1. We initialize minimum variable to keep track of minimum element in stack.

2. For push operation:
	-> If stack is empty then simply push data and uodate min as data
	-> Else if current element is less than minimum than push (2 * current element - min) and update min as current element
	-> Else simply push data
	
3. For pop operation:
	-> If stack is empty then stack underflow
	-> Else If top element of stack is less than minimum then it is modified element we push and min is depend on that top element.
	So to update min we will be doing (min = 2 * min - top element) and pop element from stack
	-> Else means top element is greater than aur equals to min directly pop
	
4. For get min simply return min variable (2 * current element - min) in push and (min = 2 * min - top element) in pop 
beacuse we are not using extra data structure to keep track of min.



Reason for doing (2 * current element - min)  in push operation and min = 2 * min - top element) in pop operation to keep min
updated when pop is happened

Example : 18, 19, 29, 15, 16

1. Pushing all elements:
	-> pushed 18 : stack is empty so stack[18] and min = 18
	-> pushed 19 : stack[19, 18] and min = 18
	-> pushed 29 : stack[29, 19, 18] and min = 18
	-> pushed 15 : 15 < min(18), so 2 * 15 - 18 = 12. stack[12, 29, 19, 18] and min = 15
	-> pushed 16 : stack[16, 12, 29, 19, 18] and min = 15

2. Popping all elements:
	-> popped 16 : stack[12, 29, 19, 18]
	-> popped 12 : 12 < min, so 2 * min(15) - 12 = 18. After popping 12 we will left with 29, 19, 18 and minimum is 18.
	So stack[29, 19, 18] min = 18
	-> popped 29: stack[19, 18] and minimum = 18
	-> popped 29: stack[18] and minimum = 18
	
*/
import java.util.*;

public class practice_1 {
	static int min = Integer.MAX_VALUE;
	public static void main(String args[]) {
		Stack<Integer> stack = new Stack<>();
		
		push(18, stack);
		push(19, stack);
		push(29, stack);
		push(15, stack);
		push(16, stack);
		
		min();
		
		pop(stack);
		pop(stack);
		
		min();
	}
	
	public static void push(int data, Stack<Integer> stack) {
		if (stack.isEmpty()) {
			stack.push(data);
			min = data;
		}
		else if (data < min) {
			stack.push(2 * data - min);
			min = data;
		}
		else {
			stack.push(data);
		}
	}
	
	public static void pop(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			System.out.println("Stack Underflow");
		}
		else if (stack.peek() < min) {
			min = 2 * min - stack.peek();
			stack.pop();
		}
		else {
			stack.pop();
		}
	}
	
	public static void min() {
		System.out.println("Minimum elememt of stack is : " + 
	min);
	}
}
// Time --> O(1)    Space --> O(1)