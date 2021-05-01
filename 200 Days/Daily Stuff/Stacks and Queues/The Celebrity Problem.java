/*
Using two loops:
1. First using two loops find that row index whose all rows are fill with zero. If find mark unknown as true
2. Then using single loop check if its all columns are fill with one. If it is then mark known as true
3. If both known and unknown are true then return that row index. Else return -1
*/

import java.util.*;

public class practice_1 {
	public static void main(String args[]) {
		int array[][] = { {0, 0, 1, 0},
		           {0, 0, 1, 0},
		           {0, 0, 0, 0},
		           {0, 0, 1, 0} };
		
		System.out.println(celebrity(array));
	}
	
	public static int celebrity(int array[][]) {
		boolean unknown = true, known = true;
		int celebrityRowIndex = -1;
		
		// traversing whole array and find celebrity w.r.t row index
		// checking each column of all rows
		for (int row = 0; row < array.length; row++) {
			unknown = true; known = true;
			celebrityRowIndex = row;
			for (int col = 0; col < array[0].length; col++) {
				if (array[row][col] == 1) {
					// if it is not celebrity don't need to check further
					unknown = false;
					break;
				}
			}
			// if found celebrity
			if (unknown) {
				break;
			}
		}
		
		// if has celebrity
		if (unknown) {
			// checking all rows 
			for (int row = 0; row < array.length; row++) {
				// if it is unknown by some one 
				if (array[row][celebrityRowIndex] == 0) {
					known = false;
				}
				
				// if every one knows him
				if(known) {
					break;
				}
			}
		}
		
		// if he knows nobody(unknown) and every one knows him(known)
		if (known && unknown) {
			return celebrityRowIndex;
		}
		
		// if no celebrity is found
		else {
			return -1;
		}
	}
}
// Time --> O(n ^ 2 + n)



				/********************************* EFFICIENT APPROACH ***********************************/

/*
In this solution we are reducing time.
Using stack.

1. First push all index values i.e 0 to n - 1 in stack

2. while loop till stack is not empty and stack size is greater than or equals to 2
	-> pop two elements at a time from stack
	-> If  array[top1][top2] == 1 push top2 Else array[top2][top1] == 1 push top1
	
3. After this step we will have only pseudo celebrity. To check if it is real celebrity check all its row fill with 0's 
and all it's columns fill with 1 and skip diagonal. This checking requires two different for loops. 
*/
import java.util.*;

public class practice_1 {
	public static void main(String args[]) {
		int array[][] = { {0, 0, 1, 0},
		           {0, 0, 1, 0},
		           {0, 0, 0, 0},
		           {0, 0, 1, 0} };
		
		System.out.println(celebrity(array));
	}
	
	public static int celebrity(int array[][]) {
		Stack<Integer> stack = new Stack<>();
		boolean flag = true;
		
		for (int index = 0; index < array.length; index++) {
			stack.push(index);
		}
		
		// checking who is celebrity and who is not
		while (!stack.isEmpty() && stack.size() >= 2) {
			
			// popping two candidates at a time
			int top1 = stack.pop();
			int top2 = stack.pop();
			
			// if any one is pseudo celebrity then again push in stack
			if (array[top1][top2] == 1) {
				stack.push(top2);
			}
			else if (array[top2][top1] == 1) {
				stack.push(top1);
			}
		}
		
		// At last one candidate will be there in stack
		// but it is pseudo celebrity
		int potentialCelebrity = stack.pop();
		
		// checking if all rows are 0
		for (int col = 0; col < array.length; col++) {
			if (array[potentialCelebrity][col] == 1) {
				flag = false;
				break;
			}
		}
		
		// checking if all columns are 1
		for (int row = 0; row < array.length; row++) {
			// skipping diagonal because it is always zero
			if (row != potentialCelebrity) {
				if (array[row][potentialCelebrity] == 0) {
					flag = false;
					break;
				}
			}
		}
		
		// If all rows are 0 and all columns are 1 of pseudo
		// celebrity then he is the one
		return (flag == false) ? -1 : potentialCelebrity;
	}
}
// Time --> O(4n)   Space --> O(n)


