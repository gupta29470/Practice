import java.util.*;
public class Onestringrotationofanother {
    public static void main(String[] args) {
        
       String os="ABCD";
       String ks="CDAB";
       os=os.concat(os);
        System.out.println(os);
       if(os.contains(ks))
       {
           System.out.println(ks+" is Rotation of String");
       }
       else
       {
           System.out.println(ks+" is not a Rotation of String");
       }
       
   
    // Since there may not be space after 
    // last word. 
//    while (st.empty() == false) { 
//        System.out.print(st.pop()); 
//    }
//        System.out.println(" ");
    
}
}