import java.io.*;
import java.util.*;

public class allpossiblevalidIPaddress  {

    static boolean isvalid(String s) {
        //length should be 1 2 or 3 before dot not mor than 3 like 255.255 
        //as 255 is 3 not more than that.
        if (s.length() > 4) {
            return false;
        }
        if (s.startsWith("0") && s.length() > 1) {
            return false;
        }
        int val = Integer.parseInt(s);

        return val >= 0 && val <= 255;
    }

    static List<String> restoreip(String s) {
        List<String> res = new ArrayList<>();

        int n = s.length();
        for (int i = 1; i < 4 && i < n; i++) {
            String first = s.substring(0, i);
            if (!isvalid(first)) {
                continue;
            }

            for (int j = 1; i + j < n && j < 4; j++) {
                String second = s.substring(i, i + j);
                if (!isvalid(second)) {
                    continue;
                }

                for (int k = 1; i + j + k < n && k < 4; k++) {
                    String third = s.substring(i + j, i + j + k);
                    String fourth = s.substring(i + j + k);
                    if (!isvalid(third) || !isvalid(fourth)) {
                        continue;
                    }
                    res.add(first+"."+second+"."+third+"."+fourth);
                    
                }
            }

        }

        return res;

    }

    public static void main(String[] args) {
        String s = "25525522135";
        System.out.println(restoreip(s).toString());
    }

}
