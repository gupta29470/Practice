/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class find_smallest{
	public static void main (String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    int n=Integer.parseInt(br.readLine()),ans=0;
		    String s=br.readLine();
		    String s1[]=s.split(" ");
		    int a[]=new int[n];
		    for(int i=0;i<n;i++) a[i]=Integer.parseInt(s1[i]);
		    ans=a[0];
		    for(int i=1;i<n;i++){
		    ans=Math.min(a[i],ans);
		}
		    System.out.println(ans);
		}
	}
}