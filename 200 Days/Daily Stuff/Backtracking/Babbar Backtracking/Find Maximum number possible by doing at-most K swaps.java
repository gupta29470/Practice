/*
Given a positive integer, find the maximum integer possible by doing at-most K swap operations on its digits.
Examples: 

Input: M = 254, K = 1
Output: 524
Swap 5 with 2 so number becomes 524
*/


/*
Naive Solution:
Approach: The idea is to consider every digit and swap it with digits following it one at a time and see if it leads to the 
maximum number. The process is repeated K times. The code can be further optimized, if the current digit is swapped with a digit 
less than the following digit.
Algorithm:  

1. Create a global variable which will store the maximum string or number.
2. Define a recursive function that takes the string as number and value of k
3. Run a nested loop, the outer loop from 0 to length of string -1 and inner loop from i+1 to end of the string.
4. Swap the ith and jth character and check if the string is now maximum and update the maximum string.
5. Call the function recursively with parameters: string and k-1.
6. Now again swap back the ith and jth character.
*/

import java.util.*;
import java.sql.*;//1

public class practice_1 {
	static String max = "";
	public static void main(String args[]) {
		String number = "129814999";
		int swaps = 4;
		
		findLargest(number, swaps);
		
		System.out.println(max);
	}
	
	public static void findLargest(String number, int swaps) {
		char numbers[] = number.toCharArray();
		
		findLargestUtil(numbers, swaps);
	}
	
	// Function to find maximum
	// integer possible by
	// doing at-most K swap
	// operations on its digits
	public static void findLargestUtil(char numbers[], int swaps) {
		
		// Return if no swaps left
		if (swaps == 0) {
			return;
		}
		
		// Consider every digit
		for (int index1 = 0; index1 < numbers.length; index1++) {
			
			// Compare it with all digits
    		// after it
			for (int index2 = 0; index2 < numbers.length; index2++) {
				
				// if digit at position i
      			// is less than digit
      			// at position j, swap it
      			// and check for maximum
      			// number so far and recurse
      			// for remaining swaps
				if (numbers[index1] < numbers[index2]) {
					
					 // swap str[i] with
        			// str[j]
					swap(numbers, index1, index2);
					
					
					// If current num is more
        			// than maximum so far
					if (String.valueOf(numbers).compareTo(max) > 0){
						max = String.valueOf(numbers);
					}
					
					
					// recurse of the other
        			// k - 1 swaps
					findLargestUtil(numbers, swaps - 1);
					
					
					// Backtrack
					swap(numbers, index1, index2);
				}
			}
		}
	}
	
	public static void swap(char numbers[], int index1, int index2) {
		char temp = numbers[index1];
		numbers[index1] = numbers[index2];
		numbers[index2] = temp;
	}
}
/*
Complexity Analysis:  

Time Complexity: O((n^2)^k). 
For every recursive call n^2 recursive calls is generated until the value of k is 0. So total recursive calls are O((n^2)^k).
Space Complexity:O(n). 
This is the space required to store the output string.
*/




/*
								****************** EFFICIENT APPROACH *************************
								
"It can be observed that to make the maximum string, the maximum digit is shifted to the "front". 
So, instead of trying all pairs, try only those pairs where one of the elements is the maximum digit which is not yet swapped to 
the front. "

Instead of comparing all current character with all remaining character, we will find 1st maximum character and then swap with first 
character. Again it will find 2nd maximum character and then swap with second character. Again it will find 3rd maximum character 
and then swap with third character and so on...

// if current char is not equal to maxChar means it's value is change, means swap is happened, decrement swap.


Algorithm:  

1. Create a global variable which will store the maximum string or number.
2. Define a recursive function that takes the string as a number, the value of k, and the current index.
3. Find the index of the maximum element in the range current index to end.
4. if the index of the maximum element is not equal to the current index then decrement the value of k.
5. Run a loop from the current index to the end of the array
6. If the ith digit is equal to the maximum element
7. Swap the ith and element at the current index and check if the string is now maximum and update the maximum string.
8. Call the function recursively with parameters: string and k.
9. Now again swap back the ith and element at the current index.
*/


import java.util.*;

public class practice_1 {
	static String max = "";
	public static void main(String args[]) {
		String number = "129814999";
		int swaps = 4;
		
		findLargest(number, swaps);
		
		System.out.println(max);
	}
	
	public static void findLargest(String number, int swaps) {
		char numbers[] = number.toCharArray();
		int index = 0;
		
		findLargestUtil(numbers, swaps, index);
	}
	
	public static void findLargestUtil(char numbers[], int swaps, int index) {
		
		if (swaps == 0) {
			return;
		}
		
		/* This will find 1st maximum character and then swap with first character.
		 Again it will find 2nd maximum character and then swap with second character.
		 Again it will find 3rd maximum character and then swap with third character and so on
		*/
		char maxChar = numbers[index];
		
		// loop to find maximum character
		for (int _index = index + 1; _index < numbers.length; _index++) {
			if (numbers[_index] > maxChar) {
				maxChar = numbers[_index];
			}
		}
		
		// if maxChar is not same as initialization means it's value is change, means swap is happened
		if (maxChar != numbers[index]) {
			swaps--;
		}
		
		// swap current character with max character
		for (int _index = index; _index < numbers.length; _index++) {
			
			if (numbers[_index] == maxChar) {
				
				// swap 1st max with 1st character
				// swap 2nd max with 2nd character
				// and so on...
				swap(numbers, index, _index);
				
				// update max
				if (String.valueOf(numbers).compareTo(max) > 0) {
					max = String.valueOf(numbers);
				}
				
				// moving forward 
				findLargestUtil(numbers, swaps, index + 1);
				
				
				// backtrack
				swap(numbers, index, _index);
			}
		}
		
	}
	
	public static void swap(char numbers[], int index1, int index2) {
		char temp = numbers[index1];
		numbers[index1] = numbers[index2];
		numbers[index2] = temp;
	}
}
/*
Complexity Analysis:  

Time Complexity: O(n^k). 
For every recursive call n recursive calls is generated until the value of k is 0. So total recursive calls are O((n)^k).
Space Complexity: O(n). 
The space required to store the output string.
*/
