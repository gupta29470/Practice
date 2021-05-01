/*
1. countInvalidParentheses function : First we will find number of brackets that leads to string invalid.
2. removeInvalidParentheses : Then we will remove that amount of brackets one by one using recursion calls and check if by 
removing that amount of brackets makes string valid. If yes and it is unique then print and store in set. Else if it is 
invalid or not unique than skip.
*/


import java.util.*;
import java.sql.*;//1

public class practice_1 {
	public static void main(String args[]) {
		
		String input = "(v)())()";
		
		Set<String> answers = new HashSet<>();
		
		int numberOfInvalidParantheses = countInvalidParentheses(input);

		removeInvalidParentheses(input, numberOfInvalidParantheses, answers);
		
	}
	
	public static void removeInvalidParentheses(String input, int
			numberOfInvalidParantheses, Set<String> answers) {
		
		// we remove that much amount of invalid parentheses
		if (numberOfInvalidParantheses == 0) {
			// check if current string is valid
			int isValidString = countInvalidParentheses(input);
			if (isValidString == 0) {
				if (!answers.contains(input)) {
					System.out.print(input + " ");
					answers.add(input);
					
				}
			}
			return;
		}
		
		for (int index = 0; index < input.length(); index++) {
			String left = input.substring(0, index);
			String right = input.substring(index + 1);
			
			removeInvalidParentheses(left + right, numberOfInvalidParantheses - 1,
					answers);
		}
	}
	
	// this function checks if string is valid or not;
	// if not valid then gives count by how many invalid parentheses
	// string becomes invalid
	public static int countInvalidParentheses(String input) {
		Stack<Character> stack = new Stack<>();

		for (int index = 0; index < input.length(); index++) {
			int currentChar = input.charAt(index);

			if (currentChar == '(') {
				stack.push('(');
			} else if (currentChar == ')') {
				if (stack.isEmpty()) {
					stack.push(')');
				} else if (stack.peek() == ')') {
					stack.push(')');
				} else if (stack.peek() == '('){
					stack.pop();
				}
			}
			// any other alphabets
			else {
				continue;
			}
		}
		return stack.size();
	}
}
/*
Time Complexity : O(2^N) since in the worst case we will have only left parentheses"(" in the expression and for every bracket we 
will have two options i.e. whether to remove it or consider it. 
Considering that the expression has NN parentheses, the time complexity will be O(2^N)

Space Complexity : O(n)  Stack
*/