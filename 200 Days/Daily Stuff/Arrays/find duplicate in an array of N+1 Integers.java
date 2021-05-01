/*
Given an array of integers nums containing n + 1 integers where each 
integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
*/


/*
************************ SOLUTION 1 ************************************
formula : sum - ((n - 1) * (n) / 2)
*/
class Solution {
    public int findDuplicate(int[] nums) {
        int sum = 0;
        
        for (int index = 0; index < nums.length; index++){
            sum+= nums[index];
        }
        
        return sum - ((nums.length - 1) * (nums.length) / 2);
    }
}
// Time --> O(n)


/*
************************ SOLUTION 2 ************************************
Using set if set contains current element return current element else add 
add in set
*/
class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int duplicate = -1;
        for (int index = 0; index < nums.length; index++){
            if (!set.contains(nums[index])){
                set.add(nums[index]);
            }
            else{
                duplicate = nums[index];
                break;
            }
        }
        return duplicate;
    }
}
// Time --> O(n)    Space --> O(n)



/*
************************ SOLUTION 2 ************************************
Input: [2, 3, 3, 1]
->Index 0:
    Absolute value = 2
    Put a minus sign to a[2] => [2, 3, -3, 1]
-> Index 1:
    Absolute value = 3
    Put a minus sign to a[3] => [2, 3, -3, -1]
-> Index 2:
    Absolute value = 3
    As a[3] is already negative, it means 3 is a duplicate
*/
class Solution {
    public int findDuplicate(int[] nums) {
		// traverse array
        for (int index = 0; index < nums.length; index++){
			// absolute value
            int absolute = Math.abs(nums[index]);
            // if already negative then return absolute
            if (nums[absolute] < 0){
                return absolute;
            }
			// mark negative
            nums[absolute] = -nums[absolute];
        }
        return -1;
    }
}