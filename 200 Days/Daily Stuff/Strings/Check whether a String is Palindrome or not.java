/*
Convert String to character array and use two pointers, one pointer at 
start and another at end. 
If character at start is not equals to character at end return false.
If it is same start will increment and end is decrement.
If is palindrome at last return true
*/

class CheckPalindrome{
    public static void main(String[] args) {
        String string = "aakaa";
        
        System.out.println(isPalindrome(string));
    }
    
    public static boolean isPalindrome(String string){
        
        char charArray[] = string.toCharArray();
        int start = 0, end = charArray.length - 1;
        
        while (start < end){
            if (charArray[start] != charArray[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
// Time --> O(String length)    Space --> O(String length)


/*
Directly use two pointers, one pointer at start of string and another at 
end of string. 
If character at start is not equals to character at end return false.
If it is same start will increment and end is decrement.
If is palindrome at last return true
*/
class CheckPalindrome {

    public static void main(String[] args) {
        String string = "aakaa";

        System.out.println(isPalindrome(string));
    }

    public static boolean isPalindrome(String string) {

        int start = 0, end = string.length() - 1;

        while (start < end) {
            if (string.charAt(start) != string.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
