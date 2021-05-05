/*
The idea is to use an auxiliary stack. 

Create an empty stack.
One by one dequeue first K items from given queue and push the dequeued items to stack.
Enqueue the contents of stack at the back of the queue
Dequeue (size-k) elements from the front and enque them one by one to the same queue. 
*/

import java.util.*;

public class practice_1 {

	public static void main(String args[]) {
		int array[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		Queue<Integer> queue = new ArrayDeque<>();
		int k = 5;

		for (int data : array) {
			queue.add(data);
		}

		System.out.println("Before reverse :  " + queue);

		reverseKItems(queue, k);

		System.out.println("After reverse :  " + queue);
	}

	public static void reverseKItems(Queue<Integer> queue, int k) {

		if (queue.isEmpty() == true || k > queue.size()) {
			return;
		}
			
		if (k <= 0) {
			return;
		}

		Stack<Integer> stack = new Stack<>();

		// Push the first K elements into a Stack
		for (int index = 0; index < k; index++) {
			stack.push(queue.poll());
		}

		// Enqueue the contents of stack
        // at the back of the queue
		while (!stack.isEmpty()) {
			queue.add(stack.pop());

		}
		
		// Remove the remaining elements and enqueue
        // them at the end of the Queue
		for (int index = 0; index < queue.size() - k; index++) {
			int value = queue.poll();
			queue.add(value);
		}
	}
}
/*
Complexity Analysis: 

Time Complexity: O(n+k). 
Where ‘n’ is the total number of elements in the queue and ‘k’ is the number of elements to be reversed. 
This is because firstly the whole queue is emptied into the stack and after that first ‘k’ elements are emptied and 
enqueued in the same way.
Auxiliary Space :Use of stack to store values for the purpose of reversing-: O(n)
*/












