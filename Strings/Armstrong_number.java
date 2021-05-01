import java.util.*;

/**
 *
 * @author Aakash
 */
public class Armstrong_number {

    /**
     * @param args the command line arguments
     */
    
        // TODO code application logic here
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int number,rem,s=0;
        
        System.out.println("Enter number to check armstrong or not:");
        number=sc.nextInt();
        int temp=number;
        while(number>0)
        {
            rem=number%10;
            number=number/10;
            s=s+rem*rem*rem;
        }
        if(temp==s)
        {
            System.out.println("Armstrong");
            
        }
        else
        {
            System.out.println("Not Armstrong");
        }
        System.out.println(s);
        
    }
}
