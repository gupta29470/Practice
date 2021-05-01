/*
The idea is to store indexes of previous starting brackets in a stack. The first element of the stack is a special element that 
provides index before the beginning of valid substring (base for next valid string). 

1) Create an empty stack and push -1 to it. 
   The first element of the stack is used 
   to provide a base for the next valid string. 

2) Initialize result as 0.

3) If the character is '(' i.e. str[i] == '('), 
   push index'i' to the stack. 
   
2) Else (if the character is ')')
   a) Pop an item from the stack (Most of the 
      time an opening bracket)
   b) If the stack is not empty, then find the
      length of current valid substring by taking 
      the difference between the current index and
      top of the stack. If current length is more 
      than the result, then update the result.
   c) If the stack is empty, push the current index
      as a base for the next valid substring.

3) Return result.
*/

import java.util.*;

public class practice_1 {
	public static void main(String args[]) {
		String input = "((()()";
		System.out.println(longestValid(input));
		
		input = "()(()))))";
		System.out.println(longestValid(input));
	}
	
	public static int longestValid(String input) {
		int longestValid = Integer.MIN_VALUE;
		
		// as we need length so are pushing index 
		Stack<Integer> indexStack = new Stack<>();
		indexStack.push(-1); // it is useful if full string is valid
		
		for (int index = 0; index < input.length(); index++) {
			char currentChar = input.charAt(index);
			
			// if opening found
			if (currentChar == '(') {
				indexStack.push(index); // pushing opening bracket index
			}
			
			// if closing found
			else {
				if (!indexStack.isEmpty()) {
					indexStack.pop(); // pop respective opening index
				}
				
				if (!indexStack.isEmpty()) {
					// calculate max length
					longestValid = Math.max(longestValid, (index - indexStack.peek()));
				}
				else {
					// else push closing index 
					indexStack.push(index);
				}
			}
		}
		return longestValid;
	}
}
// Time --> O(n)    Space --> O(n)



			/**************************************** EFFICIENT APPROACH ************************************/
/*
String is valid if number of open parantheses is equal to number of close parantheses in right full way.

1. The idea to solve this problem is to traverse the string on and keep track of the count of open parentheses and close 
parentheses with the help of two counters open and close respectively.

2. First, the string is traversed from the left towards the right and for every “(” encountered, the open counter is 
incremented by 1 and for every “)” the close counter is incremented by 1.

3. Whenever the open becomes equal to close, the length of the current valid string is calculated and if it greater than the 
current longest substring, then value of required longest substring is updated with current string length.

If the close counter becomes greater than the open counter, then the set of parentheses has become invalid and
hence the open and close counters are set to 0.


4. After the above process, the string is similarly traversed from right to left and similar procedure is applied.
*/

import java.util.*;

public class practice_1 {
	public static void main(String args[]) {
		String input = "((()()";
		System.out.println(longestValid(input));
		
		input = "()(()))))";
		System.out.println(longestValid(input));
	}
	
	public static int longestValid(String input) {
		int longestValid = Integer.MIN_VALUE;
		int open = 0, close = 0;
		
		for (int index = 0; index < input.length(); index++) {
			char currentChar = input.charAt(index);
			
			// If "(" is encountered, then
            // open counter is incremented
            // else close counter is incremented
			if (currentChar == '(') {
				open++;
			}
			else {
				close++;
			}
			
			
			// Whenever open is equal to close,
            // it signifies that the subsequence
            // is valid and
			if (open == close) {
				longestValid = Math.max(longestValid, open + close);
			}
			
			// Reseting the counters when the
            // subsequence becomes invalid
			else if (open < close) {
				open = close = 0;
			}
		}
		
		// Reseting the counters for right to left traversal
		open = close = 0;
		
		for (int index = input.length() - 1; index >= 0; index--) {
			char currentChar = input.charAt(index);
			
			// If "(" is encountered, then
            // open counter is incremented
            // else close counter is incremented
			if (currentChar == '(') {
				open++;
			}
			else {
				close++;
			}
			
			
			// Whenever open is equal to close,
            // it signifies that the subsequence
            // is valid and
			if (open == close) {
				longestValid = Math.max(longestValid, open + close);
			}
			
			if (close < open) {
				close = open = 0;
			}
		}
		
		// Reseting the counters when the
        // subsequence becomes invalid
		return longestValid;
	}
}
// Time --> O(2n)






