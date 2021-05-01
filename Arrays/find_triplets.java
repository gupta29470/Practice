/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class find_triplets {
	 public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++)
	        a[i] = sc.nextInt();
            System.out.println(triplet(a,n,x));
        }
    }
    static int triplet(int a[],int n,int x){
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    if(a[i]+a[j]+a[k]==x){
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}

