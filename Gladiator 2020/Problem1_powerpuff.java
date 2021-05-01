import java.io.*;
import java.util.*;

public class Problem1_powerpuff {
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.println("Enter Number of ing:");
       n=sc.nextInt();
       long[] a=new long[n];
       long b[]=new long[n];
       List<Long> res=new ArrayList<>();
       for(int i=0;i<n;i++)
       {
           a[i]=sc.nextLong();
           
       }
       for(int i=0;i<n;i++)
       {
           b[i]=sc.nextLong();
       }
       for(int i=0;i<n;i++)
       {
           long c=b[i]/a[i];
           res.add(c);
       }
     

    	System.out.println(Collections.min(res));

   }
}

   