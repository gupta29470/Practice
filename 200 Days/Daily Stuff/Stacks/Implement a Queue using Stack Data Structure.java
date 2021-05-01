import java.util.*;

public class vit {

    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        for (int temp : list){
            enqueue(temp);
        }
        for (int index = 0; index < list.size(); index++){
            System.out.print(dequeue()+" ");
        }
    }

    public static void enqueue(int data) {
        while (!stack1.isEmpty()){
            stack2.add(stack1.pop());
        }
        stack1.push(data);
        while (!stack2.isEmpty()){
            stack1.add(stack2.pop());
        }
    }

    public static int dequeue() {
        if (stack1.isEmpty()){
            return -1;
        }
        return stack1.pop();
    }

}



import java.util.*;

public class vit {

    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        for (int temp : list){
            enqueue(temp);
        }
        for (int index = 0; index < list.size(); index++){
            System.out.print(dequeue()+" ");
        }
    }

    public static void enqueue(int data) {
        stack1.push(data);
    }

    
    
    public static int dequeue() {
        if (stack1.isEmpty() && stack2.isEmpty()){
            return -1;
        }
            if (stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
    }

}



import java.util.*;

public class vit {

    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        for (int temp : list) {
            enqueue(temp);
        }
        for (int index = 0; index < list.size(); index++) {
            System.out.print(dequeue() + " ");
        }
    }

    public static void enqueue(int data) {
        stack1.push(data);
    }

    public static int dequeue() {
        if (stack1.isEmpty()){
            return -1;
        }
        int top = stack1.pop();
        if (stack1.isEmpty()){
            return top;
        }
        int temp = dequeue(); // recursion call
        stack1.add(top);
        return temp;
    }

}
