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
            String t[] = br.readLine().trim().split(" ");
            int a[] = new int[n];
            int b[] = new int[n];
            for (int index = 0; index < n; index++) {
                a[index] = Integer.parseInt(s[index]);
            }
            for (int index = 0; index < n; index++) {
                b[index] = Integer.parseInt(t[index]);
            }

            int needed, result = 0;
            for (int index1 = 0; index1 < n; index1++){
                needed = 1;
                for (int index2 = index1 + 1; index2 < n; index2++){
                    if (a[index1] >= a[index2] && a[index1] <= b[index2] ||
                        a[index2] >= a[index1] && a[index2] <= b[index1]){
                        needed++;
                    }
                    result = Math.max(result, needed);
                }
            }
                    
                    
                    
            System.out.println(result);
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
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            for (int index = 0; index < n; index++) {
                a[index] = sc.nextInt();
            }
            for (int index = 0; index < n; index++) {
                b[index] = sc.nextInt();
            }
            
            Arrays.sort(a); Arrays.sort(b);
            
            int min = 1, needed = 1, index1 = 1, index2 = 0;
            
            while (index1 < n){
                if (a[index1] > b[index2]){
                    index2+= 1;
                    min-= 1;
                }
                else{
                    min+= 1;
                    index1+= 1;
                }
                needed = Math.max(needed, min);
            }
            System.out.println(needed);
        }
	}
}

Time  --> (nLogn)