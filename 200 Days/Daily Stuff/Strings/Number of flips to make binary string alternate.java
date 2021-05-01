/*
We can solve this problem by considering all possible results, 
As we are supposed to get alternate string, there are only 2 possibilities, 
alternate string starting with 0 and alternate string starting with 1. 

We will try both cases and choose the string which will require minimum 
number of flips as our final answer.

Trying a case requires O(n) time in which we will loop over all 
characters of given string, if current character is expected character 
according to alternation then we will do nothing otherwise we will increase 
flip count by 1. After trying strings starting with 0 and starting with 1, 
we will choose the string with minimum flip count.
*/


class BinaryStringAlternate{
    public static void main(String[] args) {
        
        String str = "0001010111";
        
        System.out.println(minFlips(str));
    }
    
    public static int minFlips(String string){
        //  return minimum of following two 
        //  1) flips when alternate string starts with 0 
        //  2) flips when alternate string starts with 1 
        return Math.min(minFlipsUtil(string, '0'), minFlipsUtil(string, '1'));
    }
    
    public static int minFlipsUtil(String string, char expected){
        int flipCount = 0;
        
        for (int index = 0; index < string.length(); index++){
            
            //  if current character is not expected, 
            // increase flip count 
            if (string.charAt(index) != expected){
                flipCount++;
            }
            
            //  flip expected character each time 
            expected = expected == '0'? '1' : '0';
        }
        return flipCount;
    }
}