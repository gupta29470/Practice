/*
We iterate through the given expression and for each character in the expression, if the character is a open parenthesis
‘(‘ or any of the operators or operands, we push it to the stack. If the character is close parenthesis ‘)’, 
then pop characters from the stack till matching open parenthesis ‘(‘ is found. 

Now for redundancy two condition will arise while popping- 
 
1. If immediate pop hits a open parenthesis ‘(‘, then we have found a duplicate parenthesis. For example, (((a+b))+c) has 
duplicate brackets around a+b. When we reach second “)” after a+b, we have “((” in the stack. Since the top of stack is a 
opening bracket, we conclude that there are duplicate brackets. 
 
2. If immediate pop doesn’t hit any operand(‘*’, ‘+’, ‘/’, ‘-‘) then it indicates the presence of unwanted brackets surrounded 
by expression. For instance, (a)+b contain unwanted () around a thus it is redundant. 
*/


import java.util.*;

public class practice_1 {
	public static void main(String args[]) {
		String input = "(a+b*(c-d))";
		
		boolean result = redundantParanthesis(input);
		
		if (result) {
			System.out.println("String have redundant paranthesis");
		}
		else {
			System.out.println("String does not have redundant paranthesis");
		}
	}
	
	public static boolean redundantParanthesis(String input) {
		
		Stack<Character> stack = new Stack<>();
		
		for (int index = 0; index < input.length(); index++) {
			char currentChar = input.charAt(index);
			
			// if current character is close parenthesis ')'
			if (currentChar == ')') {
				
				 // If immediate pop have open parenthesis '('
                // duplicate brackets found
				boolean flag = true;
				
				while (stack.peek() != '(') {
					
					// Check for operators in expression
					if (stack.peek() == '+' || stack.peek() == '-' || stack.peek() == '*'
							|| stack.peek() == '/') {
						flag = false;
					}
					stack.pop();
				}
				
				// popping corresponding opening paranthesis for current closing paranthesis
				stack.pop();
				
				// If operators not found
				if (flag) {
					return true;
				}
			}
			
			// push open parenthesis '(',
            // operators and operands to stack
			else {
				stack.push(currentChar);
			}
		}
		return false;
	}
}
// Time --> O(n)  Space --> O(n)
