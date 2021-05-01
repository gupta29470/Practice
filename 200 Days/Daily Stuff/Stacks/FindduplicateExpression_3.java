import java.util.*;

public class FindduplicateExpression_3 {

    public static void main(String args[]) {

        String expression = "((x+y))";
        boolean result = duplicateExpression(expression);
        if (result){
            System.out.println("Duplicate paranthesis found");
        }
        else{
            System.out.println("No duplicate paranthesis found");
        }
    }

    public static boolean duplicateExpression(String expression) {

        if (expression.length() <= 3){
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        for (Character temp : expression.toCharArray()){
            if (temp != ')'){
                stack.push(temp);
            }
            else{
                if (stack.peek() == '('){
                    return true;
                }
                while (stack.peek() != '('){
                    stack.pop();
                }
                stack.pop();
            }
        }
        return false;
    }

}
