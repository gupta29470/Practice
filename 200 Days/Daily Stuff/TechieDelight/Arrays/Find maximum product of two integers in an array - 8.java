import java.io.*;
import java.util.*;

public class vita {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s[] = br.readLine().trim().split(" ");
            int a[] = new int[n];
            for (int index = 0; index < s.length; index++) {
                a[index] = Integer.parseInt(s[index]);
            }
            int max = Integer.MIN_VALUE;
            for (int index1 = 0; index1 < n; index1++) {
                for (int index2 = index1 + 1; index2 < n; index2++) {
                    int prod = a[index1] * a[index2];
                    max = Math.max(max, prod);
                }
            }
            System.out.println(max);

        }
    }
}
Time O(n^2)

import java.io.*;
import java.util.*;

public class vita {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s[] = br.readLine().trim().split(" ");
            int a[] = new int[n];
            for (int index = 0; index < s.length; index++) {
                a[index] = Integer.parseInt(s[index]);
            }
            int max = 0;
            Arrays.sort(a);
            if ((a[0] * a[1]) < a[n - 1] * a[n - 2]) {
                max = a[n - 1] * a[n - 2];
            } else {
                max = a[0] * a[1];
            }
            System.out.println(max);
        }
    }
}
Time ---> (n Logn)


