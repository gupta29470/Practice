import java.util.*;
import java.math.*;

public class Ceil_Floor_Binary_Search {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int d = sc.nextInt();
        Arrays.sort(a);
        int low = 0, high = n - 1, ceil = 0, floor = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (d < a[mid]) {
                high = mid - 1;
                ceil = a[mid];
            } else if (d > a[mid]) {
                low = mid + 1;
                floor = a[mid];
            } else {
                floor = a[mid];
                ceil = a[mid];
                break;
            }
        }
        System.out.println(ceil);
        System.out.println(floor);
    }

}
