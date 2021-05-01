import java.util.*;

public class Skew_matrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int a[][] = new int[row][col];
        int b[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        if (symmetric(a, row, col)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
		}

    static boolean symmetric(int a[][], int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (a[i][j] != -a[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

}