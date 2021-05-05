/*
The idea is similar to the queue post, here we need to use three extra arrays. In queue post, we needed two extra arrays, 
one more array is required because in queues, enqueue() and dequeue() operations are done at different ends.
Following are the three extra arrays are used: 

1) front[]: This is of size k and stores indexes of front elements in all queues. 

2) rear[]: This is of size k and stores indexes of rear elements in all queues. 

2) next[]: This is of size n and stores indexes of next item for all items in array arr[]. 

Here arr[] is the actual array that stores k queues.
Together with k queues, a queue of free slots in arr[] is also maintained. The top of this queue is stored in a variable ‘free’.
All entries in front[] are initialized as -1 to indicate that all queues are empty. All entries next[i] are initialized as i+1 
because all slots are free initially and pointing to the next slot. Top of the free queue, ‘free’ is initialized as 0.
*/


import java.util.*;

public class practice_1 {
	
	static int n;
	static int size;
	static int array[];
	static int frontIndex[];
	static int rearIndex[];
	static int nextElementIndex[];
	static int freeIndex;
	
	public static void main(String args[]) {
		int n = 3;
		int size = 10;
		frontIndex = new int[n];
		rearIndex = new int[n];
		array = new int[size];
		nextElementIndex = new int[size];
		
		for (int index = 0; index < n; index++) {
			frontIndex[index] = rearIndex[index] = -1;
		}
		
		for (int index = 0; index < size - 1; index++) {
			nextElementIndex[index] = index + 1;
		}
		
		nextElementIndex[size - 1] = -1;
		
		enQueue(15, 2);
		enQueue(45, 2);
		enQueue(17, 1);
		enQueue(49, 1);
		enQueue(39, 1);
		enQueue(11, 0);
		enQueue(9, 0);
		enQueue(7, 0);
		
		deQueue(2);
		deQueue(1);
		deQueue(0);
		
	}
	
	 // To enqueue an item in queue number 'queueNumber' where queueNumber is from 0 to n-1
	
	public static void enQueue(int data, int queueNumber) {
		if (isQueueFull()) {
			System.out.println("Queue is full");
			return;
		}
		
		int index = freeIndex;
		
		freeIndex = nextElementIndex[index];
		
		if (isQueueEmpty(queueNumber)) {
			frontIndex[queueNumber] = rearIndex[queueNumber] = index;
		}
		else {
			
			// Update next of rear and then rear for queue number 'queueNumber'
			nextElementIndex[rearIndex[queueNumber]] = index;
			rearIndex[queueNumber] = index;
		}
		
		nextElementIndex[index] = -1;
		
		// Put the item in array
		array[index] = data;
		
		System.out.println("Enqueued " + data + " in " + queueNumber);
	}
	
	public static void deQueue(int queueNumber) {
		
		// Underflow checkSAS
		if (isQueueEmpty(queueNumber)) {
			System.out.println("Queue is empty");
			return;
		}
		
		 // Find index of front item in queue number 'queueNumber'
		int index = frontIndex[queueNumber];
		
		 // Change top to store next of previous top
		frontIndex[queueNumber] = nextElementIndex[index];
		
		// Attach the previous front to the beginning of free list
		nextElementIndex[index] = freeIndex;
		
		freeIndex = index;
		
		System.out.println("Dequeued " + array[index] + " from " + queueNumber);
	}
	
	
	// To dequeue an from queue number 'i' where i is from 0 to k-1
	public static boolean isQueueFull() {
		return (freeIndex == -1);
	}
	
	 // To check whether queue number 'i' is empty or not
	public static boolean isQueueEmpty(int queueNumber) {
		return (frontIndex[queueNumber] == -1);
	}
}

/*
Time complexities of enqueue() and dequeue() is O(1).
The best part of the above implementation is, if there is a slot available in the queue, then an item can be enqueued in any of 
the queues, i.e., no wastage of space. This method requires some extra space. Space may not be an issue because queue items are 
typically large, for example, queues of employees, students, etc where every item is of hundreds of bytes. For such large queues, 
the extra space used is comparatively very less as we use three integer arrays as extra space.
*/










