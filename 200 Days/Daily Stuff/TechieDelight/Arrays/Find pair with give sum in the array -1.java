class Solution {
    public int[] twoSum(int[] nums, int target) {
        int sol[] = new int[2];
        int first = 0, second = 0;
        for (int index1 = 0; index1 < nums.length; index1++){
            for (int index2 = index1 + 1; index2 < nums.length; index2++){
                if (nums[index1] + nums[index2] == target){
                    first = index1; second = index2;
                }
            }
        }
        sol[0] = first; sol[1] = second;
        return sol;
    }
}
// Time --> O(n^2)     Space --> O (1)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map <Integer , Integer> map = new HashMap<>();
        int sol[] = new int[2];
        int first = 0, second = 0;
        
        for (int index = 0; index < nums.length; index++){
            if (map.containsKey(target - nums[index])){
                first = map.get(target - nums[index]);
                second = index;
            }
            else{
                map.put(nums[index], index);
            }
        }
        sol[0] = first; sol[1] = second;
        return sol;
    }
}

// Time -- > O(n)    Space --> O(n)
