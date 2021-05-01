/*
****************** ROTATE MATRIX 90 degree clockwise ******************
*/

/*
********************** BRUTE FORCE *****************************
Create a another matrix of size given matrix.
using two loops put first column in first row, second column in second 
row, third column in third row and so on at end last column will be 
last row.

Note: we did not create extra index variable to put in rotatedMatrix.
we are modifying indexes of two loops and using it.

Eg: 1 2 3 
	4 5 6
	7 8 9

so  7 4 1 will be first row of rotatedMatrix so initially col = first 
column i.e 2 and row is first row i.e 0
rotatedMatrix[(n - 1) - col][row] = matrix[row][col]
i.e rotatedMatrix[(3 - 1) - 2 = 0][0] = matrix[0][2]
row ++
rotatedMatrix[(3 - 1) - 2 = 0][1] = matrix[1][2]
so on...
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

        for (int col = 0; col < n; col++){
            for (int row = n - 1; row >= 0; row--){
                rotatedMatrix[col][(n - 1) - row] = 
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
// Time --> O(n^2)   Space --> O(1)



/*
***************************** EFFICIENT APPROACH ********************
Step 1: Transpose matrix in place
Step 2 : interchange columns i.e first colum will interchange with first row,
second column will interchange with second last row , third colum will
interchange with third row ans so on..
We will interchange the columns till half of size of matrix, because if 
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

we want:  7 4 1
		  8 5 2
		  9 6 3
		 
		 
Step 2: interchange columns
int temp = matrix[index1][index2];
matrix[index1][index2] = matrix[index1][(n - 1) - index2];
matrix[index1][(n - 1) - index2] = temp;


initially index1 and index2 are 0. so,
int temp = matrix[0][0]... so temp = 1
matrix[0][0] = matrix[0][(3 - 1) - 0 = 2].. matrix[0][0] = 7
matrix[0][(3 - 1) - 0 = 2] = temp ... matrix[0][(3 - 1) - 0 = 2] = 1

index2 ++ and index2 will become 1, but we have to traverse half size
of column so this condition break and it will come out of loop

index1 ++ 
int temp = matrix[1][0]... so temp = 2
matrix[0][1] = matrix[1][(3 - 1) - 0 = 2].. matrix[0][0] = 8
matrix[1][(3 - 1) - 0 = 2] = temp ... matrix[1][(3 - 1) - 0 = 2] = 2


index2 ++ and index2 will become 1, but we have to traverse half size
of column so this condition break and it will come out of loop

index1++
int temp = matrix[2][0]... so temp = 3
matrix[2][0] = matrix[2][(3 - 1) - 0 = 2].. matrix[0][0] = 9
matrix[2][(3 - 1) - 0 = 2] = temp ... matrix[2][(3 - 1) - 0 = 2] = 3


finally matrix rotated 90 degree clockwise


so on interchange till half of size of matrix.. 

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
        
        // Transpose matrix in place
		for (int index1 = 0; index1 < n; index1++){
            for (int index2 = index1; index2 < n; index2++){
                int temp = matrix[index1][index2];
                matrix[index1][index2] = matrix[index2][index1];
                matrix[index2][index1] = temp;
            }
        }
        
        /*
	interchange columns i.e first colum will interchange with first row,
second column will interchange with second last row , third colum will
interchange with third row ans so on..
We will interchange the columns till half of size of matrix, because if 
we do till n so swapping will be done two times and matrix again comes
in to original position
		*/
		
		for (int index1 = 0; index1 < n; index1++){
            for (int index2 = 0; index2 < n / 2; index2++){
                int temp = matrix[index1][index2];
                matrix[index1][index2] = matrix[index1][(n - 1) - index2];
                matrix[index1][(n - 1) - index2] = temp;
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
// Time --> O(n^2)  Space -->O(1)
