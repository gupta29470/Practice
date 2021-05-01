import java.util.*;

/**
 *
 * @author Aakash
 */
public class onedarray {

    /**
     * @param args the command line arguments
     */
    
        // TODO code application logic here
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n;
        
       
        System.out.println("Enter how many elements you want to insert:");
        n=sc.nextInt();
        int a[]=new int[n];
        System.out.println("Please Enter " +n +" elements");
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        System.out.println("Your inserted data in array is:");
        for (int i=0;i<a.length;i++)
        {
            System.out.println(a[i]);
        }
        int b[]=new int[]{1,2};
        
    }
}
