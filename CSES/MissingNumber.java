import java.util.*;
public class MissingNumber {
    public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = sc.nextInt();
        }
        int xor1 = arr[0];
        for (int i = 1; i < n-1; i++) {
            xor1 ^= arr[i];
        }
        int xor2 = 1;
        for (int i = 2; i <= n; i++) {
            xor1 ^= i;
        }
        System.out.println(xor1 ^ xor2);

    }
}