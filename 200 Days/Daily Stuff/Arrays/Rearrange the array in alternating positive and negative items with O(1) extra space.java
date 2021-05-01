/*
********************** BRUTE *******************************
arrangeAlternately function:
	-> sort the array
	
	-> create two pointers start and end which point to 0 and n - 1
	
	-> create a result array of size input array
	
	-> while start is less than end :
		-> put array[start] in result array and array[end] in result
		array and increment start and decrement end
		
	-> print result array
*/

import java.util.*;

class ArrangeElementsAlternately {

    public static void main(String[] args) {

        int[] A = { 9, -3, 5, -2, -8, -6, 1, 3 };
        
        arrangeAlternately(A);
    }
    
    public static void arrangeAlternately(int A[]){
        Arrays.sort(A);
        
        int start = 0, end = A.length - 1;
        int []result = new int[A.length];
        int index = 0;
        while (start < end){
            result[index++] = A[start];
            result[index++] = A[end];
            start++;
            end--;
        }
        
        for (int data : result){
            System.out.print(data+" ");
        }
    }

}
// Time -> O(nlogn)(sorting)   Space --> O(n)(result array)



/*
******************************** OPTIMAL *******************************
arrangeAlternately:
	-> create two list positiveList and negativeList to store positive 
	and negative elements respectively
	
	-> traverse array, if current element is less than zero put in 
	negativeList  else put in positiveList
	
	-> create two variables index1 and index2 for two list and index
	to put alternate elements in input Array
	
	-> while (index1 < positiveList.size() && index2 < negativeList.size())
		-> put positiveList element, put negativeList element in 
		input array and increment index1, index2 and index
	
	-> put remaining elements in any of list:
		-> while (index1 < positiveList.size()):
			-> put positiveList element in input array and increment
			index1 and index
			
			-> while (index2 < positiveList.size()):
			-> put negativeList element in input array and increment
			index2 and index
	
	-> print input array
*/

import java.util.*;

class ArrangeElementsAlternately {

    public static void main(String[] args) {

        int[] A = {9, -3, 5, -2, -8, -6, 1, 3};

        arrangeAlternately(A);
    }

    public static void arrangeAlternately(int A[]) {

        ArrayList<Integer> positiveList = new ArrayList<>();
        ArrayList<Integer> negativeList = new ArrayList<>();

        for (int index = 0; index < A.length; index++) {
            if (A[index] < 0) {
                negativeList.add(A[index]);
            } else {
                positiveList.add(A[index]);
            }
        }

        int index = 0, index1 = 0, index2 = 0;

        while (index1 < positiveList.size() && index2 < negativeList.size()) {

            A[index++] = positiveList.get(index1++);
            A[index++] = negativeList.get(index2++);
        }

        while (index1 < positiveList.size()) {
            A[index++] = positiveList.get(index1++);
        }

        while (index2 < negativeList.size()) {
            A[index++] = negativeList.get(index2++);
        }

        for (int data : A) {
            System.out.print(data + " ");
        }
    }

}

// Time --> O(n)   Space --> O(n) for two list



/*
******************************* OPTIMIZED ********************************
we are going to use quick sort partition algorithm, means we swap elements 
and find index of first positive element where before that index all 
elements are negative and after that all elements are positive.

after finding partition we will arrange element alternately where 
one index start from 0 and another start from first positive index and
we swap negative element and positive element and increment index by 2 which
start from 0 and increment index by 1 which start from first positive
index.

arrangeAlternately function:
	-> partionOfPos_Neg:
		-> create pivot = 0 as deciding element and firstPositiveIndex = 0
		
		-> traverse array, if current element is less than pivot means
		less than zero then swap current element and A[firstPositiveIndex]
		and increment firstPositiveIndex
		
		-> return firstPositiveIndex
	
	-> holding first Positive Index in partition variable.
	
	-> arranging elements alternately:
		-> index start from 0 and index < partition , partition < n and
		index increment by 2 and partition increment by 1
			-> swap (A[index], A[partition])
			
	
	-> print input array.
*/

class ArrangeElementsAlternately {

    public static void main(String[] args) {

        int[] A = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};

        arrangeAlternately(A);
    }

    public static void arrangeAlternately(int A[]) {

        // holding first Positive Index in partition variable.
		int partition = partionOfPos_Neg(A);

        
		// arranging elements alternately:
		
		for (int index = 0; index < partition && partition < A.length;
                index += 2, partition++) {

            int temp = A[index];
            A[index] = A[partition];
            A[partition] = temp;
        }

        for (int data : A) {
            System.out.print(data + " ");
        }
    }

    public static int partionOfPos_Neg(int A[]) {
		// create pivot = 0 as deciding element and firstPositiveIndex = 0
        int pivot = 0, firstPositiveIndex = 0;

        
		// traverse array, if current element is less than pivot means
	// less than zero then swap current element and A[firstPositiveIndex]
		// and increment firstPositiveIndex
		for (int index = 0; index < A.length; index++) {
            if (A[index] < pivot) {
                int temp = A[index];
                A[index] = A[firstPositiveIndex];
                A[firstPositiveIndex] = temp;

                firstPositiveIndex++;
            }
        }
        // return firstPositiveIndex
		return firstPositiveIndex;
    }

}
// Time --> O(n)   Space--> O(1)
