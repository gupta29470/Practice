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
            int count0 = 0, count1 = 0;
            for (int index = 0; index < a.length; index++) {
                if (a[index] == 0) {
                    count0++;
                } else if (a[index] == 1) {
                    count1++;
                }

            }
            int index = 0;
            while (count0-- > 0) {
                a[index] = 0;
                index++;
            }
            while (count1-- > 0) {
                a[index] = 1;
                index++;
            }
            for (int value : a) {
                System.out.print(value + " ");
            }

        }
    }
}
