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

            int maxLen = 0, start = 0, end = 0;

            Set<Integer> set = new HashSet<>();
            for (int index = 0; index < n; index++) {
                set.add(a[index]);
            }

            for (int index = 0; index < n; index++) {
                if (!set.contains(a[index] - 1)) {
                    int temp = a[index];

                    while (set.contains(temp)) {
                        temp++;
                    }

                    if (maxLen < temp - a[index]) {
                        maxLen = temp - a[index];
                        start = index;
                        end = temp;
                    }
                }
            }
            System.out.println("Start : " + start + "  End : " + end);
            System.out.println(maxLen);
        }
    }
}
