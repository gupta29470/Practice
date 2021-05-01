import java.util.*;
import java.io.*;
import java.math.*;

public class foss {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int n = Integer.parseInt(br.readLine());
        int a[] = {-5, 3, 4, 5, -6, -2, 8, 9, -1, -4};
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a.length-1-i;j++)
            {
                if(a[j]>a[j+1])
                {
                    a[j]^=a[j+1];
                    a[j+1]^=a[j];
                    a[j]^=a[j+1];
                }
            }
        }
//        for (int b : a) {
//            System.out.print(b + " ");
//        }
        for(int i=0;i<a.length;i+=2)
        {
            if(a[i]<0)
            {
                int j=i+1;
                while(j<a.length)
                {
                    if(a[j]>=0){
                        a[i]^=a[j];
                        a[j]^=a[i];
                        a[i]^=a[j];
                        break;
                    }
                    else
                    {
                        j++;
                    }
                }
                    
            }
        }

        for (int b : a) {
           System.out.print(b + " ");
        }
    }
}