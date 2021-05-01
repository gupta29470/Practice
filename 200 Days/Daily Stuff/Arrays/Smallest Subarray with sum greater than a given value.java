/*
using two loops outer loop will traverse from 0 to n - 1 and inner loop
traverse from outer loop index + 1 to n - 1.
store outer loop element in currentSum.
add inner loop element in currentSum.
if currentSum is greater than given sum then update smallSubarrayLength
which is length of small sub array by initializing :
	suppose start at index 1 and end at index 5 so total 5 elements
	so length will be: end(5) - start(1) + 1 = 5
if end - start + 1 is less than minLength update minLength
*/

class SmallestSubarray {

    public static void main(String[] args) {
        int array[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
        int sum = 280;

        System.out.println(smallestSubarray(array, sum));
    }

    public static int smallestSubarray(int array[], int sum) {

        int smallSubarrayLength = array.length + 1;
        
        for (int start = 0; start < array.length; start++){
            if (array[start] > sum){
                return 1;
            }
            int currentSum = array[start];
            for (int end = start + 1; end < array.length; end++){
                currentSum+= array[end];
                
                if (currentSum > sum && (end - start + 1) < smallSubarrayLength){
                    smallSubarrayLength = end - start + 1;
                }
            }
        }
        return smallSubarrayLength;
    }

}
// Time --> O(n^2)   Space--> O(1)




/*
********************** USING SLIDING WINDOW *****************************
we start from 0th index and add current element in windowSum. if windowSum
is greater than given sum then we store sub array length and decrease 
element from start of array. After subtracting start element of subarray
from windowSum if windowSum is still greater than sum then we update 
inshort minLength decrease by 1 and it is going till windowSum becomes
less than or equals to sum.

smallestSubarray function:

	-> initiale minLength = max value, windowSum = 0 and left = 0
	
	-> for loop from 0 to n - 1 and index name is "right"
		-> add current element in windowSum
		-> while loop if windowSum > sum && left <= right(if windowSum
		is less than sum or left is greater than right we will not
		enter in while loop)
			-> then we choose min length between current minLength and
			right - left + 1(end - start + 1)
			
			-> we decrease left index element in windowSum
			windowSum =windowSum - array[left]
			
			-> increment left
*/
class SmallestSubarray {

    public static void main(String[] args) {
        int array[] = {1, 4, 45, 6, 0, 19};
        int sum = 51;

        System.out.println(smallestSubarray(array, sum));
    }

    public static int smallestSubarray(int array[], int sum) {

        int minLength = Integer.MAX_VALUE;

        int windowSum = 0, left = 0;

        for (int right = 0; right < array.length; right++) {
			
			// add current element in windowSum
            windowSum += array[right];

    /*
	while loop if windowSum > sum && left <= right(if windowSum
		is less than sum or left is greater than right we will not
		enter in while loop)
	*/
			while (windowSum > sum && left <= right) {
	
	/*
	then we choose min length between current minLength and
			right - left + 1(end - start + 1)
	*/
                minLength = Math.min(minLength, right - left + 1);
    /*
	we decrease left index element in windowSum
			windowSum =windowSum - array[left]
	*/
                windowSum -= array[left];
                
				// increment left
				left++;
            }
        }
        return minLength;
    }

}

