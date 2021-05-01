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

            ArrayList<Integer> arr = new ArrayList<>();
            for (int index = 0; index < n; index++) {
                arr.add(a[index] * a[index]);
            }
            boolean flag = false;
            for (int index1 = 0; index1 < n; index1++) {
                for (int index2 = index1 + 1; index2 < n; index2++) {
                    int temp = (a[index1] * a[index1]) + (a[index2] * a[index2]);
                    if (arr.contains(temp)) {
                        flag = true;
                    }
                }
            }
            if (flag == false) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }

        }
    }

}

Time ---> O(n) Space --> O(n)


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

            if (triplet(a, n)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public static boolean triplet(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] * arr[i]);
        }
        for (int i = n - 1; i >= 2; i--) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (arr[l] + arr[r] == arr[i]) {
                    return true;
                }
                if (arr[l] + arr[r] < arr[i]) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return false;
    }

}
Time -- > O(n) Space --> O(1)