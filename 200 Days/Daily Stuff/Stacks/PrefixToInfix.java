import java.util.*;

public class PrefixToInfix {
    
    public static void main(String args[]) {
        String expression = "*+AB-CD";
        System.out.println(prefixToInfix(expression));
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
    
    public static String prefixToInfix(String expression) {
        
        Stack<String> stack = new Stack<>();
        for (int index = expression.length() - 1; index >= 0; index --){
            Character temp = expression.charAt(index);
            
            if (ifOperator(temp)){
                String first = stack.pop();
                String second = stack.pop();
                
                String convert = "(" + first + temp + second + ")";
                stack.push(convert);
            }
            else{
                stack.push(temp.toString());
            }
        }
        return stack.pop();
    }
}
