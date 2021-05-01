import java.util.*;
public class Occuranceofeachchar {
    public static void main(String[] args) {
        
        String s1="mynameisaakash";
        Map<Character,Integer>map=new HashMap<>();
        char c[]=s1.toCharArray();
        for(Character ch:c)
        {
            if(map.containsKey(ch))
            {
                map.put(ch, map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
        }
        Set<Character>set=map.keySet();
        for(Character b:set)
        {
           
            System.out.println("Character "+b+" hs occured "+map.get(b)+" times");
        }
        
    }
    
}
