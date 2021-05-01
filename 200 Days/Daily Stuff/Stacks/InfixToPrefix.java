import java.util.*;

public class InfixToPrefix {

    public static void main(String args[]) {
        String exp = "A+B*(C^D-E)";
        System.out.println(infixToPrefix(exp));

    }

    public static int precedence(char temp) {
        switch (temp) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    public static String infixToPrefix(String expression) {

        String result = "";
        Stack<Character> stack = new Stack<>();
        String reverse = new StringBuilder(expression).reverse().toString();
        System.out.println(reverse);
        for (Character temp : reverse.toCharArray()) {
            if (Character.isLetterOrDigit(temp)) {
                result += temp;
            } else if (temp == ')') {
                stack.push(temp);
            } else if (temp == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    result += stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() != ')') {
                    return "invalid paranthesis";
                } else {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(temp) < precedence(stack.peek())) {
                    if (stack.peek() == ')') {
                        return "invalid paranthesis";
                    }
                    result += stack.pop();
                }
                stack.push(temp);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == ')') {
                return "invalid paranthesis";
            } else {
                result += stack.pop();
            }
        }
        return new StringBuilder(result).reverse().toString();
    }

}
