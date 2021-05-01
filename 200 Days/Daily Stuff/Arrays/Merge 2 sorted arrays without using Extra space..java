/*
mergeTwoSortedArrays function:
	-> create a tempArray array of size array1.length + array2.length
	-> put elements of array1 and array2 in tempArray 
	-> sort tempArray
	-> put tempArray elements in array1 and array2 with respective
	size
*/


import java.util.*;

class MergeTwoSortedArrays {

    public static void main(String[] args) {

        int array1[] = {1, 5, 9, 10, 15, 20};
        int array2[] = {2, 3, 8, 13};

        mergeTwoSortedArrays(array1, array2);

        System.out.println("Array 1: ");
        for (int index = 0; index < array1.length; index++) {
            System.out.print(array1[index] + " ");
        }
        System.out.println("");
        System.out.println("Array 2: ");
        for (int index = 0; index < array2.length; index++) {
            System.out.print(array2[index] + " ");
        }
    }

    public static void mergeTwoSortedArrays(int array1[], int array2[]) {

        int tempArray[] = new int[array1.length + array2.length];

        int ind = 0;

        for (int index = 0; index < array1.length; index++) {
            tempArray[ind] = array1[index];
            ind++;
        }

        for (int index = 0; index < array2.length; index++) {
            tempArray[ind] = array2[index];
            ind++;
        }

        Arrays.sort(tempArray);

        ind = 0;

        for (int index = 0; index < array1.length; index++) {
            array1[index] = tempArray[ind];
            ind++;
        }

        for (int index = 0; index < array2.length; index++) {
            array2[index] = tempArray[ind];
            ind++;
        }
    }
}
// Time --> O(nlogn)  Space --> O(n + m) length of both arrays


/*
********************* SPACE OPTIMIZED SOLUTION ********************
mergeTwoSortedArrays function:
	-> create index1 and index2 variable and initialize with 0
	-> index1 for array1 and index2 for array2
	-> while index1 is less than array1.length and index2 is less than
	array2.length
		-> if array1[index1] is less than array2[index2] means array1
		element is less than array2 element than increment index1
		
		-> else if array1[index1] is greater than array2[index2] means 
		array1 element is greater than array2 element than 
		swap(array1[index1] and array2[index2] and do "insertion sort"
		on array2 and increment index1
*/


class MergeTwoSortedArrays {

    public static void main(String[] args) {

        int array1[] = {1, 5, 9, 10, 15, 20};
        int array2[] = {2, 3, 8, 13};

        mergeTwoSortedArrays(array1, array2);

        System.out.println("Array 1: ");
        for (int index = 0; index < array1.length; index++) {
            System.out.print(array1[index] + " ");
        }
        System.out.println("");
        System.out.println("Array 2: ");
        for (int index = 0; index < array2.length; index++) {
            System.out.print(array2[index] + " ");
        }
    }

    public static void mergeTwoSortedArrays(int array1[], int array2[]) {

        int index1 = 0, index2 = 0;

        while (index1 < array1.length && index2 < array2.length) {
            if (array1[index1] < array2[index2]) {
                index1++;
            } else if (array1[index1] > array2[index2]) {
                int temp = array1[index1];
                array1[index1] = array2[index2];
                array2[index2] = temp;
                insertionSort(array2);
                index1++;
            }
        }
    }

    public static void insertionSort(int array[]) {
        for (int index = 0; index < array.length; index++) {
            int currentElement = array[index];
            int currentIndex = index;

            while (currentIndex > 0 && array[currentIndex - 1] > currentElement) {
                array[currentIndex] = array[currentIndex - 1];
                currentIndex--;
            }
            array[currentIndex] = currentElement;
        }
    }
}

// Time --> O(n * m) 1 for outer loop and 1 insertion sort for loop
// Space --> O(1)




/*
The idea is simple. Consider each array element X[] and ignore it if it is 
already in the correct order (i.e., the element smallest among all remaining 
elements); otherwise, swap it with the smallest element, which happens to be 
the first element of Y[].
After swapping, move the element (now present at Y[0] ) to its correct position in 
Y[] to maintain the sorted order.
*/

import java.util.Arrays;
 
class Merge
{
    // Function to in-place merge two sorted arrays X[] and Y[]
    // invariant: `X[]` and `Y[]` are sorted at any point
    public static void merge(int[] X, int[] Y)
    {
        int m = X.length;
        int n = Y.length;
 
        // Consider each element `X[i]` of array `X` and ignore the element if it is
        // already in the correct order; otherwise, swap it with the next smaller
        // element, which happens to be the first element of `Y`.
        for (int i = 0; i < m; i++)
        {
            // compare the current element of `X[]` with the first element of `Y[]`
            if (X[i] > Y[0])
            {
                // swap `X[i] with `Y[0]`
                int temp = X[i];
                X[i] = Y[0];
                Y[0] = temp;
 
                int first = Y[0];
 
                // move `Y[0]` to its correct position to maintain the sorted
                // order of `Y[]`. Note: `Y[1…n-1]` is already sorted
                int k;
                for (k = 1; k < n && Y[k] < first; k++) {
                    Y[k - 1] = Y[k];
                }
 
                Y[k - 1] = first;
            }
        }
    }
 
    public static void main (String[] args)
    {
        int[] X = { 1, 4, 7, 8, 10 };
        int[] Y = { 2, 3, 9 };
 
        merge(X, Y);
 
        System.out.println("X: " + Arrays.toString(X));
        System.out.println("Y: " + Arrays.toString(Y));
    }
}

// Time --> O(n * m) 1 for outer loop and 1 for sorting array Y[]
// Space --> O(1)


/*
We move all greater elements from array 1 to array 2 as result array1 has all
smaller elements than array2 and array1 and array2 both are unsorted.
At end we sort both the arrays.


*/

import java.util.*;

class Merge {

    public static void main(String[] args) {

        int arr1[] = {1, 3, 4, 5}, arr2[] = {2, 4, 6, 8};
        merge(arr1, arr2);

        for (int index = 0; index < arr1.length; index++) {
            System.out.print(arr1[index] + " ");
        }
        System.out.println("");
        for (int index = 0; index < arr2.length; index++) {
            System.out.print(arr2[index] + " ");
        }
    }

    public static void merge(int array1[], int array2[]) {
		
		// index1 from end of array1 and index2 is from start of array2
        int index1 = array1.length - 1, index2 = 0;
		
		// putting all smaller elements in array2 compared with array1 in 
		// array1
        while (index1 >= 0 && index2 < array2.length) {
            if (array1[index1] > array2[index2]) {
                int temp = array1[index1];
                array1[index1] = array2[index2];
                array2[index2] = temp;
            }
            index1--;
            index2++;
        }
		// At last sort both arrays
        Arrays.sort(array1);
        Arrays.sort(array2);
    }
}

// Time --> O(n) + O(2 n * logn)
// Space --> O(1)

