public class vita {

    public static void main(String[] args) {
        int a[] = {3, 5, 4, 2};
        int ans = Integer.MIN_VALUE;
        for (int index1 = 0; index1 < a.length; index1++) {
            for (int index2 = index1 + 1; index2 < a.length; index2++) {
                if (a[index1] <= a[index2]) {
                    ans = Math.max(ans, index2 - index1);
                }
            }
        }
        System.out.println(ans);
    }

}

Time --> O(n^2)


public class vita {

    public static void main(String[] args) {
        int a[] = {3, 5, 4, 2};
        int ans = Integer.MIN_VALUE;

        int left[] = new int[a.length];
        int right[] = new int[a.length];
        left[0] = a[0];
        right[a.length - 1] = a[a.length - 1];

        for (int index = 1; index < a.length; index++) {
            left[index] = Math.min(left[index - 1], a[index]);
        }

        for (int index = a.length - 2; index >= 0; index--) {
            right[index] = Math.max(right[index + 1], a[index]);
        }

        int index1 = 0, index2 = 0;

        while (index1 < a.length && index2 < a.length) {
            if (right[index2] >= left[index1]) {
                ans = Math.max(ans, index2 - index1);
                index2++;
            } else {
                index1++;
            }
        }
        System.out.println(ans);
    }

}
Time --> O(n)
Space --> O(n)



public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {
        int len = A.size();
        List<Integer> left = new ArrayList<>(Collections.nCopies(len , 0));
        List<Integer> right = new ArrayList<>(Collections.nCopies(len , 0));
        left.set(0, A.get(0));
        right.set(len - 1, A.get(len - 1));
        
        for (int index = 1; index < len; index++){
            left.set(index, Math.min(left.get(index - 1), A.get(index)));
        }
        for (int index = len - 2; index >= 0; index--){
            right.set(index, Math.max(right.get(index + 1), A.get(index)));
        }
        
        int index1 = 0, index2 = 0, ans = Integer.MIN_VALUE;
        while (index1 < len && index2 < len){
            if (right.get(index2) >= left.get(index1)){
                ans = Math.max(ans, index2 - index1);
                index2++;
            }
            else{
                index1++;
            }
        }
        return ans;
    }
}
Time --> O(n)
Space --> O(n)

