/*
Consider the sorted permutation of the given array a1, a1, a2,…., an – 1, an such that 
a1 < a2 < a3…. < an – 1 < an. 
Now, to obtain the answer having maximum sum of difference between consecutive element, 
arrange element in following manner: 
a1, an, a2, an-1,…., an/2, a(n/2) + 1 
We can observe that the arrangement produces the optimal answer, as all a1, a2, a3,….., 
a(n/2)-1, an/2 are subtracted twice while a(n/2)+1 , a(n/2)+2, a(n/2)+3,….., an – 1, an are 
added twice. 
Note – a(n/2)+1 This term is considered only for even n because for odd n, it is added once 
and substracted once and hence cancels out. 
 
*/

// Java program to maximize the sum of difference
// between consecutive elements in circular array
import java.io.*;
import java.util.Arrays;
  
class MaxSum
{
    // Return the maximum Sum of difference between
    // consecutive elements.
    static int maxSum(int arr[], int n)
    {
        int sum = 0;
  
        // Sorting the array.
        Arrays.sort(arr);
      
        // Subtracting a1, a2, a3,....., a(n/2)-1,
        // an/2 twice and adding a(n/2)+1, a(n/2)+2,
        // a(n/2)+3,....., an - 1, an twice.
        for (int i = 0; i < n/2; i++)
        {
            sum -= (2 * arr[i]);
            sum += (2 * arr[n - i - 1]);
        }
      
        return sum;
    }
 
    // Driver Program
    public static void main (String[] args)
    {
        int arr[] = { 4, 2, 1, 8 };
        int n = arr.length;
        System.out.println(maxSum(arr, n));
    }
}

// Time --> O(n logn)