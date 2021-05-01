import java.util.*;

public class vit {

    static Queue<Integer> queue1 = new ArrayDeque<>();
    static Queue<Integer> queue2 = new ArrayDeque<>();

    public static void main(String[] args) {
        int datas[] = {1, 2, 3, 4, 5};

        for (int data : datas) {
            push(data);
        }
        for (int index = 0; index < datas.length; index++) {
            System.out.print(pop() + " ");
        }
    }

    public static void push(int data) {
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
        queue1.add(data);

        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
    }

    public static int pop() {
        if (queue1.isEmpty()) {
            System.out.println("Stack is Empty");
            System.exit(1);
        }
        return queue1.poll();
    }
}







import java.util.*;

public class vit {

    static Queue<Integer> queue1 = new ArrayDeque<>();
    static Queue<Integer> queue2 = new ArrayDeque<>();

    public static void main(String[] args) {
        int datas[] = {1, 2, 3, 4, 5};

        for (int data : datas) {
            push(data);
        }
        for (int index = 0; index < datas.length; index++) {
            System.out.print(pop() + " ");
        }
    }

    public static void push(int data) {
        queue1.add(data);
    }

    public static int pop() {
        if (queue1.isEmpty()) {
            System.out.println("Queue is empty");
            System.exit(1);
        }
        while (queue1.size() != 1) {
            queue2.add(queue1.poll());
        }
        int temp = queue1.poll();

        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        return temp;
    }
}
