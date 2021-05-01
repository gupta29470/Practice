/*
A simple solution is to consider all subarrays one by one and check if sum of 
every subarray is equal to 0 or not. The complexity of this solution would be 
O(n^2).
*/

class ZeroSubarray {

    public static void main(String[] args) {
        int array[] = {6, 3, -1, -3, 4, -2, 2,
             4, 6, -12, -7};
        
        zeroSubarray(array);
    }

    public static void zeroSubarray(int array[]) {

        for (int index1 = 0; index1 < array.length; index1++) {
            int sum = array[index1];
            for (int index2 = index1 + 1; index2 < array.length; index2++) {
                if (array[index1] == 0) {
                    System.out.println(array[index1]);
                }
                sum += array[index2];
                if (sum == 0) {
                    print(array, index1, index2);
                }
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
======= If Array contains only one zero sub array use this approach ==========


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
class ZeroSumSubarray {

    public static void main(String[] args) {
        int array[] = {6, 3, -1, -3, 4, -2, 2,
             4, 6, -12, -7};
        
        zeroSumSubarray(array, 0);
    }

    public static void zeroSumSubarray(int array[], int sum) {

        int index1, currentSum = array[0], start = 0;
        
        for (index1 = 1; index1 <= array.length; index1++){
			 // If curr_sum exceeds the sum, 
            // then remove the starting elements 
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
// Time --> O(n)  Space --> O(1)



import java.util.*;
 
class ZeroSumSubarray{
    public static void main(String[] args) {
        
        int array[] = {6, 3, -1, -3, 4, -2, 2,
             4, 6, -12, -7};
        
        zeroSumSubarray(array);
    }
    
    // Function to get index of  all subarrays with a zero-sum in a given array
    public static void zeroSumSubarray(int array[]){
        // create an empty multimap to store the starting index of all
        // subarrays having the same sum
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        
         // insert `(0, -1)` pair into the map to handle the case when
        // subarray with zero-sum starts from index 0
        insertInToMap(map, 0, -1);
        
        // traverse the given array
        for (int index = 0; index < array.length; index++){
            // sum of elements so far
            sum = sum + array[index];
            
            // if the sum is seen before, there exists at least one
            // subarray with zero-sum
            if (map.containsKey(sum)){
                // find all subarrays with the same sum
                List<Integer> startIndexes = map.get(sum);
                for (int startIndex : startIndexes){
                    print(array, startIndex + 1, index);
                }
            }
            // insert (sum so far, current index) pair into the multimap
            insertInToMap(map, sum, index);
        }
        
    }
    // Utility function to insert <key, value> into the multimap
    public static void insertInToMap(Map<Integer, List<Integer>> map, int key,
            int value){
        // if the key is seen for the first time, initialize the list
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(value);
    }
    
     // Function to print all subarrays with a zero-sum in a given array
    public static void print(int array[], int start, int end){
        System.out.print(start + " to " + end  + " : ");
        for (int index = start; index <= end; index++){
            System.out.print(array[index] + ", ");
        }
        System.out.println("");
    }
}
// Time --> O(n)   Space --> O(n)
