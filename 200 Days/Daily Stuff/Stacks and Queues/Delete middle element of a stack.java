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
		
		findMiddle(stack, 0, stack.size());
		
		System.out.println(stack);
	}
	
	public static void findMiddle(Stack<Integer> stack, int middle, int size) {
		if (middle == size) {
			return;
		}
		
		// pop all elemnts
		int value = stack.pop();
		
		// recursive call
		findMiddle(stack, middle + 1, size);
		
		// push all elements except middle
		if (middle != (size / 2)) {
			stack.push(value);
		}
	}
}

// Time --> O(n)   Space --> O(n)













