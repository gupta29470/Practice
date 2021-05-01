import java.util.*;

public class Swayamvar {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = "";
        while(s==""||s.length()!=n) {
            s = s + sc.next();
        }
        int counter1 = 0, counter2 = 0, result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'r') {
                counter1++;
            } else if (s.charAt(i) == 'm') {
                counter2++;
            }
        }
        if (counter1 == counter2) {
            System.out.println("0");
            return;
        } else if (counter1 > counter2) {
            result = counter1 - counter2;
            result = Math.abs(result);
            System.out.println(result);
            return;
        } else {
            result = counter2 - counter1;
            result = Math.abs(result);
            System.out.println(result);
            return;
        }

    }
}
