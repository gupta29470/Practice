class RabinKarp {

    public static void main(String[] args) {

        String txt = "abcdabce";
        String pat = "bce";

        System.out.println(searchPattern(txt, pat));
    }

    public static String searchPattern(String string, String pattern) {
        int hash = 1;
        
        // hash value for pattern
        int patternHash = 0;
        
        //hash value for string
        int stringHash = 0;
        
        //the number of characters in the input alphabet 
        int numberOfCharacters = 256; 
        
        int strLen = string.length();
        int patternLen = pattern.length();
        
        // A prime number to shorten hash value
        int shorten = 101;

        //The value of hash would be "pow(d, M-1)%q
        for (int index = 0; index < patternLen - 1; index++) {
            hash = (numberOfCharacters * hash) % shorten;
        }

        // Calculate the hash value of pattern and first 
        // window of string
        for (int index = 0; index < patternLen; index++) {
            patternHash = (numberOfCharacters * patternHash
                    + (pattern.charAt(index))) % shorten;

            stringHash = (numberOfCharacters * stringHash
                    + (string.charAt(index))) % shorten;
        }

        
        // Slide the pattern over text one by one 
        for (int index1 = 0; index1 <= strLen - patternLen; index1++) {
            
            // Check the hash values of current window of text 
            // and pattern. If the hash values match then only 
            // check for characters on by one 
            if (patternHash == stringHash) {
                int index2;
                
                /* Check for characters one by one */
                for (index2 = 0; index2 < patternLen; index2++) {
                    if (string.charAt(index1 + index2) != pattern.charAt(index2)) {
                        break;
                    }
                }
                
                // if patternHash == stringHash and pat[0...M-1] = str[i, i+1, ...i+M-1] 
                if (index2 == patternLen) {
                    return "Pattern found at index : " + index1;
                }
            }

            // Calculate hash value for next window of text: Remove 
            // leading digit, add trailing digit 
            if (index1 < strLen - patternLen) {
                stringHash = (numberOfCharacters * (stringHash - string.charAt(index1) * hash)
                        + string.charAt(index1 + patternLen)) % shorten;
            }

            // We might get negative value of t, converting it 
            // to positive 
            if (stringHash < 0) {
                stringHash = stringHash + shorten;
            }
        }
        return "Pattern not found";
    }
}

/*
The average case and best case complexity of Rabin-Karp algorithm is 
O(m + n) and the worst case complexity is O(mn).

The worst-case complexity occurs when spurious hits occur a number 
for all the windows.
*/