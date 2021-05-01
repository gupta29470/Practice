import java.util.*;

/**
 *
 * @author Aakash
 */
public class Prime_with_method {

    /**
     * @param args the command line arguments
     */
    
        // TODO code application logic here
    public static boolean checkprime(int n)
    {
        if(n<=1)
        {
            return false;
        }
        for(int i=2;i<n/2;i++)
        {
            if(n%i==0)
            {
                return false;
            }
            
        }
        return true;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int start,end;
        System.out.println("Start:");
        start=sc.nextInt();
        System.out.println("End:");
        end=sc.nextInt();
        for(int i=start;i<=end;i++)
        {
            if(checkprime(i))
            {
                System.out.println(i);
            }
        }
    }
}
