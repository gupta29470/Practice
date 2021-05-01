package javaapplication1;
import java.util.*;

/**
 *
 * @author Aakash
 */
public class JaggedArray {

    /**
     * @param args the command line arguments
     */
    
        // TODO code application logic here
    
    public static void main(String args[])
    {Scanner sc=new Scanner(System.in);
int p[][]={{5,6,4,9},{1,2,3}};
        int counter = 0;
        for(int i=0;i<p.length;i++)
        {
            for(int j=0;j<p[i].length;j++)
            {
                System.out.print(p[i][j]+" ");
                
                
            }
            System.out.println("");
        }
            
        for(int i[]:p)
        {
            for(int j:i)
            {
                System.out.print(j+" ");
            }System.out.println("");
        }
        
        
        
    }
}
