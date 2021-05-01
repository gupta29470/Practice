import java.util.*;

public class KthlargestandKthsmallestnumberinanarray {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a[]={7, 10, 4, 3, 20, 15};
        KthlargestandKthsmallestnumberinanarray f=new KthlargestandKthsmallestnumberinanarray();
        f.dividearray(a, 0, a.length-1);
        for(int b:a)
        {
            System.out.print(b+" ");
        }
        System.out.println("");
        int k;
        System.out.println("Enter value of k:");
        k=sc.nextInt();
        System.out.println(k+" th smallest element is "+a[k-1]+" and "+k+" th largest element is "+a[a.length-k]);
        
    }
    public void  dividearray(int a[],int low,int high)
    {
        if(low>=high)
            return;
        int mid=(low+high)/2;
        dividearray(a,low,mid);
        dividearray(a,mid+1,high);
        mergearray(a,low,high);
    }
    
    public void mergearray(int a[],int low,int high)
    {
        int mid=(low+high)/2;
        int n=a.length,i=low,j=mid+1,k=low;
        int temp[]=new int[n];
        while(i<=mid &&j<=high)
        {
            if(a[i]<a[j])
            {
                temp[k++]=a[i++];
            }
            else
            {
                temp[k++]=a[j++];
            }
        }
        while(i<=mid)
        {
            temp[k++]=a[i++];
        }
        while(j<=high)
        {
            temp[k++]=a[j++];
        }
        for(int b=low;b<=high;b++)
        {
            a[b]=temp[b];
        }
        
    }
    
}
