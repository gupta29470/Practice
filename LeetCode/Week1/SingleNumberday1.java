import java.util.*;
class SingleNumberday1 {
    public static int singleNumber(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(nums[i]))
            {
                map.put(nums[i],map.get(nums[i])+1);
            }
            else
            {
                map.put(nums[i],1);
            }
        }
        
        for(Map.Entry<Integer,Integer> x:map.entrySet())
        {
            if(x.getValue()==1)
                return x.getKey();
        }
        return -1;
        
        
        
        
    }
public static void main(String args[])
{int nums[]={4,1,2,1,2};
System.out.println(singleNumber(nums));
}
        
}

/*
Given a non-empty array of integers, every element appears twice 
except for one. Find that single one.

Input: [2,2,1]
Output: 1