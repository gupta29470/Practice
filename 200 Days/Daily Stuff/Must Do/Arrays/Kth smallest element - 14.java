/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            String in[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(in[0]);

            String s[] = br.readLine().trim().split(" ");

            int a[] = new int[n];

            for (int index = 0; index < n; index++) {
                a[index] = Integer.parseInt(s[index]);
            }
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    return b - a;
                }
            });

            for (int index = 0; index < n; index++) {
                maxHeap.add(a[index]);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
            System.out.println(maxHeap.peek());
        }
    }
}
// Time --> O(nLogk)



import java.io.*;
import java.util.*;

public class vita {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            String in[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(in[0]);

            String s[] = br.readLine().trim().split(" ");

            int a[] = new int[n];

            for (int index = 0; index < n; index++) {
                a[index] = Integer.parseInt(s[index]);
            }
            int k = Integer.parseInt(br.readLine());
            System.out.println(kth_smallest(a, 0, n - 1, k - 1));
        }
    }

    public static int partition(int a[], int low, int high) {
        int pivot = a[high], pivotloc = low;

        for (int index = low; index <= high; index++) {
            if (a[index] < pivot) {
                int temp = a[index];
                a[index] = a[pivotloc];
                a[pivotloc] = temp;
                pivotloc++;
            }
        }
        int temp = a[pivotloc];
        a[pivotloc] = a[high];
        a[high] = temp;

        return pivotloc;
    }

    public static int kth_smallest(int a[], int low, int high, int k) {
        int partition = partition(a, low, high);

        if (partition == k) {
            return a[partition];
        } else if (partition < k) {
            return kth_smallest(a, partition + 1, high, k);
        } else {
            return kth_smallest(a, low, partition - 1, k);
        }
    }
}


// Time O(n)