/*
Matrix is sorted as per each row so as column
Given an n x n matrix and a number x, find the position of x in the 
matrix if it is present in it. Otherwise, print “Not Found”. 
In the given matrix, every row and column is sorted in increasing order.
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
******************** EFFICIENT APPORACH ******************************

Approach: The simple idea is to remove a row or column in each comparison 
until an element is found. Start searching from the top-right corner of the 
matrix. There are three possible cases. 

1. The given number is greater than the current number: This will ensure, 
that all the elements in the current row are smaller than the given number 
as the pointer is already at the right-most element and the row is sorted. 
Thus, the entire row gets eliminated and continue the search on the next row.
Here elimination means that row needs not to be searched.

2. The given number is smaller than the current number: This will ensure, 
that all the elements in the current column are greater than the given 
number. Thus, the entire column gets eliminated and continue the search 
on the previous column i.e. the column at the immediate left.

3. The given number is equal to the current number: This will end the 
search.

Algorithm: 
Let the given element be x, create two variable i = 0, j = n-1 as 
index of row and column
Run a loop until i = 0
Check if the current element is greater than x then decrease the count 
of j. Exclude the current column.
Check if the current element is less than x then increase the count of i. 
Exclude the current row.
If the element is equal then print the position and end.
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
        
        int index1 = 0, index2 = array.length - 1;
        
        while (index1 < array.length && index2 > 0){
            if (array[index1][index2] == key){
                System.out.println("Row index : " + index1 + 
                            " Column index : " + index2);
                    return;
            }
            else if (array[index1][index2] > key){
                index2--;
            }
            else{ // if mat[index1][index2] < x
                index1++;
            }
        }
        
    }
}
// Time --> O(n)   Space --> O(1)