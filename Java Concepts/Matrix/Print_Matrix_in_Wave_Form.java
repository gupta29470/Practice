import java.io.*;
import java.util.*;

public class Print_Matrix_in_Wave_Form{

public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int rows = sc.nextInt();
    int cols = sc.nextInt();
    int a[][] = new int[rows][cols];
    
    for (int i = 0; i < rows; i++){
        for (int j = 0; j < cols; j++){
            a[i][j] = sc.nextInt();
        }
    }
    for (int col = 0; col < cols; col ++){
        if(col % 2 == 0){
            for (int row = 0; row < rows; row ++){
                System.out.println(a[row][col]);
            }
        }
        else{
            for (int row = rows - 1; row >= 0; row --){
                System.out.println(a[row][col]);
            }
        }
    }
    
    
    }

}
