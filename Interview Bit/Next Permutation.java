public class Solution {
    public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        int size = A.size();
        if (A == null || size <= 1){
            return A;
        }
        
        int index1 = size - 2;
        while (index1 >= 0 && A.get(index1) > A.get(index1 + 1)){
            index1 --;
        }
        
        if (index1 >= 0){
            int index2 = size - 1;
            while(A.get(index2) <= A.get(index1)){
                index2 --;
            }
            swap (A, index1, index2);
        }
        reverse (A, index1 + 1, size - 1);
        return A;
    }
    
    public static void swap (ArrayList<Integer> A, int index1, int index2){
        int temp = A.get(index1);
        A.set(index1, A.get(index2));
        A.set(index2, temp);
    }
    public static void reverse (ArrayList<Integer> A, int start, int end){
        while (start <= end){
            swap (A, start, end);
            start ++;
            end --;
        }
    }
    
}
Time --> O(n)