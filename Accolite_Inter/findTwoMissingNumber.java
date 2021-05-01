import java.util.*;

public class findTwoMissingNumber {

    public static void main(String args[]) {
        int a[] = {1, 3, 5, 6, 0, 0};
        int n = a.length;
        // Cause overflow time:O(n) space(1)
        int sumOfArrayElements = 0;
        for (int i = 0; i < n - 2; i++) {
            sumOfArrayElements += a[i];
        }
        int sumOfMissingInteger = (((n * (n + 1)) / 2) - sumOfArrayElements);
        int avgOfMissingInetger = sumOfMissingInteger / 2;
        int sumOfNaturalNumberTillAverage = avgOfMissingInetger * (avgOfMissingInetger + 1) / 2;
        int firstNumber = sumOfNaturalNumberTillAverage - (n - 2);
        int secondNumber = sumOfNaturalNumberTillAverage - firstNumber;
        System.out.println(firstNumber + " " + secondNumber);

        //Prevent Overflow time O(n) space(1)
        int b[] = {1, 3, 5, 6, 0, 0};
        int m = b.length;
        int xor = b[0];
        for (int i = 1; i < m - 2; i++) {
            xor ^= b[i];
        }
        for (int i = 1; i <= m; i++) {
            xor ^= i;
        }
        int setBit = xor & ~(xor - 1);
        int x = 0, y = 0;
        for (int i = 0; i < m - 2; i++) {
            if ((b[i] & setBit) > 0) {
                x ^= b[i];
            } else {
                y ^= b[i];
            }
        }
        for (int i = 1; i <= m; i++) {
            if ((i & setBit) > 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }
        System.out.println(x+" "+y);
    }
}
