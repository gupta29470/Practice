import java.util.*;
public class Anagram {
    public static void main(String[] args) {
        
       String str1="peek",str2="keep";
       boolean status=true;
       String s1=str1.replace("\\s", "");
       String s2=str2.replace("//s", "");
       
       char[]a1=s1.toLowerCase().toCharArray();
       char[]a2=s2.toLowerCase().toCharArray();
       Arrays.sort(a1);
       Arrays.sort(a2);
       status=Arrays.equals(a1, a2);
       if(status)
       {
           System.out.println("Anargam");
       }
       else
       {
           System.out.println("Not Anargam");
       }
        
        
    }
    
}
