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

            Map<Integer, Integer> map = new HashMap<>();
            for (int value : a) {
                if (map.containsKey(value)) {
                    map.put(value, map.get(value) + 1);
                } else {
                    map.put(value, 1);
                }
            }
            
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(entry.getValue() > 1){
                    System.out.println(entry.getKey());
                }
            }
        }
    }
}
