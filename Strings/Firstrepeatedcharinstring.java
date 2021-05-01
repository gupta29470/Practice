import java.io.*;
import java.util.*;

public class Firstrepeatedcharinstring {

    public void rep(String s) {
        Map<String, Integer> map = new LinkedHashMap<>();
        String str[] = s.split(" ");
        for (String s1 : str) {
            if (map.containsKey(s1)) {
                map.put(s1, map.get(s1) + 1);
            } else {
                map.put(s1, 1);
            }
        }
//        Set<String> st = map.keySet();
//        for (String s1 : st) {
//            if (map.get(s1) > 1) {
//                System.out.println(s1);
//                break;
//            }
//        }
        
        for(Map.Entry<String,Integer> a:map.entrySet())
        {
            if(a.getValue()>1)
            {
                System.out.println(a);
                break;
            }
        }
    }

    public static void main(String[] args) {
        foss f1 = new foss();
        String s = "Ravi had been saying that he had been there";
        f1.rep(s);

    }

}
