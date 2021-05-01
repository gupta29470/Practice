/*
Given two numbers n and k where n represents a number of elements in a set, find a number of ways to partition the set into 
k subsets.
set contains 1 to n 

Example: 

Input: n = 3, k = 2
Output: 3
Explanation: Let the set be {1, 2, 3}, we can partition
             it into 2 subsets in following ways
             {{1,2}, {3}},  {{1}, {2,3}},  {{1,3}, {2}}  

Input: n = 3, k = 1
Output: 1
Explanation: There is only one way {{1, 2, 3}}
*/


/*
1. number starts from 1 and goes till n.
2. numberOfSubsets to keep track of whether we are able to generate k subsets if yes then it is valid and print
3. subsets to store k subsets

For each number we have choice either we put in existing subset or first non - empty subset, first because to avoid duplications.

Handle the base cases. If n = 0 or k = 0 or k > n return 0 as there cannot be any subset. 
If n is equal to k or k is equal to 1 return 1.

1. if current subset is not empty We have choice we can put in existing subset.
Note: numberOfSubset will not increase because we are adding in existing subset.

2. if current subset is empty We have choice we can put new subset.
Note: numberOfSubset will increase because we are adding in new subset and we have to put in first empty subset.
to avoid duplication.

Eg : 3 subsets : 1, 2 || 3 || empty  and 1, 2 || empty || 3 are same.
*/

import java.util.*;

public class practice_1 {
	
	static int count = 0;
	
	public static void main(String args[]) {
		int n = 4, k = 2;
		
		KSubsets(n, k);
		
		System.out.println(count);
	}
	
	public static void KSubsets(int n, int k) {
		
		// if wrong input is given
		if (k == 0 || k > n || n == 0) {
			count = 0;
			return;
		}
		
		/*
		1. number starts from 1 and goes till n.
		2. numberOfSubsets to keep track of whether we are able to generate k subsets if yes then it is valid and print
		3. subsets to store k subsets
		*/
		int number = 1;
		int numberOfSubsets = 0;
		ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
		
		// filling empty list
		for (int index = 0; index < k; index++) {
			subsets.add(new ArrayList<>());
		}
		
		KSubsetsUtil(n, k, number, numberOfSubsets, subsets);
	}
	
	public static void KSubsetsUtil(int n, int k, int number, int numberOfSubsets, 
			ArrayList<ArrayList<Integer>> subsets) {
		
		// if number out of range
		if (number > n) {
			
			// if we are able to generate k subsets
			if (numberOfSubsets == k) {
				
				// increment count
				count++;
				
				// print subset
				for (ArrayList<Integer> subset : subsets) {
					System.out.print(subset + " ");
				}
				System.out.println();
			}
			return;
		}
		
		// looping subsets
		for (int index = 0; index < subsets.size(); index++) {
			
			// if current subset is not empty 
			// We have choice we can put in existing subset
			// note numberOfSubset will not increase because we are adding in existing subset
			if (subsets.get(index).size() > 0) {
				
				// adding number
				subsets.get(index).add(number);
				
				// calling function with next number
				KSubsetsUtil(n, k, number + 1, numberOfSubsets, subsets);
				
				// if we found or not found answer backtracking to find another answer
				subsets.get(index).remove(subsets.get(index).size() - 1);
			}
			
			// if current subset is empty 
			// We have choice we can put new subset
			// Note: numberOfSubset will increase because we are adding in new subset and we have to put in first empty subset
			// to avoid duplication
			else {
				
				// adding number
				subsets.get(index).add(number);
				
				// calling function with next number and increment of numberOfSubset
				KSubsetsUtil(n, k, number + 1, numberOfSubsets + 1, subsets);
				
				// if we found or not found answer backtracking to find another answer
				subsets.get(index).remove(subsets.get(index).size() - 1);
				
				// helps to put in first empty subset
				break;
			}
		}
	}
}

/*
Time complexity: O(2^n). 
For every value of n, two recursive function is called. More specifically the Time complexity is exponential.
Space complexity: O(n)(Due to call stack). 
*/















