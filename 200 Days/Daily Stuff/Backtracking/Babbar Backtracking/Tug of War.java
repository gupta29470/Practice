/*
Wehave given an array, we have to divide array in 2 parts such as difference of sum of part1 and sum of part2 is minimum

As a subset rule in backtracking either we condiser element or not. So for current element either we consider in part1 or part2.

If array length is even then part 1 and part 2 size is equal.
If array length is odd then part 1 size is 1 greater than part 2 size.
*/


import java.util.*;
import java.sql.*;//1

public class practice_1 {
	static int minimumDifference = Integer.MAX_VALUE;
	static StringBuilder answer = new StringBuilder();
	public static void main(String args[]) {
		int array[] = {10, 20, 30, 40};
		
		tugOfWar(array);
		
		System.out.println(answer);
	}
	
	public static void tugOfWar(int array[]) {
		Deque<Integer> deque1 = new ArrayDeque<>();
		Deque<Integer> deque2 = new ArrayDeque<>();
		
		int sum1 = 0, sum2 = 0, index = 0;
		
		tugOfWarUtil(array, index, deque1, deque2, sum1, sum2);
	}
	
	public static void tugOfWarUtil(int array[], int index, 
			Deque<Integer> deque1, Deque<Integer> deque2, 
			int sum1 , int sum2) {
		
		if (index == array.length) {
			// finding difference 
			int difference = Math.abs(sum1 - sum2);
			
			if (difference < minimumDifference) {
				// clearing string builder because we found parts difference more smalller than previous one
				answer.setLength(0);
				answer.append(deque1);
				answer.append(deque2);
				
				// updating difference
				minimumDifference = difference;
				return;
			}
		}
		
		// for handling odd and even case that's why length + 1
		// array length is 7
		// part 1 size : 7 + 1 = 8 / 2 = 4
		// part 2 size will be 3
		if (deque1.size() < (array.length + 1 ) / 2) {
			
			// consider in deque 1 and not considering in deque 2
			deque1.add(array[index]);
			
			// adding to part 1 sum and not in part 2 sum
			tugOfWarUtil(array, index + 1, deque1, deque2, 
					sum1 + array[index], sum2);
			
			// backtrack
			deque1.removeLast();
		}
		
		if (deque2.size() < (array.length + 1) / 2) {
			
			// consider in deque 2 and not considering in deque 1
			deque2.add(array[index]);
			
			// adding to part 2 sum and not in part 1 sum
			tugOfWarUtil(array, index + 1, deque1, deque2, sum1, 
					sum2 + array[index]);
			
			// backtrack
			deque2.removeLast();
		}
	}
}

// Time --> O(2 ^ n)   Space --> O(2 n)