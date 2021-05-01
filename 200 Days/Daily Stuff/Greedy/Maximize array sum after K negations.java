/*
This problem has very simple solution, we just have to replace the minimum 
element arr[i] in array by -arr[i] for current operation. 
In this way we can make sum of array maximum after K operations. 
One interesting case is, once the minimum element becomes 0, 
we don’t need to make any more changes. 
*/

import java.util.*;

class MaximizeSum{
    public static void main(String[] args) {
        
        int array[] = {-2, 0, 5, -1, 2};
        int k = 4;
        
        System.out.println(maximizeSum(array, k));
    }
    
    public static int maximizeSum(int array[], int k){
        for (int index1 = 1; index1 <= k; index1++){
            int minimum = Integer.MAX_VALUE;
            int minIndex = -1;
            
            // Find minimum element in array for
            // current operation and modify it
            // i.e; arr[j] --> -arr[j]
            for (int index2 = 0; index2 < array.length; index2++){
                if (array[index2] < minimum){
                    minimum = array[index2];
                    minIndex = index2;
                }
            }
            
            // if minimum is 0, so there is no point to conver 0 to -0
            // or -0 to 0
            if (minimum != 0){
                array[minIndex] = -(array[minIndex]);
            }
        }
        return Arrays.stream(array).sum();
    }
}
// Time --> O(n * k)



// Using sort
/*
1. We sort array:
	-> if first element is 0 means array contains all positive elements 
	then we can do k operations on 0, so there is no point of moving forward
	return sum of array
	
	-> else if first element is greater than 0 means array contains all positive 
	elements we can do k  operations on first element only.
	If k is even then return sum of array as it is 
	If k is odd invert 1st element and return sum of array
	
	-> else
	loop array till array length and also check k > 0:
		-> if current element is less than 0 then only invert it and decrement k.
	
	If K is not zero:
		-> Again sort array
			-> Do remaining k operations on first element
			If k is even then return sum of array as it is 
			If k is odd invert 1st element and return sum of array
	
	return sum of array.
*/
import java.util.*;

class MaximizeSum {

    public static void main(String[] args) {

        int array[] = {4, 3, 2};
        int k = 1;

        System.out.println(maximizeSum(array, k));
    }

    public static int maximizeSum(int array[], int k) {
        Arrays.sort(array);

/*
if first element is 0 means array contains all positive elements 
	then we can do k operations on 0, so there is no point of moving forward
	return sum of array
*/
        if (array[0] == 0) {
            return Arrays.stream(array).sum();
        } 
		
/*
else if first element is greater than 0 means array contains all positive 
	elements we can do k  operations on first element only.
	If k is even then return sum of array as it is 
	If k is odd invert 1st element and return sum of array
*/
        else if (array[0] > 0) {
            array[0] = (k % 2 == 0) ? array[0] : -array[0];
            return Arrays.stream(array).sum();
        } 
		
/*
-> else
	loop array till array length and also check k > 0:
		-> if current element is less than 0 then only invert it and decrement k.
	
*/
        else {
            for (int index = 0; index < array.length && k > 0; index++) {
                if (array[index] < 0) {
                    array[index] = -array[index];
                    k--;
                }
            }
        }
		
		/*
		If K is not zero:
		-> Again sort array
			-> Do remaining k operations on first element
			If k is even then return sum of array as it is 
			If k is odd invert 1st element and return sum of array
	
	return sum of array.
		*/

        if (k > 0) {
            Arrays.sort(array);
            array[0] = (k % 2 == 0) ? array[0] : -array[0];
        }
        return Arrays.stream(array).sum();
    }
}
// Time --> O(2 * (n logn) + O(n))



// Using Min Heap

/*
1. Put all elements of array in min heap.

2. Remove root element i.e minimum element from heap invert it and put again 
in heap.

3. Sum of all heap elements
*/

class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
		// Put all elements of array in min heap.
        for(int elem: A){
            minHeap.add(elem);
        }
        
		/*
	Remove root element i.e minimum element from heap invert it and put again 
in heap.
		*/
        for(int i=0 ; i<K ; ++i){
            int curr = minHeap.poll();
            minHeap.add(-1*curr);
        }
        
        int sum = 0;
        while(!minHeap.isEmpty()){
            sum += minHeap.poll();
        }
        
        return sum;
    }
}

// Time --> O(n logn + n logk)    Space --> O(n)