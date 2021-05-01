import java.util.*;
public class StringReverse {
    public static void main(String[] args) {
        
       String s1="Aakash",b="";
       for(int i=s1.length()-1;i>=0;i--)
       {
           b+=s1.charAt(i);
       }
        System.out.println(b);
        
       char c[]=s1.toCharArray();
       char temp;
       for(int i=c.length-1;i>=0;i--)
       {
           b+=c[i];
       }
        System.out.println(b);
        
        StringBuilder s2=new StringBuilder("Aakash");
        s2.reverse();
        System.out.println(s2);
       char d[]=s1.toCharArray();
       
        int s=0,e=d.length-1;
        while(s<e)
        {
            temp=d[s];
            d[s]=d[e];
            d[e]=temp;
            s++;
            e--;
        }
        for(Character v:d)
        {
            System.out.print(v);
        }
        
         
        
    }
    
}
