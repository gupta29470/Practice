import java.util.*;
import java.math.*;

public class FirstIndex_And_LastIndex_BinarySearch {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int d = sc.nextInt();

        int low = 0, high = n - 1;
        int firstIndex = -1, lastIndex = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (d < a[mid]) {
                high = mid - 1;
            } else if (d > a[mid]) {
                low = mid + 1;
            } else {
                firstIndex = mid;
                high = mid - 1;
            }
        }

        low = 0;
        high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (d < a[mid]) {
                high = mid - 1;
            } else if (d > a[mid]) {
                low = mid + 1;
            } else {
                lastIndex = mid;
                low = mid + 1;
            }
        }
        System.out.println(firstIndex);
        System.out.println(lastIndex);
    }

}
