/*
The solution to the problem is a simple greedy approach. It consists of two steps. 
Step 1 : Sort both the arrays in O (n log n) time. 
Step 2 : Find absolute difference of each pair of corresponding elements 
(elements at same index) of both arrays and add the result to the sum S. 
The time complexity of this step is O(n).
Hence, the overall time complexity of the program is O(n log n). 
*/

import java.util.*;

public class prat {

    public static void main(String[] args) {
        long a[] = {4, 1, 8, 7};
        long b[] = {2, 3, 6, 5};

        System.out.println(minimumSum(a, b));
    }

    public static long minimumSum(long array1[], long array2[]){
        Arrays.sort(array1);
        Arrays.sort(array2);
        long minimumSum = 0;
        
        for (int index = 0; index < array1.length; index++){
            minimumSum+= Math.abs(array1[index] - array2[index]);
        }
        return minimumSum;
    }
}
// Time --> O(n log n).