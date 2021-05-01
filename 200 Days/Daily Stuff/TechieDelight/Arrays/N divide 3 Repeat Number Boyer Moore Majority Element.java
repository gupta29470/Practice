class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<>();
        if (len == 0){
            return ans;
        }
        
        if (len == 1){
            ans.add(nums[0]);
            return ans;
        }
        if (len == 2){
            if (nums[0] == nums[1]){
                ans.add(nums[0]);
                return ans;
            }
            ans.add(nums[0]);
            ans.add(nums[1]);
            return ans;
        }
        
        int first = Integer.MIN_VALUE, second = Integer.MAX_VALUE;
        int count1 = 0, count2 = 0;
        
        
        for (int index = 0; index < len ; index++){
            if (first == nums[index]){
                count1++;
            }
            else if (second == nums[index]){
                count2++;
            }
            else if (count1 == 0){
                count1 = 1;
                first = nums[index];
            }
            else if (count2 == 0){
                count2 = 1;
                second = nums[index];
            }
            else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0; count2 = 0;
        for (int index = 0; index < len; index++){
            if (first == nums[index]){
                count1++;
            }
            else if (second == nums[index]){
                count2++;
            }
        }
        
        if (count1 > len / 3){
            ans.add(first);
        }
        if (count2 > len / 3){
            ans.add(second);
        }
        return ans;
    }
}




public class Solution {
    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> a) {
        
        if (a.size() == 0){
            return -1;
        }
        if (a.size() == 1){
            return a.get(0);
        }
        
        int first = Integer.MIN_VALUE, second = Integer.MAX_VALUE;
        int n = a.size();
        int check = n / 3, count1 = 0, count2 = 0;
        
        for (int index = 0; index < n; index++){
            if (first == a.get(index)){
                count1++;
            }
            else if (second == a.get(index)){
                count2++;
            }
            else if (count1 == 0){
                count1++;
                first = a.get(index);
            }
            else if (count2 == 0){
                count2++;
                second = a.get(index);
            }
            else{
                count1--;
                count2--;
            }
        }
        
        count1 = 0; count2 = 0;
        for (int index = 0; index < n; index++){
            if (first == a.get(index)){
                count1++;
            }
            else if (second == a.get(index)){
                count2++;
            }
        }
        
        if (count1 > check){
            return first;
        }
        if (count2 > check){
            return second;
        }
        return -1;
    }
}


Time --> O(n)