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

            for (int index = 1; index < n - 1; index += 2) {
                if (a[index - 1] > a[index] && a[index + 1] < a[index] && index != n - 1) {
                    swap(a, index - 1, index);
                } else if (a[index + 1] > a[index] && a[index - 1] < a[index] && index != n - 1) {
                    swap(a, index + 1, index);
                } else if (a[index - 1] > a[index] && a[index + 1] > a[index] && index != n - 1) {
                    if (a[index - 1] > a[index + 1] && index != n - 1) {
                        swap(a, index - 1, index);
                    } else if (a[index + 1] > a[index - 1] && index != n - 1) {
                        swap(a, index + 1, index);
                    }
                }
            }
            
            for (int val : a){
                System.out.print(val+" ");
            }
        }
    }

    public static void swap(int a[], int number1, int number2) {
        int temp = a[number1];
        a[number1] = a[number2];
        a[number2] = temp;
    }
}


Time -- > O(n)
Space --> O(1)



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

            for (int index = 1; index < n - 1; index += 2) {
                if (a[index - 1] > a[index]) {
                    swap(a, index - 1, index);
                }

                if (index + 1 < n && a[index + 1] > a[index]) {
                    swap(a, index + 1, index);
                }
            }

            for (int val : a) {
                System.out.print(val + " ");
            }
        }
    }

    public static void swap(int a[], int number1, int number2) {
        int temp = a[number1];
        a[number1] = a[number2];
        a[number2] = temp;
    }
}


Time -- > O(n)  Space --> O(1)