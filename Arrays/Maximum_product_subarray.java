import java.util.*;
import java.io.*;
import java.math.*;

public class Maximum_product_subarray {

    static int min(int x, int y) {
        return x < y ? x : y;
    }

    static int max(int x, int y) {
        return x > y ? x : y;
    }

    static int sub(int[] a) {
        int maxeh = 1, mineh = 1, msf = 1, flag = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                maxeh = maxeh * a[i];
                mineh = min(mineh * a[i], 1);
                flag = 1;
            } else if (a[i] == 0) {
                maxeh = 1;
                mineh = 1;
            } else {
                int temp = maxeh;
                maxeh = max(mineh * a[i], 1);
                mineh = temp * a[i];
            }
            if (msf < maxeh) {
                msf = maxeh;
            }
        }
        if (flag == 0 && msf == 1) {
            return 1;
        }
        return msf;
    }

    public static void main(String args[]) throws Exception {
        int arr[] = {1, -2, -3, 0, 7, -8, -2 };
        System.out.println("Maximum Sub array product is "
                + sub(arr));
    }
}

//import java.io.*;
//public class Problem4A{
//public static void main(String args[]){
//    //}
//}
