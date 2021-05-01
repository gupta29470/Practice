class Movezeroes {
    public void moveZeroes(int[] nums) {
        
        if(nums.length==0||nums.length==1)
            return;
        int left=0,right=0;
        while(right<nums.length)
        {
            if(nums[right]==0)
            {
                ++right;
                
            }
            else
            {
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                ++left;
                ++right;
            }
        }
        
    }
}


/*Given an array nums, write a function to move all 0's to the end 
of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

https://www.youtube.com/watch?v=PNJoyRaIW7U&t=297s