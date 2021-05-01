import java.util.*;

/**
 *
 * @author Aakash
 */
public class RandomClass {

    /**
     * @param args the command line arguments
     */
    
        // TODO code application logic here
    
    public static void main(String args[])
    {Scanner sc=new Scanner(System.in);
Random r=new Random();
        int a[]=new int[50];
        for(int i=0;i<a.length;i++)
        {
            a[i]=r.nextInt(a.length);
        }
        for(int i:a)
        {
            System.out.println(i);
        }
        
            
        
        
        
    }
}