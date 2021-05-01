/*
To solve sudoku we have to replace 0 with any number between 1 to 9 but on 3 conditions:
1. The possible number should not present in row
2. The possible number should not present in column
3. The possible number should not present in 3 * 3 sub matrix where 0 is present.

Traverse the board.
	1. if current cell is not zero move forward
	2. if current cell is zero then try to fit with number between 1 to 9 but number should satisfy 3 conditions

Note: For one cell there can be many possible number we are choosing first one and moving forward. If the number which we have 
placed previously is not right or we can try to replace previous 0 with another option so we can solve sudoku. 
We backtrack and make 0 and try different option.
*/


import java.util.*;
import java.sql.*;//1

public class practice_1 {
	public static void main(String args[]) {
		int[][] board = new int[][] { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		solveSudoku(board);

	}

	public static void solveSudoku(int board[][]) {
		int rowIndex = 0, columnIndex = 0;

		solveSudokuUtil(board, rowIndex, columnIndex);
	}

	public static void solveSudokuUtil(int board[][], int rowIndex, int columnIndex) {

		if (rowIndex == board.length) {
			display(board);
			return;
		}

		// for changing row and column
		int nextRowIndex = 0, nextColumnIndex = 0;

		// if reach last column, change to next row
		if (columnIndex == board[0].length - 1) {
			nextRowIndex = rowIndex + 1;
			nextColumnIndex = 0;
		} else {
			nextRowIndex = rowIndex;
			nextColumnIndex = columnIndex + 1;
		}

		// if current cell is not zero move forward
		if (board[rowIndex][columnIndex] != 0) {
			solveSudokuUtil(board, nextRowIndex, nextColumnIndex);
		} 
		// if current cell is zero then try to fit with number between 1 to 9 but number should satisfy 3 conditions
		else {
			for (int possibleOption = 1; possibleOption <= 9; possibleOption++) {
				if (isValidPossibleOption(board, rowIndex, columnIndex, possibleOption)) {

					// we placed possible number.
					// Note: for one cell there can be many possible number we are choosing first one
					board[rowIndex][columnIndex] = possibleOption;
					
					// moving forward
					solveSudokuUtil(board, nextRowIndex, nextColumnIndex);

					
					// if the number which we have placed is not right or we can try to replace with another option
					// so we can solve sudoku. We backtrack and make 0 and try different option.
					board[rowIndex][columnIndex] = 0;
				}
			}
		}
	}

	// checking those 3 conditions.
	public static boolean isValidPossibleOption(int board[][], int rowIndex, int columnIndex, int possibleOption) {

		// checking in columns
		for (int index = 0; index < board[0].length; index++) {
			if (board[rowIndex][index] == possibleOption) {
				return false;
			}
		}

		// checking in rows
		for (int index = 0; index < board.length; index++) {
			if (board[index][columnIndex] == possibleOption) {
				return false;
			}
		}

		// checking 3 * 3 matrix
		// finding starting point of 3 * 3 matrix in 2d array
		int subMatrixRowIndex = 3 * (rowIndex / 3);
		int subMatrixColumnIndex = 3 * (columnIndex / 3);

		for (int index1 = 0; index1 < 3; index1++) {
			for (int index2 = 0; index2 < 3; index2++) {
				if (board[subMatrixRowIndex + index1][subMatrixColumnIndex + index2] == possibleOption) {
					return false;
				}
			}
		}

		return true;
	}

	public static void display(int board[][]) {
		for (int index1 = 0; index1 < board.length; index1++) {
			for (int index2 = 0; index2 < board[0].length; index2++) {
				System.out.print(board[index1][index2] + " ");
			}
			System.out.println();
		}
	}
}
/*
Complexity Analysis:  

Time complexity: O(9^(n*n)). 
For every unassigned index, there are 9 possible options so the time complexity is O(9^(n*n)). The time complexity remains the 
same but there will be some early pruning so the time taken will be much less than the naive algorithm but the upper bound time 
complexity remains the same.
*/