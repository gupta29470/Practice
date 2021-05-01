public class vita {

    public static void main(String[] args) {

        int a[] = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
        int start = Integer.MIN_VALUE, end = Integer.MAX_VALUE;

        for (int index = 0; index < a.length; index++) {
            if (a[index] > a[index + 1]) {
                start = index;
                break;
            }
        }

        if (start == Integer.MIN_VALUE) {
            System.out.println("-1");
            return;
        }
        for (int index = a.length - 1; index >= 0; index--) {
            if (a[index] < a[index - 1]) {
                end = index;
                break;
            }
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int index = start; index <= end; index++) {
            min = Math.min(min, a[index]);
            max = Math.max(max, a[index]);
        }

        for (int index = 0; index < start; index++) {
            if (a[index] > min) {
                start = index;
                break;
            }
        }
        for (int index = a.length - 1; index > end; index--) {
            if (a[index] < max) {
                end = index;
                break;
            }
        }
        System.out.println(start + " " + end);
    }
}




public class Solution {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        
        int len = A.size();
        ArrayList<Integer> res = new ArrayList<Integer>();
        int start = Integer.MIN_VALUE, end = Integer.MAX_VALUE;
        for (int index = 0; index < len - 1; index ++){
            if (A.get(index) > A.get(index + 1)){
                start = index;
                break;
            }
        }
        
        if (start == Integer.MIN_VALUE){
            res.add(-1);
            return res;
        }
        
        for (int index = len - 1; index >= 0; index --){
            if (A.get(index) < A.get(index - 1)){
                end = index;
                break;
            }
        }
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int index = start; index <= end; index++){
            min = Math.min(min, A.get(index));
            max = Math.max(max, A.get(index));
        }
        for (int index = 0; index < start; index++){
            if (A.get(index) > min){
                start = index;
                break;
            }
        }
        for (int index = len - 1; index > end; index--){
            if (A.get(index) < max){
                end = index;
                break;
            }
        }
        res.add(start);
        res.add(end);
        return res;
    }
}
Time --> O(n)