/*
The idea of the solution is to hold all values in Function Call Stack until the stack becomes empty. When the stack becomes empty, 
insert all held items one by one at the bottom of the stack. 
For example, let the input stack be  

    1  <-- top
    2
    3
    4    
First 4 is inserted at the bottom.
    4 <-- top

Then 3 is inserted at the bottom
    4 <-- top    
    3

Then 2 is inserted at the bottom
    4 <-- top    
    3 
    2
     
Then 1 is inserted at the bottom
    4 <-- top    
    3 
    2
    1
So we need a function that inserts at the bottom of a stack using the above given basic stack function.
void insertAtBottom((): First pops all stack items and stores the popped item in function call stack using recursion. 
And when stack becomes empty, pushes new item and all items stored in call stack.
*/

import java.util.*;

public class practice_1 {
	public static void main(String args[]) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		System.out.println(stack);
		
		reverse(stack);
		
		System.out.println(stack);
	}
	
	public static void reverse(Stack<Integer> stack) {
		// base case
		if (stack.isEmpty()) {
			return;
		}
		
		// popping value from stack
		int value = stack.pop();
		
		// calling function recursively
		reverse(stack);
		
		// pushing element at bottom
		insertAtBottom(stack, value);
	}

	public static void insertAtBottom(Stack<Integer> stack, int value) {
		// if stack is empty so at bottom we will add value
		if (stack.isEmpty()) {
			stack.push(value);
			return;
		}
		
		// popping all elements
		int toppers = stack.pop();
		
		// calling function recursively
		insertAtBottom(stack, value);
		
		// pushing
		stack.push(toppers);
	}
}

//Time Complexity: This approach takes the worst time complexity of O(n^2), 
