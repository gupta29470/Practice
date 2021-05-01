/*
Given an n x n matrix mat[n][n] of integers, find the maximum value of 
mat(c, d) – mat(a, b) over all choices of indexes such that both c > a 
and d > b.

Example:

Input:
mat[N][N] = {{ 1, 2, -1, -4, -20 },
             { -8, -3, 4, 2, 1 }, 
             { 3, 8, 6, 1, 3 },
             { -4, -1, 1, 7, -6 },
             { 0, -4, 10, -5, 1 }};
Output: 18
The maximum value is 18 as mat[4][2] 
- mat[1][0] = 18 has maximum difference. 
*/


/*
************************ BRUTE FORCE APPROACH **************************
A simple solution would be to apply Brute-Force. For all values mat(a, b) 
in the matrix, we find mat(c, d) that has maximum value such that c > a 
and d > b and keeps on updating maximum value found so far. We finally 
return the maximum value.
*/
class SpecificPair {

    public static void main(String[] args) {

        int matrix[][] = {{1, 2, -1, -4, -20},
        {-8, -3, 4, 2, 1},
        {3, 8, 6, 1, 3},
        {-4, -1, 1, 7, -6},
        {0, -4, 10, -5, 1}};

        System.out.println(specificPair(matrix));;
    }

    public static int specificPair(int matrix[][]) {

        int maximum = Integer.MIN_VALUE;
        int size = matrix.length;

        for (int index1 = 0; index1 < size - 1; index1++) {
            for (int index2 = 0; index2 < size - 1; index2++) {
                for (int index3 = index1 + 1; index3 < size; index3++) {
                    for (int index4 = index2 + 1; index4 < size; index4++) {
                        if (maximum < (matrix[index3][index4] - 
						matrix[index1][index2])) {
                            maximum = matrix[index3][index4] - 
							matrix[index1][index2];
                        }
                    }
                }
            }
        }
        return maximum;
    }

}
// Time --> O(n ^ 4)   Space --> O(1)



/*
********************** EFFICIENT APPROACH ********************************
An efficient solution uses extra space. We pre-process the matrix such 
that index(i, j) stores max of elements in matrix from (i, j) to (N-1, N-1)
and in the process keeps on updating maximum value found so far. 
We finally return the maximum value.


We are creating extra space or extra matrix of size input matrix
(storeMaximum)
Last element of storeMaximum will be last element of input matrix

Step 1: Fill last row :
	-> initialize column from second last column and fill current 
	index value of storeMaximum with max(next element of 
	storeMaximum which is already filled, current element of matrix)

Step 2: Fill last column: 
	-> -> initialize row from second last column and fill current 
	index value of storeMaximum with max(next element of 
	storeMaximum which is already filled, current element of matrix)
	
Step 3: Fill the remainig parts of storeMaximum and also check if 
subtraction of current element of matrix and next element of 
storeMaximum is greater than maxValue then update maxValue.
Fill current element of storeMaximum with max(current element of matrix,
storeMaximum next row, current column, store maximum current row, next
column)

return max column


input matrix  and  		storeMaximum matrix:
1   2 -1 -4 -20 			10 10 10 7 3 
-8 -3 4  2 	1				10 10 10 7 3 
3   8 6  1   3 				10 10 10 7 3 
-4 -1 1  7 	-6 				10 10 10 7 1 
0  -4 10 -5  1 				10 10 10 1 1 
 


		

*/

class SpecificPair {

    public static void main(String[] args) {

        int matrix[][] = {{1, 2, -1, -4, -20},
        {-8, -3, 4, 2, 1},
        {3, 8, 6, 1, 3},
        {-4, -1, 1, 7, -6},
        {0, -4, 10, -5, 1}};

        System.out.println(specificPair(matrix.length, matrix));;
    }

    static int specificPair(int N, int matrix[][]) {
        //stores maximum value 
        int maxValue = Integer.MIN_VALUE;
        
        // storeMaximum[i][j] stores max of elements in matrix 
        // from (i, j) to (N-1, N-1) 
        int storeMaximum[][] = new int[N][N];
        
        // last element of storeMaximumr will be same's as of 
        // the input matrix 
        storeMaximum[N - 1][N - 1] = matrix[N - 1][N - 1];
        
         // preprocess last row 
        for (int index = N - 2; index >= 0; index--){
            storeMaximum[N - 1][index] = Math.max(storeMaximum[N - 1][index + 1],
                    matrix[N - 1][index]);
        }
        
        // preprocess last column 
        for (int index = N - 2; index >= 0; index--){
            storeMaximum[index][N - 1] = Math.max(storeMaximum[index + 1]
			[N - 1],
                    matrix[index][N - 1]);
        }
        
        // preprocess rest of the matrix from bottom 
        for (int index1 = N - 2; index1 >= 0; index1--){
            for (int index2 = N - 2; index2 >= 0; index2--){
                // Update maxValue
                maxValue = 
                    Math.max(maxValue, storeMaximum[index1 + 1][index2 + 1]
					- matrix[index1][index2]);
                
                // set storeMaximum (i, j) 
                storeMaximum[index1][index2] = Math.max(matrix[index1]
				[index2], Math.max(storeMaximum[index1 + 1][index2], 
                                storeMaximum[index1][index2 + 1]));
            }
        }

        return maxValue;
    }
}
// Time --> O(n * m)   Space --> O(n * m)