/*
Naive Solution:  

Approach: The idea is very basic. Traverse through all oranges in multiple rounds. In every round, rot 
the oranges to the adjacent position of oranges which were rotten in the last round.

Algorithm: 
1. Create a variable result = 0 and changed = false
2. Run a loop until there is no cell of the matrix which is changed in an iteration.
3. Run a nested loop and traverse the matrix. If the element of the matrix is equal to no then assign the adjacent 
elements to no + 1 if the adjacent element’s value is equal to 1, i.e. not rotten, and update changed to true.
4. Traverse the matrix and check if there is any cell which is 1. If 1 is present return -1
5. Else return no – 2
*/

import java.util.*;

public class practice_1 {

	public static void main(String args[]) {
		int matrix[][] = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };

		System.out.println(rottOranges(matrix));
	}

	public static int rottOranges(int matrix[][]) {
		int result = 2;
		boolean flag = false;

		while (true) {
			for (int index1 = 0; index1 < matrix.length; index1++) {

				for (int index2 = 0; index2 < matrix[0].length; index2++) {

					if (matrix[index1][index2] == 2) {
						// up
						if (index1 - 1 >= 0) {
							if (matrix[index1 - 1][index2] == 1) {
								matrix[index1 - 1][index2] = 2;
								flag = true;
							}
						}

						// down
						if (index1 + 1 < matrix.length) {
							if (matrix[index1 + 1][index2] == 1) {
								matrix[index1 + 1][index2] = 2;
								flag = true;
							}
						}

						// left
						if (index2 - 1 >= 0) {
							if (matrix[index1][index2 - 1] == 1) {
								matrix[index1][index2 - 1] = 2;
								flag = true;
							}
						}

						// right
						if (index2 + 1 < matrix[0].length) {
							if (matrix[index1][index2 + 1] == 1) {
								matrix[index1][index2 + 1] = 2;
								flag = true;
							}
						}
					}
				}
			}
			if (flag == false) {
				break;
			}
			
			flag = false;
			result++;
		}

		for (int index1 = 0; index1 < matrix.length; index1++) {
			for (int index2 = 0; index2 < matrix.length; index2++) {
				if (matrix[index1][index2] == 1) {
					return -1;
				}
			}
		}

		return result - 2;
	}
}
/*
Complexity Analysis: 
Time Complexity : O((R*C) * (R *C)). 
The matrix needs to be traversed again and again until there is no change in the matrix, that can happen max(R *C)/2 times. 
So time complexity is O((R * C) * (R *C)).
Space Complexity:O(1). 
No extra space is required.
*/



/*
Using Queue.

Approach: The idea is to use Breadth First Search. The condition of oranges getting rotten is when they come in contact with 
other rotten oranges. This is similar to breadth-first search where the graph is divided into layers or circles and the search is 
done from lower or closer layers to deeper or higher layers. In the previous approach, the idea was based on BFS but the 
implementation was poor and inefficient. To find the elements whose values are no the whole matrix had to be traversed. 
So that time can be reduced by using this efficient approach of BFS. 

Create a model class which has time, row index and column. time is basically how many time we required to rott all oranges

The idea is using queue with type of model class.
1. Enqueue (rotten oranges) those elements from matrix whose value is 2, its time = 0, rowIndex and colIndex of 2

2. While queue is not empty:
	
	3. poll element
	
	4. extract time, rowIndex and colIndex of rotten oranges
	
	5. Rott up, down, left and right and all are doing at same time so all times will be time + 1
	
	6. Update result = time

7. Traverse matrix and check if 1 is present or not, if present then return -1
8. return result

*/
import java.util.*;

public class practice_1 {

	public static void main(String args[]) {
		int matrix[][] = { 
				{2, 1, 0, 2, 1},
				{0, 0, 1, 2, 1},
				{1, 0, 0, 2, 1},
		 };

		System.out.println(rottOranges(matrix));
	}

	public static int rottOranges(int matrix[][]) {
		int result = 0;
		
		Queue<RottenOranges> queue = new LinkedList<>();
		
		// Enqueue (rotten oranges) those elements from matrix whose value is 2, its time = 0, rowIndex and colIndex of 2
		for (int index1 = 0; index1 < matrix.length; index1++) {
			for (int index2 = 0; index2 < matrix[0].length; index2++) {
				if (matrix[index1][index2] == 2) {
					queue.add(new RottenOranges(0, index1, index2));
				}
			}
		}
		
		// While queue is not empty:
		while (!queue.isEmpty()) {
			
			// poll element
			RottenOranges rottOranges = queue.poll();
			
			// extract time, rowIndex and colIndex of rotten oranges
			int time = rottOranges.time;
			int rowIndex = rottOranges.rowIndex;
			int colIndex = rottOranges.colIndex;
			
			// Rott up, down, left and right and all are doing at same time so all times will be time + 1
			// up
			if (rowIndex - 1 >= 0 && matrix[rowIndex - 1][colIndex] == 1) {
				matrix[rowIndex - 1][colIndex] = 2;
				queue.add(new RottenOranges(time + 1, rowIndex - 1, colIndex));
			}
			
			// down
			if (rowIndex + 1 < matrix.length && matrix[rowIndex + 1][colIndex] == 1) {
				matrix[rowIndex + 1][colIndex] = 2;
				queue.add(new RottenOranges(time + 1, rowIndex + 1, colIndex));
			}
			
			// left
			if (colIndex - 1 >= 0 && matrix[rowIndex][colIndex - 1] == 1) {
				matrix[rowIndex][colIndex - 1] = 2;
				queue.add(new RottenOranges(time + 1, rowIndex, colIndex - 1));
			}
			
			// right
			if (colIndex + 1 < matrix[0].length && matrix[rowIndex][colIndex + 1] == 1) {
				matrix[rowIndex][colIndex + 1] = 2;
				queue.add(new RottenOranges(time + 1, rowIndex, colIndex + 1));
			}
			
			// Update result = time
			result = time;
		}
		
		// Traverse matrix and check if 1 is present or not, if present then return -1
		for (int index1 = 0; index1 < matrix.length; index1++) {
			for (int index2 = 0; index2 < matrix[0].length; index2++) {
				if (matrix[index1][index2] == 1) {
					return -1;
				}
			}
		}
		return result;
	}
}


// Create a model class which has time, row index and column. time is basically how many time we required to rott all oranges
class RottenOranges{
	int time, rowIndex, colIndex;
	
	RottenOranges(int time, int rowIndex, int colIndex){
		this.time = time;
		this.rowIndex = rowIndex;
		this.colIndex = colIndex;
	}
}
// time --> O(n * m)  Space --> O(n * m)