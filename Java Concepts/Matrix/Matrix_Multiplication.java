import java.util.*;
import java.math.*;

public class Matrix_Multiplication {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int row1 = sc.nextInt();
        int col1 = sc.nextInt();

        int[][] a = new int[row1][col1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int row2 = sc.nextInt();
        int col2 = sc.nextInt();
        if (row2 != col1) {
            System.out.println("Invalid input");
            return;
        }
        int[][] b = new int[row2][col2];
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < col2; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        int result[][] = new int[row1][col2];
        int sum = 0;
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                sum = 0;
                for (int k = 0; k < col1; k++) {
                    sum = sum + a[i][k] * b[k][j];
                }
                result[i][j] = sum;
            }
        }

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

}
