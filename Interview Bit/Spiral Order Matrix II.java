public class Solution {
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        int row = 0, col = 0, maxRow = A - 1, maxCol = A - 1;
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        
        for (int index = 0; index < A; index++){
            ArrayList<Integer> temp = new ArrayList<Integer>(Collections.nCopies(A, 0));
            ans.add(temp);
        }
        int fill = 1;
        while (row <= maxRow && col <= maxCol){
            for (int index = col; index <= maxCol; index++){
                ans.get(row).set(index, fill);
                fill++;
            }
            row ++;
            
            for (int index = row; index <= maxRow; index++){
                ans.get(index).set(maxCol, fill);
                fill++;
            }
            maxCol --;
            
            if (row <= maxRow){
                for (int index = maxCol; index >= col; index--){
                    ans.get(maxRow).set(index, fill);
                    fill++;
                }
            }
            maxRow --;
            
            if (col <= maxCol){
                for (int index = maxRow; index >= row; index--){
                    ans.get(index).set(col, fill);
                    fill++;
                }
            }
            col ++;
        }
        return ans;
    }
}
// Time Complexity: O(m*n).