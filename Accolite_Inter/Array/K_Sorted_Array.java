import java.util.*;
// Time complexity : O(nLogk)
public class K_Sorted_Array {

    public static void main(String args[]) {
        int a[] = {5, 1, 6, 2, 4, 3};
        int k = 3;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k + 1; i++) {
            pq.add(a[i]); // 1 2 5 6
        }
        int index = 0;
        for (int i = k + 1; i < a.length; i++) {
            a[index++] = pq.peek(); //1 2
            pq.poll();
            pq.add(a[i]); //3 4 5 6
        }
        Iterator<Integer> itr = pq.iterator();
        while (itr.hasNext()) {
            a[index++] = pq.peek();
            pq.poll();
        }
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

}
