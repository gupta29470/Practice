import java.util.*;
import javafx.util.*;

public class Minimum_Coin_Greedy_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a[] = {1, 2, 5, 10};
        int res = 0, ans = 0, tot = 52;
        for (int index = a.length - 1; index >= 0; index--) {
            if (tot >= a[index]) {
                ans = (int) Math.floor(tot / a[index]);
                res += ans;
                tot -= a[index] * ans;
            }
        }
        System.out.println(res);
        tot = 57;
        res = 0;
        ans = 0;
        for (int index = a.length - 1; index >= 0; index--) {
            if (a[index] <= tot) {
                ans = (int) Math.floor(tot / a[index]);
                res += ans;
                tot -= ans * a[index];
            }
        }
        System.out.println(res);
    }

}
