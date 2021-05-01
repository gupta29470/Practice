class Binary_Array_Sorting 
{ 
	static int[] SortBinaryArray(int arr[], int n) 
	{ 
	    /*int j=-1;
	   for(int i=0;i<n;i++){
	       if(arr[i]<1){
	           j++;
	           arr[i]=arr[i]^arr[j];
	           arr[j]=arr[i]^arr[j];
	           arr[i]=arr[i]^arr[j];
	       }*/
	       Arrays.sort(arr);
	   //}
	   return arr;
	} 
} 
/*
Given a binary array A[] of size N. The task is to arrange the array in increasing order.

Note: The binary array contains only 0  and 1.

Input:
The first line of input contains an integer T, denoting the test cases. Every test case contains two lines, the first line is N(size of the array) and the second line is space-separated elements of the array.

Output:
Space-separated elements of sorted arrays. There should be a new line between the output of every test case.

Your Task:
Complete the function SortBinaryArray() which takes given array as input and returns the sorted array. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Challenge: Try doing it in one pass.

Constraints:
1 < = T <= 100
1 <= N <= 106
0 <= A[i] <= 1

Example:
Input:
2
5
1 0 1 1 0
10
1 0 1 1 1 1 1 0 0 0
Output:
0 0 1 1 1
0 0 0 0 1 1 1 1 1 1
*/