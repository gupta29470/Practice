/*
solution is based on the fact that the largest value should be scaled maximum and 
smallest value should be scaled minimum. So we multiply minimum value of i with 
minimum value of arr[i]. So, sort the given array in increasing order and compute 
the sum of ari]*i, where i = 0 to n-1.

*/
import java.util.*;

public class prat {

    public static void main(String[] args) {
        int arr[] = {3, 5, 6, 1};
        int n = arr.length;
        
        System.out.println(maximizeSum(arr, n));
    }
    
    public static int maximizeSum(int array[], int len){
        
        // Sort the array
        Arrays.sort(array);
        int sum = 0;
        
        // Finding the sum of arr[i]*i
        for (int index = 0; index < len; index++){
            sum+= array[index] * index;
        }
        return sum;
    }
}
// Time --> O(n logn)