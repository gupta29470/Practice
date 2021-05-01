import java.util.*;
   
   public class Rotate_A_Number {
   
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        //finding len of number
        String s = Integer.toString(n);
        int len = s.length();

        k = k % len;//for bigger digits;

        //if k is negative
        if (k < 0) {
            k = k + len;//make positive
        }

        int div = 1, mul = 1;
        for (int i = 0; i < len; i++) {
            if (i < k) {
                div *= 10;
            } else {
                mul *= 10;
            }
        }

        int quo = n / div;
        int rem = n % div;
        int result = rem * mul + quo;
        System.out.println(result);
    }
}
