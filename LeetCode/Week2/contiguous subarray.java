class contiguous_subarray {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map=new LinkedHashMap<>();
        int sum=0,max=0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
               sum=sum-1; 
            }
            else
            {
                sum+=1;
            }
            if(map.containsKey(sum))
            {
                max=Math.max(max,i-map.get(sum));
            }
            else
            {
                map.put(sum,i);
            }
        }
        return max;
    }
}


/*
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.







/*

Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.




https://www.youtube.com/watch?v=xbMpRtZdYdk