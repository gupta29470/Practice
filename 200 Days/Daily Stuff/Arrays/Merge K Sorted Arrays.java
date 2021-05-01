/*
************************* BRUTE FORCE **************************
Create a output array put all matrix elements in output array, sort 
output array and print it.
*/

import java.util.*;

class KSortedArrays {

    public static void main(String[] args) {

        int matrix[][] = {{1, 3, 5, 7},
        {2, 4, 6, 8},
        {0, 9, 10, 11}};
        
        kSortedArrays(matrix);
    }

    public static void kSortedArrays(int matrix[][]) {

        int size = matrix.length;
        int sortedArray[] = new int[size * size];
        int index = 0;

        for (int index1 = 0; index1 < size; index1++) {
            for (int index2 = 0; index2 < size; index2++) {
                sortedArray[index++] = matrix[index1][index2];
            }
        }
        Arrays.sort(sortedArray);

        for (int data : sortedArray) {
            System.out.print(data + " ");
        }
        System.out.println("");
    }
}
// Time --> O(n^2)    Space --> O(n^2)



/*
All rows are sorted among themselves so as column. So we will create
min heap and initially put first column in min heap.
Now, traverse from column 1 to n - 1 columns, put current element 
in min heap and simultaneously remove element from min heap.
At last remove remaining elements from min heap.
*/

import java.util.*;

class KSortedArrays {

    public static void main(String[] args) {

        int matrix[][] = {{1, 3, 5, 7},
        {2, 4, 6, 8},
        {0, 9, 10, 11}};
        
        kSortedArrays(matrix);
    }

    public static void kSortedArrays(int matrix[][]) {

        int size = matrix.length;
       
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        
        for (int index = 0; index < size; index++){
            priorityQueue.add(matrix[index][0]);
        }
        
        for (int col = 1; col < size; col++){
            for (int row = 0; row < size; row++){
                priorityQueue.add(matrix[row][col]);
                System.out.print(priorityQueue.poll() + " ");
            }
        }
        while (!priorityQueue.isEmpty()){
            System.out.print(priorityQueue.poll() + " ");
        }
        System.out.println("");
    }
}
// Time --> O(n * n (log k))    Space --> O(k)