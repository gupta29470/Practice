import java.util.*;

public class Decodethegivensequence_6 {

    public static void main(String args[]) throws Exception {
        String sequence = "IIDDIDID";

        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int index = 0; index <= sequence.length(); index++) {
            stack.push(index + 1);

            if (index == sequence.length() || sequence.charAt(index) == 'I') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }
        System.out.println(result);
    }
}
