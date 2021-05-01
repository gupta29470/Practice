/*
Given an array of positive integers arr[] and a sum x, find all unique combinations in arr[] where the sum is equal to x. 
The same repeated number may be chosen from arr[] unlimited number of times. Elements in a combination (a1, a2, …, ak) must be 
printed in non-descending order. (ie, a1 <= a2 <= … <= ak). 
The combinations themselves must be sorted in ascending order, i.e., the combination with smallest first element should be printed 
first. If there is no combination possible the print “Empty” (without quotes).
*/



/*
1. Sort the array(non-decreasing).
2. First remove all the duplicates from array.
3. Then use recursion and backtracking to solve 
   the problem.
   (A) If at any time sub-problem sum == 0 then 
       add that array to the result (vector of 
       vectors).
   (B) Else if sum is negative then ignore that 
       sub-problem.
   (C) Else insert the present array in that 
       index to the current vector and call 
       the function with sum = sum-ar[index] and
       index = index, then pop that element from 
       current index (backtrack) and call the 
       function with sum = sum and index = index+1
*/

import java.util.*;

public class practice_1 {
	static ArrayList<ArrayList<Integer>> answers = new ArrayList<>();

	public static void main(String args[]) {
		ArrayList<Integer> input = new ArrayList<>();

		input.add(2);
		input.add(4);
		input.add(6);
		input.add(8);

		int sum = 8;

		ArrayList<ArrayList<Integer>> result = combinationalSum(input, sum);

		System.out.println(result);
	}

	public static ArrayList<ArrayList<Integer>> combinationalSum(ArrayList<Integer> input, int sum) {

		// removing duplicates
		Set<Integer> set = new HashSet<>(input);

		input.clear();

		input.addAll(set);

		Collections.sort(input);

		ArrayList<Integer> miniAnswer = new ArrayList<>();
		int index = 0;

		combinationalSumUtil(input, sum, index, miniAnswer);

		return answers;
	}

	public static void combinationalSumUtil(ArrayList<Integer> input, int sum, int index,
			ArrayList<Integer> miniAnswer) {

		// we find that required combination
		if (sum == 0) {
			answers.add(new ArrayList<>(miniAnswer));
			return;
		}

		// loop array
		for (int indexUtil = index; indexUtil < input.size(); indexUtil++) {

			// checking if sum does not becomes negative
			if ((sum - input.get(indexUtil)) >= 0) {

				// if not then add in sub list
				miniAnswer.add(input.get(indexUtil));

				// recursively call function for same index until
				// condition satisfy
				combinationalSumUtil(input, sum - input.get(indexUtil), indexUtil, miniAnswer);

				// if our current combination is incorrect then remove
				// elements from list which leads to incorrect
				miniAnswer.remove(input.get(indexUtil));
			}
		}
	}
}

/*
Time Complexity : 2 ^ k * k
As it has same condition with subset problem. Either we pick element or not pick element. Picking and not picking is not 
depend on length of array i.e n. As desired combination length can be 1, 2, 3 or any number so that any number is k and 
putting k times in list is another k

So 2 ^ k is picking and not picking , where  * k is putting elements in list k times

Space Complexity : number of combinations
*/







