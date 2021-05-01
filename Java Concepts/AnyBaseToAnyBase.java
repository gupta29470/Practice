import java.util.*;
  
  public class AnyBaseToAnyBase {
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int sourceBase = scn.nextInt();
     int  destBase= scn.nextInt();
     System.out.println(getValue(n,sourceBase,destBase));
     
   }
   public static int getValue(int n,int sb,int db){
       int decimal=getValueIndecimal(n,sb);
       int result=getValueInBase(decimal,db);
       return result;
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