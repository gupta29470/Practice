/*
if we want to minimize the money, we must buy candies at minimum cost and get 
candies of maximum costs for free. To maximize the money, we must do the reverse. 
Below is an algorithm based on this.

First Sort the price array.

For finding minimum amount :
  Start purchasing candies from starting 
  and reduce k free candies from last with
  every single purchase.

For finding maximum amount : 
   Start purchasing candies from the end 
   and reduce k free candies from starting 
   in every single purchase.
*/

import java.util.*;

class Candies{
    public static void main(String[] args) {
        int arr[] = { 3, 2, 1, 4 };
        int n = arr.length;
        int k = 2;
        Arrays.sort(arr);
        
        System.out.println("Minimum : " + minimumAmount(arr, n, k));
        System.out.println("Maximum : " + maximumAmount(arr, n, k));
    }
    
    public static int minimumAmount(int array[], int len, int k){
        int minimum = 0;
        
        for (int index = 0; index < len; index++){
			//purchasing candies from starting 
            minimum += array[index];
			
			// getting free from end
            len = len - k;
        }
        return minimum;
    }
    
    public static int maximumAmount(int array[], int len, int k){
        int maximum = 0;
        int limit = 0;
        for (int index = len - 1; index >= limit; index--){
			// purchasing candies from ending 
            maximum += array[index];
			
			// getting free from start
            limit = limit + k;
        }
        return maximum;
    }
}
// Time --> O(n logn)