import java.util.*;

public class practice_1 {

	public static void main(String args[]) {
		String input = "Aakash";
		
		reverse(input);
	}
	
	public static void reverse(String input) {
		Stack<Character> stack = new Stack<>();
		
		for (char currentChar : input.toCharArray()) {
			stack.push(currentChar);
		}
		
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		System.out.println();
	}
}
