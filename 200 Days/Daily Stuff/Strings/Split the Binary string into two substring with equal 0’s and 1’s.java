/*
 Initialize count = 0 and traverse the string character by character 
 and keep track of the number of 0s and 1s so far. 
 Whenever the count of 0s and 1s become equal increment the count. 
 If the count of 0s and 1s in the original string is not equal 
 then print -1 else print the value of count after the traversal of 
 the complete string.
*/


class Split{
    public static void main(String[] args) {
        
        String string = "0111100010";
        
        System.out.println(split(string));
    }
    
    public static int split(String string){
        int count0 = 0, count1 = 0, count = 0;
        
        for (int index = 0; index < string.length(); index++){
            if (string.charAt(index) == '0'){
                count0++;
            }
            else if (string.charAt(index) == '1'){
                count1++;
            }
            
            if (count0 == count1){
               count++;
            }
        }
        
        if (count0 != count1){
            return -1;
        }
        
        return count;
    }
}