import java.util.*;

public class secondsmallestelement {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
       int num[]={12, 13, 1, 10, 34, 1};
       int n=num.length;
        int first,second=n;
        if(n<2)
        {
            System.out.println("Invalid");
        }
        first=second=Integer.MAX_VALUE;
        System.out.println(first);
        for(int i=0;i<n;i++)
        {
            if(num[i]<first)
            {
                second=first;
                first=num[i];
            }
            else if(num[i]<second && num[i]!=first)
            {
                second=num[i];
            }
        }
        if(second==Integer.MAX_VALUE)
        {
            System.out.println("Not a value");
        }
        else
        {
            System.out.println(second);
        }
        
    }
}
