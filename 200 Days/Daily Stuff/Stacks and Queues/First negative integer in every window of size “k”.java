/*
Naive Approach: Run two loops. In the outer loop, take all subarrays(windows) of size k. In the inner loop, get the first 
negative integer of the current subarray(window).
*/

import java.util.*;

public class practice_1 {

	public static void main(String args[]) {
		int arr[] = { -8, 2, 3, -6, 10 };
		int k = 2;
		
		firstNegative(arr, k);
	}

	public static void firstNegative(int array[], int k) {
		int len = array.length;
		
		// Loop for each subarray(window) of size k
		for (int index1 = 0; index1 < len - k + 1; index1++) {
			boolean flag = false;
			
			 // traverse through the current window
			for (int index2 = 0; index2 < k; index2++) {
				
				// if a negative integer is found, then
            	// it is the first negative integer for
            	// current window. Print it, set the flag
            	// and break
				if (array[index1 + index2] < 0) {
					flag = true;
					System.out.print(array[index1 + index2] + " ");
					break;
				}
			}
			
			// if the current window does not
        	// contain a negative integer
			if (!flag) {
				System.out.print(0);
			}
		}

	}
}
// Time --> O((n-k+1)*k)



/*
Using Sliding Window Technique.

1. Create queue.

2. Loop from 0 to K initially and if element is less than 0 or negative then put its index in queue. Reason for putting index 
because because we have to move forward to array and consider K size window so we have to remove processed index from front.

3. Loop from K to n :

	4. if queue is not empty print array[queue.peek()]. Else print 0.
	
	5. Remove index which are out of window, queue.peek() < (index - k + 1) remove it.
	
	6. If current element is less than 0, add its index in queue.

7. Print last window result. if queue is not empty print array[queue.peek()]. Else print 0.
	
*/
import java.util.*;

public class practice_1 {

	public static void main(String args[]) {
		int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
		int k = 3;
		
		firstNegative(arr, k);
	}

	public static void firstNegative(int array[], int k) {
		int len = array.length;
		
		Queue<Integer> queue = new LinkedList<>();
		int index = 0;
		
		for (index = 0; index < k; index++) {
			if (array[index] < 0) {
				queue.add(index);
			}
		}
		
		//System.out.println(queue);
		
		for (; index < len; index++) {
			if (!queue.isEmpty()) {
				System.out.print(array[queue.peek()] + " ");
			}
			else {
				System.out.print("0" + " ");
			}
			
			while ((!queue.isEmpty()) && (queue.peek() < (index - k + 1))) {
				queue.poll();
			}
			
			if (array[index] < 0) {
				queue.add(index);
			}
		}
		
		if (!queue.isEmpty()) {
			System.out.print(array[queue.peek()] + " ");
			queue.poll();
		}
		else {
			System.out.print("0" + " ");
		}
	}
}

// Time --> O(n)   Space --> O(k) for queue.



/*
 It is also possible to accomplish this with constant space. The idea is to have a variable firstNegativeIndex to keep track 
 of the first negative element in the k sized window. At every iteration, we skip the elements which no longer fall under
 the current k size window (firstNegativeIndex <= i – k) as well as the positive elements. 

*/

import java.util.*;
 
class GFG{
     
static void printFirstNegativeInteger(int arr[],
                                      int k, int n)
{
    int firstNegativeIndex = 0;
    int firstNegativeElement;
     
    for(int i = k - 1; i < n; i++)
    {
         
        // Skip out of window and positive elements
        while ((firstNegativeIndex < i ) &&
               (firstNegativeIndex <= i - k ||
            arr[firstNegativeIndex] > 0))
        {
            firstNegativeIndex ++;
        }
         
        // Check if a negative element is
        // found, otherwise use 0
        if (arr[firstNegativeIndex] < 0)
        {
            firstNegativeElement = arr[firstNegativeIndex];
        }
        else
        {
            firstNegativeElement = 0;
        }
        System.out.print(firstNegativeElement + " ");
    }
}
 
// Driver code
public static void main(String[] args)
{
    int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
    int n = arr.length;
    int k = 3;
     
    printFirstNegativeInteger(arr, k, n);   
}
}
/*
Time Complexity: O(n) 
Auxiliary Space: O(1)
*/


























