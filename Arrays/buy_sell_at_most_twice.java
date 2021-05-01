import java.util.*;

/**
 *
 * @author Aakash
 */
public class buy_sell_at_most_twice {
    static int profits(int a[]){
        int n=a.length;
        int profit[]=new int[n];
        for(int i=0;i<n;i++)
            profit[i]=0;
        int maxprice=a[n-1];
        
        for(int i=n-2;i>=0;i--){
            
            if(a[i]>maxprice){
                maxprice=a[i];
                   
            }
            profit[i]=Math.max(profit[i+1], maxprice-a[i]);
            
        }
        
        int minprice=a[0];
        
        for(int i=1;i<n;i++){
            if(a[i]<minprice){
                minprice=a[i];
            }
            System.out.println(profit[i-1]);
            profit[i]=Math.max(profit[i-1], profit[i]+(a[i]-minprice));
            //System.out.println(i+" "+profit[i]); 
        }
        int result=profit[n-1];
        return result;
    }

    public static void main(String[] args) {

        int arr[] = {2, 30, 15, 10, 8, 25, 80};
        System.out.println(profits(arr));
                
    }
}
