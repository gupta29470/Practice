import java.util.*;
import java.io.*;
import java.math.*;

public class Sieve_of_Eratosthenes {

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
      
       boolean a[]=new boolean[n+1];
      for(int i=0;i<n;i++){
          a[i]=true;
      }
      for(int i=2;i*i<=n;i++){
          if(a[i]==true){
              for(int j=i*i;j<=n;j+=i){
                  a[j]=false;
              }
          }
      }
      for(int i=2;i<=n;i++){
          if(a[i]==true){
              System.out.print(i+" ");
          }
      }

       
    }
    
}