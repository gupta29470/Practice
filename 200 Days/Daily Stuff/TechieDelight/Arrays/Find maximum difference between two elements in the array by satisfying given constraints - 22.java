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

            for (int index = 0; index < n; index++) {
                a[index] = Integer.parseInt(s[index]);
            }
            int max = Integer.MIN_VALUE;
            for (int index1 = 0; index1 < n; index1++){
                for (int index2 = index1 + 1; index2 < n; index2++){
                    max = Math.max(max, a[index2] - a[index1]);
                }
            }
            System.out.println(max);
            
        }
    }
}

Time  --> O(n^2)  Space --> O(1)


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

            for (int index = 0; index < n; index++) {
                a[index] = Integer.parseInt(s[index]);
            }

            int max = Integer.MIN_VALUE, maxSoFar = a[n - 1];

            for (int index = n - 2; index >= 0; index--) {
                if (a[index] > maxSoFar) {
                    maxSoFar = a[index];
                } else {
                    max = Math.max(max, maxSoFar - a[index]);
                }
            }
            if (max == Integer.MIN_VALUE) {
                System.out.println("-1");
            } else {
                System.out.println(max);
            }

        }
    }
}
Time  --> O(n)  Space --> O(1)
