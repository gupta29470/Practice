/*
This method efficiently utilizes the available space. It doesn’t cause an overflow if there is space available in arr[]. 
The idea is to start two stacks from two extreme corners of arr[]. stack1 starts from the leftmost element, the first element in 
stack1 is pushed at index 0. The stack2 starts from the rightmost corner, the first element in stack2 is pushed at index (n-1). 
Both stacks grow (or shrink) in opposite direction. To check for overflow, all we need to check is for space between top elements 
of both stacks. 
*/

import java.util.*;

public class practice_1 {
	
	static int size = 5;
	static int array[] = new int[size];
	static int top1 = -1, top2 = size;
	
	public static void main(String args[]) {
		pop1();
		pop2();
		
		push1(5);
        push2(10);
        push2(15);
        push1(11);
        push2(7);
        
        peek1();
        peek2();
        
        pop1();
        push2(40);
        pop2();
        
        peek1();
        peek2();
	}
	
	// Method to push an element x to stack1
	public static void push1(int data) {
		
		if ((top1 + 1) == top2) {
			System.out.println("Stack 1 Overflow");
		}
		// There is at least one empty space for
        // new element
		else {
			top1++;
			array[top1] = data;
		}
	}
	
	// Method to push an element x to stack2
	public static void push2(int data) {
		
		if ((top2 - 1) == top1) {
			System.out.println("Stack 1 Overflow");
		}
		// There is at least one empty space for
        // new element
		else {
			top2--;
			array[top2] = data;
		}
	}
	
	// Method to pop an element from first stack
	public static void pop1() {
		if (top1 < 0) {
			System.out.println("Stack 1 Underflow");
		}
		else {
			int poppedData = array[top1];
			array[top1] = 0;
			top1--;
			
			System.out.println("Popped data is : " + poppedData);
		}
	}
	
	// Method to pop an element from second stack
	public static void pop2() {
		if (top2 == size) {
			System.out.println("Stack 2 Underflow");
		}
		else {
			int poppedData = array[top2];
			array[top2] = 0;
			top2++;
			
			System.out.println("Popped data is : " + poppedData);
		}
	}
	
	public static void peek1() {
		if (top1 < 0) {
			System.out.println("Stack 1 Underflow");
		}
		else {
			System.out.println(array[top1]);
		}
	}
	
	public static void peek2() {
		if (top2 == size) {
			System.out.println("Stack 2 Underflow");
		}
		else {
			System.out.println(array[top2]);
		}
	}
}
/*
Time Complexity: 
Push operation : O(1)
Pop operation : O(1)
Auxiliary Space :O(N). 
Use of array to implement stack so it is a space-optimised method. 
*/














