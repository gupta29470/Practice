/*
A Naive Solution is to generate all possible quadruples and compare the 
sum of every quadruple with X. The following code implements this simple 
method using four nested loops.
*/
class Quadruplets {

    public static void main(String[] args) {
        int array[] = {2, 7, 4, 0, 9, 5, 1, 3};
        int sum = 20;

        System.out.println(quadruplets(array, sum));
    }

    public static boolean quadruplets(int array[], int sum) {
        int size = array.length;
        for (int index1 = 0; index1 < size - 3; index1++) {
            for (int index2 = index1 + 1; index2 < size - 2; index2++) {
                for (int index3 = index2 + 1; index3 < size - 1; index3++) {
                    for (int index4 = index3 + 1; index4 < size; index4++) {
                        if (array[index1] + array[index2] + array[index3]
                                + array[index4] == sum) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
// Time --> O(n^4)



/*
Following are the detailed steps.
1) Sort the input array.
2) Fix the first element as A[index1] where index1 is from 0 to n–3. 
After fixing the first element of quadruple, fix the second element as 
A[index2] where index2 varies from index1+1 to n-2. 
Find remaining two elements in O(n) using two pointers, i.e index3 starts 
from index2 + 1 and index index4 starts from n - 1

using two for loops and one while loop for 2 pointers

 -> if (array[index1] + array[index2] + array[index3]
                            + array[index4] == sum) return true

-> else if (array[index1] + array[index2] + array[index3]
                            + array[index4] < sum) {
                        increment index3
                    } 
-> else if (array[index1] + array[index2] + array[index3]
                            + array[index4] > sum) {
                        decrement index4
                    } 
*/
import java.util.*;

class Quadruplets {

    public static void main(String[] args) {
        int array[] = {2, 7, 4, 0, 9, 5, 1, 3};
        int sum = 20;

        System.out.println(quadruplets(array, sum));
    }

    public static boolean quadruplets(int array[], int sum) {
        int size = array.length;
        Arrays.sort(array);

        for (int index1 = 0; index1 < size - 3; index1++) {
            for (int index2 = index1 + 1; index2 < size - 2; index2++) {
                int index3 = index2 + 1, index4 = size - 1;
                while (index3 <= index4) {
                    if (array[index1] + array[index2] + array[index3]
                            + array[index4] == sum) {
                        return true;
                    } 
                    else if (array[index1] + array[index2] + array[index3]
                            + array[index4] < sum) {
                        index3++;
                    } 
                    else {
                        index4--;
                    }
                }
            }
        }
        return false;
    }
}
// Time --> O(n log n) + O(n ^3) 
// O(n log n): Sorting
// O(n ^ 3): 3 loops




/*
Using Hash Map:
The idea is to consider every pair of elements in the array one by one and 
insert it into a map. For each pair of elements (i, j) , calculate the 
remaining sum. If the remaining sum exists in the map and elements 
involved in the previous occurrence doesn’t overlap with the current pair, 
i.e., ((i, j, i, y) or (i, j, x, i) or (i, j, j, y) or (i, j, x, j))
, print the quadruplet and return.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
class Pair {
    public int x, y;
 
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
 
class Main
{
    // Function to check if quadruplet exists in an array with the given sum
    public static boolean quadTuple(int[] A, int n, int sum)
    {
        // create an empty map
        // `key` —> sum of a pair in the array
        // `value` —> list storing an index of every pair having that sum
        Map<Integer, List<Pair>> map = new HashMap<>();
 
        // consider each element except the last element
        for (int i = 0; i < n - 1; i++)
        {
            // start from the i'th element until the last element
            for (int j = i + 1; j < n; j++)
            {
                // calculate the remaining sum
                int val = sum - (A[i] + A[j]);
 
                // if the remaining sum is found on the map,
                // we have found a quadruplet
                if (map.containsKey(val))
                {
                    // check every pair having a sum equal to the remaining sum
                    for (Pair pair: map.get(val))
                    {
                        int x = pair.x;
                        int y = pair.y;
 
                        // if quadruplet doesn't overlap, print it and
                        // return true
                        if ((x != i && x != j) && (y != i && y != j))
                        {
                            System.out.print("Quadruplet Found ("
                                        + A[i] + ", " + A[j] + ", "
                                        + A[x] + ", " + A[y] + ")");
                            return true;
                        }
                    }
                }
 
                // insert the current pair into the map
 
                // null check (Java 8)
                map.putIfAbsent(A[i] + A[j], new ArrayList<>());
                map.get(A[i] + A[j]).add(new Pair(i, j));
            }
        }
 
        // return false if quadruplet doesn't exist
        return false;
    }
 
    public static void main(String[] args)
    {
        int[] A = { 2, 7, 4, 0, 9, 5, 1, 3 };
        int sum = 20;
 
        if (!quadTuple(A, A.length, sum)) {
            System.out.print("Quadruplet Doesn't Exist");
        }
    }
}
// Time --> O(n^2)  Space --> O(n^2)