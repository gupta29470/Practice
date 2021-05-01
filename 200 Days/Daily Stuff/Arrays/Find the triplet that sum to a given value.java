/*
using three loops:
	-> index1 starts with 0
	-> index2 starts with index1 + 1
	-> index3 starts with index2 + 1
	
	if (array[index1] + array[index2] + array[index3] is equal to sum) then
	print (array[index1], array[index2], array[index3])
*/

class Triplet {

    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5};

        triplets(array, 9);

    }

    public static void triplets(int array[], int sum) {
          
        for (int index1 = 0; index1 < array.length; index1++){
            for (int index2 = index1 + 1; index2 < array.length; index2++){
                for (int index3 = index2 + 1; index3 < array.length; index3++){
                    if (array[index1] + array[index2] + array[index3] == sum){
                        System.out.print(array[index1] + " " + array[index2] +
                                " " + array[index3]);
                        System.out.println("");
                    }
                }
            }
        }
    }

}

// Time --> O(n^3)  Space --> O(1)



/*
Using sorting and two pointers
triplets function:
	-> sort the array
	
	-> for loop from 0 to n - 2
		-> initialize two pointers left = index + 1 (starts next from currentSum
		element) and right = n - 1(last)
		-> while (left < right)
			-> if array[index] + array[left] + array[right] == sum then
			print (array[index], array[left], array[right])

Main objective for using for loop because we have to find 3 number 
we assuming out of 3 one number is for loop's element and remaining
2 is left's and right's element
*/

import java.util.*;

class Triplet {

    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5};

        triplets(array, 9);

    }

    public static void triplets(int array[], int sum) {

        Arrays.sort(array);
        
        for (int index = 0; index < array.length - 1; index++){
            int left = index + 1;
            int right = array.length - 1;
            
            while (left < right){
                if (array[index] + array[left] + array[right] == sum){
                    System.out.print(array[index] + " " + array[left] + " " +
                            array[right]);
                    System.out.println("");
                    return;
                }
                else if (array[index] + array[left] + array[right] < sum){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
    }

}
// Time --> O(nLogn) + O(n^2)  Space --> O(1)



/*
Using Hash Set
triplets function:
	-> 1st for loop from 0 to n - 1
		-> create hash set to store elements uniquely
		-> initialize current sum = sum - array[index1] because outer 
		loop element may be 1 element out of 3 and task is reduced to 
		find 2 other element
		-> inner loop from index1 + 1 to n - 1
			-> if set.contains(currentSum - inner loop's current element)
			then print (array[index1], array[index2] and 
			currentSum - array[index2])
			-> else addd inner loop's element in set
*/

import java.util.*;

class Triplet {

    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5};

        triplets(array, 9);

    }

    public static void triplets(int array[], int sum) {

    // 1st for loop from 0 to n - 1
		for (int index1 = 0; index1 < array.length; index1++){
			
			// create hash set to store elements uniquely
            Set<Integer> set = new HashSet<>();
			
	/* initialize current sum = sum - array[index1] because outer 
		loop element may be 1 element out of 3 and task is reduced to 
		find 2 other element
	*/		int currentSum = sum - array[index1];
	
			// inner loop from index1 + 1 to n - 1
            for (int index2 = index1 + 1; index2 < array.length; index2++){
				
		// if set.contains(currentSum - inner loop's current element)
                if (set.contains(currentSum - array[index2])){
					
		// print (array[index1], array[index2] and 
			//currentSum - array[index2])
                    System.out.print(array[index1] + " " + array[index2]
                    + " " + (currentSum - array[index2]));
                    System.out.println("");
                }
				
				// else addd inner loop's element in set
                else{
                    set.add(array[index2]);
                }
            }
        }
    }

}

// Time --> O(n^2)  Space --> O(n)
