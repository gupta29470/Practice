import java.util.*;

public class BinarySearch_recursiveapproach {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a[]={1,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59};
        
        int key,n=a.length;
        key=sc.nextInt();
        int low=1,high=n;
        int result=BinarySearch(a,low,high,key);
        if(result==-1)
        {
            System.out.println("Element not found");
        }
        else
        {
            System.out.println(key+" is found at index "+result);
        }
     }
    
    static int BinarySearch(int a[],int low,int high,int key)
    {
        if(low<=high)
        {
        if(low==high) // one element present
        {
            if(a[low]==key)
            {
                return low;
            }
            else
            {
                return 0;
            }
        }
        else
        {
            int mid=(low+high)/2;
            if(key==a[mid])
            {
                return mid;
            }
            if(key<a[mid])
            {
                return BinarySearch(a,low,mid-1,key);
            }
            else
            {
                return BinarySearch(a,mid+1,high,key);
            }
        }
        }
        return -1;
        
        
    }
}
