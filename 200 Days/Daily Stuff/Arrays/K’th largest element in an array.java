/*
*************************** Using Min Max Heap ************************
In Min Heap -> 
	1. Create Priority Queue
	2. Insert 0 to k - 1 element in priority Queue
	3. for remaining element start from k to n - 1
		-> if current element is greater than root than remove root and add
		current
	4. return root


In Max Heap -> 
	1. Create Priority Queue with Collection.reverseOrder
	2. Insert 0 to n - 1 element in priority Queue
	3. while(--k > 0) (i.e if k is 3 remove only 2 element) poll element
	4. return root
*/


import java.util.*;

class Min_Max_Heap {

    public static void main(String[] args) {

        int array[] = {9, 7, 4, 3, 10, 5, 1};

        int k = 3;

        System.out.println(kthLargestMinHeap(array, k));
        System.out.println(kthLargestMaxHeap(array, k));
    }

    public static int kthLargestMinHeap(int array[], int k) {
        // create min heap and insert 0 to k - 1 from array
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int index = 0; index < k; index++) {
            priorityQueue.add(array[index]);
        }

        // for remaining elements
        for (int index = k; index < array.length; index++) {
            if (array[index] > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.add(array[index]);
            }
        }
        return priorityQueue.peek();
    }

    public static int kthLargestMaxHeap(int array[], int k) {
        // create min heap and insert all elements from array
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int index = 0; index < array.length; index++) {
            priorityQueue.add(array[index]);
        }

        // remove exactly k - 1 times
        while (--k > 0) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }

}


/*
Time :
Min Heap -> O(nlogk)  
Max Heap -> O(n + klogn)

Space:
Min Heap -> O(k)
Max Heap -> O(n)
*/
