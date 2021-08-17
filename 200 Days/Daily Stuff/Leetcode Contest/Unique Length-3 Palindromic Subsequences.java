class Solution {
    public int countPalindromicSubsequence(String s) {
        int len = s.length();
        
        if (len < 3){
            return 0;
        }
        
        char charArray[] = s.toCharArray();
        int firstOccurence[] = new int[26];
        int lastOccurence[] = new int[26];
        
        int answer = 0;
        
        Arrays.fill(firstOccurence, -1);
        Arrays.fill(lastOccurence, -1);
        
        for (int index = 0; index < len; index++){
            char currentChar = charArray[index];
            
            if (firstOccurence[currentChar - 'a'] == -1){
                firstOccurence[currentChar - 'a'] = index;
            }
            
            lastOccurence[currentChar - 'a'] = index;
        }
        
        
        for (int index1 = 0; index1 < 26; index1++){
            int firstIndex = firstOccurence[index1];
            int lastIndex = lastOccurence[index1];
            boolean visited[] = new boolean[26];
            
            for (int index2 = firstIndex + 1; index2 < lastIndex; index2++){
                char temp = charArray[index2];
                if (!visited[temp - 'a']){
                    visited[temp - 'a'] = true;
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
