import java.util.*;
    
    public class 3_Ways_to_Count_LCM_GCD{
    
    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      int n1=sc.nextInt();
      int n2=sc.nextInt();
      int on1=n1;
      int on2=n2;
      while(n1%n2!=0){
          int rem=n1%n2;
          n1=n2;
          n2=rem;
      }
      int gcd=n2;
      int lcm=(on1*on2)/gcd;
      System.out.println(gcd);
      System.out.println(lcm);
     }
    }
	
	
	
import java.util.*;
import java.math.*;
    
    public class Main{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger b1 = new BigInteger(sc.next());
        BigInteger b2 = new BigInteger(sc.next());
        BigInteger ob1 = b1;
        BigInteger ob2 = b2;
        BigInteger result = b1.gcd(b2);
        BigInteger lcm=(ob1.multiply(ob2)).divide(result);
        System.out.println(result);
        System.out.println(lcm);
    }
}


import java.util.*;
import java.math.*;
    
    public class Main{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int on1 = n1;
        int on2 = n2;
        while (n1 % n2 != 0) {
            int rem = n1 % n2;
            n1 = n2;
            n2 = rem;
        }
        int gcd = n2;
        int lcm = (on1 > on2) ? n1 : n2;
        while (true) {
            if (lcm % on1 == 0 && lcm % on2 == 0) {
                lcm = lcm;
                break;
            }
            ++lcm;
        }
        System.out.println(gcd);
        System.out.println(lcm);
    }
}
