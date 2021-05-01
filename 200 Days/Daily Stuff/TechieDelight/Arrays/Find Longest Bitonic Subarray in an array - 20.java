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

            int increasing[] = new int[n];
            int decreasing[] = new int[n];
            
            increasing[0] = 1; decreasing[n - 1] = 1;
            
            for (int index = 1; index < n; index++){
                increasing[index] = 1;
                if (a[index] > a[index - 1]){
                    increasing[index] = increasing[index - 1] + 1;
                }
            }
            
            for (int index = n - 2; index >= 0; index--){
                decreasing[index] = 1;
                if (a[index] > a[index + 1]){
                    decreasing[index] = decreasing[index + 1] + 1;
                }
            }
            
            int maxLen = 0, start = 0, end =0;
            
// Longest Bitonic Subsequence formula = increasing[index] + decreasing[index] - 1;
            
            for (int index = 0; index < n; index++){
                int len = increasing[index] + decreasing[index] - 1;
                if (maxLen < len){
                    maxLen = len;
                    start = index - increasing[index] + 1;
                    end = index + decreasing[index] - 1;
                }
            }
            
            System.out.println("Start : "+start);
            System.out.println("End : "+end);
            System.out.println("Longest Bitonic Subsequence : "+maxLen);
            
        }
    }

}

Time  ---> O(n)  Space ---> O(n)


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

            int start = 0, end = 0;
            int maxLen = 1;
            int index = 0; 
            while (index + 1 < n){
                int len = 1;
                while(index + 1 < n && a[index] < a[index + 1]){
                    index ++; 
                    len ++;
                }
                
                while(index + 1 < n && a[index] > a[index + 1]){
                    index ++;
                    len ++;
                }
                
                
                if (maxLen < len){
                    maxLen = len;
                    end = index;
                }
            }
            start = end - maxLen + 1;
            System.out.println("Start : "+start);
            System.out.println("End : "+end);
            System.out.println("Longest Bitonic Subsequence : "+maxLen);
            
            
        }
    }

}
Time  ---> O(n)  Space ---> O(1)