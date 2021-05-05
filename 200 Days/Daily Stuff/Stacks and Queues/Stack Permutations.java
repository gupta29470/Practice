/*
1. Continuously pop elements from the input queue and check if it is equal to the top of output queue or not, 
if it is not equal to the top of output queue then we will push the element to stack.

2. Once we find an element in input queue such the top of input queue is equal to top of output queue,
we will pop a single element from both input and output queues, and compare the top of stack and top of output queue now. 
If top of both stack and output queue are equal then pop element from both stack and output queue. If not equal, go to step 1.

3. Repeat above two steps until the input queue becomes empty. At the end if both of the input queue and stack are empty then 
the input queue is permutable otherwise not.
*/

import java.util.*;

public class practice_1 {
	
	public static void main(String args[]) {
		int inputArray[] = {1, 2, 3};
		int outputArray[] = {2, 1, 3};
		
		System.out.println(checkStackPermutation(inputArray, outputArray));
	}
	
	public static boolean checkStackPermutation(int inputArray[], int outputArray[]) {
		
		Queue<Integer> inputQueue = new LinkedList<>();
		Queue<Integer> outputQueue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		
		for (int data : inputArray) {
			inputQueue.add(data);
		}
		
		for (int data : outputArray) {
			outputQueue.add(data);
		}
		
		System.out.println(inputQueue);
		System.out.println(outputQueue);
		
		while (!inputQueue.isEmpty()) {
			int currentElement = inputQueue.poll();
			
			if (currentElement == outputQueue.peek()) {
				outputQueue.poll();
				
				while (!stack.isEmpty()) {
					if (stack.peek() == outputQueue.peek()) {
						stack.pop();
						outputQueue.poll();
					}
					else {
						break;
					}
				}
			}
			else {
				stack.push(currentElement);
			}
		}
		return (inputQueue.isEmpty()) && (stack.isEmpty());
	}
}
// Time --> O(3n)   Space --> O(3n)











