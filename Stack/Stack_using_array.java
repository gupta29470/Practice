import java.util.*;
import java.io.*;
import java.math.*;

public class Stack_using_array {

    static int top;
    static int max = 10;
    static int stack[] = new int[max];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        push(50);
        pop();
       show();
        System.out.println(isEmpty());      
    }
    

    static void push(int data) {
        if (top >=max - 1) {
            System.out.println("Stack is full");
        } else {
            stack[top] = data;
            top++;
        }
    }

    static void  pop() 
    { int data=0;
        if (top <= 0) { 
            
            System.out.println("Stack Underflow"); 
        }
           
       else { 
            data=stack[top];
            top--;
            stack[top]=0;
             System.out.println(data);
        } 
            
        
    }
    static void show() {
        if (top < 0) {
            System.out.println("Stack is empty");
        } else {
            for (int i : stack) {
                System.out.print(i + " ");
            }
        }
    }

   static void peek() {
        if (top < 0) {
            System.out.println("Stack is empty");
        } else {
            System.out.println(stack[top]);
        }
    }
   static boolean isEmpty(){
       
           return top<=0;
       
   }
   static int size(){
       return top;
   }
}
