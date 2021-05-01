import java.io.*;
import java.util.*;

public class vita {

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int test = Integer.parseInt(br.readLine());
//        while (test-- > 0) {
//            int n = Integer.parseInt(br.readLine());
//            String s[] = br.readLine().trim().split(" ");
//
//        }
        int a[] = {2,2,1,1,1,2,2};

        int res = majorityElement(a);
        System.out.println(res);

    }

    public static int majorityElement(int[] a) {
        int cand = findCandidate(a, a.length);
        int res = isMajority(a, a.length, cand);
        return res;
    }

    public static int findCandidate(int a[], int size) {
        int count = 1, me = a[0];
        for (int index = 1; index < a.length; index++) {
            if (me == a[index]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                count = 1;
                me = a[index];
            }
        }
        return me;
    }

    public static int isMajority(int a[], int size, int cand) {
        int count = 0;
        for (int index = 0; index < size; index++) {
            if (cand == a[index]) {
                count++;
            }
        }
        if (count > size / 2) {
            return cand;
        }
        return -1;
    }
}
