import java.util.*;
import java.io.*;
import java.math.*;

public class reverse_string_3_ways {

    static String s = "aakash";
    static char stack[] = new char[s.length()];

    static int top=-1;

    public static void main(String[] args) throws IOException {
        String a = "";
        Scanner sc = new Scanner(System.in);
        
        //METHOD 1 TO REVERSE STRING
        
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            st.add(s.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            char c = st.pop();
            a += c;
        }
        System.out.println(a);
        push(s);
        //print();
        print_pop();
        char c[]=s.toCharArray();
        reverse(c);
        System.out.print(String.valueOf(c)+" ");
    }
    //METHOD 2 TO REVERSE STRING
    static void push(String s) {
        if(s.length()==0){
            System.out.println("String is Empty");
        }
        if(top>=s.length()-1){
            System.out.println("Stack is full");
        }
        for(int i=0;i<s.length();i++){
            top++;
            stack[top]=s.charAt(i);
        }
    }
    

    static void print_pop() {
        String res="";
       if(top<0){
            System.out.println("Stack is Empty");
        }
        int i=s.length()-1;
        while(i>=0){
            char c=stack[top--];
            res+=c;
            i--;
        }
        System.out.println(res);

        
    }
    static void print(){
        
    }
    
    //METHOD 3 TO REVERSE STRING --> VERY  EFFICIENT
    static void swap(char a[],int i,int j){
        char temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    static void reverse(char str[]){
        int n=s.length();
        for(int i=0;i<n/2;i++){
            swap(str,i,n-1-i);
        }
    }
}
