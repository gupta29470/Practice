import java.util.*;

public class OptimizedWay_to_check_PrimeNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int flag = 0;
            if (n < 2) {
                System.out.println("not prime");
            } else {
                for (int i = 2; i * i <= n; i++) {
                    if (n % i == 0) {
                        System.out.println("not prime");
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    System.out.println("prime");
                }
            }
        }

    }
}
