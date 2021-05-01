import java.util.*;

/**
 *
 * @author Aakash
 */
public class JaggedArray3d {

    /**
     * @param args the command line arguments
     */
    
        // TODO code application logic here
    
    public static void main(String args[])
    {Scanner sc=new Scanner(System.in);
int p[][][]={{{5,6,4,9},{1,2,3}}};
        int counter = 0;
        for(int i=0;i<p.length;i++)
        {
            for(int j=0;j<p[i].length;j++)
            {
                for(int k=0;k<p[i][j].length;k++)
                {
                System.out.print(p[i][j][k]+" ");
                } 
                System.out.println("");
                
                
            }
           
        }
            
        for(int i[][]:p)
        {
            for(int j[]:i)
                
            {
                for(int k:j)
                {
                System.out.print(k+" ");
                } System.out.println("");
            }
           
        }
        
        
        
    }
}
