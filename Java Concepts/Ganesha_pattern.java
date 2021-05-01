import java.io.*;
import java.util.*;

public class Ganesha_pattern {
    
      
  
    public static void main(String args[]) 
            
    { 
        Scanner sc=new Scanner(System.in);

        int n;
        System.out.println("Enter number:");
        n=sc.nextInt();
        System.out.println("");
        // first component
        System.out.print("*");
        for(int i=1;i<=(n-3)/2;i++)
        {
            System.out.print(" ");
        }
        for(int i=1;i<=(n+1)/2;i++)
        {
            System.out.print("*");
        }
        System.out.println("");
        //2nd component
        
        for(int row=1;row<=(n-3)/2;row++)
        {
            System.out.print("*");
            for(int i=1;i<=(n-3)/2;i++)
            {
            System.out.print(" ");
            }
             System.out.print("*");
             System.out.println("");
        }
        
        //3rd component
        for(int i=1;i<=n;i++)
        {
            System.out.print("*");
        }
        System.out.println("");
        //4th component
        for(int row =1;row<=((n-3)/2);row++)
        {
            for(int i =1;i<=((n-3)/2)+1;i++){
            System.out.print(" ");
            
            }
            System.out.print("*");
            for(int i=1;i<=(n-3)/2;i++)
            {
                System.out.print(" ");
            }
            System.out.print("*");System.out.println("");
            
        }
        
        //5th component
        for(int i=1;i<=(n+1)/2;i++)
        {
            System.out.print("*");
        }
        for(int i=1;i<=(n-3)/2;i++)
        {
            System.out.print(" ");
        }
        System.out.print("*");
        System.out.println("");
        
    } 
}
