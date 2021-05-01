import java.util.*;

public class Heap_sort_Ascending_Descending {

    static int heap[] = new int[100];
    static int heapsize = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a[] = {1, 3, 5, 4, 6, 13, 10,
            9, 8, 15, 17};
        int b[] = {17, 15, 14, 13, 10, 9, 8};
        
        sort_ascending(b,b.length);
        for(int i:b){
            System.out.print(i+ " ");
        }
        System.out.println("");
        sort_descending(a);
        for(int i:a){
            System.out.print(i+" ");
        }

    }
    static void sort_ascending(int a[],int n){
        int startindex=(n/2)-1;
        for(int i=startindex;i>=0;i--){
            heapify_max(a,n,i);
        }
        for(int i=n-1;i>=0;i--){
            int temp=a[0];
            a[0]=a[i];
            a[i]=temp;
            heapify_max(a,i,0);
        }
    }
    
    static void heapify_max(int a[],int n,int i){
        int largest=i;
        int left=2*i+1;
        int right=2*i+2;
        
        if(left<n && a[left]>a[largest])
            largest=left;
        if(right<n && a[right]>a[largest])
            largest=right;
        
        if(largest!=i){
            int temp=a[i];
            a[i]=a[largest];
            a[largest]=temp;
            heapify_max(a,n,largest);
        }
    }
    static void sort_descending(int a[]){
        int n=a.length;
        int startindex=(n/2)-1;
        for(int i=startindex;i>=0;i--){
            heapify_min(a,n,i);
        }
        for(int i=n-1;i>=0;i--){
            int temp=a[0];
            a[0]=a[i];
            a[i]=temp;
            heapify_min(a,i,0);
        }
        
    }
    static void heapify_min(int a[],int n,int i){
        int smallest=i;
        int left=2*i+1;
        int right=2*i+2;
        
        if(left<n && a[left]<a[smallest]){
            smallest=left;
        }
        if(right<n && a[right]<a[smallest]){
            smallest=right;
        }
        if(smallest!=i){
            int temp=a[i];
            a[i]=a[smallest];
            a[smallest]=temp;
            heapify_min(a,n,smallest);
        }
    }

}
