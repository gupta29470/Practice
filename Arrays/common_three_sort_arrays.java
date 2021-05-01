import java.util.*;

public class common_three_sort_arrays {

    
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int arr[]={1 ,5 ,10, 20,40,80};
        int arr1[]={6 ,7 ,20, 80,10};
        int arr2[]={3 ,4 ,15, 20,30,70,80,120};
        common_three_sort_arrays f=new common_three_sort_arrays();
        f.common(arr, arr1, arr2);
       
    }
    
    public void common(int a[],int b[],int c[])
    {
        int i=0,j=0,k=0;
        while(i<a.length && j<b.length && k<c.length)
        {
        if(a[i]==b[j]&&a[i]==c[k])
        {
            System.out.println(a[i++]);
            j++;
            k++;
        }
        else if(a[i]>b[j])
        {
            j++;
            
        }
        else if(b[j]>a[i] )
        {
            i++;
            
        }
        else
        {
            k++;
        }
    }
        }
      
  
}