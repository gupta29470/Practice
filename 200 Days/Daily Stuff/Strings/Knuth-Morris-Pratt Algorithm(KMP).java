class KMP{
    public static void main(String[] args) {
        String txt = "AAAABAAAAABBBAAAAB"; 
        String pat = "AAAB"; 
        patternSearch(txt, pat); 
    }
    
    public static void patternSearch(String string, String pattern){
     
        int strLen = string.length();
        int patLen = pattern.length();
        int index1 = 0, index2 = 0;
        
        // create lps[] that will hold the longest 
        // prefix suffix values for pattern 
        int lps[] = new int[patLen];
        
        // Preprocess the pattern (calculate lps[] 
        // array) 
        computeLPS(pattern, lps);
        
        // index for string
        while (index1 < strLen){
            if (string.charAt(index1) == pattern.charAt(index2)){
                index1++;
                index2++;
            }
            if (index2 == patLen){
                System.out.println("Pattern found at index : " + (index1 - index2));
                index2 = lps[index2 - 1];
            }
            // mismatch after index2 matches 
            else if (index1 < strLen && string.charAt(index1) 
                    != pattern.charAt(index2)){
                
                // Do not match lps[0..lps[index2-1]] characters, 
                // they will match anyway 
                if (index2 != 0){
                    index2 = lps[index2 - 1];
                }
                else{
                    index1++;
                }
            }
        }
    }
    
    public static void computeLPS(String pattern, int lps[]){
        
        // length of the previous longest prefix suffix 
        int patLen = pattern.length();
        int length = 0, index = 1;
        
        // lps[0] is always 0 
        lps[0] = 0;
        
        while (index < patLen){
            if (pattern.charAt(length) == pattern.charAt(index)){
                length++;
                lps[index] = length;
                index++;
            }
            
            // (pat[index] != pat[length]) 
            else{
                if (length == 0){
                    lps[index] = length;
                    index++;
                }
                // go to previous index
                else{
                    length = lps[length - 1];
                }
            }
        }
    }
}
// Time --> O(n)   Space --> O(m) pattern length.