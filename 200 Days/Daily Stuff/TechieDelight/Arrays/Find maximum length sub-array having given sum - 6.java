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
            int k = Integer.parseInt(in[1]);
            String s[] = br.readLine().trim().split(" ");
            int a[] = new int[n];
            for (int index = 0; index < n; index++) {
                a[index] = Integer.parseInt(s[index]);
            }

            int sum = 0, maxlen = 0;
            Map <Integer, Integer> map = new HashMap<>();
            for (int index = 0; index < n; index++){
                sum+= a[index];
                
                if(sum == k){
                    maxlen = index + 1;
                }
                
                if(!map.containsKey(sum)){
                    map.put(sum, index);
                }
                
                if(map.containsKey(sum - k)){
                    if (maxlen < index - map.get(sum - k)){
                        maxlen = index - map.get(sum - k);
                    }
                }
            }
            System.out.println(maxlen);
        }

    }
}
