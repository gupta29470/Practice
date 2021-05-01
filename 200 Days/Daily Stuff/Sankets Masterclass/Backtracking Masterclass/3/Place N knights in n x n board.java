/*
Given n * n board, find total ways to place n knights in n * n board, using its usual chess moves 
without visiting any cell twice
*/

/*
Some points to consider:
1. Knight move in eight direction
	-> diagonal + up, 
	-> diagonal + down, 
	-> diagonal + right, 
	-> diagonal + left,
	-> diagonal + upper right diagonal, 
	-> diagonal + upper left diagonal,
	-> diagonal + lower right diagonal, 
	-> diagonal + lower left diagonal
	
2. Unlike queen we can placed possible knights in one row because queen and knight have different
attacking strategy
	
2. if count == len means we placed n knights then increment totalWays

3. loop row:
	-> loop column and try to place possible knights in current row. If current row is same as 
	previous row then column index will be previous column index + 1.
	If current row index is not same as previous row index then column index will start from 0.
	Means we have placed possible knight in one row and changed row. 
	
	-> If is safe cell then :
		-> mark current cell as visited
		
		-> Recursive call for remaining columns and increment count too
		
		-> backtrack and mark current cell as unvisited.


4. safe cell function will check:
	-> upper diagonal and left
	-> upper diagonal and right
	-> upper left diagonal and up
	-> upper right diagonal and up
*/



public class Practice {

    static int totalWays = 0;

    public static void main(String[] args) {
        nKnights(3);
        
        System.out.println(totalWays);
    }

    public static void nKnights(int len) {
        boolean placedKnights[][] = new boolean[len][len];
        int rowIndex = 0, colIndex = 0, count = 0;

        nKnightsUtil(len, placedKnights, rowIndex, colIndex, count);
    }

    public static void nKnightsUtil(int len, boolean placedKnights[][],
            int rowIndex, int colIndex, int count) {
        if (count == len) {
            totalWays++;
            return;
        }

        for (int row = rowIndex; row < len; row++) {
            for (int col = (row == rowIndex) ? colIndex : 0; col < len; col++) {
                if (isSafeCell(row, col, len, placedKnights)) {
                    placedKnights[row][col] = true;

                    // checking for remaining columns in row because unlike
                    // queens, knights can placed in same row
                    nKnightsUtil(len, placedKnights, row, col + 1, count + 1);

                    //backtrack
                    placedKnights[row][col] = false;
                }
            }
        }
    }
    
    public static boolean isSafeCell(int row, int col, int len,
            boolean placedKnights[][]){
         
        // upper diagonal and left
        if (row - 1 >= 0 && col - 2 >= 0 && (placedKnights[row - 1][col - 2])){
            return false;
        }
        
        // upper diagonal and right
        if (row - 1 >= 0 && col + 2 < len && (placedKnights[row - 1][col + 2])){
            return false;
        }
        
        // upper left diagonal and up
        if (row - 2 >= 0 && col - 1 >= 0 && (placedKnights[row - 2][col - 1])){
            return false;
        }
        
        // upper right diagonal and up
        if (row - 2 >= 0 && col + 1 < len && (placedKnights[row - 2][col + 1])){
            return false;
        }
        
        return true;
    }
}

// Time --> O(n!)
// Space --> O(n ^ 2)
