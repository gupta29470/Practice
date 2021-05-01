public class Quicksorts {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a[]={55,666,85,99,12,33};
        int low=0,high=a.length-1;
       foss f =new foss();
       f.Quicksort(a, low, high);
        for(int i:a)
        {
            System.out.println(i);
        }
       
     }
    void Quicksort(int a[],int low,int high)
    { 
        
        int j=partition(a,low,high);
        
        if(low<j-1)
        {
            Quicksort(a,low,j-1);
        }
        if(j<high)
        {
            Quicksort(a,j-1,high);
        }
        
    }
    static int partition(int a[],int low,int high)
    {
     
       int pivot=a[(low+high)/2];
        
       while(low<=high)
       {
           while(a[low]<pivot)
           {
               low++;
           }
           while(a[high]>pivot)
           {
               high--;
           }
           if(low<=high)
           {
               int temp=a[low];
               a[low]=a[high];
               a[high]=temp;
               low++;
               high--;
           }
           
       }
       return low;
    }
}
