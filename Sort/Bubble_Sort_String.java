import java.util.*;

/**
 *
 * @author Aakash
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    
        // TODO code application logic here
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n;
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
        {int flag=0;
            for(int col=0;col<a.length-1-row;col++)
            {
                if(a[col].compareTo(a[col+1])>0)//compare to method convert character in to unicode and compare it
                                                //if output==0 return 0;if output less than 0 return-1;if greater than 0 return 1
                {
                    temp=a[col];
                    a[col]=a[col+1];
                    a[col+1]=temp;
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
