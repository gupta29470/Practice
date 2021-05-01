import java.io.*;
import java.util.*;

class first_non_repeated_element {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    for(int i=0;i<n;i++) a[i]=sc.nextInt();
		    Map<Integer,Integer> map=new LinkedHashMap<>();
		    for(int i=0;i<n;i++)
		    {
		        if(map.containsKey(a[i]))
		        {
		            map.put(a[i],map.get(a[i])+1);
		        }
		        else
		    {
		        map.put(a[i],1);
		    }
		    }
		    for(Map.Entry<Integer,Integer> st:map.entrySet())
		    {
		        if(st.getValue()==1)
		        {
		            System.out.println(st.getKey()+" ");
		            break;
		        }
		    }
		}
	}
}