import java.io.*;
import java.util.*;

public class firstrepeatedcharacter  {

    public void rep(String s) {
        char c[]=s.toCharArray();
        Set<Character> st=new HashSet<>();
        for(int i=0;i<c.length;i++)
        {
            char c1=c[i];
            if(st.contains(c1))
            {
                System.out.println(c1);
                break;
            }
            else
            {
                st.add(c1);
            }
        }
    }

    public static void main(String[] args) {
        foss f1 = new foss();
        String s = "Ravi had been saying that he had been there";
        f1.rep(s);

    }

}
