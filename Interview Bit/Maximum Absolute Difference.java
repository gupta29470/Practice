public class vita {

    public static void main(String[] args) {
        int a[] = {1, 3, -1};
        int max = Integer.MIN_VALUE;

        for (int index1 = 0; index1 < a.length; index1++) {
            for (int index2 = index1 + 1; index2 < a.length; index2++) {
                int valDiff = Math.abs(a[index2] - a[index1]);
                int indDiff = Math.abs(index2 - index1);
                int sum = valDiff + indDiff;
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }

}
Time --> O(n ^ 2)


public class Solution {
    public int maxArr(ArrayList<Integer> a) {
        
        int len = a.size();
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        
        for (int index = 0; index < len; index++){
            min1 = Math.min(min1, a.get(index) + index);
            max1 = Math.max(max1, a.get(index) + index);
            min2 = Math.min(min2, a.get(index) - index);
            max2 = Math.max(max2, a.get(index) - index);
        }
        return Math.max(max1 - min1, max2 - min2);
    }
}
/* Formula :
Case 1: A[i] > A[j] and i > j
|A[i] - A[j]| = A[i] - A[j]
|i -j| = i - j
--> hence, f(i, j) = (A[i] + i) - (A[j] + j)


Case 2: A[i] < A[j] and i < j
|A[i] - A[j]| = -(A[i]) + A[j]
|i -j| = -(i) + j
--> hence, f(i, j) = -(A[i] + i) + (A[j] + j)


Case 3: A[i] > A[j] and i < j
|A[i] - A[j]| = A[i] - A[j]
|i -j| = -(i) + j
--> hence, f(i, j) = (A[i] - i) - (A[j] - j)

Case 4: A[i] < A[j] and i > j
|A[i] - A[j]| = -(A[i]) + A[j]
|i -j| = i - j
--> hence, f(i, j) = -(A[i] - i) + (A[j] - j)
*/

Time --> O(n)