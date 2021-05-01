/*
String : ABC 
Output: ABC
ACB
BAC
BCA
CAB
CBA

So we are giving chance to every character to start string. So we are at index of given
string, if we get all permutations of string((0 to index - 1) + (index + 1 to n - 1))
we just have to append current character at start of rest of permutated strings.
*/


public class Practice {

    public static void main(String[] args) {
        String input = "ABC";
        
        permutation(input, "");
    }
    
    public static void permutation(String input, String permutation){
		// base case
        if ("".equals(input)){
            System.out.println(permutation);
            return;
        }
        
		// self work
        for (int index = 0; index < input.length(); index++){
            char currentChar = input.charAt(index);
            String restOfString = input.substring(0, index) + input.substring(index + 1);
            
			// recursive assumption
            permutation(restOfString, permutation + currentChar);
        }
    }

}


// Handiling duplicates using Set.
/*
At every level we maintain a set to store current character and rest work is same as 
above method
*/

import java.util.*;

/**
 *
 * @author Aakash
 */
public class Practice {

    public static void main(String[] args) {
        String input = "AAC";

        permutation(input, "");
    }

    public static void permutation(String input, String permutation) {
		// base case
        if ("".equals(input)) {
            System.out.println(permutation);
            return;
        }
		// self work
        Set<Character> set = new HashSet<>();
        for (int index = 0; index < input.length(); index++) {
            char currentChar = input.charAt(index);
            if (!set.contains(currentChar)) {
                String restOfString = input.substring(0, index) + input.substring(index + 1);
                set.add(currentChar);
				
				// recursive assumption
                permutation(restOfString, permutation + currentChar);
            }
        }
    }
}
//Time --> 
