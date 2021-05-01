/*
1. Do Merge Intervals and return newArray
2. If k is found in any range we are returning : start + k - 1
	eg : k = 4 and range is 1, 4.
	So as k is found in this range so we returning : 
	1(start) + 4(k) - 1 = 5 - 1 = 4
	
	Else if k is greater than range we are deducting k as we have checked this 
	range 
	
*/

import java.util.*;
 
class KthSmallestAgain{
    public static void main(String[] args) {
        
        int array[][] = {{1, 3}, {9, 15}};
        
        System.out.println(kthSmallestAgain(array, 4));
    }
    
    public static int kthSmallestAgain(int array[][], int k){
        Arrays.sort(array, (data1, data2) -> data1[0] - data2[0]);
        
        int newArray[][] = mergeIntervals(array);
        int answer = 0;

        for (int index = 0; index <= newArray.length; index++){
            if (((newArray[index][1] - newArray[index][0]) + 1) >= k){
                answer = (newArray[index][0] + k) - 1;
                break;
            }
            else{
                k = k - ((newArray[index][1] - newArray[index][0]) + 1);
            }
        }
        return answer;
    }
    
    public static int[][] mergeIntervals(int array[][]){
       
        ArrayList<int[]> storeMerged = new ArrayList<>();
        
        if (array.length == 1){
            storeMerged.add(new int[]{array[0][0], array[0][1]});
            return storeMerged.toArray(new int[0][]);
        }
        
        int start = array[0][0];
        int end = array[0][1];
        
        for (int index = 1; index < array.length; index++){
            if (end >= array[index][0]){
                end = Math.max(end, array[index][1]);
            }
            else{
                storeMerged.add(new int[]{start, end});
                start = array[index][0];
                end = array[index][1];
            }
        }
        
        storeMerged.add(new int[]{start, end});
        
        return storeMerged.toArray(new int[0][]);
    }
}