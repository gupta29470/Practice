/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class RainTrap_Efficient {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-->0){
		    int n=sc.nextInt();
		    int blockHeight[]=new int[n];
		    for(int i=0;i<n;i++){
		        blockHeight[i]=sc.nextInt();
		    }
		    int leftmax=0,rightmax=0,leftind=0,rightind=n-1,unit=0;
		    while(leftind<=rightind){
		        if(blockHeight[leftind]<blockHeight[rightind]){
		            if(blockHeight[leftind]>leftmax){
		                leftmax=blockHeight[leftind];
		            }
		            else{
		                unit+=leftmax-blockHeight[leftind];
		                leftind++;
		            }
		        }
		        else{
		            if(blockHeight[rightind]>rightmax){
		                rightmax=blockHeight[rightind];
		            }
		            else{
		                unit+=rightmax-blockHeight[rightind];
		                rightind--;
		            }
		        }
		    }
		    
		    System.out.println(unit);
		}
	}
}