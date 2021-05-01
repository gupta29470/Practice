import java.util.*;
  
  public class AnyBaseToDecimal {
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int d = getValueIndecimal(n, b);
      System.out.println(d);
   }
  
   public static int getValueIndecimal(int n, int b){
      int result=0,power=1;
      while(n>0){
          int rem=n%10;
          n=n/10;
          result+=rem*power;
          power*=b;
      }
      return result;
   }
  }