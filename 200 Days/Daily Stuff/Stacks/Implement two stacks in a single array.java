import java.util.*;

public class vit {

    private static int n;
    private static int array[];
    static int top1, top2;

    public static void main(String[] args) {

        List<Integer> list_1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list_2 = Arrays.asList(6, 7, 8, 9, 10);
        n = list_1.size() + list_2.size();
        array = new int[n];
        top1 = -1;
        top2 = n;
        for (int data : list_1) {
            push1(data);
        }

        for (int data : list_2) {
            push2(data);
        }
        System.out.println("Popped from stack 1 : " + pop1());
        System.out.println("Popped from stack 2 : " + pop2());

    }

    public static void push1(int data) {
        if (top1 + 1 == top2) {
            System.out.println("Stack Overflow");
            return;
        }
        top1++;
        array[top1] = data;
    }

    public static void push2(int data) {
        if (top1 + 1 == top2) {
            System.out.println("Stack Overflow");
            return;
        }
        top2--;
        array[top2] = data;
    }

    public static int pop1() {
        if (top1 < 0) {
            return -1;
        }
        int top = array[top1];
        top1--;
        return top;
    }

    public static int pop2() {
        if (top2 >= n) {
            return -1;
        }
        int top = array[top2];
        top2++;
        return top;
    }
}
