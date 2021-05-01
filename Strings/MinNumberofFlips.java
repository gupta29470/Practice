import java.io.*;
import java.util.*;

public class MinNumberofFlips {

    public static int alternate(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0 && s.charAt(i) == '1') {
                ans++;
               // System.out.println(ans);
            } else if (i % 2 == 1 && s.charAt(i) == '0') {
                ans++;
               // System.out.println(ans);
            }
           // System.out.println(ans);
            //System.out.println(n-ans);

        }
        return Math.min(ans, n - ans);

    }

    public static void main(String[] args) {
        String s = "0101";
        System.out.println(alternate(s));
    }
}
