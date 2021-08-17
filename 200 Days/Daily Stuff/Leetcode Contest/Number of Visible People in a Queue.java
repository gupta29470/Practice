class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int len = heights.length;
        int visibles[] = new int[len];
        Stack<Integer> stack = new Stack<>();
        
        for(int index = len - 1; index >= 0; index--) {
            while(!stack.isEmpty() && stack.peek() < heights[index]) {
                visibles[index]++;
                stack.pop();
            }
            
            if(!stack.isEmpty()) {
                visibles[index]++; 
            }
            
            stack.push(heights[index]);
        }
        
        return visibles;
    }
}
