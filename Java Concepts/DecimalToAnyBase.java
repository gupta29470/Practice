import java.util.*;
  
  public class DecimalToAnyBase {
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int dn = getValueInBase(n, b);
      System.out.println(dn);
   }
  
   public static int getValueInBase(int n, int b){
       int result=0,power=1;
       while(n>0){
           int rem=n%b;
           n=n/b;
           result+=rem*power;
           power=power*10;
       }
       return result;
   }
  }