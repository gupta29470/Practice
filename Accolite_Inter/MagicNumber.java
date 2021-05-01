import java.util.*;

public class MagicNumber {

    public static void main(String[] args) {
        int n=5,pow=1,ans=0;
        while(n>0){
            pow*=5;
            if(((int)n & 1)==1){
                ans+=pow;
            }
            n>>=1;
        }

        System.out.println(ans);

    }
}