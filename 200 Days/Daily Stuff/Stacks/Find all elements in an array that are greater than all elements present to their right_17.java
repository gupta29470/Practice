public class vit {

    public static void main(String[] args) {
        int array[] = {10, 4, 6, 3, 5};
        
        int max = Integer.MIN_VALUE;
        for (int index = array.length - 1; index >= 0; index--) {
            if (array[index] >= max) {
                max = array[index];
                System.out.print(max+" ");
            }
        }
        
    }
}
// Time -> O(n) 


import java.util.*;

public class vit {

    public static void main(String[] args) {
        int array[] = {10, 4, 6, 3, 5};
        Stack<Integer> result = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int index = array.length - 1; index >= 0; index--) {
            if (array[index] >= max) {
                max = array[index];
                result.push(max);
            }
        }
        while (!result.isEmpty()){
            System.out.print(result.pop()+" ");
        }
    }
}

// Time -> O(n)   Space -> O(n)