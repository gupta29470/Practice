/*
	************************ USING STACK *************************
1. create stack to store characters of string and it helps to 
identify duplicates
2. create string builder to append result characters to string builder
and return as string
3. loop string
	-> if character on the top of stack is same as current character
	remove character from stack i.e pop
	-> else push current character in stack
4. loop stack to append result characters  to string builder
5. return as string
*/

import java.util.*;

class RemoveAdjacent {

    public static void main(String[] args) {

        String string = "azxxzy";
        
        System.out.println(removeDuplicates(string));
    }

    public static String removeDuplicates(String string) {

        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        
        for (int index = 0; index < string.length(); index++){
            if (!stack.isEmpty() && stack.peek() == string.charAt(index)){
                stack.pop();
            }
            else{
                stack.push(string.charAt(index));
            }
        }
        for (Character distinct : stack){
            result.append(distinct);
        }
        return result.toString();
    }
}
// Time --> O(n)  Space --> O(n)



/*
1. create string builder and initialize with current string. Use of this
string builder is we are not using any data structure to store distinct
character so we have to update current string. As string is immutable so
we are using string builder

2. create foundDuplicate as type boolean initialize with false. It will 
be true if we found duplicate

3. do : 
	-> update found = false
	-> loop string builder :
		-> if current character and next character is same then 
		update string builder by putting all characters before current
		character and all characters after next character
		
		-> update foundDuplicate = true
	
	as while loop check if foundDuplicate = true if yes it goes again
	to do block else do... while block breaks

4. return string builder as string
*/
class RemoveAdjacent {

    public static void main(String[] args) {

        String string = "azxxzy";

        System.out.println(removeDuplicates(string));
    }

    public static String removeDuplicates(String S) {

        StringBuilder sb = new StringBuilder(S);
        boolean foundDuplicate = false;

        do {
            foundDuplicate = false;
            
            for (int index = 0; index < sb.length() - 1; index++) {
                if (sb.charAt(index) == sb.charAt(index + 1)) {
                    sb = new StringBuilder(sb.substring(0, index)
                            + sb.substring(index + 2));
                    foundDuplicate = true;
                }
            }
        } while (foundDuplicate);

        return sb.toString();
    }
}
// Time --> O(n)   Space --> O(n)
