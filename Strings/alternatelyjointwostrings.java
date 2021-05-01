import java.io.*;
import java.util.*;

public class alternatelyjointwostrings {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int n;
        n=sc.nextInt();
        
        for(int i=0;i<n;i++)
        {
        String S,T;
        S=sc.next();
        T=sc.next();
            StringBuilder result = new StringBuilder(); 
            if(S.length()>T.length())
            {
                S=S.substring(0,T.length());
            }
            else
            {
                T=T.substring(0,S.length());
            }
        
            for(int j=0;j<S.length()||j<T.length();j++)
            {
                if(j<S.length())
                {
                    result.append(S.charAt(j));
                }
                if(j<T.length())
                {
                    result.append(T.charAt(j));
                }
            }
            
        System.out.println(result);
       
        }
        
        
       
        
        
    }
}