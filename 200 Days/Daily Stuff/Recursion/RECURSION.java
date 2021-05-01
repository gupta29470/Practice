/*  ******************** RECURSION ********************** */

//1.
public class reverse_string_using_recursion {

    public static void main(String[] args) throws Exception {
        String input = "Aakash";
        reverse(input);
    }
    
    public static void reverse(String input){
        
        if (input == null || input.length() == 1){
            System.out.println(input);
            return;
        }
        int len = input.length();
        System.out.print(input.charAt(len - 1));
        reverse(input.substring(0, len - 1));
    }
}

//2.
public class Check_if_a_number_is_Palindrome_or_not {

    public static void main(String[] args) throws Exception {
        int number = 121;
        int temp = 0;
        int res = checkNumberPalindrome(number, temp);
        if (res == number){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }

    public static int checkNumberPalindrome(int number, int temp) {
        
        if (number == 0){
            return temp;
        }
        temp = (temp * 10) + (number % 10);
        return checkNumberPalindrome(number / 10, temp);
    }
}


//3.
import java.util.*;

public class Reverse_a_Stack_using_recursion {

    public static void main(String[] args) throws Exception {
        Stack<Integer> originalStack = new Stack<>();
        originalStack.add(14);
        originalStack.add(9);
        originalStack.add(67);
        originalStack.add(91);
        originalStack.add(101);
        originalStack.add(25);
        System.out.println(originalStack);
        reverseStack(originalStack);
        System.out.println(originalStack);

    }

    public static void reverseStack(Stack<Integer> stack) {

        if (stack.isEmpty()) {
            return;
        }
        int element = stack.pop();
        reverseStack(stack);

        insertAtLast(stack, element);
    }

    public static void insertAtLast(Stack<Integer> stack, int element) {

        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }

        int removeElement = stack.pop();
        insertAtLast(stack, element);
        stack.push(removeElement);
    }
}

