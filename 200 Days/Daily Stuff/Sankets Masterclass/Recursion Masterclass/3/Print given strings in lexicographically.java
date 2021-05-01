/*
Sort the string and find all subsets of a string
*/

import java.util.*;

/**
 *
 * @author Aakash
 */
public class Practice {

    public static void main(String args[]){
        char input[] = "BAC".toCharArray();
        Arrays.sort(input);
        
        lexicographically(input, input.length, 0, "");
    }
    
    public static void lexicographically(char[] input, int len, int index, String output){
        if (index == len){
            System.out.println(output);
            return;
        }
        
        lexicographically(input, len, index + 1, output + input[index]);
        lexicographically(input, len, index + 1, output);
    }
    
}
// // Time --> O(2 ^ n)   Space --> O(2 ^ n)