import java.util.*;
public class vit {

    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        int datas[] = {1, 2, 3, 4, 5};

        for (int data : datas) {
            enQueue(data);
        }

        while (!stack1.isEmpty()) {
            System.out.print(deQueue() + " ");
        }
    }

    public static void enQueue(int data) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(data);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public static int deQueue() {
        if (stack1.isEmpty()) {
            System.out.println("Queue is Empty");
            System.exit(1);
        }
        return stack1.pop();
    }

}




import java.util.*;

public class vit {

    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        int datas[] = {1, 2, 3, 4, 5};

        for (int data : datas) {
            enQueue(data);
        }

        while (!stack1.isEmpty()) {
            System.out.print(deQueue() + " ");
        }
    }

    public static void enQueue(int data) {
        stack1.push(data);

    }

    public static int deQueue() {
        if (stack1.isEmpty()) {
            System.out.println("Queue is Empty");
            System.exit(1);
        }
        while (stack1.size() != 1) {
            stack2.push(stack1.pop());
        }
        int temp = stack1.pop();

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return temp;
    }

}
