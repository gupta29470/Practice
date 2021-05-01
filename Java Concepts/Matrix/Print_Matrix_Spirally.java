import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int a[][] = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int maxrow = rows - 1, maxcol = cols - 1;
        int i, row = 0, col = 0;
        while (row <= maxrow && col <= maxcol) {
            // First Column
            for (i = row; i <= maxrow; i++) {
                System.out.println(a[i][col]);
            }
            col += 1;

            // Last Row
            for (i = col; i <= maxcol; i++) {
                System.out.println(a[maxrow][i]);
            }
            maxrow -= 1;

            // Last column
            if (col <= maxcol) {
                for (i = maxrow; i >= row; i--) {
                    System.out.println(a[i][maxcol]);
                }
            }
            maxcol -= 1;

            // First Column
            if (row <= maxrow) {
                for (i = maxcol; i >= col; i--) {
                    System.out.println(a[row][i]);
                }
            }
            row += 1;
        }

    }

}
