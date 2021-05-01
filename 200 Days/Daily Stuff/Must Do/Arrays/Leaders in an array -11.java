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
            StringBuilder sb = new StringBuilder();
            for (int index1 = 0; index1 < n; index1++){
                int index2;
                for (index2 = index1 + 1; index2 < n; index2++){
                    if (a[index1] < a[index2]){
                        break;
                    }
                }
                if (index2 == n){
                    sb.append(a[index1] + " ");
                }
            }
            System.out.println(sb);
        }
    }

}


Time --> O(n^2)


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
            
            ArrayList<Integer> arr = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            
            for (int index = n - 1; index >= 0; index--){
                if (a[index] >= max){
                    max = a[index];
                    arr.add(a[index]);
                }
            }
            for (int index = arr.size() - 1; index >= 0; index--){
                System.out.print(arr.get(index)+" ");
            }
            System.out.println();
        }
    }

}
Time --> O(n) Space --> O(n)