package javaapplication1;
import java.util.*;

/**
 *
 * @author Aakash
 */
public class RotateArray_reversalalgo {

    /**
     * @param args the command line arguments
     */
    
        // TODO code application logic here
    
    public static void main(String args[])
    {Scanner sc=new Scanner(System.in);
JavaApplication1 j=new JavaApplication1();
        int a[]={1, 2, 3, 4, 5, 6, 7};
        int r=2;
        j.rotatearray(a,r);
        
        for(int i:a)
        {
            System.out.println(i);
        }
        
        
        
        
        
        
        
        
        
    }
     
    
    public void reverse(int a[],int start,int end)
    {
        while(start<end)
        {
            a[start]=a[start]+a[end];
            a[end]=a[start]-a[end];
            a[start]=a[start]-a[end];
            start++;
            end--;
        }
    }
    public void rotatearray(int a[],int r)
     {
         if(r==0)
             return;
         
         int n=a.length;
         int b=n-r;
         reverse(a,0,n-r-1);
         reverse(a,b,n-1);
         reverse(a,0,n-1);
         
     }
}
