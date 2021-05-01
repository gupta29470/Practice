import java.util.*;

public class PostfixToPrefix {

    public static void main(String args[]) {
        String expression = "ABC/-AK/L-*";
        System.out.println(postfixToPrefix(expression));
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

    public static String postfixToPrefix(String expression) {

        Stack<String> stack = new Stack<>();
        for (int index = 0; index < expression.length(); index ++){
            Character temp = expression.charAt(index);
            
            if (ifOperator(temp)){
                String first = stack.pop();
                String second = stack.pop();
                
                String convert = temp + second + first ;
                stack.push(convert);
            }
            else{
                stack.push(temp.toString());
            }
        }
        return stack.pop();
    }
}
