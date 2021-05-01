/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            String in[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(in[0]);
            String s[] = br.readLine().trim().split(" ");
            int a[] = new int[n];
            for (int index = 0; index < n; index++) {
                a[index] = Integer.parseInt(s[index]);
            }

            long ans = partition(a, 0, n - 1);
            System.out.println(ans);
        }
    }

    public static long merge(int a[], int low, int mid, int high){
        long count = 0;
        int left[] = Arrays.copyOfRange(a, low, mid + 1);
        int right[] = Arrays.copyOfRange(a, mid + 1, high + 1);
        
        int index1 = 0, index2 = 0, index3 = low;
        
        while (index1 < left.length && index2 < right.length){
            if(left[index1] <= right[index2]){
                a[index3++] = left[index1++];
            }
            else{
                a[index3++] = right[index2++];
                count+= (mid + 1) - (low + index1);
            }
        }
        
        while (index1 < left.length){
            a[index3++] = left[index1++];
        }
        while (index2 < right.length){
            a[index3++] = right[index2++];
        }
        return count;
    }
    
    public static long partition(int a[], int low, int high){
        long count = 0;
        if (low < high){
            int mid = (low + high) / 2;
            count+= partition(a, low, mid);
            count+= partition(a, mid + 1, high);
            count+= merge(a, low, mid, high);
        }
        return count;
    }
}
