/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Intersection {
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int t;t=sc.nextInt();
	    while(t-->0)
	    {
		int m,n;
		m=sc.nextInt();
		n=sc.nextInt();
		int a[]=new int[m];
		int b[]=new int[n];
		for(int i=0;i<m;i++)
		{
		    a[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++)
		{
		    b[i]=sc.nextInt();
		}
	
	    HashSet<Integer> set=new HashSet<>();
	    int res=0;
	    for(int i=0;i<a.length;i++)
	    {
	        set.add(a[i]);
	        
	    }
	    for(int i=0;i<b.length;i++)
	    {
	        if(set.contains(b[i]))
	        {
	            res++;
	            set.remove(b[i]);
	        }
	    }
	    System.out.println(res);
	    }
	}
	    
		    
		   
}