import java.util.*;

public class Max_diff {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a[]={1,-3,3,47,21,91};
        System.out.println(maxdiff(a));
        
    }
  
    public static int maxdiff(int a[])
    {
       int maxdiff=a[1]-a[0];
       int minele=a[0];
       for(int i=1;i<a.length;i++)
       {
           if((a[i]-minele)>maxdiff)
           {
               maxdiff=a[i]-minele;
           }
           if(a[i]<minele)
           {
               minele=a[i];
           }
       }
       return maxdiff;
    }
    
}
