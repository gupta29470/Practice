import java.util.*;

public class Permutations {

     public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        if (n == 1) {
            System.out.println(n);
            return;
        }
        else if (n > 1 && n <= 3) {
            System.out.println("NO SOLUTION");
            return;
        }
        else if(n==4){
            System.out.println("2 4 1 3");
        }
        else{
            int x=0,y=0;
            int odd[]=new int[n];
            int even[]=new int[n];
            int val=5;
            while(val<=n){
                odd[x++]=val;
                val+=2;
            }
            val=6;
            while(val<=n){
                even[y++]=val;
                val+=2;
            }
            
            for(int i=0;i<y;i++){
                sb.append(even[i]+" ");
            }sb.append("2 4 1 3 ");
            for(int i=0;i<x;i++){
                sb.append(odd[i]+" ");
            }
        }
        System.out.println(sb);
    }

}
