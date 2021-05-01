import java.util.*;

public class vit {

    public static void main(String[] args) {
        Nodes root = new Nodes(15);
        root.left = new Nodes(10);
        root.right = new Nodes(20);
        root.left.left = new Nodes(8);
        root.left.right = new Nodes(12);
        root.right.left = new Nodes(16);
        root.right.right = new Nodes(25);

        reverseLevelOrderTraversal(root);
    }

    public static void reverseLevelOrderTraversal(Nodes root) {
        Queue<Nodes> queue = new LinkedList<>();
        Stack<Nodes> stack = new Stack<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            Nodes current = queue.poll();
            stack.push(current);

            if (current.right != null) {
                queue.add(current.right);
            }
            if (current.left != null) {
                queue.add(current.left);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().data + " ");
        }
    }
}

class Nodes {

    int data;
    Nodes left, right;

    public Nodes(int data) {
        this.data = data;
        left = right = null;
    }
}
