
/*
Sort the array:
for kth smallest return k - 1 element from array
for kth largest return n - k element from array
*/
import java.io.*;
import java.util.*;

class MinMaxInArray {

    public static void main(String[] args) {

        int array[] = {5, 4, 3, 1, 9, 2, 10};
        int k = 3;
        
        kthSmallestLargest(array, k);
    }

    public static void kthSmallestLargest(int array[], int k) {
        Arrays.sort(array);

        int kthSmallest = array[k - 1];
        int kthLargest = array[array.length - k];

        System.out.println(kthSmallest + " " + kthLargest);
    }
}

// Time --> O(nlogn)



/*
*************************** Using Min Max Heap ************************
In Max Heap -> 
	1. Create Priority Queue with Collection.reverseOrder
	2. Insert 0 to k - 1 element in priority Queue
	3. for remaining element start from k to n - 1
		-> if current element is less than root than remove root and add
		current
	4. return root


In Min Heap -> 
	1. Create Priority Queue
	2. Insert 0 to n - 1 element in priority Queue
	3. while(--k > 0) (i.e if k is 3 remove only 2 element) poll element
	4. return root
*/

import java.util.*;
class Min_Max_Heap {

    public static void main(String[] args) {

        int array[] = {9, 7, 4, 3, 10, 5, 1};

        int k = 3;

        System.out.println(kthSmallestMaxHeap(array, k));
        System.out.println(kthSmallestMinHeap(array, k));
    }

    public static int kthSmallestMaxHeap(int array[], int k) {

        // create a max-heap using PriorityQueue class and
        // insert first k elements of the array into the heap
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int index = 0; index < k; index++) {
            priorityQueue.add(array[index]);
        }

        // do for remaining array elements
        for (int index = k; index < array.length; index++) {
            // if current element is less than the root of the heap
            if (array[index] < priorityQueue.peek()) {
                // replace root with the current element
				priorityQueue.poll();
                priorityQueue.add(array[index]);
            }
        }
        // return the root of max-heap
        return priorityQueue.peek();
    }

    public static int kthSmallestMinHeap(int array[], int k) {

        // create a max-heap using PriorityQueue class and
        // insert all elements of the array into the heap
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int index = 0; index < array.length; index++) {
            priorityQueue.add(array[index]);
        }

        // pop from min-heap exactly (k-1) times
        while (--k > 0) {
            priorityQueue.poll();
        }
        // return the root of min-heap
        return priorityQueue.peek();
    }

}


/*
Time Complexity :
Max Heap: O(nlogk)
Min Heap: O(n + klogn)

Space:
Max Heap -> O(k)
Min Heap -> O(n)

For finding smallest element use Max Heap
*/
