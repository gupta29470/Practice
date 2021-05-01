import java.util.*;

public class Move_nega_ele {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a[]={1,-3,3,5,6,-9,3,-4};
        move_neg_ele(a);
        
    }
  
    public static void move_neg_ele(int a[])
    {
       int i=0,j=a.length-1;
       boolean b=true;
       while(i<j)
       {
           while(a[i]<0 && i<j)
           {
               i++;
           }
           while(a[j]>0 && i<j)
           {
               j--;
           }
           if(i<j)
           {
               int temp=a[i];
               a[i]=a[j];
               a[j]=temp;
           }
       }
       for(int c:a)
       {
           System.out.println(c);
       }
    }
    
}