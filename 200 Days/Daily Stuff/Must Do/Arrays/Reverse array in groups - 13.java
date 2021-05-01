/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0){
		    String in[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(in[0]);
		    int k = Integer.parseInt(in[1]);
		    
		    String s[] = br.readLine().trim().split(" ");
		    int a[] = new int[n];
		    for (int index = 0; index < n; index++){
		        a[index] = Integer.parseInt(s[index]);
		    }
		    
		    for (int index = 0; index < n; index+= k){
		        int left = index , right = Math.min(index + k - 1, n - 1);
		        
		        while (left < right){
		            int temp = a[left];
		            a[left] = a[right];
		            a[right] = temp;
		            left ++;
		            right --;
		        }
		    }
		    
		    for (int val : a){
		        System.out.print(val+" ");
		    }
		    
		    System.out.println();
		}
	}
}

Time --> O(n)