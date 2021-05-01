import java.util.*;

/**
 *
 * @author Aakash
 */
public class ReverseArray {

    /**
     * @param args the command line arguments
     */
    
        // TODO code application logic here
    
    public static void main(String args[])
    {Scanner sc=new Scanner(System.in);
int a[]={5,47,56,85,74,25,22,88};
        
        int s=0, e=a.length-1,temp;
        
        while(s<e)
        {
            a[s]=a[s]+a[e];
            a[e]=a[s]-a[e];
            a[s]=a[s]-a[e];
//            temp=a[s];
//            a[s]=a[e];
//            a[e]=temp;
            s=s+1;
            e=e-1;
         
        }
        for(int i:a)
         {
             System.out.println(i);
         }
        
        
        
        
        
        
    }
}