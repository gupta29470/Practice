/*
Run two loops to generate all subarrays of size k and find maximum and minimum values. Finally return sum of all 
maximum and minimum elements. 
*/
import java.util.*;

public class practice_1 {
	
	public static void main(String args[]) {
		int array[] = {2, 5, -1, 7, -3, -1, -2} ;
		int k = 4;
		
		sum(array, k);
	}
	
	public static void sum(int array[], int k) {
		int len = array.length;
		int sum = 0;
		
		for (int index1 = 0; index1 < len - k + 1; index1++) {
			int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
			for (int index2 = 0; index2 < k; index2++) {
				
				if (array[index1 + index2] > max) {
					max = array[index1 + index2];
				}
				
				if (array[index1 + index2] < min) {
					min = array[index1 + index2];
				}
			}
			sum += max + min;
		}
		System.out.print(sum);
	}
}
// Time --> O(n * k)


/*
Using Two Deques:

Reason for using two queues:
1. minimumIndexes deque is used to store indexes of increasing order element's index.
2. maximumIndexes deque is used to store indexes of deccreasing order element's index.

3. loop 0 to k:

	4. if curent element is smaller than array[minimumIndexes.peekLast()] then remove all greater elements index from last 
	from minimumIndexes.
	
	5. if curent element is greater than array[maximumIndexes.peekLast()] then remove all smaller elements index from last 
	from maximumIndexes.
	
	6. add current indexes in both deques

7. loop k to n:
	
	8. sum += array[minimumIndexes.peekFirst()] + array[maximumIndexes.peekFirst()] 
	
	9. remove all indexes which are out of window, if minimumIndexes.peekFirst() <= index - k remove it 
	
	10. 6. remove all indexes which are out of window, if maximumIndexes.peekFirst() <= index - k remove it 
	
	11. if curent element is smaller than array[minimumIndexes.peekLast()] then remove all greater elements index from last 
	from minimumIndexes.
	
	12. if curent element is greater than array[maximumIndexes.peekLast()] then remove all smaller elements index from last 
	from maximumIndexes.
	
	13. if curent element is smaller than array[minimumIndexes.peekLast()] then remove all greater elements index from last 
	from minimumIndexes.
	
	14. if curent element is greater than array[maximumIndexes.peekLast()] then remove all smaller elements index from last 
	from maximumIndexes.
	
	15. add current indexes in both deques
*/
import java.util.*;

public class practice_1 {
	
	public static void main(String args[]) {
		int array[] = {2, 5, -1, 7, -3, -1, -2} ;
		int k = 4;
		
		sum(array, k);
	}
	
	public static void sum(int array[], int k) {
		int len = array.length;
		int sum = 0;
		Deque<Integer> minimumIndexes = new LinkedList<>();
		Deque<Integer> maximumIndexes = new LinkedList<>();
		int index;
		
		for (index = 0; index < k; index++) {
			
			// Remove all previous greater elements
            // that are useless.
			while(!minimumIndexes.isEmpty() && array[minimumIndexes.peekLast()] >= array[index]) {
				minimumIndexes.removeLast();
			}
			
			// Remove all previous smaller that are elements
            // are useless.
			while (!maximumIndexes.isEmpty() && array[maximumIndexes.peekLast()] <= array[index]) {
				maximumIndexes.removeLast();
			}
			
			// Add current element at rear of both deque
			minimumIndexes.add(index);
			maximumIndexes.add(index);
		}
		
		for (; index < len; index++) {
			
			// Element at the front of the deque 'minimumIndexes' & 'maximumIndexes'
            // is the largest and smallest
            // element of previous window respectively
			sum += array[minimumIndexes.peekFirst()] + array[maximumIndexes.peekFirst()];
			
			// Remove all elements which are out of this
            // window
			while (!minimumIndexes.isEmpty() && minimumIndexes.peekFirst() <= (index - k)) {
				minimumIndexes.removeFirst();
			}
			
			while (!maximumIndexes.isEmpty() && maximumIndexes.peekFirst() <= (index - k)) {
				maximumIndexes.removeFirst();
			}
			
			// Remove all previous greater elements
            // that are useless.
			while(!minimumIndexes.isEmpty() && array[minimumIndexes.peekLast()] >= array[index]) {
				minimumIndexes.removeLast();
			}
			
			// Remove all previous smaller that are elements
            // are useless.
			while (!maximumIndexes.isEmpty() && array[maximumIndexes.peekLast()] <= array[index]) {
				maximumIndexes.removeLast();
			}
			
			// Add current element at rear of both deque
			minimumIndexes.add(index);
			maximumIndexes.add(index);
		}
		
		sum += array[minimumIndexes.peekFirst()] + array[maximumIndexes.peekFirst()];
		System.out.println(sum);
	}
}

// Time --> O(n)  Space --> O(2 * k)

































