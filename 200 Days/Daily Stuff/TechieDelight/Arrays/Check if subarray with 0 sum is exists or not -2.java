/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test =Integer.parseInt(br.readLine());
		while (test-- > 0){
		    int n = Integer.parseInt(br.readLine());
		    String s[] = br.readLine().trim().split(" ");
		    int a[] = new int[n];
		    for (int index = 0; index < s.length; index++){
		        a[index] = Integer.parseInt(s[index]);
		    }
		    Set <Integer> set = new HashSet<>();
		    set.add(0);
		    int sum = 0;
		    boolean flag = false;
		    for (int index = 0; index < a.length; index++){
		        sum+= a[index];
		        
		        if(set.contains(sum)){
		            flag = true;
		            break;
		        }
		        set.add(sum);
		    }
		    if (flag == true){
		        System.out.println("Yes");
		    }
		    else {
		        System.out.println("No");
		    }
		}
	}
}