/*
using two loops outer loops to traverse array from 0 to n - 1 and inner 
loop to traverse from current element index + 1 to n - 1

we create two varibles between outer loop and inner loop currentProduct and
currentElement. 
currentProduct for storing currentProduct and checking
with maxProduct after every multiplication and currentElement is used to 
store currentElement because if we currentElement is positive and max
product till now is negative so one element i.e current element can be 
subarray of size 1 and we mark as maxProduct.

*/

class MaximumProductSubArray {

    public static void main(String[] args) {

        int array[] = {-1, -3, -10, 0, 60};

        System.out.println(maximumProductSubArray(array));
    }

    public static int maximumProductSubArray(int array[]) {
        int maxProduct = 0;
        for (int index1 = 0; index1 < array.length; index1++) {
            int currentProduct = array[index1];
            int currentElement = array[index1];
            for (int index2 = index1 + 1; index2 < array.length; index2++) {
                currentProduct *= array[index2];
                maxProduct = Math.max(maxProduct, currentProduct);
            }
            maxProduct = Math.max(maxProduct, currentElement);
        }
        return maxProduct;
    }
}
// Time --> O(n^2)   Space --> O(1)


/*
In Kadanes algorithm we have to store only max_ending_here sum, but in this 
we have to store min_ending_here and max_ending_here product, because 
min_ending_here will surely have negative value if array contains negative
and positive element and max_ending_here contains positive value.
so if next element is big negative number, then min_ending_here will
multiply with it and become the big positive value.

maxSubarrayProduct function:
	-> if current element is positive we simply multiply it with 
	max_ending_here and min_ending_here will be min(min_ending_here *
	currentElement, 1)
	
	-> if current element is 0 then subarray property breaks and 
	max_ending_here = 1, min_ending_here = 1
	
	-> if current element is negative then we store max_ending_here till
	 now in temp varible, and we update max_ending_here = 
	 max(min_ending_here( if negative) * current element(negative), 1)
	 (becomes big negative) and min_ending_here = temp * current element
	 
	 -> max_so_far is less than max_ending_here update max_so_far
	 
	 -> if max_so_far = 0 return 0 else return max_so_far
*/


import java.io.*;
 
class MaximumProductSubArray {

    public static void main(String[] args) {

        int array[] = {90, 91, -91, 91, -91, -90, 90, 90, -90, -90};

        System.out.println(maximumProductSubArray(array));
    }

    
    /* Returns the product of 
    max product subarray.
    Assumes that the given 
    array always has a subarray
    with product more than 1 */
    public static long maximumProductSubArray(int array[]) {
        // Initialize overall max product
        long maxProduct = 0;

        // max positive product 
        // ending at the current
        // position
        long minEndingHere = 1;
        
        // min negative product 
        // ending at the current
        // position
        long maxEndingHere = 1;

        
        /* Traverse through the array. Following
        values are maintained after the ith iteration:
        max_ending_here is always 1 or some positive product
                        ending with arr[i]
        min_ending_here is always 1 or some negative product
                        ending with arr[i] */
        for (int index = 0; index < array.length; index++) {
            /* If this element is positive, update
               max_ending_here. Update min_ending_here only
               if min_ending_here is negative */
            if (array[index] > 0){
                maxEndingHere = maxEndingHere * array[index];
                minEndingHere = Math.min(minEndingHere * array[index], 1);
            }
            
            /* If this element is 0, then the maximum
            product cannot end here, make both
            max_ending_here and min_ending _here 0
            Assumption: Output is alway greater than or
            equal to 1. */
            else if (array[index] == 0){
                maxEndingHere = 1;
                minEndingHere = 1;
            }
            /* If element is negative. This is tricky
            max_ending_here can either be 1 or positive.
            min_ending_here can either be 1 or negative.
            next min_ending_here will always be prev.
            max_ending_here * arr[i]
            next max_ending_here will be 1 if prev
            min_ending_here is 1, otherwise
            next max_ending_here will be
                        prev min_ending_here * arr[i] */
            else{
                long temp = maxEndingHere;
                maxEndingHere = Math.max(minEndingHere * array[index], 1);
                minEndingHere = temp * array[index];
            }
            
            // update max_so_far, if needed
            if (maxProduct < maxEndingHere){
                maxProduct = maxEndingHere;
            }
        }
        
        if (maxProduct == 0){
            return 0;
        }
        return maxProduct;
    }
}




/*
************************** LEETCODE SUBMISSION *******************
Above GFG one does not work
*/

class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0], maxEndingHere = nums[0], minEndingHere = nums[0];
        
        for (int index = 1; index < nums.length; index++){
            int temp = maxEndingHere;
            
            maxEndingHere = Math.max(nums[index], Math.max(nums[index] * 
                             maxEndingHere, nums[index] * minEndingHere));
            
            minEndingHere = Math.min(nums[index], Math.min(nums[index] * 
                            temp, nums[index] * minEndingHere));
							
            maxProduct = Math.max(maxProduct, maxEndingHere);
        }
        return maxProduct;
    }
}
