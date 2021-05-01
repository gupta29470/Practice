/*
Using backtracking we are optimizing.
In pure recursion we are using string and concat character and every time new string is 
generated so it is costly.
*/

public class Practice {
    
    public static void main(String[] args) {
        int array[] = {1, 2, 3};
        
        subSet(array);
    }
    
    public static void subSet(int array[]){
        int len = array.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        subSetUtil(array, index, len, deque);
    }
    
    public static void subSetUtil(int array[], int index, int len, Deque<Integer> deque){
        if (index == len){
            System.out.println(deque);
            return;
        }
        
         // consider the n'th element
        deque.add(array[index]);
        
        subSetUtil(array, index + 1, len, deque);
        
        // backtrack
        deque.removeLast();
        
        // or don't consider the n'th element
        subSetUtil(array, index + 1, len, deque);
    }
}
// Time --> O(2 ^ n)