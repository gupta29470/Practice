/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s[] = br.readLine().trim().split(" ");
            int a[] = new int[n];

            for (int index = 0; index < n; index++) {
                a[index] = Integer.parseInt(s[index]);
            }
            
            int left[] = new int[n];
            left[0] = 0;
            for (int index = 1; index < n; index++){
                left[index] = left[index - 1] + a[index - 1];
            }
            StringBuffer sb = new StringBuffer();
            int right = 0;
            for (int index = n - 1; index >=0; index--){
                if (left[index] == right){
                    sb.append(index + 1);
                } 
                right+= a[index];
            }
            if(sb.length() == 0){
                sb.append("-1");
            }
            System.out.println(sb);
            
        }
	}
}