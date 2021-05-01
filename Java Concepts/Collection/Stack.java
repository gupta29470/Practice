import java.util.*;

public class Stack {

    public static void main(String[] args) throws IOException {
        Stack s=new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println("Remove top element: "+s.pop());//Remove top element: 5
        System.out.println("Search element 1: "+s.search(1));//Search element 1: 4

    }
}
