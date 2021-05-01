/*
Inversion Count for an array indicates – how far (or close) the array is 
from being sorted. If array is already sorted then inversion count is 0. 
If array is sorted in reverse order that inversion count is the maximum. 
Formally speaking, two elements a[i] and a[j] form an inversion if 
a[i] > a[j] and i < j 
Example: 

Input: arr[] = {8, 4, 2, 1}
Output: 6

Explanation: Given array has six inversions:
(8, 4), (4, 2), (8, 2), (8, 1), (4, 1), (2, 1).
*/


/*
************************ BRUTE FORCE *****************************
we use two loops :
	-> outer loop(index1) will traverse from 1 to n - 1 elements and 
	inner loop(index2) will traverse outer index + 1 to n - 1 for each 
	element.
	if we found (array[index1] > array[index2]) means any smaller element
	(array[index2] than current element array[index1] we increment count
*/
class CountInversion{
    public static void main(String[] args) {
        int array[] = {3, 1, 2};
        
        System.out.println(countInversion(array));
    }
    
    public static int countInversion(int array[]){
        int count = 0;
        
        for (int index1 = 0; index1 < array.length; index1++){
            for (int index2 = index1 + 1; index2 < array.length; index2++){
                if (array[index1] > array[index2]){
                    count++;
                }
            }
        }
        return count;
    }
}
//Time --> O(n ^2)  Space --> O(1)



/*
**************************** OPTIMAL SOLUTION *****************************
perform merge sort but store every recursion in count variable
divideArray function:
	-> create inversionCount variable
	
	-> It is used to divide array till elements are in single state
	
	-> we pass (array, left, middle + 1, right) to mergeArrayAndCount 
	function
	
	-> mergeArrayAndCount function:
		-> create three variable : index1 for left sub array index2 for
		right sub array and index3 for temporary array to store
		sorted elements, inversionCount = 0 to count number of inversions
		
		-> while loop (index <= middle - 1 and index <= right) middle - 1
		beacuse we made middle to right sub array
			-> if left sub array element is smaller than right sub array
			element then put in temporary array and increment index1 and 
			index3
			
			-> else put in temporary array and increment index2 and 
			index3 and inversionCount will be middle - index1
		
		-> put remaining left sub array element in temporary array
		
		-> put remaining right sub array element in temporary array
		
		-> pull back all sorted elements in temporary array elements
		in original array
		
		-> return inversionCount
	
	-> return inversionCount
		

if a[i] is greater than a[j], then there are (mid – i) inversions. 
because left and right subarrays are sorted, so all the remaining elements 
in left-subarray (a[i+1], a[i+2] … a[mid]) will be greater than a[j].
*/

class MergeSort {

    public static void main(String[] args) {

        int array[] = {468, 335, 1, 170, 225, 479, 359, 463, 465, 206, 146, 282,
            328, 462, 492, 496, 443, 328, 437, 392, 105, 403, 154, 293, 383, 422,
            217, 219, 396, 448, 227, 272, 39, 370, 413, 168, 300, 36, 395, 204,
            312, 323

        };

        System.out.println(divideArray(array, 0, array.length - 1));;

        for (int data : array) {
            System.out.print(data + " ");
        }
    }

    public static int divideArray(int array[], int left, int right) {
        int inversionCount = 0;
        if (left < right) {
            int middle = (left + right) / 2;

            inversionCount += divideArray(array, left, middle);
            inversionCount += divideArray(array, middle + 1, right);

            // middle will be in right sub array
            inversionCount += mergeArrayAndCount(array, left, middle + 1, right);
        }
        return inversionCount;
    }

    public static int mergeArrayAndCount(int array[], int left, int middle,
            int right) {

        int index1 = left, index2 = middle, index3 = left,
                inversionCount = 0;
        int tempArray[] = new int[array.length];

        // middle will be in right sub array
        while ((index1 <= middle - 1) && (index2 <= right)) {
            if (array[index1] <= array[index2]) {
                tempArray[index3++] = array[index1++];
            } // if inversion encounters
            else {
                tempArray[index3++] = array[index2++];
                inversionCount += (middle - index1);
            }
        }

        while (index1 <= middle - 1) {
            tempArray[index3++] = array[index1++];
        }

        while (index2 <= right) {
            tempArray[index3++] = array[index2++];
        }

        for (int index = left; index <= right; index++) {
            array[index] = tempArray[index];
        }
        return inversionCount;
    }
}

// Time--> O(nlogn)(merge sort)  Space--> O(n)(tempArray)
