import java.util.*;
// Time : O(n)
public class Kth_Smallest_Element_QuickSelect {

    public static void main(String args[]) {
        int a[] = {10, 4, 5, 8, 6, 11, 26};
        int n = a.length;
        int k = 3;
        System.out.println(Kth_smallest(a, 0, n - 1, k - 1));
    }

    static int partition(int a[], int left, int right) {
        int pivot = a[right], pivot_location = left;
        for (int i = left; i <= right; i++) {
            if (a[i] < pivot) {
                int temp = a[i];
                a[i] = a[pivot_location];
                a[pivot_location] = temp;
                pivot_location++;
            }
        }
        int temp = a[pivot_location];
        a[pivot_location] = a[right];
        a[right] = temp;

        return pivot_location;
    }

    static int Kth_smallest(int a[], int left, int right, int k) {
        int partition = partition(a, left, right);
        if (partition == k) {
            return a[partition];
        } else if (partition < k) {
            return Kth_smallest(a, partition + 1, right, k);
        } else {
            return Kth_smallest(a, left, partition - 1, k);
        }
    }

}
