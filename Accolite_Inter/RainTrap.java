/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class RainTrap {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-->0){
		    int n=sc.nextInt();
		    int blockHeight[]=new int[n];
		    for(int i=0;i<n;i++){
		        blockHeight[i]=sc.nextInt();
		    }
		    int leftMost[]=new int[n];
		    int rightMost[]=new int[n];
		    leftMost[0]=blockHeight[0];
		    rightMost[n-1]=blockHeight[n-1];
		    for(int index=1;index<n;index++){
		        leftMost[index]=Math.max(leftMost[index-1],blockHeight[index]);
		    }
		    for(int index=n-2;index>=0;index--){
		        rightMost[index]=Math.max(rightMost[index+1],blockHeight[index]);
		    }
		    int unit=0;
		    for(int index=0;index<n;index++){
		        unit+=Math.min(leftMost[index],rightMost[index])-blockHeight[index];
		    }
		    System.out.println(unit);
		}
	}
}