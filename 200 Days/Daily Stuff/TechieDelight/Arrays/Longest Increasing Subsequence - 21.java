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

            int L[] = new int[n];
            Arrays.fill(L, 1);
            
            for (int index1 = 0; index1 < n; index1++){
                for (int index2 = index1 + 1; index2 < n; index2++){
                    if (a[index2] > a[index1] && L[index2] < L[index1] + 1){
                        L[index2] = L[index1] + 1; 
                    }
                }
            }
            
            System.out.println("Longest Increasing Subsequence : "+Arrays.stream(L).max().getAsInt());
            
            int max = 0, ele = 0, ind = -1;
            for (int index = 0; index < n; index++){
                if (max <= L[index]){
                    max = L[index];
                    ele = a[index]; 
                    ind = index;
                }
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append(ele);
            for (int index = ind; index >= 0; index--){
                if (L[index] == max - 1){
                    sb.append(" "+a[index]);
                    max = L[index];
                }
            }
            System.out.print("Subsequences are : ");
            System.out.println(sb.reverse());
        }
    }

}

Time Complexity  -->  O(n^2)



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

            int I[] = new int[n + 1];
            Arrays.fill(I, Integer.MIN_VALUE);

            int maxLen = 0;
            for (int index = 0; index < n; index++) {
                int low = 0, high = maxLen;

                while (low <= high) {
                    int mid = (low + high) / 2;

                    if (I[mid] < a[index]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                I[low] = a[index];
                if (maxLen < low) {
                    maxLen = low;
                }
            }
            
            System.out.println(maxLen);
        }
    }
}


Time Complexity  -->  O(nLogn)