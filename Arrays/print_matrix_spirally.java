/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class print_matrix_spirally {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
        int m=sc.nextInt();
        int n=sc.nextInt();
        int a[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sc.nextInt();            
                
            }
        }
        print_mat(m,n,a);
	}
}
        static void print_mat(int m,int n,int a[][]){
            int i,row=0,col=0,last_row=m-1,last_col=n-1;
            while(row<=last_row && col<=last_col){
                for(i=col;i<=last_col;i++){
                    System.out.print(a[row][i]+" ");
                }
                row++;
                for(i=row;i<=last_row;i++){
                    System.out.print(a[i][last_col]+" ");
                }
                last_col--;
                if(row<=last_row){
                    for(i=last_col;i>=col;i--){
                        System.out.print(a[last_row][i]+" ");
                    }
                }
                last_row--;
                if(col<=last_col){
                    for(i=last_row;i>=row;i--){
                        System.out.print(a[i][col]+" ");
                    }
                }
                col++;
            }
        
        System.out.println();
	}
	
}
//https://www.geeksforgeeks.org/accolite-interview-on-campus/