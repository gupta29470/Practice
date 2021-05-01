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

            int count = 0, maxCount = 0, prevIndex = -1, replaceIndex = -1;
            
            for (int index = 0; index < n; index++){
                if (a[index] == 1){
                    count ++;
                }
                
                else{
                    count = index - prevIndex;
                    prevIndex = index;
                }
                
                if(count > maxCount){
                    maxCount = count;
                    replaceIndex = prevIndex;
                }
            }
            
            System.out.println(replaceIndex);

        }

    }

}
