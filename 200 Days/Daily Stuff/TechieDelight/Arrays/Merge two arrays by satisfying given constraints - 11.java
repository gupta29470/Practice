import java.io.*;
import java.util.*;

public class vita {

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
            for (int index = 0; index < s.length; index++) {
                a[index] = Integer.parseInt(s[index]);
            }
            for (int index = 0; index < t.length; index++) {
                b[index] = Integer.parseInt(t[index]);
            }
            
            rearrange(a, b);
            System.out.println(Arrays.toString(a));

        }
    }

    public static void rearrange(int a[], int b[]) {
        int index = 0;
        for (int value : a) {
            if (value != 0) {
                a[index++] = value;
            }
        }
        merge(a, b, index - 1, b.length - 1);

    }

    public static void merge(int a[], int b[], int aLength, int bLength) {
        int shiftIndex = aLength + bLength + 1;

        while (aLength >= 0 && bLength >= 0) {
            if (a[aLength] > b[bLength]) {
                a[shiftIndex--] = a[aLength--];
            } else {
                a[shiftIndex--] = b[bLength--];
            }
        }

        while (bLength >= 0) {
            a[shiftIndex] = b[bLength--];

        }
        Arrays.fill(b, 0);

    }

}



Time --> O(m + n)   Space --> o(1)