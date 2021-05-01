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
            
            boolean flag = true;
            
            for (int index = 0; index <= n - 2; index++){
                if (flag){
                    if (a[index] > a[index + 1]){
                        int temp = a[index];
                        a[index] = a[index + 1];
                        a[index + 1] = temp;
                    }
                }
                else{
                    if (a[index] < a[index + 1]){
                        int temp = a[index];
                        a[index] = a[index + 1];
                        a[index + 1] = temp;
                    }
                }
                flag = !flag;
            }
            for (int val : a){
                System.out.print(val+" ");
            }
            System.out.println();
        }

	}
}