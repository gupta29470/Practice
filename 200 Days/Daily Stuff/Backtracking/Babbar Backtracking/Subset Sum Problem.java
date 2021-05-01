/*
You have given an array of positive integers and sum. Check if subset present in array which is equal to sum or not.

Use backtracking:
1. For current element we have two choices either we consider current element or not.
	(i) If we consider it we add in deque and recursively call function by increment array index and subtract sum from current element.
	
	(ii) If we did not consider it we recursively call function by increment array index.
	
*/

import java.util.*;
import java.sql.*;//1

public class practice_1 {
	public static void main(String args[]) {
		int array[] = {15, 22, 14, 26, 32, 9, 16, 8};
		int sum = 53;
		
		isSubsetPresent(array, sum);
	}
	
	public static boolean isSubsetPresent(int array[], int sum) {
		Deque<Integer> deque = new ArrayDeque<>();
		int index = 0;
		
		return isSubsetPresentUtil(array, sum, index, deque);
	}
	
	public static boolean isSubsetPresentUtil(int array[], int sum, 
			int index, Deque<Integer> deque) {
		
		// reach end of array
		if (index == array.length) {
			// found subset
			if (sum == 0) {
				System.out.println(deque);
				return true;
			}
			// not found
			else {
				return false;
			}
		}
		
		// including element
		deque.add(array[index]);
		
		isSubsetPresentUtil(array, sum - array[index], index + 1, deque);
		
		// backtrack
		deque.removeLast();
		
		// not including element
		return isSubsetPresentUtil(array, sum, index + 1, deque);
	}
}
// Time --> O(2 ^ n)   Space --> O(n)