/*
		********************** BRUTE FORCE *************************
		
Here is it given that the total number of elements is always odd. 
Now, we have the formula that the (1+N*M)/2 th smallest element in an 
ordered(sorted) list is the median. Since the number of elements are odd 
there is no case of having more than one middle elements.We can think of 
a very simple approach where we will store all the elements of the matrix 
in a 1-Dimensional array and after sorting we will output the element at 
[(1+N*M)/2–1]th index.

Solution steps

1. First, create an array of size N*M and copy all the elements of the 
matrix in that array. You can copy either row-wise or column-wise.

2. After copying simply sort the entire array.

3. Output the element at the [(1+N*M)/2–1]th index as this will be the middle element partitioning the array in lower and upper halves.
*/

import java.util.*;

class MatrixMedian{
    public static void main(String[] args) {
        
        int matrix[][]= { {1,3,5}, {2,6,9}, {3,6,9} }; 
        
        System.out.println(matrixMedian(matrix));
    }
    
    public static int matrixMedian(int array[][]){
        int row = array.length, column = array[0].length;
        int tempArray[] = new int[row * column];
        int index = 0;
        
        for (int index1 = 0; index1 < row; index1++){
            for (int index2 = 0; index2 < column; index2++){
                tempArray[index++] = array[index1][index2];
            }
        }
        
        Arrays.sort(tempArray);
        
        return tempArray[(1 + row * column) / 2 - 1];
    }
}

/*
Time Complexity: O(N*M*log(N*M)

Space Complexity: O(N*M)
*/



/*
************************* EFFICIENT APPROACH **********************
Using Binary Search:
As binary search requires range and matrix is row wise sorted so
we find low as minimum in first column and high as maximum in last 
column.

Median of matrix in row wise sorted matrix formula is :
(row * column + 1) / 2

so we initialize our desired element is (row * column + 1) / 2

While low is less than equals to high:
	-> calculate mid 
	-> pass matrix and mid to numberOfSmallerEqualsElements function
	-> if numberOfSmallerEqualsElements is greater or equals to desiredElement:
		-> store mid in median and update high = mid - 1
		Note: we are not stopping once we find 
		numberOfSmallerEqualsElements is greater or equals to desiredElement
		because it is possible that mid value is not present in matrix so 
		we make sure we find until low <= high
	else if numberOfSmallerEqualsElements is less than k:
		-> update low = mid + 1

return median


numberOfSmallerEqualsElements function: This function is used to count
number of smaller or equals to elements than mid
	-> initialize index1 = 0 and index2 = matrix size - 1 and count = 0
	-> while index1 < matrix size && index2 >= 0:
		-> if current element is greater than k then decrement index2
		-> else : update count+= index2 + 1 and increment index1
		
	return count
*/


class MatrixMedian {

    public static void main(String[] args) {
        int m[][] = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};

        System.out.println(matrixMedian(m));
    }

    public static int matrixMedian(int matrix[][]) {
        int minimum = Integer.MAX_VALUE, maximum = Integer.MIN_VALUE;
        int row = matrix.length, col = matrix[0].length;

        for (int index = 0; index < row; index++) {
            minimum = Math.min(matrix[0][index], minimum);
            maximum = Math.max(matrix[index][col - 1], maximum);
        }

        int desiredElement = (row * col + 1) / 2;

        int low = minimum, high = maximum;
        int median = 0;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (numberOfSmallerEqualsElements(matrix, mid) >= desiredElement) {
                median = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return median;
    }

    public static int numberOfSmallerEqualsElements(int matrix[][], int value) {
        int size = matrix.length;
        int index1 = 0, index2 = size - 1;
        int count = 0;

        while (index1 < size && index2 >= 0) {
            if (matrix[index1][index2] > value) {
                index2--;
            } else {
                count += index2 + 1;
                index1++;
            }
        }
        return count;
    }
}
// // Time --> O(2n log(column))   Space --> O(1)

