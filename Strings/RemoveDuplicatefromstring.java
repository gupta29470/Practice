import java.util.*;
public class RemoveDuplicatefromstring {
   // public static void main(String[] args) {
        
    /* Function checks if passed strings (str1 and str2) 
       are rotations of each other */
   
//    public static boolean rotation(String s1,String s2)
//    {
//        return(s1.length()==s2.length())&&(s1+s1).indexOf(s2)!=-1;
//    }
    public static void main(String[] args) {
        String s1="SILLYSPIDERS";
        Map<Character,Integer> map=new LinkedHashMap<>();
        char []c=s1.toCharArray();
        for(Character d:c)
        {
            if(map.containsKey(d))
            {
                map.put(d, map.get(d));
            }
            else
            {
                map.put(d,1);
            }
        }String res="";
        Set<Character> set=map.keySet();
        
            for(Character d:set)
            {
                res=res+d;
            }
        
        System.out.println(res);
        
        
    }
} 