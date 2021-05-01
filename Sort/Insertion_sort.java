import java.util.*;

/**
 *
 * @author Aakash
 */
public class Insertion_sort {

    /**
     * @param args the command line arguments
     */
    
        // TODO code application logic here
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n,flag=0,min,j;
        int temp;
        System.out.println("Enter how many names you want to enter:");
        n=sc.nextInt();
        int a[]=new int[n];
        System.out.println("Enter "+n+ " elements:");
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        for(int row=0;row<a.length;row++)
        {
            temp=a[row];
            j=row;
            while(j>0 && a[j-1] > temp)
            {
                a[j]=a[j-1];
                j=j-1;
                
            }
            a[j]=temp;
            
             
            
        }
        System.out.println("Sorted elemets are:");
        for(int i:a)
        {
            System.out.println(i);
        }
        
        
            
          
        
    }
}
