class GfG {

    // arr[] : the input array containing 0s and 1s
    // N : size of the input array
    
    // return the maximum length of the subarray
    // with equal 0s and 1s
    int maxLen(int[] a, int N)
    {
        for (int index = 0; index < N; index++){
            if(a[index] == 0){
                a[index] = -1;
            }
        }
        
        int k = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxlen = 0;
        for (int index = 0; index < N; index++){
            sum+= a[index];
            if(sum == k){
                maxlen = index + 1;
            }
            map.putIfAbsent(sum, index);
            
            if(map.containsKey(sum)){
                if (maxlen < index - map.get(sum)){
                    maxlen = index - map.get(sum);
                }
            }
        }
        return maxlen;
    }
}
