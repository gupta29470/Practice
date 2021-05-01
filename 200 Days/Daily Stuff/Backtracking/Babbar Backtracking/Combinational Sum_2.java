/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates 
where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.


Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
*/


/*
In combination sum 1 we have to remove duplicates because that does not makes sense to keep duplicate as we can pick one element
may times till condition satisfy.

But in this problem we have to pick elements at once in per combination, so we keep duplicate. 
There will be case we find duplicate combination so do not include in answer.
*/

/*
1. Sort the array(non-decreasing).
2. Then use recursion and backtracking to solve 
   the problem.
   (A) If at any time sub-problem sum == 0 then 
       add that array to the result (vector of 
       vectors).
   (B) Else if sum is negative then ignore that 
       sub-problem.
   (C) Else insert the present array in that 
       index to the current vector and call 
       the function with sum = sum-ar[index] and
       index = index + 1 , then pop that element from 
       current index (backtrack) and call the 
       function with sum = sum and index = index+1
*/


import java.util.*;
import java.sql.*;//1

public class practice_1 {
	static ArrayList<ArrayList<Integer>> answers = new ArrayList<>();

	public static void main(String args[]) {
		Integer array[] = {10, 1, 2, 7, 6, 1, 5};
		List<Integer> input = new ArrayList<>();
		
		Collections.addAll(input, array);

		int sum = 8;

		ArrayList<ArrayList<Integer>> result = combinationalSum(input, sum);

		System.out.println(result);
	}

	public static ArrayList<ArrayList<Integer>> combinationalSum(List<Integer> input, int sum) {

		Collections.sort(input);

		ArrayList<Integer> miniAnswer = new ArrayList<>();
		int index = 0;

		combinationalSumUtil(input, sum, index, miniAnswer);

		return answers;
	}

	public static void combinationalSumUtil(List<Integer> input, int sum, int index,
			ArrayList<Integer> miniAnswer) {

		// we find that required combination
		if (sum == 0) {
			// if combination is already present then skip
			if (!answers.contains(miniAnswer)) {
				answers.add(new ArrayList<>(miniAnswer));
			}
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
				combinationalSumUtil(input, sum - input.get(indexUtil), indexUtil + 1, miniAnswer);

				// if our current combination is incorrect then remove
				// elements from list which leads to incorrect
				miniAnswer.remove(input.get(indexUtil));
			}
		}
	}
}



/*
Time Complexity : 2 ^ n * k
As it has same condition with subset problem. Either we pick element or not pick element. Picking and not picking is not 
depend on length of array i.e n. As desired combination length can be 1, 2, 3 or equal to n  because we have to pick one element
at once and putting k times in list is another k

So 2 ^ k is picking and not picking , where  * k is putting elements in list k times

Space Complexity : number of combinations
*/
