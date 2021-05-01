/*
This technique shows how a nested for loop in some problems can be 
converted to a single for loop to reduce the time complexity.
Let’s start with a problem for illustration where we can apply this 
technique – 

Given an array of integers of size ‘n’.
Our aim is to calculate the maximum sum of ‘k’ 
consecutive elements in the array.

Input  : arr[] = {100, 200, 300, 400}
         k = 2
Output : 700

Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}
         k = 4 
Output : 39
We get maximum sum by adding subarray {4, 2, 10, 23}
of size 4.

Input  : arr[] = {2, 3}
         k = 3
Output : Invalid
There is no subarray of size 3 as size of whole
array is 2.
*/



/*
we use two loops, outer loops will run from 0 to n - k + 1 and inner loop 
will run from 0 to less than k
example k = 4 and array length is 9 then :
	outerloop will run from 0 to 5(included) and inner loop from 0 to 3
	(included)

As inner loop will be run of k size we we take sum of k elements and
check if this k elements are of maximum sum

array[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
->  :index1 = 0 ,currentSum = 0, index2 = 0
	currentSum = 0 + array[0 + 0] = 1
	index2 = 1 maxSum = 1
	:index1 = 0 currentSum = 1, index2 = 1
	currentSum = 1 + array[0 + 1] = 4 + 1 = 5
	index2 = 2 maxSum = 5
	:index1 = 0, currentSum = 5, index2 = 2
	currentSum = 5 + array[0 + 2] = 5 + 2 = 7
	index2 = 3 maxSum = 7
	:index1 = 0, currentSum = 7, index2 = 3
	currentSum = 7 + array[0 + 3] = 7 + 10 = 17
	index2 = 4 maxSum = 17  inner loop breaks 

-> :index1 = 1, currentSum = 0, index2 = 0
	currentSum = 0 + array[1 + 0] = 4
	index2 = 1 maxSum = 17
	:index1 = 1, currentSum = 4, index2 = 1
	currentSum = 4 + array[1 + 1] = 4 + 5 = 6
	index2 = 2 maxSum = 17
	index1 = 1, currentSum = 6, index2 = 2
	currentSum = 6 + array[1 + 2] = 6 + 10 = 16
	index2 = 3 maxSum = 17
	index1 = 1, currentSum = 16, index2 = 3
	currentSum = 16 + array[1 + 3] = 16 + 2 = 18
	index2 = 4 maxSum = 18  inner loop breaks 
	.
	.
	.
	vice versa 
	and max window will be (3, 1, 0, 20) = 24
	
*/
class WindowSlidingTechnique {

    public static void main(String[] args) {
        int array[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;

        System.out.println(maxSum(array, k));;
    }

    public static int maxSum(int array[], int k){
        
        int maxSum = 0;
        
        for (int index1 = 0; index1 < array.length - k + 1; index1++){
             int currentSum = 0;
             for (int index2 = 0; index2 < k; index2++){
                 currentSum+= array[index1 + index2];
                 
                 maxSum = Math.max(currentSum, maxSum);
             }
        }
        return maxSum;
    }

}
// Time --> O(n^2)  space --> O(n)



/*
************************** SLIDING WINDOW ************************
maxSum function:
	-> first we for loop from 0 to 3 (k size) and hold max sum of that
	k elements
	
	-> initialize windowSum = maxSum till now
	
	-> second for loop from 4 to n - 1(remaining) and we add current element
	with windowSum and subtract element from previous window.
	
	
Eg: as k size is 4 so we have 0 to 3 index(k element) sum store in 
maxSum. as we start from 4 and we add array[4] in windowSum then we 
have sum of 5 elements(0 to 4) but k = 4 so we remove 0 now we have 1 to 4
element of sum, as index = 5 then subtract element of index2 and vice versa

Applying sliding window technique : 

We compute the sum of first k elements out of n terms using a linear loop 
and store the sum in variable window_sum.
Then we will graze linearly over the array till it reaches the end and 
simultaneously keep track of maximum sum.
To get the current sum of block of k elements just subtract the first 
element from the previous block and add the last element of the current
block .
*/

class WindowSlidingTechnique {

    public static void main(String[] args) {
        int array[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;

        System.out.println(maxSum(array, k));;
    }

    public static int maxSum(int array[], int k){
        
        int maxSum = 0;
        
        for (int index = 0; index < k; index++){
            maxSum+= array[index];
        }
        
        int windowSum = maxSum;
        
        for (int index = k; index < array.length; index++){
            windowSum+= array[index] - array[index - k];
            
            maxSum = Math.max(windowSum, maxSum);
        }
        return maxSum;
    }

}
