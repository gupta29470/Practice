/*
Solving nQueen problem using bit set to improve time and space complexities.

We are trying to reduce isSafeCell function from nQueen pure backtracking solution.

1. We have created 3 bit set data structure and content of bit set data structure is 1 bit.
3 bit set are : reservedColumn, reservedLeftDiagonal, reservedRightDiagonal i.e is Queen is there 
in that column or in upper left diagonal, or upper right diagonal.

2. We traverse the row with rowIndex and column with loop.

3. Loop column for each row:
	-> If current row and current column has no Queen we flip 0 to 1 column bit set
	
	-> If upper left row and upper left column i.e upper left diagonal  has no Queen we flip 0 to 1 
	reservedLeftDiagonal bit set
	
	-> If upper right row and upper right column i.e upper right diagonal  has no Queen we flip 
	0 to 1 reservedRightDiagonal bit set
	
	-> Recursive call for remaining rows.
	
	-> backtracking rule:
		-> Again flipping reservedColumn, reservedLeftDiagonal, reservedRightDiagonal i.e 1 to 0.
*/




import java.util.*;
import java.io.*;

public class Practice {

    static int totalWays = 0;

    public static void main(String[] args) {
        nQueen(4);
        
        System.out.println(totalWays);
    }
    
    public static void nQueen(int len){
        int rowIndex = 0;
        BitSet reservedColumn = new BitSet(100);
        BitSet reservedLeftDiagonal = new BitSet(100);
        BitSet reservedRightDiagonal = new BitSet(100);
        
        int loop = 0;
      
        nQueenUtil(len, rowIndex, reservedColumn, reservedLeftDiagonal, 
                reservedRightDiagonal);
    }
    
    public static void nQueenUtil(int len, int rowIndex, BitSet reservedColumn,
            BitSet reservedLeftDiagonal, BitSet reservedRightDiagonal){
        
        if (rowIndex == len){
            totalWays++;
            return;
        }
        
        for (int colIndex = 0; colIndex < len; colIndex++){
            if (!reservedColumn.get(colIndex) && 
                    !reservedLeftDiagonal.get((rowIndex - colIndex) + (len - 1))
                    && !reservedRightDiagonal.get(rowIndex + colIndex)){
                
                reservedColumn.flip(colIndex);
                reservedRightDiagonal.flip(rowIndex + colIndex);
                reservedLeftDiagonal.flip(rowIndex - colIndex + len - 1);
                
                
                nQueenUtil(len, rowIndex + 1, reservedColumn, reservedLeftDiagonal, 
                        reservedRightDiagonal);
                
                reservedColumn.flip(colIndex);
                reservedRightDiagonal.flip(rowIndex + colIndex);
                reservedLeftDiagonal.flip(rowIndex - colIndex + len - 1);
            }
        }
    }
}

// Time --> O(n)   Space --> O(n)
