/*
N - Queens problem is to place n - queens in such a manner on an n x n chessboard that no 
queens attack each other by being in the same row, column or diagonal.
*/

/*
Some points to consider:
1. If we place queen in specific row then that specific row is in attacked, so we don't 
need to try to place more queens in that row.

2. If we have given n * n board and have to place n queen, then we have to place 
atleast one queen in every row, then only we are able to achieve to place n queens in 
n * n board.

3. If you are not able to achieve the above goal, then we have more than one queen in 
any specific row and thet attacked each other.

4. If we get any row with no placed queen in that, then we don't need to make any further 
calls for that arrangement, beacuse whatever we do we can't place n queens, if we left 
any row without placing queens. So we prune all further calls.

5. Queen move in eight direction: up, down, left, right, upper left, 
diagonals : upper right, lower left, lower right
*/

public class Practice {
    static int totalWays = 0;
    
    public static void main(String[] args) {
        nQueen(5);
        
        System.out.println(totalWays);
    }
    
    public static void nQueen(int len){
        // used to place queen in cell
        boolean placedQueen[][] = new boolean[len][len];
        int rowIndex = 0;
        
        nQueenUtil(len, placedQueen, rowIndex);
    }
    
    public static void nQueenUtil(int len, boolean placedQueen[][], int rowIndex){
        
        // base case
        // we found a way to place all n queens 
        if (rowIndex == len){
            totalWays++;
            displayQueen(len, placedQueen);
            System.out.println("------------------------------------");
            return;
        }
        
        // self work
        // we will check manually is cell safe then only place queen
        for (int colIndex = 0; colIndex < len; colIndex++){
            // checking if current cell is safe
            if (isSafeCell(placedQueen, rowIndex, colIndex, len)){
                placedQueen[rowIndex][colIndex] = true;
                
                // recursive assumption
                // if we placed one queen in specific row then we don't have 
                // check further in that row and try to place queen
                // if we do so then queen will attack each other
                nQueenUtil(len, placedQueen, rowIndex + 1); 
                
                // backtrack
                placedQueen[rowIndex][colIndex] = false;
            }
        }
    }
    
    // checking in backwards only beacuse we still reach further than rowIndex and colIndex
    public static boolean isSafeCell(boolean placedQueen[][], int rowIndex, 
            int colIndex, int len){
        
        //.checking upward
        for (int index = rowIndex - 1; index >= 0; index--){
            if (placedQueen[index][colIndex]){
                return false;
            }
        }
        
        // upper right diagonal
        for (int index1 = rowIndex - 1, index2 = colIndex + 1; index1 >= 0 && index2 < len; index1--, index2++){
            if (placedQueen[index1][index2]){
                return false;
            }
        }
        
        // upper left diagonal
        for (int index1 = rowIndex - 1, index2 = colIndex - 1; index1 >= 0 && index2 >= 0; index1--, index2--){
            if (placedQueen[index1][index2]){
                return false;
            }
        }
           
        return true;
    }
    
    public static void displayQueen(int len, boolean placedQueen[][]){
        for (int index1 = 0; index1 < len; index1++){
            for (int index2 = 0; index2 < len; index2++){
                if (placedQueen[index1][index2]){
                    System.out.print("Q  ");
                }
                else{
                    System.out.print("- ");
                }
            }
            System.out.println("");
        }
    }
}

// Time --> O(n!)
/*
Explanation: If we add all this up and define the run time as T(N). Then T(N) = O(N2) + N*T(N-1). 
If you draw a recursion tree using this recurrence, the final term will be something like n3+ n!O(1). 
By the definition of Big O, this can be reduced to O(n!) running time.
*/
// Space --> O(n ^ 2)  placedQueen matrix