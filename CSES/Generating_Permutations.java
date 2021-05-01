import java.util.*;

public class Generating_Permutations {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String o = "";
        if (n == 1) {
            System.out.println(n);
            return;
        }
        if (n > 1 && n <= 3) {
            System.out.println("No solution");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            } else {
                o = o.concat(Integer.toString(i) + " ");
            }
        }
        System.out.print(o);

    }

}
