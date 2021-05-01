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

            int zeroPointer = 0;
            for (int index = 0; index < n; index++) {
                if (a[index] != 0) {
                    int temp = a[index];
                    a[index] = a[zeroPointer];
                    a[zeroPointer] = temp;
                    zeroPointer++;
                }
            }

            for (int value : a) {
                System.out.print(value + " ");
            }
            System.out.println("");

        }
    }
}

Time ---> O(n)   Space ---> O(1)  Single Traversal




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

            int shiftIndex = 0;
            for (int index = 0; index < n; index++){
                if (a[index] != 0){
                    a[shiftIndex++] = a[index];
                }
            }
            for (int index = shiftIndex; index < n; index++){
                a[index] = 0;
            }
            for (int value : a) {
                System.out.print(value + " ");
            }
            System.out.println("");

        }
    }
}
Time ---> O(n)   Space ---> O(1)  Double Traversal
