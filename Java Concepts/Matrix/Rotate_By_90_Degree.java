import java.io.*;
import java.util.*;

public class Rotate_By_90_Degree  {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = rows;
        int a[][] = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        /*
    Two operations have to perform
        1. Transpose
        2. Reverse Columns
         */

        // Transpose 
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < i; j++){
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        // Reverse Columns 
        for(int i = 0; i < rows; i++){
            int left = 0;
            int right = a[0].length - 1;
            while (left <= right){
                int temp = a[i][left];
                a[i][left] = a[i][right];
                a[i][right] = temp;
                left ++;
                right --;
            }
        }
        display(a);

    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

}
