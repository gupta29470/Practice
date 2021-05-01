import java.util.*;

/**
 *
 * @author Aakash
 */
public class threedarray {
public static void main(String args[])
    {
int[][][] a={{{10,20,30},{50,60},{70,80}}};
System.out.println("Your inserted data in array is:");
        for (int i=0;i<a.length;i++)
        {
            for (int j=0;j<a[i].length;j++)
        
        {
            for (int k=0;k<a[i][j].length;k++)
            {
            System.out.print(a[i][j][k]+" ");
        }
            System.out.println();
        }
        
    }
    }
}