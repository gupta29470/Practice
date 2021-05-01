/*
*********************** BRUTE FORCE *********************************
Create a tempArray of size n * n and put all the elements in tempArray
and sort tempArray and return index k - 1 of tempArray.
*/

import java.util.*;

class kthSmallest {

    public static void main(String[] args) {

        int matrix[][] = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {25, 29, 37, 48},
            {32, 33, 39, 50},};
        
        int k = 7;
        System.out.println(kthSmallest(matrix, k));
    }

    public static int kthSmallest(int matrix[][], int k) {
        int tempArray[] = new int[matrix.length * matrix.length];
        int index = 0;

        for (int index1 = 0; index1 < matrix.length; index1++) {
            for (int index2 = 0; index2 < matrix.length; index2++) {
                tempArray[index++] = matrix[index1][index2];
            }
        }

        Arrays.sort(tempArray);

        return tempArray[k - 1];
    }
}
// Time --> O(n * n)   Space --> O(n * n)



/*
*************************** EFFICIENT APPROACH ************************
Using Binary seacrh:
As matrix is sorted and we know that kth smallest element will be range
between 1st element of matrix and last element of matrix.
So appoint low = first element of matrix and high = last element of matrix.

While low is less than equals to high:
	-> calculate mid 
	-> pass matrix and mid to numberOfSmallerEqualsElements function
	-> if numberOfSmallerEqualsElements is greater or equals to k:
		-> store mid in answer and update high = mid - 1
		Note: we are not stopping once we find 
		numberOfSmallerEqualsElements is greater or equals to k because
		it is possible that mid value is not present in matrix so 
		we make sure we find until low <= high
	else if numberOfSmallerEqualsElements is less than k:
		-> update low = mid + 1

return answer


numberOfSmallerEqualsElements function: This function is used to count
number of smaller or equals to elements than mid
	-> initialize index1 = 0 and index2 = matrix size - 1 and count = 0
	-> while index1 < matrix size && index2 >= 0:
		-> if current element is greater than k then decrement index2
		-> else : update count+= index2 + 1 and increment index1
		
	return count
*/

class kthSmallest {

    public static void main(String[] args) {

        int matrix[][] = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15},};

        int k = 5;
        System.out.println(kthSmallest(matrix, k));
    }
    
    public static int kthSmallest(int matrix[][], int k){
        
        int size = matrix.length;
        int low = matrix[0][0], high = matrix[size - 1][size - 1];
        int answer = 0;
        
        while (low <= high){
            int mid = (low + high) / 2;
            
            if (numberOfSmallerEqualsElements(matrix, mid) >= k){
                answer = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return answer;
    }
    
    public static int numberOfSmallerEqualsElements(int matrix[][], int value){
       
        int size = matrix.length;
        int index1 = 0, index2 = size - 1, count = 0;
        
        while (index1 < size && index2 >= 0){
            if (matrix[index1][index2] > value){
                index2--;
            }
            else{
                count+= index2 + 1;
                index1++;
            }
        }
        return count;
    }
    
}

// Time --> O(2n log(maxValue))   Space --> O(1)
// 2n for numberOfSmallerEqualsElements function(while (index1 < size && index2 >= 0))  
// and log(maxValue) will be used by kthSmallest function(binary search)


