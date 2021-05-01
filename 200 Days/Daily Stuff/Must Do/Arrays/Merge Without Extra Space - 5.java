/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            String input[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            String s[] = br.readLine().trim().split(" ");
            String t[] = br.readLine().trim().split(" ");
            int a[] = new int[n];
            int b[] = new int[m];
            for (int index = 0; index < n; index++) {
                a[index] = Integer.parseInt(s[index]);
            }
            for (int index = 0; index < m; index++) {
                b[index] = Integer.parseInt(t[index]);
            }

            int pointer1 = n - 1, pointer2 = 0;
            while (pointer1 >= 0 && pointer2 < m){
                if (a[pointer1] > b[pointer2]){
                    int temp = a[pointer1];
                    a[pointer1] = b[pointer2];
                    b[pointer2] = temp;
                }
                pointer1 --;
                pointer2 ++;
            }
            Arrays.sort(a);
            Arrays.sort(b);
            StringBuilder sb = new StringBuilder();
            for (int index = 0; index < n; index++){
                sb.append(a[index]+ " ");
            }
            for (int index = 0; index < m; index++){
                sb.append(b[index]+ " ");
            }
            System.out.println(sb);
        }
    }

}
