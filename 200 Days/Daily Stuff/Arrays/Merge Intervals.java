/*
mergeIntervals function:
	-> create a arraylist with type of int array 
	ArrayList<int[]> storeMerge = new ArrayList<>();
	-> if input array length is 0 or null then return
	return storeMerge.toArray(new int[0][]);
	
	-> if input array length is 1 then add array[0][0] and array[0][1]
	in list and return
	storeMerge.add(new int[]{array[0][0], array[0][1]});
    return storeMerge.toArray(new int[0][]);
	
	-> if mention array is sorted then dont need to sort
	
	-> if array is not sorted then sort array according to 1st element(start)
	of every sub array
	Arrays.sort(array, (data1, data2) -> data1[0] - data2[0]);
	
	-> create start and end varible to store 1st sub array
	
	-> traverse from index 1:
		-> if current start is less or equals to than previous end than
		end = max between current end and previous end
		
		-> else create new array of start and end and add in list
		storeMerge.add(new int[]{start, end});
		start will be updated to current start
		start = array[index][0];
        end = array[index][1];
		
		-> add last subarray in list
		storeMerge.add(new int[]{start, end});
		
		-> return list as 2d array
		return storeMerge.toArray(new int[0][]);
		
*/

import java.util.*;

class MergeIntervals {

    public static void main(String[] args) {

        int array[][] = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        int result[][] = mergeIntervals(array);

        for (int index1 = 0; index1 < result.length; index1++) {
            for (int index2 = 0; index2 < result[index1].length; index2++) {
                System.out.print(result[index1][index2] + " ");
            }
            System.out.println("");
        }

    }

    public static int[][] mergeIntervals(int array[][]) {

        ArrayList<int[]> storeMerge = new ArrayList<>();
        
        // if size == 0
        if (array.length == 0 || array == null) {
            return storeMerge.toArray(new int[0][]);
        }
        
        // if size == 1
        if (array.length == 1){
            storeMerge.add(new int[]{array[0][0], array[0][1]});
            return storeMerge.toArray(new int[0][]);
        }

        // sort the array if array is not sorted
        Arrays.sort(array, (data1, data2) -> data1[0] - data2[0]);

        // storing first sub array ie. start = 1 and end = 3
        int start = array[0][0];
        int end = array[0][1];

        // traverse from index 1 as 0 is already stored in start and end
        // variable
        for (int index = 1; index < array.length; index++) {
            // if current start is less or equals to than previous end
            if (array[index][0] <= end) {
                // max between current end and previous end
                end = Math.max(array[index][1], end);
            } // if it is not colliding
            else {
				// create new array of start and end and add in list
                storeMerge.add(new int[]{start, end});
                // start will be updated to current start
                start = array[index][0];
                end = array[index][1];
            }
        }
        // last subarray will be remainig after loop
        storeMerge.add(new int[]{start, end});

        return storeMerge.toArray(new int[0][]);
    }
}
// Time --> O(n logn) + O(n)