/*
Given an array and a range [lowVal, highVal], partition the array 
around the range such that array is divided in three parts.
1) All elements smaller than lowVal come first.
2) All elements in range lowVal to highVVal come next.
3) All elements greater than highVVal appear in the end.
The individual elements of three sets can appear in any order.

Examples:

Input: arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32}  
        lowVal = 14, highVal = 20
Output: arr[] = {1, 5, 4, 2, 1, 3, 14, 20, 20, 98, 87, 32, 54}

Input: arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32}  
       lowVal = 20, highVal = 20       
Output: arr[] = {1, 14, 5, 4, 2, 1, 3, 20, 20, 98, 87, 32, 54} 
*/


/*
Just sort the array
*/

import java.util.*;

class ThreeWayPartitioning {

    public static void main(String[] args) {
        int array[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};

        int lowValue = 14, highValue = 20;

        threeWayPartitioning(array, lowValue, highValue);
    }

    public static void threeWayPartitioning(int array[], int lowValue,
            int highValue) {

        Arrays.sort(array);
        
        for (int data : array){
            System.out.print(data+" ");
        }
    }
}
// Time --> O(nlogn)  



/*
**************** USING DUTCH NATIONAL FLAG ALGORITHM ************************

we have start = 0, end = n - 1 and index to traverse array.
-> It states that if current element is lesser than lowValue than 
swap(array[start], array[index]) and increment start and index

-> It states that if current element is greater than highValue than
swap(array[index], array[end]) and decrement end. We decrementing end because 
may be we swap larger element with larger element

-> It states that if current element is in between lowVal(including) and 
highValue(including) then increment index because middle elements stays 
in middle. We only increment index because we want all value >= lowValue and 
value <= highValue in middle

threeWayPartitioning function:
	-> create start = 0, end = n - 1 and index = 0;
	
	-> while index is less than or equals to end
		-> if current element is less than lowValue than 
		swap(array[start], array[index]) and increment start and index
		
		-> else if current element is greater than highValue than
		swap(array[index], array[end]) and decrement end. We decrementing end 
		because may be we swap larger element with larger element
		
		else // current element is in between lowVal(including) and 
		highValue(including) then increment index because middle elements stays 
		in middle. We only increment index because we want all value >= lowValue 
		and value <= highValue in middle

*/

class ThreeWayPartitioning {

    public static void main(String[] args) {
        int array[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};

        int lowValue = 14, highValue = 20;

        threeWayPartitioning(array, lowValue, highValue);
    }

    public static void threeWayPartitioning(int array[], int lowValue,
            int highValue) {

        int start = 0, end = array.length - 1, index = 0;
        
        while (index <= end){
            
    /*
	if current element is less than lowValue than 
		swap(array[start], array[index]) and increment start and index
	*/
			if (array[index] < lowValue){
                swap(array, start, index);
                start++;
                index++;
            }
			
	/*
	else if current element is greater than highValue than
		swap(array[index], array[end]) and decrement end. We decrementing end 
		because may be we swap larger element with larger element
		
	*/
            else if (array[index] > highValue){
                swap(array, index, end);
                end--;
            }
           
	
	/*
	else // current element is in between lowVal(including) and 
		highValue(including) then increment index because middle elements stays 
		in middle. We only increment index because we want all value >= lowValue 
		and value <= highValue in middle
	*/
		   else{
                index++;
            }
        }
        
        for (int data : array){
            System.out.print(data+" ");
        }
    }
    
    public static void swap(int array[], int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
// Time --> O(n)   space --> O(1)