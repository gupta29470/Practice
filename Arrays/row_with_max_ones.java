import java.util.*;
import java.io.*;
import java.math.*;

public class row_with_max_ones {

//    /* Driver code */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int a[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println(find(m,n,a));
        

    }
    static int find(int m,int n,int a[][]){
        int row=0,i=0,j=n-1;
        while(i<m && j>=0){
            if(a[i][j]==1){
                row=i;
                j--;
            }
            else
            {
                i++;
            }
        }
        return row;
    }
}
