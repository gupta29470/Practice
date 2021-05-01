import java.io.*;
import java.util.*;

public class Search_in_2d_Sorted_Array_BinarySearch{

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
        int key = sc.nextInt();
        int i = 0;
        int j = cols - 1;
        while (i < rows && j >= 0){
            if(key == a[i][j]){
                System.out.println(i);
                System.out.println(j);
                return;
            }
            if(key > a[i][j]){
                i++;
            }
            else{
                j--;
            }
        }
        System.out.println("Not Found");
    }

}