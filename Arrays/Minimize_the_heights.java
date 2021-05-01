/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Minimize_the_heights {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int k=sc.nextInt();
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    for(int i=0;i<n;i++) a[i]=sc.nextInt();
		    System.out.println(mindiff(a,n,k));
		    
		}
	}
	static int mindiff(int a[],int n,int k){
	    if(n==1) return 0;
		    Arrays.sort(a);
		    int ans=a[n-1]-a[0];
		    int small=a[0]+k; int big=a[n-1]-k;
		    if(small>big){
		        small^=big;
		        big^=small;
		        small^=big;
		    }
		    for(int i=1;i<n-1;i++){
		        int sub=a[i]-k;
		        int add=a[i]+k;
		        if(sub>=small || add<=big) continue;
		        if(big-sub<add-small){
		            small=sub;
		        }
		        else{
		            big=add;
		        }
		    }
		    return Math.min(ans,big-small);
	}
	
}