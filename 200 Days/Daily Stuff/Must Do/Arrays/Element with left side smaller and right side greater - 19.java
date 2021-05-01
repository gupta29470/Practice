import java.io.*;
import java.util.*;

public class vita {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s[] = br.readLine().trim().split(" ");
            int a[] = new int[n];
            for (int index = 0; index < n; index++) {
                a[index] = Integer.parseInt(s[index]);
            }

            int maxArr[] = new int[n];
            int minArr[] = new int[n];
            maxArr[0] = a[0];
            minArr[n - 1] = a[n - 1];
            int maximum = a[0], minimum = a[n - 1], flag = 0;
            
            for (int index = 1; index < n; index++){
                maximum = Math.max(maximum, a[index]);
                maxArr[index] = maximum;
            }
            for (int index = n - 2; index >= 0; index--){
                minimum = Math.min(minimum, a[index]);
                minArr[index] = minimum;
            }
            
            for (int index = 1; index < n - 1; index++){
                if (maxArr[index] == minArr[index]){
                    flag = 1;
                    System.out.println(a[index]);
                    break;
                }
            }
            
            if (flag == 0){
                System.out.println("-1");
            }
        }
    }
}


