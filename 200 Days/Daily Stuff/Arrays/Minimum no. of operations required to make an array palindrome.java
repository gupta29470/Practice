/*
Given an array of positive integers. We need to make the given array a 
‘Palindrome’. The only allowed operation is”merging” (of two adjacent 
elements). Merging two adjacent elements means replacing them with their 
sum. The task is to find the minimum number of merge operations required 
to make the given array a ‘Palindrome’.

To make any array a palindrome, we can simply apply merge operation n-1 
times where n is the size of the array (because a single-element array is 
always palindromic, similar to single-character string). In that case, the 
size of array will be reduced to 1. But in this problem, we are asked to 
do it in the minimum number of operations.


Input : arr[] = {15, 4, 15}
Output : 0
Array is already a palindrome. So we
do not need any merge operation.

Input : arr[] = {1, 4, 5, 1}
Output : 1
We can make given array palindrome with
minimum one merging (merging 4 and 5 to
make 9)

Input : arr[] = {11, 14, 15, 99}
Output : 3
We need to merge all elements to make
a palindrome.
*/


/*

As palindrome refers to half of elements in reverse respect to other half
so we have start pointer from index 0 and end pointer from last element.

The only operation allow is merging means sum of two adjacent element, so
element at start is less than element at end, increment start  
we do merging of element at start and element at start - 1 and 
increment merging operation.

Similarly if end element is less than start element decrement end and 
then we simply do merging of element at end and element at end + 1 and increment 
merging operation.


minimumMerge function:
	-> initialize minimumMerge = 0;
	
	-> initialize start = 0 and end = n - 1
	
	-> while start is les than or equals to end:
		-> if element at start and element at end is equal, do nothing
		just simply increment start and decrement end
		
		-> else if element at start is less than element at end then 
		increment start and do merge of element at start and element
		at start - 1 
		
		else (if element at end is less than start) then decrement end
		and do merge of element at end and element at end + 1
	
	-> return minimumMerge
*/

class MinimumMerge {

    public static void main(String[] args) {
        int array[] = {1, 4, 5, 9, 1};

        System.out.println(minimumMerge(array));
    }
    
    public static int minimumMerge(int array[]){
        // initialize minimumMerge = 0;
		int minimumMerge = 0;
        
        // initialize start = 0 and end = n - 1
		int start = 0, end = array.length - 1;
        
        // while start is les than or equals to end:
		while (start <= end){
    
	/* if element at start and element at end is equal, do nothing
	just simply increment start and decrement end */
		just simply increment start and decrement end
			if (array[start] == array[end]){
                start++;
                end--;
            }
            
	/*else if element at start is less than element at end then 
		increment start and do merge of element at start and element
		at start - 1 */		
            else if (array[start] < array[end]){
                start++;
                array[start] = array[start - 1] + array[start];
                minimumMerge++;
            }
    
	/*else (if element at end is less than start) then decrement end
		and do merge of element at end and element at end + 1*/
            else{
                end--;
                array[end] = array[end] + array[end + 1];
                minimumMerge++;
            }
        }
        return minimumMerge;
    }

}
