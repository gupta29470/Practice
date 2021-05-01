import java.io.*;
import java.util.*;

public class DifferenceOfTwoArrays{

public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n1 = sc.nextInt();
    int a[] = new int [n1];
    for(int i = 0; i < n1; i++){
        a[i] = sc.nextInt();
    }
    int n2 = sc.nextInt();
    int b[] = new int [n2];
    for(int i = 0; i < n2; i++){
        b[i] = sc.nextInt();
    }
    int diff[] = new int[n2];
    int carry = 0;
    int i = a.length-1, j = b.length-1, k = diff.length-1;
    
    while(k >= 0){
        int digit = 0;
        int a1 = i>=0?a[i]:0;
        if(b[j] + carry >= a1){
            digit = b[j] + carry - a1;
            carry = 0;
        }
        else{
            digit = b[j] + carry + 10 - a1;
            carry = -1;
        }
        diff[k] = digit;
        i--;j--;k--;
        
    }
    int ind = 0;
    while (ind < diff.length){
        if(diff[ind] == 0){
            ind++;
        }
        else{
            break;
        }
    }
    while(ind < diff.length){
        System.out.println(diff[ind]);
        ind++;
    }
 }

}