/*
If the current character in the expression is an opening brace then push it into the stack.

If the current character in the expression is a closing brace , pop a character from the stack, and return false if the popped 
character is not the same as the current character, or it does not pair with the current character of the expression. 
Also, if the stack is empty, the total number of opening braces is less than the closing brace number at that point, 
so the expression cannot be balanced.
*/

import java.util.*;

public class practice_1{
	
	public static void main(String args[]) {
		String input = "[()]{}{[()()]()}";
		
		System.out.println(isBalanced(input));
	}
	
	public static boolean isBalanced(String input) {
		Stack<Character> stack = new Stack<>();
		
 		for (int index = 0; index < input.length(); index++) {
			char currentChar = input.charAt(index);
			
			// if the current character in the expression is an opening brace,
            // push it into the stack
			if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
				stack.push(currentChar);
			}
			
			// if the current character in the expression is a closing brace
			else if (currentChar == ')' || currentChar == ']' || 
					currentChar == '}') {
				
		// return false if a mismatch is found (i.e., if the stack is empty,
        // the expression cannot be balanced since the total number of opening
        // braces is less than the total number of closing braces)
				if (stack.isEmpty()) {
					return false;
				}
				
				// pop character from the stack
				char top = stack.pop();
				
	// if the popped character is not an opening brace or does not pair
          // with the current character of the expression
				if ((currentChar == ')' && top != '(') || 
						(currentChar == ']' && top != '[') || 
						(currentChar == '}' && top != '{')) {
					return false;
				}
			}
		}
 	// the expression is balanced only when the stack is empty at this point
 		return stack.isEmpty();
	}
}
// Time --> O(n)   Space --> O(n)














