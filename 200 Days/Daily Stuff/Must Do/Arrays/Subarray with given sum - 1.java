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
            int k = Integer.parseInt(in[1]);
            String s[] = br.readLine().trim().split(" ");
            int a[] = new int[n];
            for (int index = 0; index < n; index++) {
                a[index] = Integer.parseInt(s[index]);
            }

            int sum = 0, start = 0, flag = 0;
            
            for (int index = 0; index < n; index++){
                if (sum + a[index] <= k){
                    sum+= a[index];
                }
                else{
                    sum+= a[index];
                    while (sum > k){
                        sum-= a[start];
                        start++;
                    }
                }
                if (sum == k){
                    System.out.printf("%d %d", start+1, index+1);
                    System.out.println();
                    flag = 1;
                    break;
                }
            }
            if (flag == 0){
                System.out.println("-1");
            }
        }
    }
}
