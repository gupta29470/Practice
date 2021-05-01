/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
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
            
            for (int index1 = 0; index1 < n; index1++){
                
                if (a[index1] > b[0]){
                   int temp = a[index1];
                   a[index1] = b[0];
                   b[0] = temp;
                   
                   int first_ele = b[0];
                   
                   int index2;
                   for (index2 = 1; index2 < m && b[index2] < first_ele; index2++){
                       b[index2 - 1] = b[index2]; 
                   }
                   b[index2 - 1] = first_ele;
                }
            }
            
            for (int value : a){
                System.out.print(value+" ");
            }
            System.out.println("");
            for (int value : b){
                System.out.print(value+" ");
            }
            System.out.println();
        }
    }

}

Time --->  O(n * m)   Space O(1)


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
            for (int index = 0; index < n; index++) {
                a[index] = Integer.parseInt(s[index]);
            }
            for (int index = 0; index < m; index++) {
                b[index] = Integer.parseInt(t[index]);
            }

            int pointer1 = n - 1, pointer2 = 0;
            while (pointer1 >= 0 && pointer2 < m){
                if (a[pointer1] > b[pointer2]){
                    int temp = a[pointer1];
                    a[pointer1] = b[pointer2];
                    b[pointer2] = temp;
                }
                pointer1 --;
                pointer2 ++;
            }
            Arrays.sort(a);
            Arrays.sort(b);
            StringBuilder sb = new StringBuilder(); 
            for (int index = 0; index < n; index++){
                sb.append(a[index]+" ");
            }
            for (int index = 0; index < m; index++){
                sb.append(b[index]+" ");
            }
            System.out.println(sb);
            
        }
    }

}

Time --->  O(nlogn)   Space O(1) (Recommended)




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
            for (int index = 0; index < n; index++) {
                a[index] = Integer.parseInt(s[index]);
            }
            for (int index = 0; index < m; index++) {
                b[index] = Integer.parseInt(t[index]);
            }
            merge(a, b, n ,m);
            for (int value : a) {
                System.out.print(value + " ");
            }
            System.out.println("");
            for (int value : b) {
                System.out.print(value + " ");
            }
            System.out.println();

        }
    }

    public static int nextGap(int gap) {
        if (gap <= 1) {
            return 0;
        }
        return (gap / 2) + (gap % 2);
    }

    public static void merge(int a[], int b[], int n, int m) {
        int gap = m + n;
        int index1, index2;
        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {

            for (index1 = 0; index1 + gap < n; index1++) {
                if (a[index1] > a[index1 + gap]) {
                    int temp = a[index1];
                    a[index1] = a[index1 + gap];
                    a[index1 + gap] = temp;
                }
            }

            for (index2 = gap > n ? gap - n : 0; index1 < n && index2 < m; index2++) {
                if (a[index1] > b[index2]) {
                    int temp = a[index1];
                    a[index1] = b[index2];
                    b[index2] = temp;
                }
            }
            if (index2 < m) {

                for (index2 = 0; index2 + gap < m; index2++) {
                    if (b[index2] > b[index2 + gap]) {
                        int temp = b[index2];
                        b[index2] = b[index2 + gap];
                        b[index2 + gap] = temp;
                    }
                }
            }
        }
    }

}

Time --->  O((n+m)log(n+m))   Space O(1)