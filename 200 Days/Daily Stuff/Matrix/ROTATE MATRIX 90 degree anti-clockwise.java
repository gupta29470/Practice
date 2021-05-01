/*
****************** ROTATE MATRIX 90 degree anti-clockwise ******************
*/

/*
********************** BRUTE FORCE *****************************
Create a another matrix of size given matrix.
using two loops put last column in first row, second last column in second 
row, third last column in third row and so on at end 1st column will be 
last row.

Note: we did not create extra index variable to put in rotatedMatrix.
we are modifying indexes of two loops and using it.

Eg: 1 2 3 
	4 5 6
	7 8 9

so  3 6 9 will be first row of rotatedMatrix so initially col = last 
column i.e 2 and row is first row i.e 0
rotatedMatrix[(n - 1) - col][row] = matrix[row][col]
i.e rotatedMatrix[(3 - 1) - 2 = 0][0] = matrix[0][2]
row ++
rotatedMatrix[(3 - 1) - 2 = 0][1] = matrix[1][2]
so on ...
*/

class RotateMatrix {

    public static void main(String[] args) {

        int mat[][] = { 
            { 1, 2, 3, 4 }, 
            { 5, 6, 7, 8 }, 
            { 9, 10, 11, 12 }, 
            { 13, 14, 15, 16 },
        }; 

        rotateMatrix(mat);
    }

    public static void rotateMatrix(int matrix[][]) {

        int n = matrix.length;
        int rotatedMatrix[][] = new int[n][n];

        for (int col = n - 1; col >= 0; col--) {
            for (int row = 0; row < n; row++) {
                rotatedMatrix[(n - 1) - col][row] = 
				matrix[row][col];
            }
        }

        for (int index1 = 0; index1 < n; index1++) {
            for (int index2 = 0; index2 < n; index2++) {
                System.out.print(rotatedMatrix[index1][index2] + " ");;
            }
            System.out.println("");
        }
    }

}
// Time Complexity --> O(n^2)   Space --> O(1)



/*
***************************** EFFICIENT APPROACH ********************
Step 1: Transpose matrix in place
Step 2 : interchange rows i.e first row will interchange with last row,
second row will interchange with second last row , third row will
interchange with third last row ans so on..
We will interchange the rows till half of size of matrix, because if 
we do till n so swapping will be done two times and matrix again comes
in to original position


Note: we did not create extra index variable to put in rotatedMatrix.
we are modifying indexes of two loops and using it.

Eg: 1 2 3 
	4 5 6
	7 8 9
	
Step 1: After Transposing : 1 4 7
							2 5 8
							3 6 9

we want:  3 6 9
		  2 5 8
		  1 4 7
		 
		 
Step 2: interchange rows
int temp = matrix[index1][index2];
matrix[index1][index2] = matrix[(n - 1) - index1][index2];
matrix[(n - 1) - index1][index2] = temp;


initially index1 and index2 are 0. so,
int temp = matrix[0][0]... so temp = 1
matrix[0][0] = matrix[(3 - 1) - 0 = 2][0].. matrix[0][0] = 3
matrix[(3 - 1) - 0 = 2][0] = temp ... matrix[(3 - 1) - 0 = 2][0] = 1

index2 ++ 
int temp = matrix[0][1]... so temp = 4
matrix[0][1] = matrix[(3 - 1) - 0 = 2][1].. matrix[0][0] = 6
matrix[(3 - 1) - 0 = 2][1] = temp ... matrix[(3 - 1) - 0 = 2][0] = 4


so on interchange till half of size of matrix.. 

*/

class RotateMatrix {

    public static void main(String[] args) {

        int mat[][] = { 
            { 1, 2, 3, 4 }, 
            { 5, 6, 7, 8 }, 
            { 9, 10, 11, 12 }, 
            { 13, 14, 15, 16 } 
        }; 

        rotateMatrix(mat);
    }

    public static void rotateMatrix(int matrix[][]) {

        int n = matrix.length;

        // Transpose matrix in place
		for (int index1 = 0; index1 < n; index1++) {
            for (int index2 = index1; index2 < n; index2++) {
                int temp = matrix[index1][index2];
                matrix[index1][index2] = matrix[index2][index1];
                matrix[index2][index1] = temp;
            }
        }

        
		/*
		interchange rows i.e first row will interchange with last row,
second row will interchange with second last row , third row will
interchange with third last row ans so on..
We will interchange the rows till half of size of matrix, because if 
we do till n so swapping will be done two times and matrix again comes
in to original position
		*/
		for (int index1 = 0; index1 < n / 2; index1++) {
            for (int index2 = 0; index2 < n; index2++) {
                int temp = matrix[index1][index2];
                matrix[index1][index2] = matrix[(n - 1) - index1][index2];
                matrix[(n - 1) - index1][index2] = temp;
            }
        }

        for (int index1 = 0; index1 < n; index1++) {
            for (int index2 = 0; index2 < n; index2++) {
                System.out.print(matrix[index1][index2] + " ");;
            }
            System.out.println("");
        }
    }

}

