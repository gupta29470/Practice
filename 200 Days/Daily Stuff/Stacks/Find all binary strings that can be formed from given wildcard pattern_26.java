// Recursive
public class vit {

    public static void main(String[] args) {
        char pattern[] = "1?11?00?1?".toCharArray();

        printAllCombinations(pattern, 0);
    }

    public static void printAllCombinations(char pattern[], int index) {
        if (index == pattern.length) {
            System.out.println(pattern);
            return;
        }

        if (pattern[index] == '?') {
            for (char temp = '0'; temp <= '1'; temp++) {
                // replace '?' with 0 and 1
                pattern[index] = temp;

                // recur for the remaining pattern
                printAllCombinations(pattern, index + 1);

                pattern[index] = '?';
            }
            return;
        }
        // if the current character is 0 or 1, ignore it and
        // recur for the remaining pattern
        printAllCombinations(pattern, index + 1);
    }

}




// Iterative 
import java.util.*;

public class vit {

    public static void main(String[] args) {
        String pattern = "1?11?00?1?";

        printAllCombinations(pattern);
    }

    public static void printAllCombinations(String pattern) {

        Stack<String> stack = new Stack<>();

        stack.push(pattern);
        int index;

        while (!stack.isEmpty()) {
            String current = stack.pop();

            if ((index = current.indexOf('?')) != -1) {
                for (char temp = '0'; temp <= '1'; temp++) {
                    current = current.substring(0, index) + temp
                            + current.substring(index + 1);
                    stack.push(current);
                }
            } else {
                System.out.println(current);
            }
        }
    }

}
