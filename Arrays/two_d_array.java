package javaapplication1;

import java.util.*;
import java.io.*;
import java.math.*;
public class two_d_array {
    

//    /* Driver code */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int a[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sc.nextInt();            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }
   
    
    
}
}