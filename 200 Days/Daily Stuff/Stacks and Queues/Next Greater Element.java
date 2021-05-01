/*
Using two loops :
1. If we find element greater than current element then flag will be true and break the inner loop.
2. Else if flag is false then we cannot find element greater than current element so -1
*/

import java.util.*;

public class practice_1 {
	public static void main(String args[]) {
		int array[] = { 5, 3, 2, 10, 6, 8, 1, 4, 12, 7, 4 };

		nextGreater(array);
	}

	public static void nextGreater(int array[]) {
		for (int index1 = 0; index1 < array.length; index1++) {
			boolean flag = false;
			for (int index2 = index1 + 1; index2 < array.length; index2++) {
				if (array[index1] < array[index2]) {
					flag = true;
					System.out.println("Next greater of " + array[index1] + " is " + 
					array[index2]);
					break;
				}
			}
			
			if (!flag) {
				System.out.println("Next greater of " + array[index1] + " is " + 
						-1);
			}
		}
	}
}
// Time --> O(n ^ 2)



/*
Using Stack:
1. If stack is empty of current element is less than or equals to top of stack then simply push current element in stack
2. Else if current element is greater than top of stack then:
	-> pop untill stack is not empty and current element is greater than top of stack
	-> atlast outside while loop push current element
3. All remaining elements in stack signifies that we can't find greater element so all answers will be -1. Just remove all elements
from stack.
*/
import java.util.*;

public class practice_1 {
	public static void main(String args[]) {
		int array[] = { 5, 3, 2, 10, 6, 8, 1, 4, 12, 7, 4 };

		nextGreater(array);
	}

	public static void nextGreater(int array[]) {
		Stack<Integer> stack = new Stack<>();
		
		for (int currentElement : array) {
			if (stack.isEmpty() || currentElement <= stack.peek()) {
				stack.push(currentElement);
			}
			else {
				while (!stack.isEmpty() && stack.peek() < currentElement) {
					System.out.println("Next greater of " + stack.peek() + 
							" is " + currentElement);
					stack.pop();
				}
				stack.push(currentElement);
			}
		}
		
		while (!stack.isEmpty()) {
			System.out.println("Next greater of " + stack.peek() + 
					" is " + -1);
			stack.pop();
		}
	}
}
// Time ---> O(n)  Space --> O(n)
// This will not give solution in order




/*
Using Stack: Gives output in order

Loop array from end:
	1. If stack is not empty :
		-> pop elements till stack is not empty and top element is less than current element
	2. If stack is empty then next greater is -1, Else next greater of current element is top of stack
*/
import java.util.*;

public class practice_1 {
	public static void main(String args[]) {
		int array[] = { 5, 3, 2, 10, 6, 8, 1, 4, 12, 7, 4 };

		nextGreater(array);
	}

	public static void nextGreater(int array[]) {
		Stack<Integer> stack = new Stack<>();
		int nextGreaters[] = new int[array.length];
		
		for (int index = array.length - 1; index >= 0; index--) {
			
			if (!stack.isEmpty()) {
				while (!stack.isEmpty() && stack.peek() <= array[index]) {
					stack.pop();
				}
			}
			
			nextGreaters[index] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(array[index]);
		}
		
		for (int index = 0; index < array.length; index++) {
			System.out.println("Next greater of " + array[index] + " is " + 
		nextGreaters[index]);
			
		}
	}
}
// Time --> O(n)   Space --> O(n)
