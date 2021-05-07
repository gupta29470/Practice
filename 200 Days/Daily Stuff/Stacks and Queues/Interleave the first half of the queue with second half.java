/*
Given a queue of integers of even length, rearrange the elements by interleaving the first half of the queue with the 
second half of the queue.

Only a stack can be used as an auxiliary space.

Examples:

Input :  1 2 3 4
Output : 1 3 2 4

Input : 11 12 13 14 15 16 17 18 19 20
Output : 11 16 12 17 13 18 14 19 15 20

*/


/*
The approach is deque half queue and put in another queue. At one time enque one element
half queue and deque one element from original queue and enque again.

Handles odd size cases.

 
To handle both odd and even size queue we are initializing halfSize = original queue size + 1 / 2.
Eg if queue size is 10: 10 + 1 / 2 = 5 
if queue size is 9: 9 + 1 / 2 = 5

halfQueue will get one extra element in odd size.

1. Put halfSize elements in halfQueue and remove from original queue
2. while halfQueue is not empty:
	-> If queue size is odd then last element in original queue is from halfQueue
	-> If queue size is even then last element in original queue is from original queue
	
	-> first enqueue halfQueue element and then poll from original queue and put back in original queue
*/

import java.util.*;

public class practice_1 {

	public static void main(String args[]) {
		int array[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		Queue<Integer> queue = new ArrayDeque<>();

		for (int data : array) {
			queue.add(data);
		}
		
		interleave(queue);
		
		System.out.println(queue);
	}

	public static void interleave(Queue<Integer> queue) {
		int size = queue.size();
		int halfSize = (size + 1) / 2;

		Queue<Integer> halfQueue = new ArrayDeque<>(halfSize);

		for (int index = 0; index < halfSize; index++) {
			int value = queue.poll();
			halfQueue.add(value);
		}

		while (!halfQueue.isEmpty()) {
			int value1 = -1;
			int value2 = -1;
			
			if (halfQueue.size() == 1) {
				
				// If queue size is odd then last element in original queue is from halfQueue
				if (size % 2 != 0) {
					value1 = halfQueue.poll();
					queue.add(value1);
				} 
				// If queue size is even then last element in original queue is from original queue
				// first enqueue halfQueue element and then poll from original queue and put back in original queue
				else {
					value1 = halfQueue.poll();
					value2 = queue.poll();

					queue.add(value1);
					queue.add(value2);
				}
			} 
			
			// first enqueue halfQueue element and then poll from original queue and put back in original queue
			else {

				value1 = halfQueue.poll();
				value2 = queue.poll();

				queue.add(value1);
				queue.add(value2);

			}
		}
	}
}
// Time --> O(n + halfSize)   Space --> O(halfSize)
