/*
A Simple Solution is to run three loops to consider all triplets one by one. 
For every triplet, compare the sums and increment count if triplet sum is smaller 
than given sum.
*/
class Triplets{
    public static void main(String[] args) {
        
        int array[] = {5, 1, 3, 4, 7};
        int sum = 12;
        
        System.out.println(triplets(array, sum));
    }
    
    public static int triplets(int array[], int sum){
        int count = 0;
        
        for (int index1 = 0; index1 < array.length - 2; index1++){
            for (int index2 = index1 + 1; index2 < array.length - 1; index2++){
                for (int index3 = index2 + 1; index3 < array.length; index3++){
                    if (array[index1] + array[index2] + array[index3] < sum){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
// Time --> O(n^3)



/*
1) Sort the input array in increasing order.
2) Initialize result as 0.
3) Run a loop from i = 0 to n-2.  An iteration of this loop finds all
   triplets with arr[i] as first element.
     a) Initialize other two elements as corner elements of subarray
        arr[i+1..n-1], i.e., j = i+1 and k = n-1
     b) Move j and k toward each other until they meet, i.e., while (j = sum), 
	 then do k--

            // Else for current i and j, there can (k-j) possible third elements
            // that satisfy the constraint.
            (ii) Else Do ans += (k - j) followed by j++ 
*/

import java.util.*;

class Triplets {

    public static void main(String[] args) {

        int array[] = {5, 1, 3, 4, 7};
        int sum = 12;

        System.out.println(triplets(array, sum));
    }

    public static int triplets(int array[], int sum) {
        int count = 0;
        Arrays.sort(array);

        for (int index1 = 0; index1 < array.length - 2; index1++) {
            int index2 = index1 + 1, index3 = array.length - 1;
            while (index2 <= index3) {
                if (array[index1] + array[index2] + array[index3] >= sum) {
                    index3--;
                } 
                else{
                    count += (index3 - index2);
                    index2++;
                }
            }
        }
        return count;
    }
}
// Time --> O(n^2)
