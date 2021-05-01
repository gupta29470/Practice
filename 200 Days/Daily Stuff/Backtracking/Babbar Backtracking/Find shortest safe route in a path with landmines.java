/*
Given a path in the form of a rectangular matrix having few landmines arbitrarily placed (marked as 0), 
calculate length of the shortest safe route possible from any cell in the first column to any cell in the last column of the matrix.
We have to avoid landmines and their four adjacent cells (left, right, above and below) as they are also unsafe. 
We are allowed to move to only adjacent cells which are not landmines. i.e. the route cannot contains any diagonal moves.


Input: 
A 12 x 10 matrix with landmines marked as 0

[ 1  1  1  1  1  1  1  1  1  1 ]
[ 1  0  1  1  1  1  1  1  1  1 ]
[ 1  1  1  0  1  1  1  1  1  1 ]
[ 1  1  1  1  0  1  1  1  1  1 ]
[ *  *  *  *  1  1  1  1  1  1 ]
[ 1  1  1  *  1  0  1  1  1  1 ]
[ 1  0  1  *  1  1  1  1  0  1 ]
[ 1  1  1  *  *  *  *  *  1  1 ]
[ 1  1  1  1  1  1  1  *  *  * ]
[ 0  1  1  1  1  0  1  1  1  1 ]
[ 1  1  1  1  1  1  1  1  1  1 ]
[ 1  1  1  0  1  1  1  1  1  1 ]


Output:  
Length of shortest safe route is 13 (*)
*/


/*
The idea is to use Backtracking. 
We first mark all adjacent cells of the landmines as unsafe. 
Then for each safe cell of first column of the matrix, we move forward in all allowed directions and recursively checks if they 
leads to the destination or not. If destination is found, we update the value of shortest path else if none of the above 
solutions work we return false from our function.


1. markUnsafeCells function : Marking landmines up's down's left's and right's as unsafe reason for first making - 1 
because if we make 0 then it will make whole matrix unsafe that's why first mark -1 then make 0

2. isValid function : Checking if next move's row index and col index is in range

3. isSafe function : Checking if next move element is 1 and unvisited

4. findShortestPathUtil : Recursive function to find shortest path
*/

import java.util.*;
import java.sql.*;//1

public class practice_1 {
	static int shortestPath = Integer.MAX_VALUE;
	static int xDirection[] = { -1, 0, 0, 1 };
	static int yDirection[] = { 0, -1, 1, 0 };

	public static void main(String args[]) {
		int[][] mat = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
		        { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
		        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 } };

		// Find shortest path
		findShortestPath(mat);
	}

	public static void findShortestPath(int matrix[][]) {
		int rowLen = matrix.length, colLen = matrix[0].length;
		boolean visited[][] = new boolean[rowLen][colLen];
		
		markUnsafeCells(matrix, rowLen, colLen);
		
		// only consider those row whose start element is 1 because we have to move start from end
		for (int index = 0; index < rowLen; index++) {
			if (matrix[index][0] == 1) {
				findShortestPathUtil(matrix, visited, index, 0, 0, rowLen, colLen);
				
				// if shortest path becomes equal to column length then no way we can find shorter than this. Break loop
				if (shortestPath == colLen - 1) {
					break;
				}
			}
		}
		
		if (shortestPath != Integer.MAX_VALUE) {
			System.out.println("Length of shortest " +
                    "safe route is " + shortestPath);
		}
		else {
			System.out.println("Destination not " +
                    "reachable from given source");
		}
	}
	
	
	// recursive function to find shortest path
	public static void findShortestPathUtil(int matrix[][], boolean visited[][],
			int rowIndex, int colIndex, int currentPath, int rowLen, 
			int colLen) {
		
		// if we reach end column
		if (colIndex == colLen - 1) {
			
			// if current path is less than available shortest path then update current path
			if (currentPath < shortestPath) {
				shortestPath = currentPath;;
				display(matrix, rowLen, colLen);
				System.out.println("===============================================");
				System.out.println("===============================================");
			}
			return;
		}
		
		
		// if current path becomes greater than available shortest path then no need to move further
		if (currentPath > shortestPath) {
			return;
		}
		
		
		// try to moving in all 4 direction: up, down, left, right
		for (int index = 0; index < 4; index++) {
			if (isValid(matrix, rowIndex + xDirection[index], 
					colIndex + yDirection[index], rowLen, colLen) && 
					isSafe(matrix, visited, rowIndex + xDirection[index],
					colIndex + yDirection[index])) {
				
				// mark as visited
				visited[rowIndex][colIndex] = true;
				matrix[rowIndex][colIndex] = 5;
				
				// recursive assumption
				findShortestPathUtil(matrix, visited, rowIndex + xDirection[index],
						colIndex + yDirection[index], currentPath + 1, rowLen, colLen);
				
				
				// backtrack
				matrix[rowIndex][colIndex] = 1;
				visited[rowIndex][colIndex] = false;
			}
		}
	}
	
	
	// checking if next move element is 1 and unvisited
	public static boolean isSafe(int matrix[][], boolean visited[][], 
			int rowIndex, int colIndex) {
		return (matrix[rowIndex][colIndex] == 1) && 
				(!visited[rowIndex][colIndex]);
	}
	
	
	// checking if next move's row index and col index is in range
	public static boolean isValid(int matrix[][], int rowIndex, 
			int colIndex, int rowLen, int colLen) {
		return (rowIndex < rowLen) && (rowIndex >= 0) &&
				(colIndex < colLen) && (colIndex >= 0);
	}
	
	// marking landmines up's down's left's and right's as unsafe
	// reason for first making - 1 because if we make 0 then it will make whole matrix unsafe
	// that's why first mark -1 then make 0
	public static void markUnsafeCells(int matrix[][], int rowLen, 
			int colLen) {
		
		for (int index1 = 0; index1 < rowLen; index1++) {
			for (int index2 = 0; index2 < colLen; index2++) {
				if (matrix[index1][index2] == 0) {
					for (int index = 0; index < 4; index++) {
						if (isValid(matrix, index1 + xDirection[index],
								index2 + yDirection[index], rowLen, colLen)) {
							matrix[index1 + xDirection[index]][index2 + yDirection[index]] = -1;
						}
					}
				}
			}
		}
		
		for (int index1 = 0; index1 < rowLen; index1++) {
			for (int index2 = 0; index2 < colLen; index2++) {
				if (matrix[index1][index2] == -1) {
					matrix[index1][index2] = 0;
				}
			}
		}
	}
	
	
	
	public static void display(int matrix[][], int rowLen, int colLen) {
		for (int index1 = 0; index1 < rowLen; index1++) {
			for (int index2 = 0; index2 < colLen; index2++) {
				System.out.print(matrix[index1][index2] + " ");
			}
			System.out.println();
		}
	}
}

/*
For boundary cells we have only 2 options to move. 
For middle cells we have only 3 directions to move we cant go back to parent.

Time --> O((3 ^ (n ^2 - 4n - 4)) * 2 ^ (4n - 4))

2 ^ (4n - 4) -> boundary cells
(3 ^ (n ^2 - 4n - 4) -> middle cells
*/





