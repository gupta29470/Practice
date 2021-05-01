import java.util.*;

public class IncreasingArray {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a=sc.nextInt(),b; long sum=0;
        for(int i=0;i<n-1;i++){
            b=sc.nextInt();
            if(a>b){
                sum+=a-b;
            }
            else{
                a=b;
            }
        }
        System.out.println(sum);
    }
}
