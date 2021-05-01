/*
	********************* SLIDING WINDOW APPROACH **********************

Efficient Approach: There is an idea if all the elements of the array are positive. 
If a subarray has sum greater than the given sum then there is no possibility that 
adding elements to the current subarray the sum will be x (given sum). 
Idea is to use a similar approach to a sliding window. Start with an empty subarray,
 add elements to the subarray until the sum is less than x. 
 If the sum is greater than x, remove elements from the start of the current 
 subarray.

Algorithm:

Create three variables, l=0, sum = 0
Traverse the array from start to end.
Update the variable sum by adding current element, sum = sum + array[i]
If the sum is greater than the given sum, update the variable sum as 
sum = sum – array[l], and update l as, l++.
If the sum is equal to given sum, print the subarray and break the loop.
*/


class GivenSumSubarray {

    public static void main(String[] args) {
        int array[] = {1, 4, 20, 3, 10, 5};
        
        givenSumSubarray(array, 33);
    }

    public static void givenSumSubarray(int array[], int sum) {

        int index1, currentSum = array[0], start = 0;
        
        for (index1 = 1; index1 <= array.length; index1++){
            while (currentSum > sum && start < index1 - 1){
                currentSum = currentSum - array[start];
                start++;
            }
            
            if (currentSum == sum){
                int index2 = index1 - 1;
                print(array, start, index2);
                return;
            }
            
            if (index1 < array.length){
                currentSum = currentSum + array[index1];
            }
        }
    }

    public static void print(int array[], int index1, int index2) {
        System.out.print(index1 + " to " + index2 + " : " );
        for (int ind = index1; ind <= index2; ind++) {
            System.out.print(array[ind] + " ");
        }
        System.out.println("");
    }

}
/*
Complexity Analysis:

Time Complexity : O(n).
Only one traversal of the array is required. So the time complexity is O(n).
Space Complexity: O(1).
As constant extra space is required.

*/