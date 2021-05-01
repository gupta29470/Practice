import java.util.*;

public class heapsort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a[] = { 1, 12, 9, 5, 6, 10 };
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }

    static void sort(int a[]) {
        int n = a.length;
        for (int i = n / 2 - 1; i >= 0; i--) {//i start from last subtree i==last parent{
            heapify(a, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapify(a, i, 0);
        }

    }

    static void heapify(int[] a, int n, int i) {
        int largest = i;// root element
        int left = 2 * i + 1;// left child
        int right = 2 * i + 2;// right child

        if (left < n && a[left] > a[largest]) {
            largest = left;
        }
        if (right < n && a[right] > a[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            heapify(a, i, largest);
        }
    }

}
