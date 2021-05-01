import java.util.*;

public class vit {

    static Nodes root;

    public vit(int data) {
        root = new Nodes(data);
    }

    public static void main(String[] args) {
        root = new Nodes(1);
        root.left = new Nodes(2);
        root.right = new Nodes(3);
        root.left.left = new Nodes(4);
        root.right.left = new Nodes(5);
        root.right.right = new Nodes(6);
        root.right.left.left = new Nodes(7);
        root.right.left.right = new Nodes(8);
        preOrder_Recursive(root);
        System.out.println("");
        preOrder_Iteration(root);
    }

    public static void preOrder_Recursive(Nodes root) {
        Nodes current = root;
        if (current == null) {
            return;
        }
        System.out.print(current.data + " ");
        preOrder_Recursive(current.left);
        preOrder_Recursive(current.right);
    }

    public static void preOrder_Iteration(Nodes root) {
        if (root == null) {
            return;
        }
        Stack<Nodes> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Nodes current = stack.pop();
            System.out.print(current.data + " ");

            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
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
