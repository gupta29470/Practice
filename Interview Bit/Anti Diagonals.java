public class Solution {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int len = A.size();
        for (int index = 0; index < len; index++){
            int col = index, row = 0;
            ArrayList<Integer> temp = new ArrayList<>();
            while (col >= 0){
                temp.add(A.get(row).get(col));
                row ++;
                col --;
            }
            res.add(temp);
        }
        
        for (int index = 1; index < len; index++){
            int row = index, col = len - 1;
            ArrayList<Integer> temp = new ArrayList<>();
            while (row < len){
                temp.add(A.get(row).get(col));
                row ++;
                col --;
            }
            res.add(temp);
        }
        return res;
    }
}


import java.util.*;

public class vita {

    public static void main(String[] args) {

        int a[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

        for (int index = 0; index < a.length; index++) {
            int col = index, row = 0;
            ArrayList<Integer> temp = new ArrayList<>();

            while (col >= 0) {
                temp.add(a[row][col]);
                row++;
                col--;
            }
            arr.add(temp);
        }
        for (int index = 1; index < a.length; index++) {
            int row = index, col = a.length - 1;

            ArrayList<Integer> temp = new ArrayList<>();
            while (row < a.length) {
                temp.add(a[row][col]);
                row++;
                col--;
            }
            arr.add(temp);
        }

        System.out.println(arr);
    }

}
Time --> O(n ^ 2)