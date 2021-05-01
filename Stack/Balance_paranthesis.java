import java.util.*;
import java.io.*;
import java.math.*;

public class Balance_paranthesis {

    public static void main(String[] args) throws IOException {
        Stack<Character> st = new Stack<>();
        String s = "[()]{}{[()()]()}";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '{' || c == '(') {
                st.push(c);
                continue;
            }

            if (st.isEmpty()) {
                System.out.println("false");
                return;
            }
            if (c == ']') {
                if(st.peek()=='['){
                    st.pop();
                }
                else{
                    System.out.println("false");
                    break;
                }
                
            }
            else if(c==')'){
                if(st.peek()=='('){
                    st.pop();
                }
                else{
                    System.out.println("false");
                    break;
                }
            }
            else if(c=='}'){
                if(st.peek()=='{'){
                    st.pop();
                }
                else{
                    System.out.println("false");
                }
            }
        }
        if(st.isEmpty()){
            System.out.println("Balanced");
        }
        else{
            System.out.println("Not Balanced");
        }

    }

}
