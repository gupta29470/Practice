public class Solution {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
            Collections.sort(A);
            for (int index = 1; index < A.size(); index+=2){
                swaps(A, index, index - 1);
        }
        return A;
    }
    
    public void swaps(ArrayList<Integer> A, int a, int b){
        int temp = A.get(a);
        A.set(a, A.get(b));
        A.set(b, temp);
    }
}
