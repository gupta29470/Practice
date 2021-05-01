import java.io.*;
import java.util.*;

public class LastStoneWeight {
    
      
  
    public static void main(String args[]) 
            
    { int stones[]={2,7,4,1,8,1};
        PriorityQueue<Integer> pq =new PriorityQueue(Collections.reverseOrder());
        for(int a:stones)
        {
            pq.add(a);
        }
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        while(pq.size()>1)
        {
            
            pq.add(pq.poll()-pq.poll());
        }
        System.out.println( pq.peek());
    } 
}

   