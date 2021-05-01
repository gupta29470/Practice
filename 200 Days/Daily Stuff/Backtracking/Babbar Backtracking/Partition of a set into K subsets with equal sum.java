/*
Given an integer array of N elements, the task is to divide this array into K non-empty subsets such that the sum of 
elements in every subset is same. All elements of this array should be part of exactly one partition.
Examples:

Input : arr = [2, 1, 4, 5, 6], K = 3
Output : Yes
we can divide above array into 3 parts with equal
sum as [[2, 4], [1, 5], [6]]

Input  : arr = [2, 1, 5, 5, 6], K = 3
Output : No
It is not possible to divide above array into 3
parts with equal sum
*/



/*
1. index starts from 0 to n - 1.
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


*****************************************************************************************************
1. We can find  desired sum by: (sum of all array elements) / k
2. To find answer sum must divided by k
3. If numberOfSubsets == k then check each subset sum is equal to k or not if yes then print all.
*/

import java.util.*;

public class practice_1 {
	static ArrayList<Boolean> list = new ArrayList<>();
	public static void main(String args[]) {
		int array[] = {2, 1, 4, 5, 6};
		int k = 3;
		
		KSubsetsEqualSum(array, k);
		
		if (list.contains(true)) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
	}
	
	public static void KSubsetsEqualSum(int array[], int k) {
		
		/*
		1. index starts from 0 and goes till n.
		2. numberOfSubsets to keep track of whether we are able to generate k subsets if yes then it is valid and print
		3. subsets to store k subsets
		*/
		int index = 0;
		int numberOfSubsets = 0;
		ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
		
		// filling empty list
		for (int _index = 0; _index < k; _index++) {
			subsets.add(new ArrayList<>());
		}
		
		
		// We can find  desired sum by: (sum of all array elements) / k
		int sum = Arrays.stream(array).sum();
		
		// To find answer sum must divided by k
		if (sum % k != 0) {
			return;
		}
		
		sum = sum / k;
		
		KSubsetsEqualSumUtil(array, k, index, numberOfSubsets, subsets, sum);
	}
	
	public static void KSubsetsEqualSumUtil(int array[], int k, int index, 
			int numberOfSubsets, ArrayList<ArrayList<Integer>> subsets, int sum) {
		
		// if index equals array length
		if (index == array.length) {
			
			// if we are able to generate k subsets
			if(numberOfSubsets == k) {
				
				// checking if k subsets sum is equal to sum
				int counter = 0;
				for (ArrayList<Integer> subset : subsets) {
					if (sum == subset.stream().mapToInt(data -> data).sum()) {
						counter++;
					}
				}
				
				// if all subset sum is equal then print
				if (counter == k) {
					list.add(true);
					for (ArrayList<Integer> subset : subsets) {
						System.out.print(subset + " ");
					}
					System.out.println();
				}
			}
			return;
		}
		
		// looping subsets
		for (int _index = 0; _index < subsets.size(); _index++) {
			
			// if current subset is not empty 
			// We have choice we can put in existing subset
			// note numberOfSubset will not increase because we are adding in existing subset
			if (subsets.get(_index).size() > 0) {
				
				// adding number
				subsets.get(_index).add(array[index]);
				
				// calling function with next index
				KSubsetsEqualSumUtil(array, k, index + 1, numberOfSubsets, 
						subsets, sum);
				
				// if we found or not found answer backtracking to find another answer
				subsets.get(_index).remove(subsets.get(_index).size() - 1);
			}
			
			// if current subset is empty 
			// We have choice we can put new subset
			// Note: numberOfSubset will increase because we are adding in new subset and we have to put in first empty subset
			// to avoid duplication
			else {
				
				// adding number
				subsets.get(_index).add(array[index]);
				
				// calling function with next number and increment of numberOfSubset
				KSubsetsEqualSumUtil(array, k, index + 1, numberOfSubsets + 1, 
						subsets, sum);
				
				// if we found or not found answer backtracking to find another answer
				subsets.get(_index).remove(subsets.get(_index).size() - 1);
				
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
















