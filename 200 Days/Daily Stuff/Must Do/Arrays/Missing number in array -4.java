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
            for (int index = 0; index < n - 1; index++) {
                a[index] = Integer.parseInt(s[index]);
            }

            int x1 = 0, x2 = 0;
            for (int index = 0; index < n - 1; index++) {
                x1 = x1 ^ a[index];
            }
            for (int index = 1; index <= n; index++) {
                x2 = x2 ^index;
            }
            System.out.println(x1 ^ x2);
        }
    }
}
