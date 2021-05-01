/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		try{
		     Scanner sc=new Scanner(System.in);
		    int t=sc.nextInt();
		    while(t-->0){
		        int n=sc.nextInt();
		        int a[]=new int[n];
		        for(int i=0;i<n;i++){
		            a[i]=sc.nextInt();
		        }
		        int b=a[0];
		        for(int i=1;i<n;i++){
		            b=b&a[i];
		        }
		        if(b==0)
		       System.out.println("Yes");
		       else
		      System.out.println("No");
		    }
		}
		catch(Exception e){
		    System.out.println(e);
		}
	}
}
