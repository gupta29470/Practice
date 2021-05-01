/*
Using two loops keep outer loop as array2 length because we want to search
array2 element in array1 .
If array2 element found in array1 then we increment count

At last if count is equal to array2.length return "Yes" else return "No".
*/

class SubsetOfArray{
    public static void main(String[] args) {
        int array1[] = {10, 5, 2, 23, 19}, array2[] = {19, 5, 10} ;
        
        System.out.println(subsetOfArray(array1, array2));      
    }
    
    public static String subsetOfArray(int array1[], int array2[]){
        int count = 0;
        
        for (int index1 = 0; index1 < array2.length; index1++){
            for (int index2 = 0; index2 < array1.length; index2++){
                if (array2[index1] == array1[index2]){
                    count++;
                }
            }
        }
        if (count == array2.length){
            return "Yes";
        }
        else{
            return "No";
        }
    }
}
// Time --> O(n)  Space --> O(1)



/*
subsetOfArray function:
	-> sort array1 and array2
	
	-> create index1 and index2 to traverse array1 and array2 and initialize
	with zero
	
	-> while index1 < array1.length && index2 < array2.length:
		-> if (array1[index1] is equal to array2[index2]) then increment
		count and also increment index1 and index2
		
		-> else if (array1[index1] is less than array2[index2]) then
		increment index1
		
		-> else increment index2
	
At last if count is equal to array2.length return "Yes" else return "No".
*/
import java.util.*;

class SubsetOfArray{
    public static void main(String[] args) {
        int array1[] = {10, 5, 2, 23, 19}, array2[] = {19, 5, 3} ;
        
        System.out.println(subsetOfArray(array1, array2));      
    }
    
    public static String subsetOfArray(int array1[], int array2[]){
        
        int count = 0;
        
        Arrays.sort(array1);
        Arrays.sort(array2);
        
        int index1 = 0, index2 = 0;
        
        while (index1 < array1.length && index2 < array2.length){
            if (array1[index1] == array2[index2]){
                count++;
                index1++;
                index2++;
            }
            else if (array1[index1] < array2[index2]){
                index1++;
            }
            else{
                index2++;
            }
        }
        
        if (count == array2.length){
            return "Yes";
        }
        else{
            return "No";
        }
    }
}
// Time --> O(nlogn + mlogm) + O(m)(small array)
// Space --> O(1)



/*
 subsetOfArray function:
	-> create hashmap and put array1 element in hashmap
	
	-> traverse hashmap and check if array2 element contains in hashamp.
	if not contains return "No" or at last return "Yes" one of then will
	be trigger

*/

import java.util.*;

class SubsetOfArray {

    public static void main(String[] args) {
        int array1[] = {11, 1, 13, 21, 3, 7}, array2[] = {11, 3, 7, 1};

        System.out.println(subsetOfArray(array1, array2));
    }

    public static String subsetOfArray(int array1[], int array2[]) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int data : array1) {
            map.putIfAbsent(data, map.getOrDefault(map.get(data), 0) + 1);
        }

        for (int data : array2) {
            if (!map.containsKey(data)) {
                return "No";
            }
        }
        return "Yes";
    }
}

// Time --> O(n + m)  Space --> O(n)(array1)
