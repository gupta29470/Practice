import java.util.*;

/**
 *
 * @author Aakash
 */
public class Number_Palin {

    /**
     * @param args the command line arguments
     */
    
        // TODO code application logic here
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int number,rem,s=0;
        
        System.out.println("Enter number to be reverse:");
        number=sc.nextInt();
        int temp=number;
        while(number>0)
        {
            rem=number%10;
            number=number/10;
            s=rem+s*10;
        }
        if(temp==s)
        {
            System.out.println("Palindrome");
            
        }
        else
        {
            System.out.println("Not Palindrome");
        }
        System.out.println(s);
        
    }
}
