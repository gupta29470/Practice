/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aakash
 *
 */
import static java.lang.System.out;
import java.util.*;

public class JavaPrat {

    // Static Block : It runs all static block then main method
//    static{
//        System.out.println("Hii");
//    }
//    public static void main(String[] args) {
//        System.out.println("Hello");
//    }
//    static{
//        System.out.println("By");
//    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      int k=sc.nextInt();
      int x=sc.nextInt();
      int d=sc.nextInt();
      float tot=100.0f,x1=(float)x;
      int a[]=new int[n];
      for(int i=0;i<n;i++){
          a[i]=sc.nextInt();
      }
      float max=0.0f,per=0.0f;
      for(int i=0;i<a.length;i++){
          per=(a[i]*x1/tot);   
          max+=Math.max(k, per);
      }
      System.out.println(max);
      if(max<=d){
          System.out.println("fee");
      }
      else{
          System.out.println("upfront");
      }
    }
}
// int a[]={465, 882, 993, 215 ,462, 65, 364 ,784 ,166 ,959 ,508 ,778 ,101, 249, 749 ,758 ,754, 746, 51, 771, 611, 823 ,339 ,853 ,935, 643, 670, 829 ,413, 208 ,861, 51, 873, 859, 641, 716 ,94, 477, 250 ,834 ,627, 21, 858, 709, 831, 206, 186 ,22 ,278, 483, 722, 551, 670, 825, 491 ,157 ,496 ,494, 484, 58 ,404, 618, 225 ,155, 22 ,108 ,295, 372 ,883, 264, 41, 425, 668, 25, 417, 192, 723, 853, 679, 455, 189 ,67, 430 ,899, 588 ,982 ,280 ,716 ,396 ,849 ,255, 888 ,502, 435, 316 ,365 ,203 ,66 ,490 ,624};