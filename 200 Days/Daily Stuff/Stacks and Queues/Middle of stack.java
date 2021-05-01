import java.util.*;

public class practice_1 {
	
	public static void main(String args[]) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		
		int middle = 0;
		System.out.println(findMiddle(stack, middle, stack.size()));
	}
	
	public static int findMiddle(Stack<Integer> stack, int middle, int size) {
		if (stack.isEmpty()) {
			return 0;
		}
		
		// popping
		int value = stack.pop();
		
		// recursive calling function
		int result = findMiddle(stack, middle + 1, size);
		
		// pushing back value
		stack.push(value);
		
		// if we are at middle position
		if (middle == (size / 2)) {
			return value;
		}
		
		return result;
	}
}

// Time --> O((stack size + 1) / 2)   Space --> O((stack size + 1) / 2)
/*
Note: yes, recursion is the only way. Not knowing the depth of the stack means you have to store those values somewhere.
*/