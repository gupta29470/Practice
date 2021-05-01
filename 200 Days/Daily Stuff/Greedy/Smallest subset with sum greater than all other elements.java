/*
If any sum is greater than half of array sum then sum greater than all other elements.

We sort values in descending order, then take elements from the largest, 
until we get strictly more than half of total sum of the given array. 
*/

import java.util.*;

public class prat {

    public static void main(String[] args) {
        int arr[] = {3, 1, 7, 1};
        
        System.out.println(smallestSubset(arr));
    }
    
    public static int smallestSubset(int array[]){
		
		 // Calculating HALF of array sum 
        int halfSum = 0;
        
        for (int data : array){
            halfSum+= data;
        }
        halfSum = halfSum / 2;
        
		// Sort the array in ascending order and 
        // start traversing array from the ascending
        // sort in descending order.
        Arrays.sort(array);
        int currentSum = 0, result = 0;
        
        for (int index = array.length - 1; index >= 0; index--){
            currentSum+= array[index];
            result++;
            
			// Current sum greater than sum
            if (currentSum > halfSum){
                return result;
            }
        }
        return result;
    }
}
