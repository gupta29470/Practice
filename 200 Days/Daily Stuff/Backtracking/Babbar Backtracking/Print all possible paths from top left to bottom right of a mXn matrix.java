/*
The problem is to print all the possible paths from top left to bottom right of a mXn matrix with the constraints that from each 
cell you can either move only to "right" or "down".
*/

import java.util.*;
import java.sql.*;//1

public class practice_1 {
	// "right" or "down"
	static int xDirection[] = { 0, 1 };
	static int yDirection[] = { 1, 0 };

	public static void main(String args[]) {
		int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		longestPath(matrix);
	}

	public static void longestPath(int matrix[][]) {

		int rowLen = matrix.length, colLen = matrix[0].length;

		// starting with source
		int rowIndex = 0, colIndex = 0;
		boolean visited[][] = new boolean[rowLen][colLen];
		String path = "";

		longestPathUtil(matrix, visited, rowIndex, colIndex, rowLen, colLen, path);
	}

	public static void longestPathUtil(int matrix[][], boolean visited[][], int rowIndex, int colIndex, int rowLen,
			int colLen, String path) {

		// if reaches destination
		if (rowIndex == rowLen - 1 && colIndex == colLen - 1) {
			System.out.println(path + matrix[rowLen - 1][colLen - 1] + "".trim());
			return;
		}

		// mark valid cells visited
		visited[rowIndex][colIndex] = true;

		// try to move up, down, left and right
		for (int index = 0; index < 2; index++) {
			if (isValidAndSafe(rowIndex + xDirection[index], colIndex + yDirection[index], 
					rowLen, colLen, visited)) {

				// recursive assumption, moving in direction which is valid
				longestPathUtil(matrix, visited, rowIndex + xDirection[index], colIndex + yDirection[index], rowLen,
						colLen, path + matrix[rowIndex][colIndex] + " ");
			}
		}

		// backtrack if find invalid or shortest path
		visited[rowIndex][colIndex] = false;
	}

	// checking if next move's row index and col index is in range
	// checking if next move element is 1 and unvisited
	public static boolean isValidAndSafe(int rowIndex, int colIndex, int rowLen, int colLen, boolean visited[][]) {
		return (rowIndex >= 0) && (colIndex >= 0) && (rowIndex < rowLen) && (colIndex < colLen)
				&& (!visited[rowIndex][colIndex]);
	}
}

/*
 * For boundary cells we have only 1 options to move. For middle cells we have
 * 2 directions to move.
 * 
 * Time --> O((2 ^ (n ^2 - 2n - 2)) * 1 ^ (2n - 2))
 * 
 * 2 ^ (4n - 4) -> boundary cells (3 ^ (n ^2 - 4n - 4) -> middle cells
 */
