import java.util.*;
import java.lang.*;
import java.io.*;

class Union {
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
		int t;t=sc.nextInt();
		while(t-->0)
		{
		    int m,n,i;m=sc.nextInt();n=sc.nextInt();
		    int a[]=new int[m];
		    int b[]=new int[n];
		    for(i=0;i<m;i++)
		    
		        a[i]=sc.nextInt();
		    
		    for(i=0;i<n;i++)
		    
		        b[i]=sc.nextInt();
		    
		    HashSet<Integer> set=new HashSet<>();
		    int res=0;
		    for(i=0;i<a.length;i++)
		    {
		        if(!set.contains(a[i]))
		        {
		            set.add(a[i]);
		            res++;
		        }
		    }for(i=0;i<b.length;i++)
		    {
		        if(!set.contains(b[i]))
		        {
		            set.add(b[i]);
		            res++;
		        }
		    }
		    System.out.println(res);
		}
	}
}