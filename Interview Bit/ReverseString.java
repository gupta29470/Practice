import java.util.*;

public class vit {

    public static void main(String[] args) {
        
        String input = "Aakash";
        Stack<Character> stack = new Stack<>();
        for (int index = 0; index < input.length(); index++){
            stack.push(input.charAt(index));
        }
        while (!stack.empty()){
            System.out.print(stack.pop());
        }
    }
}

// Time --> O(n)   Space --> O(n)

import java.io.*;
import java.util.*;

public class vit {

    public static void main(String[] args) {
        
        String input = "Aakash";
        char inputChar[] = input.toCharArray();
        int start = 0, end = inputChar.length - 1;
        while (start <= end){
            char temp = inputChar[start];
            inputChar[start] = inputChar[end];
            inputChar[end] = temp;
            start ++; end --;
        }
        String result = new String(inputChar);
        System.out.println(result);
    }
}
// Time --> O(n)   Space --> O(1)