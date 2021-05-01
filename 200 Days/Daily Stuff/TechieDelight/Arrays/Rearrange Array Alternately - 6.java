/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            String in[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(in[0]);
            String s[] = br.readLine().trim().split(" ");
            int a[] = new int[n];
            for (int index = 0; index < n; index++) {
                a[index] = Integer.parseInt(s[index]);
            }
            StringBuilder sb = new StringBuilder();
            if (n % 2 == 0){
               int pointer1 = n - 1, pointer2 = 0;
                
                while (pointer2 < pointer1){
                    sb.append(a[pointer1]+" ");
                    sb.append(a[pointer2]+" ");
                    pointer1 --; pointer2 ++;
                } 
            }
            else{
                int pointer1 = n - 1, pointer2 = 0;
                
                while (pointer2 < pointer1){
                    sb.append(a[pointer1]+" ");
                    sb.append(a[pointer2]+" ");
                    pointer1 --; pointer2 ++;
                }
                sb.append(a[pointer2]);
            }
            
            System.out.println(sb);
        }
	}
}