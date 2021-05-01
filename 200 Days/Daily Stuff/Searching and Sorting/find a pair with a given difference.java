
/*
The naive solution would be to consider every pair in a given array and 
return if the desired difference is found. The time complexity of this 
solution would be n^2.
*/
class Pair{
    public static void main(String[] args) {
        
        int array[] = {1, 8, 30, 40, 100};
        
        System.out.println(pair(array, 60));
    }
    
    public static boolean pair(int array[], int key){
        for (int index1 = 0; index1 < array.length; index1++){
            for (int index2 = 1; index2 < array.length; index2++){
                if (array[index2] - array[index1] == key){
                    System.out.println(array[index1] + " " + array[index2]);
                    return true;
                }
            }
        }
        return false;
    }
}
// Time --> O(n^2)


/*

We can use a set to solve this problem in linear time. 
The idea is to insert each array element arr[i]  into a set. We also check 
if element  (arr[i] - diff)  or (arr[i] + diff) already exists in the set 
or not. If the element is seen before, print the pair (arr[i], arr[i] - diff)
 or (arr[i] + diff, arr[i])
*/

import java.util.HashSet;
import java.util.Set;
 
class Main
{
    // Function to find a pair with the given difference in the array.
    // This method does not handle duplicates in the array
    public static void findPair(int[] A, int diff)
    {
        // array is unsorted
 
        // take an empty set
        Set<Integer> set = new HashSet<>();
 
        // do for every array element
        for (int i: A)
        {
            // check if pair with the given difference `(i, i-diff)` exists
            if (set.contains(i - diff)) {
                System.out.println("(" + i + ", " + (i - diff) + ")");
            }
 
            // check if pair with the given difference `(i+diff, i)` exists
            if (set.contains(i + diff)) {
                System.out.println("(" + (i + diff) + ", " + i + ")");
            }
 
            // insert the current element into the set
            set.add(i);
        }
    }
 
    public static void main(String[] args)
    {
        int[] A = { 1, 5, 2, 2, 2, 5, 5, 4};
        int diff = 3;
 
        findPair(A, diff);
    }
}