import java.io.*;
import java.util.*;

public class vita {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s[] = br.readLine().trim().split(" ");
            int arr[] = new int[n];
            for (int index = 0; index < n; index++) {
                arr[index] = Integer.parseInt(s[index]);
            }

            for (int index = 0; index < n; index +=2){
                if (index > 0 && arr[index - 1] > arr[index]){
                    swap(arr, index - 1, index);
                }
                
                if (index < n - 1 && arr[index] < arr[index + 1]){
                    swap(arr, index, index + 1);
                }
            }
            
            for (int val : arr){
                System.out.print(val+" ");
            }
            
        }
    }

    public static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
}
