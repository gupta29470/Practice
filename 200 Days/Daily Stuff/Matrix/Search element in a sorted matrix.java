/*
Overall matrix is Sorted 

Given a sorted matrix mat[n][m] and an element ‘x’. Find the position of x 
in the matrix if it is present, else print -1. Matrix is sorted in a way 
such that all elements in a row are sorted in increasing order and for row 
‘i’, where 1 <= i <= n-1, the first element of row ‘i’ is greater than or 
equal to the last element of row ‘i-1’. The approach should have 
O(log n + log m) time complexity.

Examples: 

Input : mat[][] = { {1, 5, 9},
                    {14, 20, 21},
                    {30, 34, 43} }
        x = 14
Output : Found at (1, 0)

Input : mat[][] = { {1, 5, 9, 11},
                    {14, 20, 21, 26},
                    {30, 34, 43, 50} }
        x = 42
Output : -1
*/




/*
using two loops if we found current element is equal to key return 
row index and column index
*/
class SearchInMatrix {

    public static void main(String[] args) throws Exception {
        int array[][] = {{10, 20, 30, 40},
        {15, 25, 35, 45},
        {27, 29, 37, 48},
        {32, 33, 39, 50}};

       searchInMatrix(array, 29);
    }

    public static void searchInMatrix(int array[][], int key) {
        
        for (int index1 = 0; index1 < array.length; index1++){
            for (int index2 = 0; index2 < array[index1].length; index2++){
                if (array[index1][index2] == key){
                    System.out.println("Row index : " + index1 + 
                            " Column index : " + index2);
                    return;
                }
            }
        }
        
    }
}
// Time --> O(n^2)   Space --> O(1)



/*
As overall matrix is sorted so if we imagine as matrix as single array
it is sorted array and to find element in sorted array we used 
binary search.

searchInMatrix function:
	-> initialize variable row as matrix size and col as matrix
	column size
	
	-> initialize start = 0 and end = row * column - 1 i.e in below
	marix we have 9 elements if we put in 1-d array the array index 
	will be range from 0 to 8 included so below array start is 0 and 
	end is 8. Similarly matrix end = 3(row) * 3(col) - 1 = 8.
	
	-> while start is less than or equals to end
		-> find middle = (start + end) / 2
		
		-> now using middle we have to find middle element in 
		matrix. 
		For finding middle's row index we will be doing:
			rowIndex = middle / col
		For finding middle's row index we will be doing:
			colIndex = middle % col
		
		-> if array[rowIndex][colIndex] == key return true
		
		-> if array[rowIndex][colIndex] is less than key then it is sure 
		that key is after middle so update start = middle + 1
		
		-> else if array[rowIndex][colIndex] is less than 
		key then it is sure that key is before middle so update 
		end = middle - 1
		
		

*/
class SearchInMatrix {

    public static void main(String[] args) throws Exception {
        int array[][] = {{1, 5, 9},
        {14, 20, 21},
        {30, 34, 43}};

        System.out.println(searchInMatrix(array, 43));
    }

    public static boolean searchInMatrix(int array[][], int key) {

        int row = array.length, col = array[0].length;
        
        int start = 0, end = (row * col - 1);
        
        while (start <= end){
            int middle = (start + end) / 2;
            
            int rowIndex = middle / col;
            int columnIndex = middle % col;
            
            
            if (array[rowIndex][columnIndex] == key){
                System.out.println(rowIndex + " " + columnIndex);
                return true;
            }
            if (array[rowIndex][columnIndex] < key){
                start = middle + 1;
            }
            else{
                end = middle - 1;
            }
        }
        return false;
    }
}
/*
Time complexity --> O(log(n + m)) where n is row and m is column
because simple binary seach time complexity is O(logn), but we 
are doing on matrix so O(log(n + m))

Space complexity --> O(1)
*/
