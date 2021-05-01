import java.util.*;

public class Insertion_Deletion_Heap {

    static int heap[] = new int[8];
    static int heapsize = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a[] = new int[10];
        a[0] = 17;
        a[1] = 15;
        a[2] = 13;
        a[3] = 10;
        a[4] = 9;
        a[5] = 8;
        a[6] = 6;
        int n = 7;
        insert_maxHeap(a, n, 20);
        for (int i : a) {
            System.out.print(i + " ");
        }
        a[6] = 17;
        a[5] = 15;
        a[4] = 13;
        a[3] = 10;
        a[2] = 9;
        a[1] = 8;
        a[0] = 6;
        n = 7;
        System.out.println("");
        insert_minHeap(a, n, 1);
        for (int i : a) {
            System.out.print(i + " ");
        }
        int arr[] = {10, 5, 3, 2, 4};
        int ns = arr.length;
        System.out.println("");
        ns = delete_max(arr, ns);
        for (int i = 0; i < ns; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
        int b[] = {2, 4, 3, 5, 10};
        int m = b.length;
        m = delete_min(b, m);
        for (int i = 0; i < m; i++) {
            System.out.print(b[i] + " ");
        }

    }

    static void insert_minHeap(int a[], int n, int data) {
        n = n + 1;
        a[n - 1] = data;
        heapifyMin(a, n, n - 1);
    }

    static void heapifyMin(int a[], int n, int i) {
        int parent = (i - 1) / 2;
        if (a[parent] > 0) {
            if (a[i] < a[parent]) {
                int temp = a[i];
                a[i] = a[parent];
                a[parent] = temp;
                heapifyMin(a, n, parent);
            }
        }
    }

    static void insert_maxHeap(int a[], int n, int data) {
        n = n + 1;
        a[n - 1] = data;
        System.out.println(n);
        heapifyMax(a, n, n - 1);

    }

    static void heapifyMax(int a[], int n, int i) {

        int parent = (i - 1) / 2;
        if (a[parent] > 0) {
            if (a[i] > a[parent]) {
                int temp = a[i];
                a[i] = a[parent];
                a[parent] = temp;
                heapifyMax(a, n, parent);
            }
        }
    }

    //*********** DELETE ************************
    static int delete_max(int a[], int n) {
        int lastelement = a[n - 1];
        a[0] = lastelement;
        n = n - 1;
        heapify_MaxDelete(a, n, 0);
        return n;
    }

    static void heapify_MaxDelete(int a[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 1;

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
            heapify_MaxDelete(a, n, largest);
        }
    }

    static int delete_min(int a[], int n) {
        int lastelement = a[n - 1];
        a[0] = lastelement;
        n = n - 1;
        heapify_MinDelete(a, n, 0);
        return n;
    }

    static void heapify_MinDelete(int a[], int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && a[left] < a[smallest]) {
            smallest = left;
        }
        if (right < n && a[right] < a[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            int temp = a[i];
            a[i] = a[smallest];
            a[smallest] = temp;
            heapify_MinDelete(a, n, smallest);
        }
    }

}

//    }

