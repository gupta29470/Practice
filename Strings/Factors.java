import java.util.*;

/**
 *
 * @author Aakash
 */
public class Factors {

    /**
     * @param args the command line arguments
     */
    
        // TODO code application logic here
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        
        int number,s=0;
        
        System.out.println("Enter any nuymber:");
        number=sc.nextInt();
        int temp=number;
        for (int i=1;i<=number;i++)
        {
            if(number%i==0)
            {
                System.out.println(i+" ");
            }
        }
        
        
        
    }
}
