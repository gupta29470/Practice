import java.util.*;

public class Count_pairs_with_given_sum {

    static int arr[]={1, 5, 7, -1, 5};
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
		int n=arr.length,sum=6;
                System.out.println(count_pairs(n,sum));
		
		
       
        
       
    }
  
    public static int count_pairs(int n,int sum)         
    {
      Map<Integer,Integer> map=new LinkedHashMap<>();
      for(int i=0;i<n;i++)
      {
          if(!map.containsKey(arr[i]))
              map.put(arr[i],0);
          map.put(arr[i], map.get(arr[i])+1);
          
      }
      
      int twicecount=0;
      for(Integer x:map.keySet())
      {
          if(map.get(sum-x)!=null)
          {
              twicecount+=map.get(sum-x);
          }
          if((sum-x)==x)
          {
              twicecount--;
          }
          
      }
      return twicecount/2;
       
    
}
}