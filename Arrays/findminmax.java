import java.util.*;

public class findminmax {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n,find,res;
        System.out.println("ENter number you want to finD:");
        find=sc.nextInt();
        System.out.println("Enter range of array:");
        n=sc.nextInt();
       int a[]=new int [n];
       for(int i=0;i<a.length;i++)
       {
           a[i]=sc.nextInt();
       }
//      
       res=a[0];
       for(int i=0;i<a.length;i++)

       {
           
           res=Math.min(res,a[i]);
           
       }
        System.out.println("Minimum is:"+res);
        
      for(int i=0;i<a.length;i++)

       {
           
           res=Math.max(res,a[i]);
           
       }
        System.out.println("Maximum is:"+res);
        
        
        
        
    }
}