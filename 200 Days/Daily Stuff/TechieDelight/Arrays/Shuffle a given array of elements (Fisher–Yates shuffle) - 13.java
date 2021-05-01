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
            
            Random rand = new Random();
            
            for (int index = n - 1; index >= 1; index--){
                int random = rand.nextInt(index + 1);
                swap (a, index, random);
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


Time -- > O(n) Space --> O(1)
