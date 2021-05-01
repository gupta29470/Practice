/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws Exception {
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
            int right[] = new int[n];
            StringBuilder sb = new StringBuilder();
            
            left[0] = 1; right[n - 1] = 1;
            for (int index = 1; index < n; index++){
                left[index] = left[index - 1] * a[index - 1];
            }
            
            for (int index = n - 2; index >= 0; index--){
                right[index] = right[index + 1] * a[index + 1];
            }
            
            for (int index = 0; index < n; index ++){
                a[index] = left[index] * right[index];
                sb.append(a[index]+" ");
            }
            System.out.println(sb);
            
        }
    }

}


Time --> O(n)  Space --> O(n)