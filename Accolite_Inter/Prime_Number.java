import java.util.*;

public class Prime_Number {

    public static void main(String args[]) {
        int n = 5;
        if (isprime(n)) {
            System.out.println("Prime number");
        } else {
            System.out.println("Not a prime number");
        }
        if (isprime_effective(n)) {
            System.out.println("Prime number");
        } else {
            System.out.println("Not a prime number");
        }

    }

    static boolean isprime(int n) {
       if(n<=1){
           return false;
       }
       for(int i=2;i<=n/2;i++){
           if(n%i==0){
               return false;
           }
       }
       return true;
    }

    static boolean isprime_effective(int n) {
        if(n<=1){
            return false;
        }
        int i=2;
        while(i*i<=n){
            if(n%i==0){
                return false;
            }
            i+=2;
        }
        return true;
    }
}
