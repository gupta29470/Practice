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

            int meh = 0, msf = Integer.MIN_VALUE, start = 0, end = 0, st = 0;
            for (int index = 0; index < n; index++){
                meh = meh + a[index];
                if (a[index] > meh){
                    meh = a[index];
                }
                if (msf < meh){
                    msf = meh;
                    start = st;
                    end = index;
                }
                if (meh <= 0){
                    st = index + 1;
                }
            }
            System.out.println("Start : "+start);
            System.out.println("End : "+end);
            System.out.println("Max Sum : "+msf);
            System.out.println("Sub Array");
            for (int index = start; index <= end; index++){
                System.out.print(a[index]+" ");
            }
        }
    }
}
