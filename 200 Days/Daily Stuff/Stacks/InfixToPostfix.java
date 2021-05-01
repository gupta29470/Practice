import java.util.*;

public class InfixToPostfix {

    public static void main(String args[]) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
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

    public static String infixToPostfix(String expression) {

        String result = "";
        Stack<Character> stack = new Stack<>();

        for (Character temp : expression.toCharArray()) {
            if (Character.isLetterOrDigit(temp)) {
                result += temp;
            } else if (temp == '(') {
                stack.push(temp);
            } else if (temp == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "invalid paranthesis";
                } else {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(temp) <= precedence(stack.peek())) {
                    if (stack.peek() == '(') {
                        return "invalid paranthesis";
                    }
                    result += stack.pop();
                }
                stack.push(temp);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "invalid paranthesis";
            } else {
                result += stack.pop();
            }
        }
        return result;
    }

}
