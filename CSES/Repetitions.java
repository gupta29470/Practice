import java.util.*;

public class Repetitions {

     public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
        String s = sc.next();
        int min = 0, max = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                min = Math.max(min, max);
                max=0;
            }
            max++;
        }
        max = Math.max(min, max);
        System.out.println(max);
    }
}