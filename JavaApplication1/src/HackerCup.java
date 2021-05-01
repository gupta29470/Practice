/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aakash
 */
import java.util.*;
public class HackerCup {
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
        //int test=sc.nextInt();
       // while(test-->0){
            int n=5;
            int a[]={9,4,2,2,6,3,2,2,1};
            
            int len=a.length-1;
            System.out.println(len);
            StringBuilder sb=new StringBuilder();
            int m=n;
            while(m-->0){
                if(a[len]<n){
                    sb.append(len);
                }
            }
            System.out.println(sb);
            ArrayList<Integer> arr=new ArrayList<>();
           
        //}

    }
}
