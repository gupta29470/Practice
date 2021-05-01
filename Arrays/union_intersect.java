import java.util.*;

public class union_intersect {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int arr1[] = {1, 2, 4, 5, 6}; 
        int arr2[] = {2, 3, 5, 7}; 
        union(arr1,arr2);
        intersection(arr1,arr2);
       
    }
  
    public static void union(int a[],int b[])         
    {
        int i=0,j=0;
        while(i<a.length && j<b.length)
        {
            if(a[i]<b[j])
                System.out.print(a[i++]+ " ");
            else if(a[i]>b[j])
                System.out.print(b[j++]+" ");
            else
            {
                System.out.print(b[j++]+" ");
                i++;
            }
        }
        System.out.println("");
    }
    
    
    public static void intersection(int a[],int b[])
    {
        int i=0,j=0;
        while(i<a.length && j<b.length)
        {
            if(a[i]==b[j])
            {
                System.out.print(a[i++]+" ");
                j++;
            }
            else if(a[i]>b[j])
                j++;
            else
                i++;
        }
        System.out.println("");
    }
    
}