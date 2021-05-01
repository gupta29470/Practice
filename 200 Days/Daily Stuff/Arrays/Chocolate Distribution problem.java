/*
chocolateDistribution function:
	-> if array size is 0 or noOfstudents = 0 return 0
	
	-> if noOfstudents is greater than array size return 0
	
	-> Sort the array
	
	-> create index and initialize with zero
	
****(-> As we sort the array so we decided to give only one chocolate to
	each student . As array is sorted so minimum difference between
	maximum packet chocolate and minimum packet chocolate will be at 
	noOfstudents space
	
	Example: 
	arr[] = {3, 4, 1, 9, 56, 7, 9, 12} , m = 5 
	After sorting arr = {1, 3, 4, 7, 9, 9, 12, 56}
	
	so 1 index will initally at 0 index and another index will be at 
	noOfstudents space ie. 0 + 5 - 1 at index4 as given 5 students
	#so 9 - 1 = 8
	index++
	
	index = 1 and another index will be at noOfstudents space i.e
	1 + 5 - 1 at index 5 as given 5 students
	# so 9 - 3 = 6
	index++
	
	vice versa
	
	We keep track of minimum difference in minimumDifference variable.
	currentDifference will help to update minimumDifference)****
	
	-> while index < array.length && index + noOfstudents - 1 < 
	array.length
		-> currentDifference = array[index + index + noOfstudents - 1] -
		array[index](array is sorted so large value will subtract small
		value)
		
		-> if currentDifference < minimumDifference update minimumDifference
		
		-> increment index
*/

import java.util.*;

class ChocolateDistribution {

    public static void main(String[] args) {
        int array[] = {2, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48,
            43, 50};
        int noOfstudents = 7;

        System.out.println(chocolateDistribution(array, noOfstudents));
    }

    public static int chocolateDistribution(int array[], int noOfstudents) {

        // if array size is 0 or noOfstudents = 0 return 0
		if (array.length == 0 || noOfstudents == 0){
            return 0;
        }
        
        // if noOfstudents is greater than array size return 0
		if (noOfstudents > array.length){
            return 0;
        }
        
        // Sort the array
		// Reason for this in above explanation
		Arrays.sort(array);

        int index = 0;
        int minimumDifference = Integer.MAX_VALUE;

        while (index < array.length && index + noOfstudents - 1 < array.length) {
        
	/*
		currentDifference = array[index + index + noOfstudents - 1] -
		array[index](array is sorted so large value will subtract small
		value)
	*/
			int currentDifference = array[index + noOfstudents - 1] - array[index];

	// if currentDifference < minimumDifference update minimumDifference
            if (currentDifference < minimumDifference) {
                minimumDifference = currentDifference;
            }
			
		// increment index
            index++;
        }
        return minimumDifference;
    }

}
// Time --> O(nlogn)   Space --> O(1)
