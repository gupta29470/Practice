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

            int maxValue = Integer.MIN_VALUE, majority = 0;
            Map<Integer,Integer> map = new HashMap<>();
            
            for (int index = 0; index < n; index++){
                if(map.containsKey(a[index])){
                    map.put(a[index], map.get(a[index])+1);
                }
                else{
                    map.put(a[index], 1);
                }
            }
            
            for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                if (maxValue < entry.getValue()){
                    maxValue = entry.getValue();
                    majority = entry.getKey();
                }
            }
            System.out.println(majority);
        }
    }
}

Time ---> O(n)


class Solution {
    public int majorityElement(int[] a) {
        int majority = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < a.length; index++){
            map.put(a[index], map.getOrDefault(a[index] , 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() > a.length/2){
                return entry.getKey();
            }
        }
        return -1;
    }
}


Time ---> O(n)




/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
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

            int majority = 0;
            Map<Integer,Integer> map = new HashMap<>();
            
            for (int index = 0; index < n; index++){
                if(map.containsKey(a[index])){
                    map.put(a[index], map.get(a[index])+1);
                }
                else{
                    map.put(a[index], 1);
                }
            }
            boolean flag = false;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                if (entry.getValue() > n/2){
                    majority = entry.getKey();
                    flag = true;
                    break;
                }
            }
            if(flag == true){
                System.out.println(majority);
            }
            else{
                System.out.println("-1");
            }
        }
    }
}
Time ---> O(n)
