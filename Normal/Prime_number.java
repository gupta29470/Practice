import java.util.*;

/**
 *
 * @author Aakash
 */
public class Prime_number {

    /**
     * @param args the command line arguments
     */
    public static void main(String... args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        int number,flag=0;
        System.out.println("Enter any number:");
        number=sc.nextInt();
        if (number<=1)
        {
            System.out.println("Number is not prime");
        }
        for(int i=2;i<number/2;i++)
        {
            if(number%i==0)
            {
                System.out.println("Number is not prime");
                flag=1;
                break;
            }
        }
            if(flag==0)
            {
                System.out.println("Number is prime");
            }
        
    }
    
}
