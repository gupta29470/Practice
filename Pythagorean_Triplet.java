import java.util.*;
  
  public class Pythagorean_Triplet {
  
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int big = a, result = 0;
        if (b >= a) {
            big = b;
        }
        if (c >= big) {
            big = c;
        }
        if (big == a) {
            boolean flag = (((b * b) + (c * c)) == (a * a));
            System.out.println(flag);
        } else if (big == b) {
            boolean flag = (((a * a) + (c * c)) == (b * b));
            System.out.println(flag);
        } else {
            boolean flag = (((b * b) + (a * a)) == (c * c));
            System.out.println(flag);
        }
    }
}
// formula max^2=smaller1^2+smaller2^2