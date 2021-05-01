/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class find_consecutive_seuence {
	public static void main (String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
		    int n=Integer.parseInt(br.readLine()),ans=0;
		    String s=br.readLine();
		    String s1[]=s.split(" ");
		    int a[]=new int[n];
		    for(int i=0;i<n;i++) a[i]=Integer.parseInt(s1[i]);
		    Set<Integer> st=new HashSet<>();
		    for(int i:a){
		        st.add(i);
		    }
		    for(int i=0;i<n;i++){
		        if(!st.contains(a[i]-1)){
		            int j=a[i];
		            while(st.contains(j)){
		                j++;
		            }
		            if(ans<j-a[i]){
		                ans=j-a[i];
		            }
		        }
		    }
		    System.out.println(ans);
		}
	}
}