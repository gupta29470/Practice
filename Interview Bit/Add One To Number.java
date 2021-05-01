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

        int a[] = {0, 3, 7, 6, 4, 0, 5, 5, 5};
        int carry = 0, sum = 0;
        int n = a.length;
        if (a[n - 1] + 1 <= 9) {
            a[n - 1] += 1;
            for (int index = 0; index < n; index++) {
                System.out.print(a[index] + " ");
            }
        } else {
            sum = a[n - 1] + 1;
            int mod = sum % 10;
            carry = sum / 10;
            a[n - 1] = mod;
            for (int index = n - 2; index >= 0; index--) {
                sum += carry;
                mod = sum % 10;
                carry = sum / 10;
                a[index] = mod;
                if (carry == 0) {
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            if (carry > 0) {
                sb.append(carry);
            }
            if(sb.charAt(0) == 0){
                sb.deleteCharAt(0);
            }
            for (int index = 0; index < n; index++) {
                sb.append(" " + a[index]);

            }
            System.out.println(sb);
            
        }
    }
}







public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> arr) {
        int sum = 0, carry = 0;
        int n = arr.size();
        if (arr.get(n - 1) + 1 <= 9){
            arr.set(n - 1, arr.get(n - 1) + 1);
        }
        
        else{
            for (int index = n - 1; index >= 0; index--){
                sum = arr.get(index) + 1;
                int mod = sum % 10;
                carry = sum / 10;
                arr.set(index, mod);
                
                if (carry == 0){
                    break;
                }
            }
        }
        if (carry > 0){
            arr.add(0, carry);
        }
        ArrayList<Integer> res = new ArrayList<>();
        int index = 0;
        while (index < arr.size() && arr.get(index) == 0){
            index++;
        }
        
        while (index < arr.size()){
            res.add(arr.get(index));
            index++;
        }
        return res;

    }

}


// Time ---> O(1)