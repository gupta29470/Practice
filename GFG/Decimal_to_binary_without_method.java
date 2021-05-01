import java.util.*;
import java.io.*;
import java.math.*;

public class Decimal_to_binary_without_method {

    public static void main(String[] args) throws IOException {
        System.out.print("Enter any number:");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        
        int bin[]=new int[1000];
        int i=0;
        while(num>0){
            bin[i]=num%2;
            num=num/2;
            i++;
        }
        for(int j=i-1;j>=0;j--){
            System.out.println(bin[j]);
        }
    }

   
}
