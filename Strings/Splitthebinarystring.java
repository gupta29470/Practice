public class Splitthebinarystring  {

    public static int splitbinary(String str,int n)
    {
        int c1=0;//count nmber of 0's
        int c2=0;//count number of 1's
        int c3=0;//count number of 0&1 pair
        for(int i=0;i<n;i++)
        {
            if(str.charAt(i)=='0')
            {
                c1++;
            }
            else if(str.charAt(i)=='1')
            {
                c2++;
            }
            else
            {
                return -1;
            }
            if(c1==c2)
            {
                c3++;
            }
            
        }
        if(c1!=c2)
            return -1;
        return c3;
        
    }
    public static void main(String[] args) {
        String a="001110";
        int n=a.length();
        System.out.println(splitbinary(a, n));
    }
}