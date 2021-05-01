import java.util.*;

public class vit {
// Using two stacks
    static Queue<Integer> queue1 = new ArrayDeque<>();
    static Queue<Integer> queue2 = new ArrayDeque<>();

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        push(4);
        push(5);
        push(6);
        print();
        System.out.println("Popped element is : "+pop());
        print();
    }

    public static void push(int data) {
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll()); // Empty q1 and add to q2
        }
        queue1.add(data); // add data to q1

        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll()); // Empty q2 and add to q1
        }
    }

    public static int pop() {
        if (queue1.isEmpty()) {
            return -1;
        }
        int top = queue1.poll();
        return top;
    }

    public static void print() {
        Iterator itr = queue1.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println("");
    }
}



import java.util.*;
// Using two stacks --> slightly better than above solution becuase of less loop
public class vit {

    static Queue<Integer> queue1 = new ArrayDeque<>();
    static Queue<Integer> queue2 = new ArrayDeque<>();

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        for (int temp : list){
            push(temp);
        }
        int index = 0;
        while (index < list.size()){
            System.out.print(pop()+" ");
            index ++;
        }
    }

    public static void push(int data) {
        queue1.add(data);
    }

    public static int pop() {
        if (queue1.isEmpty()) {
            return -1;
        }

       int front = 0;
       while (!queue1.isEmpty()){
           if (queue1.size() == 1){
               front = queue1.poll();
           }
           else{
               queue2.add(queue1.poll());
           }
       }
       while (!queue2.isEmpty()){
           queue1.add(queue2.poll());
       }
       return front;
    }

    public static void print() {
        Iterator itr = queue1.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println("");
    }
}



import java.util.*;
// Using one queue and recursive call stack
public class vit {

    static Queue<Integer> queue1 = new ArrayDeque<>();
    static Queue<Integer> queue2 = new ArrayDeque<>();

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        for (int temp : list) {
            push(temp);
        }
        int index = 0;
        while (index <= list.size()) {
            System.out.print(pop() + " ");
            index++;
        }
    }

    public static void push(int data) {
        queue1.add(data);
    }

    public static void reverseQueue() {
        if (queue1.isEmpty()){
            return;
        }
        int front = queue1.poll();
        reverseQueue();
        queue1.add(front);
    }

    public static int pop() {
        if (queue1.isEmpty()){
            return -1;
        }
        reverseQueue();
        int front = queue1.poll();
        reverseQueue();
        return front;
    }

}

/*
All have
Time -> O(n) and space -> O(n)
