import java.util.*;
  
  public class Any_Base_Addition{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getSum(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getSum(int b, int n1, int n2){
       int carry = 0 , power = 1 , result = 0;
       while ( n1 > 0 || n2 > 0 || carry > 0){
           int digit1 = n1 % 10;
           int digit2 = n2 % 10;
           n1 = n1 / 10;
           n2 = n2 / 10;
           int digit = digit1 + digit2 + carry;
           carry = digit / b;
           digit = digit % b;
           result+= digit * power;
           power = power * 10;
       }
       return result;
   }
  }