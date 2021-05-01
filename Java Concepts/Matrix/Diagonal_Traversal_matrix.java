import java.io.*;
import java.util.*;

public class Diagonal_Traversal_Matrix {

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
        
        for (int gap = 0; gap < rows; gap++){
            for (int i = 0, j = gap; j < rows ; i++,j++){
                System.out.println(a[i][j]);
            }
        }
        
    }

}