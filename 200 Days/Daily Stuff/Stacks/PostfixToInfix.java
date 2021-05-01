import java.util.*;

public class PostfixToInfix {

    public static void main(String args[]) {
        String expression = "ab*c+";
        System.out.println(postfixToInfix(expression));
    }

    public static boolean ifOperator(Character operator) {
        switch (operator) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '%':
            case '^':
                return true;
        }
        return false;
    }

    public static String postfixToInfix(String expression) {

        Stack<String> stack = new Stack<>();
        for (Character temp : expression.toCharArray()) {
            if (ifOperator(temp)) {
                String first = stack.pop();
                String second = stack.pop();

                String convert = "(" + second + temp + first + ")";
                stack.push(convert);
            } else {
                stack.push(temp.toString());
            }
        }
        return stack.pop();
    }
}
