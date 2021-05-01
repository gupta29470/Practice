import java.util.*;
public class End_Point_of_a_Matrix {

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
        int direction = 0;
        // 0 -> east
        // 1 -> south
        // 2 -> west
        // 4 -> north

        int i = 0, j = 0;
        while (true) {
            direction = (direction + a[i][j]) % 4;

            if (direction == 0) {
                j++;
            } else if (direction == 1) {
                i++;
            } else if (direction == 2) {
                j--;
            } else if (direction == 3) {
                i--;
            }

            // checking edge cases
            if (i < 0) {
                i++;
                break;
            } else if (j < 0) {
                j++;
                break;
            } else if (i == a.length) {
                i--;
            } else if (j == a.length) {
                j--;
            }

        }
        System.out.println(i);
        System.out.println(j);

    }

}
