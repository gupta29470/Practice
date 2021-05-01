import java.io.*;
import java.util.*;

public class vita {

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

            int nos = Integer.parseInt(br.readLine());

            if (n == 0 || nos == 0) {
                return;
            }
            if (n < nos) {
                return;
            }
            Arrays.sort(a); 
            int minDiff = Integer.MAX_VALUE;
            for (int index = 0; index + nos - 1 < n; index++) {
                int diff = a[index + nos - 1] - a[index];
                if (diff < minDiff) {
                    minDiff = diff;
                }
            }
            System.out.println(minDiff);

        }
    }

}
//Time --> O(nLogn)