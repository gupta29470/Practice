/*
Using stack.
Note : String have duplicate elements will be consider if there are no elements between closing and opening paranthesis.

The idea is to use stack. Iterate through the given expression and for each character in the expression,

1. if the character is a open parenthesis ‘(‘ or any of the operators or operands, push it to the top of the stack. 

2. If the character is close parenthesis ‘)’, then pop characters from the stack till matching open parenthesis ‘(‘ is found and a 
counter(elementsInside) is used, whose value is incremented for every character encountered till the opening parenthesis ‘(‘ 
is found. 

3. If the number of characters encountered between the opening and closing parenthesis pair, is less than 1, then a pair of 
duplicate parenthesis is found else there is no occurrence of redundant parenthesis pairs. 

For example, (((a+b))+c) has duplicate brackets around “a+b”. When the second “)” after a+b is encountered, the stack contains “((“.
Since the top of stack is a opening bracket, it can be concluded that there are duplicate brackets.
*/

import java.util.*;

public class practice_1 {
	public static void main(String args[]) {
		String input = "((a+b)+(c+d))";
		
		boolean result = duplicateExpression(input);
		
		if (result) {
			System.out.println("String contains duplicate parenthesis");
		}
		else {
			System.out.println("String does not contains duplicate parenthesis");
		}
	}
	
	public static boolean duplicateExpression(String input) {
		
		Stack<Character> stack = new Stack<>();
		
		for (int index = 0; index < input.length(); index++) {
			char currentChar = input.charAt(index);
			
			// if current character is close parenthesis ')' 
			if (currentChar == ')') {
				int elementsInside = 0;
				
				while (stack.peek() != '(') {
					elementsInside++;
					stack.pop();
				}
				// popping corressing opening paranthesis
				stack.pop();
		
				if (elementsInside < 1) {
					// //duplicates found
					return true;
				}
			}
			// push open parenthesis '(', operators and 
            // operands to stack 
			else {
				stack.push(currentChar);
			}
		}
		// No duplicates found 
		return false;
	}
}

// Time --> O(n)   Space --> O(n)












