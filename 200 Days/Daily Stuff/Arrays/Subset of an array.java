// total number of subsets = 2 ^ n

public class Practice {

    public static void main(String[] args) {
        int array[] = {1, 2, 3};

        subsets(array, 0, array.length, "");
    }
    
    public static void subsets(int array[], int index, int len, String outputSubset){
        if (index == len){
            System.out.println("[" + outputSubset + "]");
            return;
        }
        // include current element
        subsets(array, index + 1, len, outputSubset + array[index] + " ");
        
        // exclude current element
        subsets(array, index + 1, len, outputSubset);
    }
}




import java.util.ArrayDeque;
import java.util.Deque;
 
class Main
{
    // Function to generate power set of a given set `S`
    public static void findPowerSet(int[] S, Deque<Integer> set, int n)
    {
        // if we have considered all elements
        if (n == 0)
        {
            System.out.println(set);
            return;
        }
 
        // consider the n'th element
        set.addLast(S[n - 1]);
        findPowerSet(S, set, n - 1);
 
        set.removeLast();                    // backtrack
 
        // or don't consider the n'th element
        findPowerSet(S, set, n - 1);
    }
 
    public static void main(String[] args)
    {
        int[] S = { 1, 2, 3 };
        Deque<Integer> set = new ArrayDeque<>();
        findPowerSet(S, set, S.length);
    }
}