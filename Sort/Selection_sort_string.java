import java.util.*;

/**
 *
 * @author Aakash
 */
public class Selection_sort_string {

    /**
     * @param args the command line arguments
     */
    
        // TODO code application logic here
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n,flag=0,min;
        String temp;
        System.out.println("Enter how many names you want to enter:");
        n=sc.nextInt();
        String a[]=new String[n];
        System.out.println("Enter "+n+ " elements:");
        for(int i=0;i<n;i++)
        {
            a[i]=sc.next();
        }
        for(int row=0;row<a.length;row++)
        {
            min=row;
            for(int col=row+1;col<a.length;col++)
            {
                if(a[col].compareTo(a[min])<0)
                {
                    min=col;
                            
                }
            }
            temp=a[row];
            a[row]=a[min];
             a[min]=temp;
             
            
        }
        System.out.println("Sorted elemets are:");
        for(int i=0;i<a.length;i++)
        {
            System.out.println(a[i]+" ");
        }
        
        
            
          
        
    }
}
