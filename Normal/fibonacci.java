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
        
        int n,k=1,a=0,b=1;
        System.out.println("Enter range:");
        n=sc.nextInt();
        while(k<=n)
        {
            System.out.print(a+" ");
            int sum=a+b;
            a=b;
            b=sum;
            k++;
        }
        
        
        
    }
}
