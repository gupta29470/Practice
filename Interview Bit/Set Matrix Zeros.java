import java.io.*;
import java.util.*;

public class vit {

    /* program to test above function */
    public static void main(String args[]) {
        int a[][] = {{0, 1, 1, 1,}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};

        //int col0 = 0, row = a.length, col = a[0].length;
        System.out.println(a.length);
        for (int index1 = 0; index1 < a.length; index1++) {
            for (int index2 = 0; index2 < a[0].length; index2++) {
                if (a[index1][index2] == 0) {
                    fillZeroes(a, index1, index2);
                    break;
                }
            }
        }
        for (int index1 = 0; index1 < a.length; index1++) {
            for (int index2 = 0; index2 < a[0].length; index2++) {
                if (a[index1][index2] == -1) {
                    a[index1][index2] = 0;
                }
            }
        }
        for (int index1 = 0; index1 < a.length; index1++) {
            for (int index2 = 0; index2 < a[0].length; index2++) {
                System.out.print(a[index1][index2] + " ");
            }
            System.out.println("");
        }

    }

    public static void fillZeroes(int arr[][], int a, int b) {

        for (int index = 0; index < arr.length; index++) {
            arr[index][b] = -1;
        }
        for (int index = 0; index < arr.length; index++) {
            arr[a][index] = -1;
        }
    }

}
// Time O(n * m) * O(n + m)
// Space O(1)






public class Solution {
  public void setZeroes(ArrayList<ArrayList<Integer>> a) {
   int col0 = 1, row = a.size(), col = a.get(0).size();
   
   for (int index1 = 0; index1 < row; index1++){
       if (a.get(index1).get(0) == 0){
           col0 = 0;
       }
       for (int index2 = 1; index2 < col; index2++){
           if (a.get(index1).get(index2) == 0){
               a.get(index1).set(0, 0);
               a.get(0).set(index2, 0);
           }
       }
   }
       
       for (int index1 = row - 1; index1 >= 0; index1--){
           for (int index2 = col - 1; index2 >= 1; index2--){
               if (a.get(index1).get(0) == 0 || a.get(0).get(index2)== 0){
                   a.get(index1).set(index2, 0);
               }
               if (col0 == 0){
                   a.get(index1).set(0, 0);
               }
           }
       }
  }
}

// Time ---> O(2 * (n * m))  Space ---> O(1)









public class Solution {
  public void setZeroes(ArrayList<ArrayList<Integer>> a) {
   boolean rowZero = false;
   boolean colZero = false;
   
   int rowSize = a.size(), colSize = a.get(0).size();
   
   for (int index = 0; index < rowSize; index++){
       if (a.get(index).get(0) == 0){
           colZero = true;
           break;
       }
   }
   for (int index = 0; index < colSize; index++){
       if (a.get(0).get(index) == 0){
           rowZero = true;
           break;
       }
   }
   
   for (int index1 = 0; index1 < rowSize; index1++){
       for (int index2 = 0; index2 < colSize; index2++){
           if (a.get(index1).get(index2) == 0){
               a.get(index1).set(0, 0); // Make first element of row zero
               a.get(0).set(index2, 0); // Make first element of col zero
           }
       }
   }
   
    // Make row zero
   for (int index1 = 1; index1 < rowSize; index1++){
       if (a.get(index1).get(0) == 0){
           for (int index2 = 0; index2 < colSize; index2++){
               a.get(index1).set(index2, 0);
           }
       }
   }
   
  // Make col zero
   for (int index1 = 1; index1 < colSize; index1++){
       if (a.get(0).get(index1) == 0){
           for (int index2 = 0; index2 < rowSize; index2++){
               a.get(index2).set(index1, 0);
           }
       }
   }
   
   // if true make 1st row zero
   if (rowZero){
       for (int index = 0; index < colSize; index++){
           a.get(0).set(index, 0);
       }
   }
   
   // if true make 1st col zero
   if (colZero){
       for (int index = 0; index < rowSize; index++){
           a.get(index).set(0, 0);
       }
   }
   
   
  }
}


Time ---> O(4 * (n * m))