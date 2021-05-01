public class vit {

    static int queue[];
    static int front = 0, rear = -1, capacity = 5, count = 0;

    public static void main(String[] args) {
        queue = new int[capacity];

        vit.enQueue(8);
        vit.enQueue(5);
        vit.enQueue(2);
        vit.enQueue(2);
        vit.enQueue(9);
        vit.deQueue();
        vit.enQueue(6);
        vit.peek();
    }

    public static void enQueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full");
            System.exit(1);
        }
        rear = (rear + 1) % capacity;
        queue[rear] = data;
        count++;
    }

    public static void deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            System.exit(1);
        }

        front = (front + 1) % capacity;
        count--;
    }

    public static boolean isFull() {
        return size() == capacity;
    }

    public static int size() {
        return count;
    }

    public static boolean isEmpty() {
        return size() == 0;
    }

    public static void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            System.exit(1);
        }
        System.out.println(queue[front]);
    }

}
