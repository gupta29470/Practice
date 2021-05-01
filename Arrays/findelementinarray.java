import java.util.*;

public class findelementinarray {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n,find;
        System.out.println("ENter number you want to finD:");
        find=sc.nextInt();
        System.out.println("Enter range of array:");
        n=sc.nextInt();
       int a[]=new int [n];
       for(int i=0;i<a.length;i++)
       {
           a[i]=sc.nextInt();
       }
//       for(int i=0;i<a.length;i++)
//       {
//           if(find ==a[i])
//           {
//               System.out.println("True");
//           }
////           else
////           {
////               System.out.println("False");
////           }
//       }
       
       Arrays.sort(a);
       int res=Arrays.binarySearch(a, find);
       boolean test=res>=0?true:false;
        System.out.println(test);
      
    }
}
