/*
To solve this problem, we have to think greedily that how can we maximize the difference 
value of the elements so that we can have a maximum sum. This is possible only if we 
calculate the difference between some very high values and some very low values like 
(highest – smallest). This is the idea which we have to use to solve this problem. 
Let us see the above example, we will have maximum difference possible for sequence 
{1, 8, 2, 4} because in this sequence we will get some high difference values, 
( |1-8| = 7, |8-2| = 6 .. ). Here, by placing 8(highest element) in place of 1 and 2 
we get two high difference values. Similarly, for the other values, we will place next 
highest values in between other, as we have only one left i.e 4 which is placed at last.

Algorithm: To get the maximum sum, we should have a sequence in which small and large 
elements comes alternate. This is done to get maximum difference.

For the implementation of the above algorithm ->
1. We will sort the array.
2. Calculate the final sequence by taking one smallest element and largest element 
from the sorted array and make one vector array of this final sequence.
3. Finally, calculate the sum of absolute difference between the elements of the array.
*/

import java.util.*;

public class prat {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 8 };
        int n = arr.length;
        
        System.out.println(maximizeSum(arr, n));
    }
    
    public static int maximizeSum(int array[], int len){
        
        // sort the original array
        // so that we can retrieve
        // the large elements from
        // the end of array elements
        Arrays.sort(array);
		
		// variable to store the
        // maximum sum of absolute
        // difference
        int maximumSum = 0;
        
        ArrayList<Integer> customSequence = new ArrayList<>();
        
		// In this loop first we will insert
        // one smallest element not entered
        // till that time in final sequence
        // and then enter a highest element
        // (not entered till that time) in
        // final sequence so that we
        // have large difference value. This
        // process is repeated till all array
        // has completely entered in sequence.
        // Here, we have loop till n/2 because
        // we are inserting two elements at a
        // time in loop.
        for (int index = 0; index < len / 2; index++){
            customSequence.add(array[index]);
            customSequence.add(array[len - index - 1]);
        }
        
		// If there are odd elements, push the
        // middle element at the end.
        if (len % 2 != 0){
            customSequence.add(array[len / 2]);
        }
        
		// In this loop absolute difference
        // of elements for the final sequence
        // is calculated.
        for (int index = 0; index < len - 1; index++){
            maximumSum += Math.abs(customSequence.get(index) - 
                    customSequence.get(index + 1));
        }
        
		// absolute difference of last element
        // and 1st element
        maximumSum += Math.abs(customSequence.get(0) - 
                customSequence.get(len - 1));
        
		// return the value
        return maximumSum;
    }
}
// Time --> O(n logn + n)
