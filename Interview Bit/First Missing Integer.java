import java.io.*;
import java.util.*;

public class vita {

    public static void main(String[] args) throws Exception {
        int a[] = {1, 5, 3, 2, -1, -3};
        Arrays.sort(a);
        for (int index = 0; index < a.length - 1; index++) {
            if (a[index] <= 0) {
                continue;
            } else {
                if (a[index + 1] == a[index] + 1) {
                    continue;
                } else {
                    System.out.println(a[index] + 1);
                    break;
                }
            }
        }
    }

}

// Time --> O(nLogn)   Space ---> O(1)





import java.io.*;
import java.util.*;

public class vita {

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int test = Integer.parseInt(br.readLine());
//        while (test-- > 0) {
//            int n = Integer.parseInt(br.readLine());
//            String s[] = br.readLine().trim().split(" ");
//
//        }

        int a[] = {1, 5, 3, 2, -1, -3};
        int max = Arrays.stream(a).max().getAsInt();
        int hash[] = new int[max + 1];
        Arrays.fill(hash, 0);

        for (int index = 0; index < a.length; index++) {
            if (a[index] <= 0) {
                continue;
            }
            hash[a[index]]++;
        }
        for (int index = 1; index < max + 1; index++) {
            if (hash[index] == 0) {
                System.out.println(index);
                break;
            }
        }
    }

}

// Time ---> O(n)  Space --> O(n)




public class Solution {
    public int firstMissingPositive(int[] A) {
        int index;
        for (index = 0; index < A.length; index++){
            if (A[index] > 0 && A[index] <= A.length){
                if (A[A[index] - 1] != A[index]){
                    swap (A, A[index] - 1, index);
					index --;
                }
            }
        }
        
        index = 0;
        for (index = 0; index < A.length; index++){
            if (A[index] != index + 1){
                return index + 1;
            }
        }
        return index + 1;
    }
    
    public void swap (int arr[], int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

// Time ---> O(n)  Space --> O(1)
