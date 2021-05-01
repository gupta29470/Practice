public class Mean_Max_Heap_usingArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a[] = {1, 3, 5, 4, 6, 13, 10,
            9, 8, 15, 17};
        int b[] = {17, 15, 14, 13, 10, 9, 8};
        int n = a.length;
        build_maxHeap(a, n);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
        build_minHeap(b, b.length);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }

    }

    static void build_maxHeap(int a[], int n) {
        int startindex = (n / 2) - 1; // last parent
        for (int i = startindex; i >= 0; i--) {
            heapifyMax(a, n, i);
        }

    }

    static void heapifyMax(int a[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

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
            heapifyMax(a, n, largest);
        }
    }

    static void build_minHeap(int a[], int n) {
        int startindex = (n / 2) - 1;
        for (int i = startindex; i >= 0; i--) {
            heapifyMin(a, n, i);
        }
    }

    static void heapifyMin(int a[], int n, int i) {
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
            heapifyMin(a, n, smallest);
        }
    }

}
