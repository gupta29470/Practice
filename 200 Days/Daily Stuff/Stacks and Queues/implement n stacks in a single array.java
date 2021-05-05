
/*
The idea is to use two extra arrays for efficient implementation of k stacks in an array. 
This may not make much sense for integer stacks, but stack items can be large for example stacks of employees, 
students, etc where every item is of hundreds of bytes. For such large stacks, the extra space used is comparatively very 
less as we use two integer arrays as extra space.

Following are the two extra arrays are used:
1) top[]: This is of size k and stores indexes of top elements in all stacks.
2) next[]: This is of size n and stores indexes of next item for the items in array arr[]. Here arr[] is actual array that 
stores k stacks.
Together with k stacks, a stack of free slots in arr[] is also maintained. The top of this stack is stored in a variable ‘free’.

All entries in top[] are initialized as -1 to indicate that all stacks are empty. All entries next[i] are initialized as i+1 
because all slots are free initially and pointing to next slot. Top of free stack, ‘free’ is initialized as 0.
*/

import java.util.*;

public class practice_1 {
	
	static int n;
	static int size;
	static int array[];
	static int topIndex[];
	static int nextElementIndex[];
	static int freeIndex;
	
	public static void main(String args[]) {
		n = 3;
		size = 6;
		array = new int[size];
		topIndex = new int[n];
		nextElementIndex = new int[size];
		freeIndex = 0;
		
		for (int index = 0; index < n; index++) {
			topIndex[index] = -1;
		}
		
		for (int index = 0; index < size - 1; index++) {
			nextElementIndex[index] = index + 1;
		}
		nextElementIndex[size - 1] = -1;
		
		push(1, 1);
		push(2, 1);
		
		push(3, 0);
		push(4, 0);
		
		push(5, 2);
		push(6, 2);
		
		pop(1);
		pop(0);
		pop(2);
	}
	
	public static void push(int data, int stackNumber) {
		// Overflow check
		if (isStackFull()) {
			System.out.println("Stack overflow");
		}
		
		// Store index of first free slot
		int index = freeIndex;
		
		 // Update index of free slot to index of next slot in free list
		freeIndex = nextElementIndex[index];
		
		// Update next of top and then top for stack number 'stackNumber'
		nextElementIndex[index] = topIndex[stackNumber];
		
		topIndex[stackNumber] = index;
		
		// Put the item in array
		array[index] = data;
		
		System.out.println("Pushed element in " + stackNumber +  " is " + array[index]);
	}
	
	public static void pop(int stackNumber) {
		// Underflow check
		if (topIndex[stackNumber] == -1) {
			System.out.println("Stack underflow");
		}
		
		// Find index of top item in stack number 'sn'
		int index = topIndex[stackNumber];
		
		// Change top to store next of previous top
		topIndex[stackNumber] = nextElementIndex[index];
		
		// Attach the previous top to the beginning of free list
		nextElementIndex[index] = freeIndex;
		
		freeIndex = index;
		
		System.out.println("Popped element from " + stackNumber +  " is " + array[index]);
	}
	
	public static boolean isStackFull() {
		return (freeIndex == -1);
	}
}

/*
Time complexities of operations push() and pop() is O(1).

The best part of above implementation is, if there is a slot available in stack, then an item can be pushed in any of the stacks, 
i.e., no wastage of space.
*/











