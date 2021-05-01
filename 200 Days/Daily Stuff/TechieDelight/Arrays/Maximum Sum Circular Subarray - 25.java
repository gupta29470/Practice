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
            
            // Step 1 : Invert array
            // Step 2 : Find max Sum --> tempMax
            // Step 3 : Invert array again to get original array
            // find max between --> kadanes(a) or Array sum + tempMax
            
            Arrays.setAll(a, index -> -a[index]);
            int tempMax = kadanes(a);
            Arrays.setAll(a, index -> -a[index]);
            int max = Math.max(kadanes(a) , Arrays.stream(a).sum() + tempMax);
            System.out.println(max);
        }
    }
    public static int kadanes (int a[]){
        int meh = 0, msf = Integer.MIN_VALUE;
        
        for (int val : a){
            meh = meh + val;
            meh = Integer.max(meh , val);
            msf = Integer.max(msf, meh);
        }
        return msf;
    }
}

Time --> O(n)  Space --> O(1)