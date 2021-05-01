/*
Though the question was already answered, I am writing this to offer an informal, 
may be intuitive explanation:

We have to make (n-1)*(m-1) cuts, so we just need to decide on which cut to 
pick first.

Let us say we can have to choose between two cuts C1 and C2 with cost c1 and c2. 
Let us say c1>c2. Let the total current cost of the whole affair be denoted by C

If we choose C1 later than this step, it will add at least 
(depending on if you add it in the very next step or not) 
c1 to the whole cost, C. If we choose C2 later than this step, 
it will add at least c2 to the whole cost, C.

So we can just say that we can greedily choose C1 now because choosing it 
later would be worse than choosing C2 later.

Hence we choose in decreasing order of costs irrespective of 
type(horizontal, vertical) of cut.
*/


// Java program to divide a 
// board into m*n squares
import java.util.Arrays;
import java.util.Collections;
  
class GFG
{
    // method returns minimum cost to break board into
    // m*n squares
    static int minimumCostOfBreaking(Integer X[], Integer Y[], 
                                                 int m, int n)
    {
        int res = 0;
      
        // sort the horizontal cost in reverse order
        Arrays.sort(X, Collections.reverseOrder());
      
        // sort the vertical cost in reverse order
        Arrays.sort(Y, Collections.reverseOrder());
      
        // initialize current width as 1
        int hzntl = 1, vert = 1;
      
        // loop untill one or both
        // cost array are processed
        int i = 0, j = 0;
        while (i < m && j < n)
        {
            if (X[i] > Y[j])
            {
                res += X[i] * vert;
      
                // increase current horizontal
                // part count by 1
                hzntl++;
                i++;
            }
            else
            {
                res += Y[j] * hzntl;
      
                // increase current vertical 
                // part count by 1
                vert++;
                j++;
            }
        }
      
        // loop for horizontal array, 
        // if remains
        int total = 0;
        while (i < m)
            total += X[i++];
        res += total * vert;
      
        // loop for vertical array, 
        // if remains
        total = 0;
        while (j < n)
            total += Y[j++];
        res += total * hzntl;
      
        return res;
    }
      
    // Driver program
    public static void main(String arg[])
    {
        int m = 6, n = 4;
        Integer X[] = {2, 1, 3, 1, 4};
        Integer Y[] = {4, 1, 2};
        System.out.print(minimumCostOfBreaking(X, Y, m-1, n-1));
    }
}
  
  
  

import java.util.*;

class MinCost{
    public static void main(String[] args) {
        int row = 4, col = 6;
        int horizontal[] = {2, 1, 3, 1, 4};
        int vertical[] = {4, 1, 2};
        System.out.print(minimumCostOfBreaking(horizontal, vertical, row - 1, col - 1));
    }
    
    public static int minimumCostOfBreaking(int horizontal[], int vertical[],
            int row, int col){
        
        Arrays.sort(horizontal);
        Arrays.sort(vertical);
		
		 // initialize current width as 1
        int horizon = 1, verti = 1;
        int index1 = row - 1, index2 = col - 1;
        int result = 0;
        
        // loop untill one or both
        // cost array are processed
        while (index1 >= 0 && index2 >= 0){
            
            if (vertical[index1] < horizontal[index2]){
                result += horizontal[index2] * verti;
                
                // increase current horizontal
                // decrease part count by 1
                horizon++;
                index2--;
            }
            else{
                result += vertical[index1] * horizon;
                
                 // increase current vertical
                // decrease part count by 1
                verti++;
                index1--;
            }
        }
        
        int total = 0;
        
        // loop for horizontal array, 
        // if remains
        while (index1 >= 0){
            total += vertical[index1]; 
            index1--;
        }
        result += total * horizon;
        
        total = 0;
        
        // loop for vertical array, 
        // if remains
        while (index2 >= 0){
            total += horizontal[index2];
            index2--;
        }
        result += total * verti;
        
        return result;
    }
    
}