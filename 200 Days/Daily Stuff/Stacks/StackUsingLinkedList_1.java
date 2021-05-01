public class StackUsingLinkedList_1 {

    static Nodes top = null;

    public static void main(String args[]) {
        push(1);
        push(2);
        push(3);
        push(4);
        push(5);
        pop();
        peek();
        printElements();
    }

    public static void push(int data) {
        Nodes newNode = new Nodes(data);

        if (top == null) {
            newNode.data = data;
            top = newNode;
            return;
        } else {
            newNode.data = data;
            newNode.next = top;
            top = newNode;
            return;
        }
    }

    public static void pop() {
        if (top == null) {
            System.out.println("Stack is Empty");
        } else {
            int temp = top.data;
            top = top.next;
            System.out.println("Popped data : " + temp);
        }
    }

    public static void peek() {
        if (top == null) {
            System.out.println("Stack is Empty");
        } else {
            System.out.println("Top Element : " + top.data);
        }
    }

    public static void printElements() {
        if (top == null) {
            System.out.println("Stack is Empty");
        } else {
            Nodes temp = top;
            System.out.print("Stack elements : ");
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }
    }

}

class Nodes {

    int data;
    Nodes next;

    public Nodes(int data) {
        this.data = data;
        next = null;
    }

}
