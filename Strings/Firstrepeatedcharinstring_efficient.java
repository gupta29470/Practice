import java.io.*;
import java.util.*;

public class Firstrepeatedcharinstring_efficient {

    public void rep(String s) {
        String str[]=s.split(" ");
        Set<String> st=new HashSet<>();
        for(int i=0;i<str.length;i++)
        {
            if(st.contains(str[i]))
            {
                System.out.println(str[i]);
                break;
            }
            else
            {
                st.add(str[i]);
            }
        }
        
    }

    public static void main(String[] args) {
        foss f1 = new foss();
        String s = "Ravi had been saying that he had been there";
        f1.rep(s);

    }

}
