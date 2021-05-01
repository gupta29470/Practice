import java.util.*;

public class faithfulNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            long n=sc.nextLong();
            long ans=0,pow=1;
            while(n>0){
                if(((int)n&1)==1){
                    ans+=pow;
                    pow*=7;
                    n>>=1;
                }
            }
            System.out.println(ans);
        }
    }
}
