import java.io.*;
import java.util.*;

public class Saddle_Point_Matrix {

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

        // finding min in row
        for (int i = 0; i < rows; i++){
            int min_max = 0;
            for (int j = 0; j < rows; j++){
                if(a[i][j] < a[i][min_max]){
                    min_max = j;
                }
            }
            
            
            // check if min is max in column
            boolean flag = true;
            for (int k = 0; k < rows; k++){
                if (a[k][min_max] > a[i][min_max]){
                    flag = false;
                    break;
                }
            }
            
            if (flag == true){
                System.out.println(a[i][min_max]);
                return;
            }
        }
        System.out.println("Invalid input");

    }

}
