public class vita {

    public static void main(String[] args) {
        int a[] = {7, 3, 16, 10};

        for (int index1 = 0; index1 < a.length; index1++){
            int count = 0;
            for (int index2 = 0; index2 < a.length; index2++){
                if (a[index1] < a[index2]){
                    count++;
                }
            }
            if (count == a[index1]){
                System.out.println(count);
                return;
            }
        }
        System.out.println("-1");

    }

}
TIme --> O(n ^2)



import java.util.*;

public class vita {

    public static void main(String[] args) {
        int a[] = {7, 3, 16, 10};

        Arrays.sort(a);
        if (a[a.length - 1] == 0) {
            System.out.println("1");
            return;
        }

        for (int index = 0; index < a.length - 1; index++) {
            if (a[index] != a[index + 1]) {
                int count = a.length - index - 1;
                if (count == a[index]) {
                    System.out.println("1");
                    return;
                }
            }
        }
        System.out.println("-1");

    }

}

TIme --> O(n)

public class Solution {
    public int solve(ArrayList<Integer> A) {
        int len = A.size();
        Collections.sort(A);
        if (A.get(len - 1) == 0){
            return 1;
        }
        
        for (int index = 0; index < len - 1; index++){
            if (A.get(index) != A.get(index + 1)){
                int count = len - index - 1;
                if (count == A.get(index)){
                    return 1;
                }
            }
        }
        return -1;
    }
}

TIme --> O(n)