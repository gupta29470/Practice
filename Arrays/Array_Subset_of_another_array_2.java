/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Array_Subset_of_another_array_2 {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int m=sc.nextInt();
		    int n=sc.nextInt();
		    int a[]=new int[m];
		    int b[]=new int[n];
		    for(int i=0;i<m;i++){
		        a[i]=sc.nextInt();
		    }
		    for(int i=0;i<n;i++){
		        b[i]=sc.nextInt();
		    }
		    Set<Integer>st=new HashSet<>();
		    int counter=0;
		    for(int i=0;i<m;i++){
		        st.add(a[i]);
		    }
		    for(int i=0;i<n;i++){
		        if(st.contains(b[i])){
		            counter++;
		        }
		    }
		    if(counter==b.length){
		        System.out.println("Yes");
		    }
		    else{
		        System.out.println("No");
		    }

		}
	}
}