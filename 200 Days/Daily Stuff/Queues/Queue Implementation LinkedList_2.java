public class vit {

    static Nodes front = null, rear = null;

    public static void main(String[] args) {
        vit.enQueue(1);
        vit.enQueue(2);
        vit.enQueue(3);
        vit.enQueue(4);
        vit.peek();
        vit.deQueue();
        vit.peek();
    }

    public static void enQueue(int data) {
        Nodes newNode = new Nodes(data);
        if (front == null && rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public static int deQueue() {
        if (front == null) {
            rear = null;
            System.out.println("Queue is Empty");
            System.exit(1);
        }

        Nodes temp = front;
        front = front.next;
        return temp.data;
    }

    public static void peek() {
        if (front == null) {
            rear = null;
            System.out.println("Queue is empty");
            System.exit(1);
        } else {
            System.out.println(front.data);
        }
    }

    public static boolean isEmpty() {
        return rear == null && front == null;
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
