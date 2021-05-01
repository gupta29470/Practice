/*
Given n * n board, with a knight placed at (0, 0) index. Check if the knight can cover 
all the cells of the board, using its usual chess moves without visiting any cell twice
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
	
2. xDirection and yDirection created to move knight in all 8 directions

3. grid array is storing how knight covers all cells 

4. visited array to ensure not any cell visit twice.
*/

public class Practice {

    static int totalWays = 0;
    
    public static void main(String[] args) {
        knightsTour(5);
    }
    
    public static void knightsTour(int len){
        boolean visited[][] = new boolean[len][len];
        int grid[][] = new int[len][len];
        int count = 0;
        int rowIndex = 0, colIndex = 0;
        
        knightsTourUtil(len, visited, grid, rowIndex, colIndex, count);
    }
    
    public static void knightsTourUtil(int len, boolean visited[][], 
            int grid[][], int rowIndex, int colIndex, int count){
        
        // if knigh covers all cells in specific way
        if (count == len * len - 1){
            grid[rowIndex][colIndex] = count;
            displayBoard(len, grid);
            System.out.println("-------------------------------------------");
            System.out.println("");
            return;
        }
        
        // if knight does not find any way to visit all cells
        if (count >= len * len){
            return;
        }
        
        // knight move in eight direction
        // diagonal + up, diagonal + down, diagonal + right, diagonal + left,
        // diagonal + upper right diagonal, diagonal + upper left diagonal,
        // diagonal + lower right diagonal, diagonal + lower left diagonal
        int xDirection[] = {-2, -2, -1, -1, 2, 2, 1, 1};
        int yDirection[] = {1, -1, 2, -2, 1, -1, 2, -2};
        
        // mark visited as true
        visited[rowIndex][colIndex] = true;
        
        // store number of moves
        grid[rowIndex][colIndex] = count;
        
        // checking if current cell is safe in all 8 directions
        for (int index = 0; index < 8; index++){
            if (isSafeCell(len, rowIndex + xDirection[index], 
                    colIndex + yDirection[index], visited)){
                
                // recursive assumption for remaining cells
                knightsTourUtil(len, visited, grid, rowIndex + xDirection[index],
                        colIndex + yDirection[index], count + 1);
            }
        }
        
        // backtrack current cell moves to 0
        grid[rowIndex][colIndex] = 0;
        
        // mark as unvisited
        visited[rowIndex][colIndex] = false;
    }
    
    public static boolean isSafeCell(int len, int rowIndex, int colIndex, 
            boolean visited[][]){
        
        return (rowIndex < len) && (colIndex < len) && (rowIndex >= 0) &&
                (colIndex >= 0) && (visited[rowIndex][colIndex] == false);
    }

    public static void displayBoard(int len, int grid[][]) {
        for (int index1 = 0; index1 < len; index1++) {
            for (int index2 = 0; index2 < len; index2++) {
                System.out.print(grid[index1][index2] + " ");
            }
            System.out.println("");
        }
    }

}

/*
For boundary cells we have only 4 options to move. 
For middle cells we have only 7 directions to move we cant go back to parent.

Time --> O((7 ^ (n ^2 - 4n - 4)) * 4 ^ (4n - 4))

4 ^ (4n - 4) -> boundary cells
(7 ^ (n ^2 - 4n - 4) -> middle cells

Space --> O(n ^ 2)
*/

/*
Output Example: Grid array
0 17 2 11 20 
7 12 19 16 3 
18 1 6 21 10 
13 8 23 4 15 
24 5 14 9 22 
-------------------------------------------

0 7 2 13 20 
17 12 19 8 3 
6 1 16 21 14 
11 18 23 4 9 
24 5 10 15 22 
-------------------------------------------

0 7 2 13 20 
15 12 19 8 3 
6 1 14 21 18 
11 16 23 4 9 
24 5 10 17 22 
-------------------------------------------

0 15 2 9 20 
5 10 19 14 3 
16 1 4 21 8 
11 6 23 18 13 
24 17 12 7 22 
-------------------------------------------
*/


