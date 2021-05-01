/*
using two loops. outer loop will traverse array from 0 to n - 1
and inner loop will traverse from outer loop index + 1 to n - 1 for
each element. 
if outer loop element and inner loop element is equal to "k" then
increment count.
*/

class CountPairsWithGivenSum {

    public static void main(String[] args) {

        int array[] = {10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1};

        System.out.println(countPairs(array, 11));
    }

   public static int countPairs(int array[], int k){
       int count = 0;
       
       for (int index1 = 0; index1 < array.length - 1; index1++){
           for (int index2 = index1 + 1; index2 < array.length; index2++){
               if (array[index1] + array[index2] == k){
                   count++;
               }
           }
       }
       return count;
   }
}
// Time --> O(n)   Space --> O(1)



/*
countPairs function:
	1. Create a map to store frequency of each number in the array. 
	(Single traversal is required)
	
	2. In the next traversal, for every element check if map contains
	k - current element if yes then twiceCount will be update to 
	frequency of k - currrent element.
	if k - current element == current element then decrement twiceCount
	Because for eg : array = 3, 2, 1 and k = 6.
	frequencies: 3 -> 1, 2 -> 1, 1 -> 1
	In second traversal we found (6 - 3) is in hash map so we update 
	twiceCount to frequency of 3 but there is no other element which can
	make pair to give us k value i.e 6 . As (6 - 3) == 3 we decrement
	twiceCount
	
	3. After completion of second traversal, we’d have twice the required 
	value stored in counter because every pair is counted two times. 
	Hence divide count by 2 and return. 
*/

import java.util.*;

class CountPairsWithGivenSum {

    public static void main(String[] args) {

        int array[] = {10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1};

        System.out.println(countPairs(array, 11));
    }

    public static int countPairs(int array[], int k) {
        int twiceCount = 0;

        Map<Integer, Integer> map = new HashMap<>();

        // Store counts of all elements in map
		for (int data : array) {
            if (!map.containsKey(data)) {
                map.put(data, 1);
            } else {
                map.put(data, map.get(data) + 1);
            }
        }
        
        
        // iterate through each element and increment the
        // count (Notice that every pair is counted twice)
		for (int index = 0; index < array.length; index++) {
            if (map.get(k - array[index]) != null) {
                twiceCount += map.get(k - array[index]);
            }

            
			// Explain in 2nd step above
			// if (arr[i], arr[i]) pair satisfies the
            // condition, then we need to ensure that the
            // count is decreased by one such that the
            // (arr[i], arr[i]) pair is not considered
			if ((k - array[index]) == array[index]) {
                twiceCount--;
            }
        }
        return twiceCount / 2;
    }
}
