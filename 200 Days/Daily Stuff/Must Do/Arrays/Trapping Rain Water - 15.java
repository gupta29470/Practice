/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		
		while (test-- > 0){
		    
		    int n = Integer.parseInt(br.readLine());
		    String s[] = br.readLine().trim().split(" ");
		    int a[] = new int[n];
		    for (int index = 0; index < n; index++){
		        a[index] = Integer.parseInt(s[index]);
		    }
		    
		    int maxL[] = new int[n]; maxL[0] = a[0];
		    
		    int maxR[] = new int[n]; maxR[n - 1] = a[n - 1];
		    
		    int water[] = new int[n];
		    
		    for (int index = 1; index < n; index++){
		        maxL[index] = Math.max(a[index], maxL[index - 1]);
		    }
		    
		    for (int index = n - 2; index >= 0; index--){
		        maxR[index] = Math.max(a[index], maxR[index + 1]);
		    }
		    
		    for (int index = 0; index < n; index++){
		        water[index] = Math.min(maxL[index], maxR[index]) - a[index]; 
		    }
		    
		    System.out.println(Arrays.stream(water).sum());
		}
	}
}

Time --> O(n)   Space --> O(n)



/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		
		while (test-- > 0){
		    
		    int n = Integer.parseInt(br.readLine());
		    String s[] = br.readLine().trim().split(" ");
		    int a[] = new int[n];
		    for (int index = 0; index < n; index++){
		        a[index] = Integer.parseInt(s[index]);
		    }
		    
		    
		    int leftind = 0, rightind = n - 1, leftmax = 0, rightmax = 0, water = 0;
		    
		    while (leftind <= rightind){
		        if (a[leftind] < a[rightind]){
		            if (a[leftind] > leftmax){
		                leftmax = a[leftind];
		            }
		            else{
		                water+= leftmax - a[leftind];
		                leftind++;
		            }
		        }
		        else{
		            if (a[rightind] > rightmax){
		                rightmax = a[rightind];
		            } 
		            else{
		                water+= rightmax - a[rightind];
		                rightind--;
		            }
		        }
		        
		    }
		    System.out.println(water);
		    
		}
	}
}

Time --> O(n)  Space --> O(1)
Time --> O(n)  Space --> O(1)