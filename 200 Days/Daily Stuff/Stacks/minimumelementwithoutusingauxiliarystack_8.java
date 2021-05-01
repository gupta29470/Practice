import java.util.*;

public class Designastackwhichreturnsminimumelementwithoutusingauxiliarystack_8.java {

    static Stack<Integer> mainStack = new Stack<>();
    static int min;

    public static void main(String[] args) {
        push(6);
        System.out.println(min());
        
        push(7);
        System.out.println(min());
        
        push(5);
        System.out.println(min());

        push(3);
        System.out.println(min());
        
        pop();
        System.out.println(min());
        
        pop();
        System.out.println(min());
    }

    public static void push (int data){
        if (mainStack.empty()){
            mainStack.push(data);
            min = data;
        }
        if (data >= mainStack.peek()){
            mainStack.push(data);
        }
        else{
            mainStack.push(2 * data - min);
            min = data;
        }
    }
    
    public static int pop(){
        if (mainStack.empty()){
            return -1;
        }
        int top = mainStack.pop();
        if (top < min){
            min = 2 * min - top;
        }
        return top;
    }
    public static int min(){
        return min;
    }
}
