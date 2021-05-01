/*
Copy input array to temp array and sort temp array.
Loop input array if current element of input array is not same as current element
of temp array then increment swap. Find current temp element in input array 
using another loop and swap input array current element with the element who
deserve to be that place.
*/

import java.util.*;
 
class MinimumSwaps{
    public static void main(String[] args) {
        
        int array[] = {101, 758, 315, 730, 472, 
                         619, 460, 479};
        
        System.out.println(minimumSwaps(array));
    }
    
    // Return the minimum number
    // of swaps required to sort the array
    public static int minimumSwaps(int array[]){
        
        int copyArray[] = Arrays.copyOfRange(array, 0, array.length);
        Arrays.sort(copyArray);
        int swaps = 0;
        
        for (int index = 0; index < array.length; index++){
            
            // This is checking whether
            // the current element is
            // at the right place or not
            if (array[index] != copyArray[index]){
                swaps++;
                
                // Swap the current element
                // with the right index
                // so that arr[0] to arr[i] is sorted
                int _index = indexOf(array, index, copyArray[index]);
                swap(array, index, _index);
            }
        }
        return swaps;
    }
    
    public static int indexOf(int array[], int start, int key){
        for (int index = start; index < array.length; index++){
            if (array[index] == key){
                return index;
            }
        }
        return -1;
    }
    
    public static void swap(int array[], int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
// Time --> O(n ^ 2)   Space --> O(n)



/*
1. Copy input array to temp array and sort temp array.

2. Create a map and loop input array to store key as current element and value as 
its index.

3. Loop input array if if current element of input array is not same as current element
of temp array then increment swap. Find current temp element index in map and store 
in tempindex variable and swap current element and index we get from map.

*/

import java.util.*;
 
class MinimumSwaps{
    public static void main(String[] args) {
        
        int array[] = {101, 758, 315, 730, 472, 
                         619, 460, 479};
        
        System.out.println(minimumSwaps(array));
    }
    
    // Return the minimum number
    // of swaps required to sort the array
    public static int minimumSwaps(int array[]){
        
        int copyArray[] = Arrays.copyOfRange(array, 0, array.length);
        Arrays.sort(copyArray);
        int swaps = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int index = 0; index < array.length; index++){
            map.put(array[index], index);
        }
        
        System.out.println(map);
        
        for (int index = 0; index < array.length; index++){
            if (array[index] != copyArray[index]){
                swaps++;
                int invalid = array[index];
                
                swap(array, index, map.get(copyArray[index]));
                
                map.put(invalid, map.get(copyArray[index]));
                map.put(copyArray[index], index);
            }
        }
        
        return swaps;
    }
    
    
    public static void swap(int array[], int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
// Time --> O(2n)  Space --> O(2n)