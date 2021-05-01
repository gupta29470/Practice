import java.util.*;

public class Evaluategivenpostfixexpression_4 {

    public static void main(String args[]) {
        String expression = "138*+";
        System.out.println(evaluatePostfix(expression));
    }

    public static int evaluatePostfix(String expression) {

        Stack<Integer> stack = new Stack<>();

        for (Character temp : expression.toCharArray()){
            if (Character.isDigit(temp)){
                stack.push(temp - '0');
            }
            else{
                int first = stack.pop();
                int second = stack.pop();
                switch (temp){
                    case '+':
                        stack.push(first + second);
                        break;
                    case '-':
                        stack.push(second - first);
                        break;
                    case '*':
                        stack.push(first * second);
                        break;
                    case '/':
                        stack.push(second / first);
                        break;
                    case '%':
                        stack.push(second % first);
                        break;
                    case '^':
                        stack.push((int)Math.pow(first, second));
                    break;
                }
            }
        }
        return stack.pop();
    }
}
