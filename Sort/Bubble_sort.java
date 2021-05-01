import java.util.*;

/**
 *
 * @author Aakash
 */
public class Bubble_sort {

    /**
     * @param args the command line arguments
     */
    
        // TODO code application logic here
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.println("Enter how many elemnts you want to enter:");
        n=sc.nextInt();
        int a[]=new int[n];
        System.out.println("Enter "+n+ " elements:");
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        for(int row=0;row<a.length;row++)
        {int flag=0;
            for(int col=0;col<a.length-1-row;col++)
            {
                if(a[col]>a[col+1])
                {
                    a[col]=a[col]+a[col+1];
                    a[col+1]=a[col]-a[col+1];
                    a[col]=a[col]-a[col+1];
                    flag=1;
                            
                }
            }
            if(flag==0)
                break;
        }
        System.out.println("Sorted elemets are:");
        for(int i=0;i<a.length;i++)
        {
            System.out.println(a[i]+" ");
        }
        
        
            
          
        
    }
}
