/*
Recursive Algorithm :

The pop element from the queue if the queue has elements otherwise return empty queue.
Call reverseQueue function for the remaining queue.
Push the popped element in the resultant reversed queue.
*/


import java.util.*;

public class practice_1 {
	
	public static void main(String args[]) {
		int array[] = {5, 24, 9, 6, 8, 4, 1, 8, 3, 6};
		Queue<Integer> queue = new ArrayDeque<>();
		
		for (int data : array) {
			queue.add(data);
		}
		
		System.out.println("Before reverse :  " + queue);
		
		reverseQueue(queue);
		
		System.out.println("After reverse :  " + queue);
	}
	
	public static void reverseQueue(Queue<Integer> queue) {
		if (queue.isEmpty()) {
			return;
		}
		
		int value = queue.poll();
		
		reverseQueue(queue);
		
		queue.add(value);
	}
}
// Time Complexity : O(n).











