class MaximumOnes {

    public static void main(String[] args) throws Exception {
        int array[][] = {{0, 0, 0, 1},
        {0, 1, 1, 1},
        {1, 1, 1, 1},
        {0, 0, 0, 0}};

        System.out.println(maximumOnes(array));
    }

    public static int maximumOnes(int array[][]) {
        int maximumOnesCount = Integer.MIN_VALUE, maximumOnesRow = -1;

        for (int index1 = 0; index1 < array.length; index1++) {
            int count = 0;
            for (int index2 = 0; index2 < array[index1].length; index2++) {
                if (array[index1][index2] == 1) {
                    count++;
                }
                if (maximumOnesCount < count) {
                    maximumOnesRow = index1;
                    maximumOnesCount = count;
                }
            }

        }
        return maximumOnesRow;
    }

}



/*

The idea is to start from the top-right corner of the matrix and do the 
following:

1.  – if current cell has value 1, continue moving left till we encounter 0 
or all columns are processed, else

2. – if current cell has value 0, continue moving down till we encounter 1 or 
all rows are processed.

Finally, we return the row index of last cell in which we have seen 1.


0 1 1 1
0 0 1 1
1 1 1 1 
0 0 0 0

row = 0, col = 3, maxOnesRow = -1

1. 0(row) < 4 && 3(col) >= 0:
	array[0][3] == 1 // true
	if condition : col = col - 1 = 2
	maxOnesRow = 0
	
2. 0 < 4 && 2 >= 0:
	array[0][2] == 1 // true
	if condition : col = col - 1 = 1
	maxOnesRow = 0
	
3. 0 < 4 && 1 >= 0:
	array[0][1] == 1 // true
	
	if condition : col = col - 1 = 0
	maxOnesRow = 0
	
4. 0 < 4 && 0 >= 0:
	array[0][0] == 1 // false
	
	else condition : row = row + 1 = 1

5. 1 < 4 && 0 >= 0
	array[1][0] == 1 // false
	
	else condition : row = row + 1 = 2
	
6. 2 < 4 && 0 >= 0
	array[2][0] == 1 // true
	
	if condition : col = col - 1 = -1
	maximumOnesRow = 2
	
7. 2 < 4 && -1 >= 0 // false

maximum ones row is: 2

*/



class MaximumOnesRow
{
    public static int findRowIndex(int mat[][]) {
        // stores row number with maximum index
        int maxOnesRow = -1;
 
        // i, j stores current row and column index
 
        // start from top-rightmost cell of the matrix
        int row = 0, col = mat[0].length - 1;
 
        while (row <= mat.length - 1 && col >= 0) {
            // move left if current cell has value 1
            if (mat[row][col] == 1) {
                col--;
                maxOnesRow = row;    // update row number
            }
            // else move down
            else {
                row++;
            }
        }
        return maxOnesRow;
    }
 
    public static void main(String[] args)
    {
        int[][] mat =
        {
            { 0, 0, 0, 1, 1 },
            { 0, 0, 1, 1, 1 },
            { 0, 0, 0, 0, 0 },
            { 0, 1, 1, 1, 1 },
            { 0, 0, 0, 0, 1 }
        };
 
        int rowIndex = findRowIndex(mat);
 
        // rowIndex = 0 means no 1's are present in the matrix
        if (rowIndex != 0) {
            System.out.print("Maximum 1's are present in the row " + rowIndex);
        }
        System.out.println("");
    }
}