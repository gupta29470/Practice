import java.util.*;

public class PrefixToPostfix {

    public static void main(String args[]) {
        String expression = "*-A/BC-/AKL";
        System.out.println(prefixToPostfix(expression));
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

    public static String prefixToPostfix(String expression) {

        Stack<String> stack = new Stack<>();
        for (int index = expression.length() - 1; index >= 0; index --){
            Character temp = expression.charAt(index);
            
            if (ifOperator(temp)){
                String first = stack.pop();
                String second = stack.pop();
                
                String convert = first + second + temp ;
                stack.push(convert);
            }
            else{
                stack.push(temp.toString());
            }
        }
        return stack.pop();
    }
}
