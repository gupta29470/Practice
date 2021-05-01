/*
Given an array of n positive integers and a number k. 
Find the minimum number of swaps required to bring all the numbers 
less than or equal to k together.

Input:  arr[] = {2, 1, 5, 6, 3}, k = 3
Output: 1

Explanation: 
To bring elements 2, 1, 3 together, swap 
element '5' with '3' such that final array
will be-
arr[] = {2, 1, 3, 6, 5}

Input:  arr[] = {2, 7, 9, 5, 8, 7, 4}, k = 5
To bring elements 2 ,5, 4 together by swapping 7 with 5 and 9 with 4
Output: 2
*/


/*
*********************** NAIVE APPROACH ***************************
1. Calculate how many elements in array is smaller than or equals to k.
Reason for calculating because the number of smaller or equals element
is found is equals to the siz of sub array which contains elements
maller than or equals to k.

Then check for each subarray and count number of greater than than k,
the subarray has minimum number of greater elements will be result.

minimumSwaps function:
	-> initialize minLength = max (result)
	
	-> lessEqual variable to count number of smaller or equals to k.
	
	-> for loop to calculate smaller or equals elements:
		-> if current element is less than or equals k increment lessEqual
	
	-> initialize index1 and index2 which will be starting index and 
	ending index of subarray. index2 is "starting index of subarray"
	and index1 is "ending index of subarray" 
	
	-> initialize greater variable = 0 to count number of greater variable
	in that subarray 
	
	-> while ending index (index1) is less than n:
		-> if current element is greater than k increment greater
		
		-> increment ending index(index1) every time
		
		-> while check if starting index(index2) is less than n and 
		check if starting index and ending index is in position
		to form subarray
		(index1 - index2) >= lessEqual
			-> update minLength 
			minLength = Math.min(minLength, greater);
			
			-> as we calculate minimum swaps i.e number of greater
			element in that subarray, so if starting index element 
			is greater than k decrement greater
			
			-> increment starting index(index2) every time
			
	-> return minLength
		
		
*/


class MinimumSwaps {

    public static void main(String[] args) {
        int array[] = {2, 7, 9, 5, 8, 7, 4};

        System.out.println(minimumSwaps(array, 5));;
    }

    public static int minimumSwaps(int array[], int k) {
        
		// initialize minLength = max (result)
		int minLength = Integer.MAX_VALUE;
		
		// lessEqual variable to count number of smaller or equals to k.
		int lessEqual = 0;

        // for loop to calculate smaller or equals elements:
		for (int index = 0; index < array.length; index++){
    // if current element is less than or equals k increment lessEqual
			if (array[index] <= k){
                lessEqual++;
            }
        }
        
        
	/*
	initialize index1 and index2 which will be starting index and 
	ending index of subarray. index2 is "starting index of subarray"
	and index1 is "ending index of subarray" */	
		int index1 = 0, index2 = 0;
		
	/* initialize greater variable = 0 to count number of greater variable
	in that subarray */	
		int greater = 0;
        
        
		// while ending index (index1) is less than n:
		while (index1 < array.length){
            // if current element is greater than k increment greater
			if (array[index1] > k){
                greater++;
            }
            
            //increment ending index(index1) every time
			index1++;
            
    /* while check if starting index(index2) is less than n and 
		check if starting index and ending index is in position
		to form subarray
		(index1 - index2) >= lessEqual */
		   while (index2 < array.length && index1 - index2 >= lessEqual){
			   
			   // update minLength 
                minLength = Math.min(minLength, greater);
                
    /*as we calculate minimum swaps i.e number of greater
			element in that subarray, so if starting index element 
			is greater than k decrement greater*/            
				if (array[index2] > k){
                    greater--;
                }
                
				// increment starting index(index2) every time
				index2++;
            }
        }
        return minLength;
    }

}
// Time --> O(n^2)    Space --> O(1)



/*
************** EFFICIENT - SLIDING WINDOW APPROACH ****************
SLIDING WINDOW shows how a nested for loop in some problems can be 
converted to a single for loop to reduce the time complexity.

Calculate how many elements in array is smaller than or equals to k.
Reason for calculating because the number of smaller or equals element
is found is equals to the siz of sub array which contains elements
smaller than or equals to k.

Calculate how many greater elements in 1st subarray i.e 0 to lessEqual - 1
and we store number of greater elements i.e number of swaps in 1st 
subarray.

Then check for other sub array by removing previous element and 
add new subarray


minimumSwaps function:
	-> initialize minLength = max (result)
	
	-> lessEqual variable to count number of smaller or equals to k.
	
	-> for loop to calculate smaller or equals elements:
		-> if current element is less than or equals k increment lessEqual
		
	-> initialize greater variable = 0 to count number of greater variable
	in that subarray 
	
	-> for loop to calculate number of greater elements till lessEqual - 1
		-> if current element is greater than k increment greater
	
	-> update minLength = greater
	
	-> as we have to check other sub arrays so we have to
	remove number of greater elements we encounter in previous subarray
	
	-> for loop removing from index 0 and adding from lessEqual, so
	index1 = 0 and index2 = lessEqual
		-> if previous subarray element(index1) is greater than k then 
		remove that greater i.e decrement greater
		
		-> if current subarray element (index2) is greater than kbhit
		then add greater i.e. increment greater 
		
		-> update minLength
*/


class MinimumSwaps {

    public static void main(String[] args) {
        int array[] = {2, 7, 9, 5, 8, 7, 4};

        System.out.println(minimumSwaps(array, 5));;
    }

    public static int minimumSwaps(int array[], int k) {
        // initialize minLength = max (result)
		int minLength = 0;
		
		// lessEqual variable to count number of smaller or equals to k.
		int lessEqual = 0;
		
// initialize greater variable = 0 to count number of greater variable
		// in that subarray 
		int greater = 0;

        // for loop to calculate smaller or equals elements:
		for (int index = 0; index < array.length; index++){
        // if current element is less than or equals k increment lessEqual
			if (array[index] <= k){
                lessEqual++;
            }
        }

    // for loop to calculate number of greater elements till lessEqual - 1
		for (int index = 0; index < lessEqual; index++){
	// if current element is greater than k increment greater
            if (array[index] > k){
                greater++;
            }
        }
        
        //update minLength = greater
		minLength = greater;
        
    /*as we have to check other sub arrays so we have to
	remove number of greater elements we encounter in previous subarray*/ 

	/*for loop removing from index 0 and adding from lessEqual, so
	index1 = 0 and index2 = lessEqual*/
		for (int index1 = 0, index2 = lessEqual; index2 < array.length; 
                index1++, index2++){
            
      /*if previous subarray element(index1) is greater than k then 
		remove that greater i.e decrement greater*/
			if (array[index1] > k){
                greater--;
            }
            
	/*if current subarray element (index2) is greater than kbhit
		then add greater i.e. increment greater */		
			if (array[index2] > k){
                greater++;
            }
            
            // update minLength
			minLength = Math.min(greater, minLength);
        }
        
        return minLength;
        
    }

}

