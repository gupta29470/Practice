/*
We have create a Pair class to return two values in one go. Two values are:
	1. value one: All elements before that index are lesser than pivot
	2. value two: All elements after that index are greater than pivot

Between value one and value two all elements are equal to pivot

We are partitioning array in partition function and return :
	1. start - 1: All elements before start - 1are lesser than pivot
	2. middle : All elements after middle are greater than pivot
	
In sort function we have check two conditions initially:
	1. if array contains 0 or 1 elements then return 
	2. if array contains two elements then we check if 1st element is greater than
	second element we swap and return
	
At first shot we are returning that index where:
	1. All elements before that index are lesser than pivot
	2. All elements after that index are greater than pivot

Then we are recurring in both half using these two recursive call:
	1.
	// recur on the subarray containing elements that are less than the pivot
        sort(array, start, pair.getLesser());
        
    2.
	// recur on the subarray containing elements that are more than the pivot
    sort(array, pair.getGreater(), end);

*/

import java.util.*;

class Sort {

    public static void main(String[] args) {
        int a[] = {2, 1};

        sort(a, 0, a.length - 1);

        System.out.println(Arrays.toString(a));
    }

    // 3–way Quicksort routine
    public static void sort(int array[], int start, int end) {
        // base condition for 0 or 1 elements
        if (start >= end) {
            return;
        }

        // handle 2 elements separately as the Dutch national flag
        // algorithm will work for 3 or more elements
        if (end - start == 1) {
            System.out.println("1");
            if (array[start] > array[end]) {
                swap(array, start, end);
            }
            return;
        }

        // rearrange elements across pivot using the Dutch
        // national flag problem algorithm
        Pair pair = partition(array, start, end);

        // recur on the subarray containing elements that are less than the pivot
        sort(array, start, pair.getLesser());
        
        // recur on the subarray containing elements that are more than the pivot
        sort(array, pair.getGreater(), end);
    }

     // Partition routine using the Dutch national flag algorithm
    public static Pair partition(int array[], int start, int end) {
        int middle = start;
        int pivot = array[end];

        while (middle <= end) {
            if (array[middle] < pivot) {
                swap(array, start, middle);
                start++;
                middle++;
            } 
            else if (array[middle] > pivot) {
                swap(array, middle, end);
                end--;
            } 
            else {
                middle++;
            }
        }
        // `arr[start … mid-1]` contains all occurrences of a pivot
        return new Pair(start - 1, middle);
    }

    public static void swap(int array[], int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}

class Pair {

    private int lesser;
    private int greater;

    Pair(int lesser, int greater) {
        this.lesser = lesser;
        this.greater = greater;
    }

    public int getLesser() {
        return lesser;
    }

    public int getGreater() {
        return greater;
    }
}
// Time --> O(n)