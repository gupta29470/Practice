public class cyclic_rotate_byone {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int arr1[] = {1, 2, 4, 5, 6}; 
        cyclic_rotate(arr1);
        for(int b:arr1)
            System.out.print(b+" ");
        
       
    }
  
    public static void cyclic_rotate(int a[])         
    {
        int x=a[a.length-1];
        for(int i=a.length-1;i>0;i--)
            a[i]=a[i-1];
        a[0]=x;
    
}
}