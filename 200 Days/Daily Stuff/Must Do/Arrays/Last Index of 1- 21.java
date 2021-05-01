/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0){
		    String s = br.readLine();
		    int max = Integer.MIN_VALUE;
		    for (int index = 0; index < s.length(); index++){
		        if (s.charAt(index) == '1'){
		            max = Math.max(max, index);
		        }
		    }
		    if (max == Integer.MIN_VALUE){
		        System.out.println("-1");
		    }
		    else{
		        System.out.println(max);
		    }
		}
	}
}