/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Binary_Array_Sorting_from_stratch {
	public static void main (String[] args) {
	Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    for(int i=0;i<n;i++){
		        a[i]=sc.nextInt();
		    }
			/*
			int j=-1;
		    for(int i=0;i<n;i++){
		        if(a[i]<1){
		            j++;
		            a[i]=a[i]^a[j];
		            a[j]=a[i]^a[j];
		            a[i]=a[i]^a[j];
		        }
		    }*/
		    Arrays.sort(a);
		    StringBuffer s = new StringBuffer(); 
		    for(int i=0;i<n;i++){
		        s.append(a[i]+" ");
		        
		    }
		    System.out.print(s);
		    System.out.println();
		}
	}
}
/*Given a binary array A[] of size N. The task is to arrange array in increasing order.

Note: The binary array contains only 0  and 1.

Input:
The first line of input contains an integer T, denoting the testcases. Every test case contains two lines, first line is N(size of array) and second line is space separated elements of array.

Output:
Space separated elements of sorted arrays. There should be a new line between output of every test case.

Constraints:
1 < = T <= 100
1 <= N <= 106
0 <= A[i] <= 1

Example:
Input:
2
5
1 0 1 1 0
10
1 0 1 1 1 1 1 0 0 0

Output:
0 0 1 1 1
0 0 0 0 1 1 1 1 1 1