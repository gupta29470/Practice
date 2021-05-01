import java.util.*;

public class Inverse_Number{

public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 0, original_place = 1, result = 0;
        while (n != 0) {
            int original_digit = n % 10;
            int inverted_digit = original_place;
            int inverted_place = original_digit;
            result += inverted_digit *(int)Math.pow(10, inverted_place - 1);
            n = n / 10;
            original_place += 1;
        }
        System.out.println(result);

    }
}
