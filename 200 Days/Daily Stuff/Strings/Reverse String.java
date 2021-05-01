/*
Using String Builder and its reverse function.
*/
class StringReverse{
    public static void main(String[] args) {
        String string = "Aakash";
        System.out.println(reverseString(string));
    }
    
    public static String reverseString(String string){
        
        StringBuilder sb = new StringBuilder(string);
        return sb.reverse().toString();
    }
}

/*
Convert  string to character array and and using two pointer i.e 
one pointer at start and one at end and swap that character, after each
swap increment start and decrement end.
return char array as string 
*/

import java.util.*;

class StringReverse{
    public static void main(String[] args) {
        String string = "Aakash";
        System.out.println(reverseString(string));
    }
    
    public static String reverseString(String string){
        
        char charArray[] = string.toCharArray();
        int start = 0, end = charArray.length - 1;
        
        while (start <= end){
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
        return Arrays.toString(charArray);
    }
}