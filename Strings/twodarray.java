import java.util.*;

/**
 *
 * @author Aakash
 */
public class twodarray {

    /**
     * @param args the command line arguments
     */
    
        // TODO code application logic here
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int row,col;
        
       
        System.out.println("Enter how many rows you want to insert:");
        row=sc.nextInt();
        System.out.println("Enter how many columns you want to insert:");
        col=sc.nextInt();
        int a[][]=new int[row][col];
        System.out.println("Please Enter " + row +" elements");
        System.out.println("Please Enter " + col +" elements");
        for(int i=0;i<row;i++)
        {for(int j=0;j<col;j++)
        {
            a[i][j]=sc.nextInt();
        }
    }
        System.out.println("Your inserted data in array is:");
        for (int i=0;i<a.length;i++)
        {
            for (int j=0;j<a[i].length;j++)
        
        {
            System.out.print(a[i][j]+" ");
        }
            System.out.println(" ");
        
    }
    }
}
