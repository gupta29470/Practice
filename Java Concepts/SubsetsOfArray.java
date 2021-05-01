import java.io.*;
import java.util.*;

public class SubsetsOfArray {

public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int a[] = new int[n];
    for (int i = 0; i < n; i++){
        a[i] =  sc.nextInt();
    }
    
    int limit = (int)Math.pow(2, n);
    
    for(int i = 0; i < limit; i++){
        int temp = i;
        String result = "";
        for(int j = n-1; j >= 0; j --){
            // converting i in to binary 0 or 1
            int remainder = temp % 2;
            temp = temp / 2;
            
            if (remainder == 0){
                result = "-\t" + result;
            }
            else{
                result = a[j] + "\t" + result;
            }
        }
        System.out.println(result);
    }
   
    
    
 }

}