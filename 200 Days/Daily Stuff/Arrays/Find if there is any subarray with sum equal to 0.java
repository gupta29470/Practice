/*
using two loops outer loop will start from 0 to n - 1 and inner loop
starts from outer loop index + 1 to n - 1.
we store outer loop element in currentSum variable. Add all right side 
elements of current element to currentSum. if we found currentSum == 0
we return true or at end we return false.
*/

class SubarrayWithZeroSum {

    public static void main(String[] args) {

        int[] A = {-10, -1, 46, -27, -32, -5, -4, 1, -29, 5, 29, 38, 14, -22,
            -9, 0};

        System.out.println(subArrayZeroSum(A));
    }

    public static boolean subArrayZeroSum(int A[]) {
        for (int index1 = 0; index1 < A.length; index1++) {
            if (A[index1] == 0){
                return true;
            }
            int currentSum = A[index1];
            for (int index2 = index1 + 1; index2 < A.length; index2++) {
                currentSum += A[index2];

                if (currentSum == 0) {
                    return true;
                }
            }
        }
        return false;
    }

}
// Time --> O(n)   Space --> O(1)



/*
We can easily solve this problem in linear time by using hasing(Set)
The idea is to use a set to check if a subarray with zero-sum is present 
in the given array or not. Traverse the array and maintain the sum of
elements seen so far. If the sum is seen before (i.e., the sum exists 
in the set), return true as there exists at least one subarray with 
zero-sum that ends at the current index; otherwise, insert the sum into 
the set.


Eg:
arr[] = {1, 4, -2, -2, 5, -4, 3}

If we consider all prefix sums, we can
notice that there is a subarray with 0
sum when :
1) Either a prefix sum repeats or
2) Or prefix sum becomes 0.

Prefix sums for above array are:
1, (1+ 4) = 5, (5 + (-2)) = 3, (3 +(-2)) = 1, (1 + 5) = 6, 
(6 + (-4)) = 2, (2 + 3) = 5

Since prefix sum "1" repeats, we have a subarray
with 0 sum. 
*/


import java.util.*;

class SubarrayWithZeroSum {

    public static void main(String[] args) {

        int[] A = {-10, -1, 46, -27, -32, -5, -4, 1, -29, 5, 29, 38, 14, -22,
            -9, 0};

        System.out.println(subArrayZeroSum(A));
    }

    public static boolean subArrayZeroSum(int A[]) {
        
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int sum = 0;
		
        /*
		If we consider all prefix sums, we can
		notice that there is a subarray with 0
		sum when :
		1) Either a prefix sum repeats or
		2) Or prefix sum becomes 0.
		*/
        for (int data : A){
            // Add current element to sum 
			sum+= data;
            
            // sum is already present in hash map
			if (set.contains(sum)){
                return true;
            }
            set.add(sum);
        }
        // We reach here only when there is 
        // no subarray with 0 sum 
		return false;
    }

}
// Time --> O(n)   Space --> O(n)
