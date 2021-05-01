import java.util.*;

public class WeirdAlgo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        if (n % 2 == 0) {
            result = n / 2;
        } else if (n % 2 != 0) {
            result = (n * 3) + 1;
        }
        System.out.println(result);

    }

}
