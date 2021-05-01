/*
1. Create a visitedGrid matrix, initially filled with false.

2. Create a recursive function, which takes initial matrix, visitedGrid matrix and
 position of rat (rowIndex, colIndex).
 
3. if the position is out of the matrix or the position is not valid then return.

4. Mark the position visitedGrid[rowIndex][colIndex] as true and check if the current 
position is destination or not. If destination is reached print the paths and increment 
totalWays.

5. Recursively call for position (rowIndex + 1, colIndex), (rowIndex - 1, colIndex),
(rowIndex, colIndex + 1) and (rowIndex, colIndex - 1).

6. Unmark position (rowIndex ,colIndex), i.e visitedGrid[i][j] = false.

*/

public class Practice {
    
    static int totalWays = 0;

    public static void main(String[] args) {
        int grid[][] = {{0, 0, 1, 0, 0, 1, 0,},
        {1, 0, 1, 1, 0, 0, 0,},
        {0, 0, 0, 0, 1, 0, 1,},
        {1, 0, 1, 0, 0, 0, 0,},
        {1, 0, 1, 1, 0, 1, 0,},
        {1, 0, 0, 0, 0, 1, 0,},
        {1, 1, 1, 1, 0, 0, 0,}
        };
        
        System.out.println(totalWays(grid));
    }

    public static int totalWays(int grid[][]) {
        int len = grid.length;
        boolean visitedGrid[][] = new boolean[len][len]; 
        int rowIndex = 0, colIndex = 0;
        String paths = "";
        
        totalWaysUtil(grid, len, visitedGrid, rowIndex, colIndex, paths);
                
        return totalWays;
    }
    
    public static void totalWaysUtil(int grid[][], int len, 
            boolean visitedGrid[][], int rowIndex, int colIndex, String paths){
        if (rowIndex == len - 1 && colIndex == len - 1){
            totalWays++;
            System.out.println(paths);
            return;
        }
        
        if (!isSafe(len, rowIndex, colIndex, visitedGrid)){
            return;
        }
        
        // mark current grid as visited
        visitedGrid[rowIndex][colIndex] = true;
        
        // if it is not block then move downward
        if ((rowIndex + 1 < len) && (grid[rowIndex + 1][colIndex] == 0)){
            totalWaysUtil(grid, len, visitedGrid, rowIndex + 1, colIndex, paths + "Down -> ");
        }
        
        // if it is not block then move upward
        if ((rowIndex - 1) >= 0 && (grid[rowIndex - 1][colIndex] == 0)){
            totalWaysUtil(grid, len, visitedGrid, rowIndex - 1, colIndex, paths + "Up -> ");
        }
        
        // if it is not block then move right
        if ((colIndex + 1 < len) && (grid[rowIndex][colIndex + 1] == 0)){
            totalWaysUtil(grid, len, visitedGrid, rowIndex, colIndex + 1, paths + "Right -> ");
        }
        
        // if it is not block then move left
        if ((colIndex - 1 >= 0) && (grid[rowIndex][colIndex - 1] == 0)){
            totalWaysUtil(grid, len, visitedGrid, rowIndex, colIndex - 1, paths + "Left -> ");
        }
        
        // backtrack current grid as unvisited
        visitedGrid[rowIndex][colIndex] = false;
    }
    
    public static boolean isSafe(int len, int rowIndex, int colIndex,
            boolean visitedGrid[][]){
        return (rowIndex >= 0) && (colIndex >= 0) && (rowIndex < len) && 
                (colIndex < len) && (visitedGrid[rowIndex][colIndex] == false);
    }
}

/*
For boundary cells we have only 2 options to move. 
For middle cells we have only 3 directions to move we cant go back to parent.

Time --> O((3 ^ (n ^2 - 4n - 4)) * 2 ^ (4n - 4))

2 ^ (4n - 4) -> boundary cells
(3 ^ (n ^2 - 4n - 4) -> middle cells

Space --> O(n ^ 2)

*/