import java.util.*;

public class BinarySearch_iterativeapproach {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a[]={1,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59};
        
        int key,n=a.length;
        key=sc.nextInt();
        int result=BinarySearch(a,key,n);
        if(result==-1)
        {
            System.out.println("Element not found");
        }
        else
        {
            System.out.println(key+" is found at index "+result);
        }
     }
    
    static int BinarySearch(int a[],int key,int n)
    {
        int low=1,high=n;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(key==a[mid])
                return mid;
            if(key<a[mid])
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }
}