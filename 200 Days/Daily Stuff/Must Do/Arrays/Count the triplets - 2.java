/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
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

            int maxVal = Arrays.stream(a).max().getAsInt();
            int freq[] = new int[maxVal + 1];

            for (int index = 0; index < n; index++) {
                freq[a[index]]++;
            }
            
            int count = 0; 
            Arrays.sort(a);
            for (int index = n - 1; index > 0  ; index--){
                int left = 0, right = index - 1;
                while (left < right){
                    if (a[left] + a[right] == a[index]){
                        count ++;
                        left ++;
                        right --;
                    }
                    else if (a[left] + a[right] < a[index]){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
            if (count != 0){
                System.out.println(count);
            }
            else{
                System.out.println(-1);
            }
        }
    }
}


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

            int maxVal = Arrays.stream(a).max().getAsInt();
            int freq[] = new int[maxVal + 1];

            for (int index = 0; index < n; index++) {
                freq[a[index]]++;
            }
            for (int val : freq) {
                System.out.print(val + " ");
            }
            int ans = 0;
            ans += freq[0] * (freq[0] - 1) * (freq[0] - 2) / 6;

            for (int index = 1; index <= maxVal; index++) {
                ans += freq[0] * (freq[index]) * (freq[index] - 1) / 2;
            }

            for (int index = 1; index * 2 <= maxVal; index++) {
                ans += freq[index] * (freq[index] - 1) / 2 * freq[2 * index];
            }

            for (int index1 = 1; index1 <= maxVal; index1++) {
                for (int index2 = index1 + 1; index1 + index2 <= maxVal; index2++) {
                    ans += freq[index1] * freq[index2] * freq[index1 + index2];
                }
            }
            if (ans == 0) {
                System.out.println(-1);
            } else {
                System.out.println(ans);
            }

        }
    }
}


Both O(n^2) 