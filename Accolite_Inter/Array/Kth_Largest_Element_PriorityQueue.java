/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Kth_Largest_Element_PriorityQueue {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-->0){
		    int n=sc.nextInt();
		    int k=sc.nextInt();
		    int a[]=new int[n];
		    for(int i=0;i<n;i++){
		        a[i]=sc.nextInt();
		    }
		    PriorityQueue<Integer> pq=new PriorityQueue<>();
		    for(int i=0;i<n;i++){
		        if(i<k){
		            pq.add(a[i]);
		        }
		        else{
		            if(pq.peek()<a[i]){
		                pq.poll();
		                pq.add(a[i]);
		            }
		        }
		    }
		    ArrayList<Integer> arr=new ArrayList<>(pq);
		    Collections.sort(arr,Collections.reverseOrder());
		    for(int i=0;i<arr.size();i++){
		        System.out.print(arr.get(i)+" ");
		    }
		    System.out.println();
		}
	}
}