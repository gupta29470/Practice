/*
Given an M x N matrix, with a few hurdles arbitrarily placed, calculate the length of longest possible route possible from source to 
destination within the matrix. We are allowed to move to only adjacent cells which are not hurdles. The route cannot contains any 
diagonal moves and a location once visited in a particular path cannot be visited again.
*/

import java.util.*;
import java.sql.*;//1

public class practice_1 {
	static int longestPath = Integer.MIN_VALUE;
	static int xDirection[] = {-1, 0, 0, 1};
	static int yDirection[] = {0, -1, 1, 0};
	
	public static void main(String args[]) {
		int matrix[][] =
		    {
		    	{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 },
                { 1, 0, 0, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
                { 1, 1, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }
		    };
		
		int source[] = {0, 0};
		int destination[] = {5, 7};
		
		System.out.println(longestPath(matrix, source, destination));
	}
	
	public static int longestPath(int matrix[][], int source[], int destination[]) {
		
		int rowLen = matrix.length, colLen = matrix[0].length;
		
		// starting with source
		int rowIndex = source[0], colIndex = source[1];
		boolean visited[][] = new boolean[rowLen][colLen];
		int currentPath = 0;
		
		longestPathUtil(matrix, visited, rowIndex, colIndex, rowLen, colLen, currentPath, 
				source, destination);
		
		return longestPath;
	}
	
	public static void longestPathUtil(int matrix[][], boolean visited[][], int rowIndex,
			int colIndex, int rowLen, int colLen, int currentPath, int source[], 
			int destination[]) {
		
		// if reaches destination
		if (rowIndex == destination[0] && colIndex == destination[1]) {
			// try to update longest path
			if (longestPath < currentPath) {
				longestPath = currentPath;
				return;
			}
		}
		
		// mark valid cells visited
		visited[rowIndex][colIndex] = true;
		
		// try to move up, down, left and right
		for (int index = 0; index < 4; index++) {
			if (isValid(rowIndex + xDirection[index], colIndex + yDirection[index], 
					rowLen, colLen) && 
					isSafe(matrix, rowIndex + xDirection[index], colIndex + yDirection[index], 
							visited)) {
				
				// recursive assumption, moving in direction which is valid
				longestPathUtil(matrix, visited, rowIndex + xDirection[index], 
						colIndex + yDirection[index], rowLen, colLen, currentPath + 1,
						source, destination);
				
			}
		}
		
		// backtrack if find invalid or shortest path
		visited[rowIndex][colIndex] = false;
	}
	
	// checking if next move's row index and col index is in range
	public static boolean isValid(int rowIndex, int colIndex, int rowLen, int colLen) {
		return (rowIndex >= 0) && (colIndex >= 0) && (rowIndex < rowLen) 
				&& (colIndex < colLen); 
	}
	
	// checking if next move element is 1 and unvisited
	public static boolean isSafe(int matrix[][], int rowIndex, int colIndex, boolean visited[][]) {
		return (matrix[rowIndex][colIndex] == 1) && (!visited[rowIndex][colIndex]);
	}
}

/*
For boundary cells we have only 2 options to move. 
For middle cells we have only 3 directions to move we cant go back to parent.

Time --> O((3 ^ (n ^2 - 4n - 4)) * 2 ^ (4n - 4))

2 ^ (4n - 4) -> boundary cells
(3 ^ (n ^2 - 4n - 4) -> middle cells
*/


