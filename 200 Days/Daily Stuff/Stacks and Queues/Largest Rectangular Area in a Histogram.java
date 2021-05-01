/*
Using two loops
1. Outer loop will traverse whole array
2. Inner loop 1 : will be traverse from current index - 1 to 0 || Inner loop 2: will traverse from current index + 1 to n

length will be current histogram length, while inner loop if we have greater or equal length histogram length we will consider it
else we will break it.
*/

import java.util.*;

public class practice_1 {
	public static void main(String args[]) {
		int histograms[] = {6, 2, 5, 4, 5, 1, 6};
		
		System.out.println(largestRectangle(histograms));
	}
	
	public static int largestRectangle(int histograms[]) {
		int maxArea = Integer.MIN_VALUE;
		
		for (int index1 = 0; index1 < histograms.length; index1++) {
			int currentArea = 0, length = histograms[index1], breadth = 1;
			
			
			for (int index2 = index1 - 1; index2 >= 0; index2--) {
				if (histograms[index1] <= histograms[index2]) {
					breadth++;
				}
				else {
					break;
				}
			}
			
			for (int index2 = index1 + 1; index2 < histograms.length; index2++) {
				if (histograms[index1] <= histograms[index2]) {
					breadth++;
				}
				else {
					break;
				}
			}
			
			currentArea = length * breadth;
			
			if (maxArea < currentArea) {
				maxArea = currentArea;
			}
		}
		return maxArea;
	}
}

// Time --> O(n ^ 2)



/*
Using stack:
We are using stack because we have to put and remove index in sequential manner.

create two arrays leftLimit and rightLimit to store left limit and right limit to each histogram

1. Traverse Loop 0 to n - 1 and fill leftLimit:
	-> If stack is empty simply put the most left limit or starting index(0)
	
	-> else 
		-> if previous index histogam length is greater or equals to current histogram's length pop index from stack, because to
		find limit of current histogram either we find first length less than current histogram length or we reach 0 index, 
		means stack empty. left limit will be top of stack + 1, we have to limit before lower length.
		
	-> every time push current index
	
2. Traverse Loop n - 1 to 0 and fill rightLimit:
	-> If stack is empty simply put the most right limit or end index(n - 1)
	
	-> else 
		-> if next index histogam length is greater or equals to current histogram's length pop index from stack, because to
		find limit of current histogram either we find first length less than current histogram length or we reach last index, 
		means stack empty. right limit will be top of stack - 1, we have to limit before lower length.
		
	-> every time push current index

3. Traverse loop 0 to n - 1 and calculate area
	-> area of each histogram will be calculated by : length of current histogram * how much indexes they cover
	area = histogram[index] * (rightLimit[index] - leftLimit[index] + 1) + 1 because to consider current histogram 
	
	update maxArea, if area > maxArea
*/

import java.util.*;

public class practice_1 {
	public static void main(String args[]) {
		int histograms[] = { 9, 10, 4, 10, 4, 5, 6 };

		System.out.println(largestRectangle(histograms));
	}

	public static int largestRectangle(int histograms[]) {
		int maxArea = Integer.MIN_VALUE;
		int pseudoArea = 0;

		Stack<Integer> stack = new Stack<>();

		int leftLimit[] = new int[histograms.length];
		int rightLimit[] = new int[histograms.length];

		for (int index = 0; index < histograms.length; index++) {
			
			if (stack.isEmpty()) {
				leftLimit[index] = 0;
			} 
			else {
				while (!stack.isEmpty() && histograms[stack.peek()] >= histograms[index]) {
					stack.pop();
				}
				
				leftLimit[index] = stack.isEmpty() ? 0 : stack.peek() + 1;
			}
			stack.push(index);
		}

		stack.clear();

		for (int index = histograms.length - 1; index >= 0; index--) {
			
			if (stack.isEmpty()) {
				rightLimit[index] = histograms.length - 1;
			} 
			
			else {
				while (!stack.isEmpty() && histograms[stack.peek()] >= histograms[index]) {
					stack.pop();
				}
				
				rightLimit[index] = stack.isEmpty() ? histograms.length - 1 : stack.peek() - 1;
			}

			stack.push(index);
		}

		for (int index = 0; index < histograms.length; index++) {
			pseudoArea = histograms[index] * (rightLimit[index] - leftLimit[index] + 1);

			if (maxArea < pseudoArea) {
				maxArea = pseudoArea;
			}
		}

		return maxArea;
	}
}
// Time --> O(3n)   Space --> O(3n)

























