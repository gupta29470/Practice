import java.util.*;

public class vit {

    static Nodes root;

    public static void main(String[] args) {
        root = new Nodes(15);
        root.left = new Nodes(10);
        root.right = new Nodes(20);
        root.left.left = new Nodes(8);
        root.left.right = new Nodes(12);
        root.right.left = new Nodes(16);
        root.right.right = new Nodes(25);

//        // construct second tree
//        Nodes y = new Nodes(15);
//        y.left = new Nodes(10);
//        y.right = new Nodes(20);
//        y.left.left = new Nodes(8);
//        y.left.right = new Nodes(12);
//        y.right.left = new Nodes(16);
//        y.right.right = new Nodes(25);
        SpiralorderTraversal(root);

    }

    public static void SpiralorderTraversal(Nodes root) {
        if (root == null) {
            return;
        }

        Stack<Nodes> stack1 = new Stack<>();
        Stack<Nodes> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {

            while (!stack1.isEmpty()) {
                Nodes current = stack1.pop();

                System.out.print(current.data + " ");
                if (current.right != null) {
                    stack2.push(current.right);
                }
                if (current.left != null) {
                    stack2.push(current.left);
                }
            }

            while (!stack2.isEmpty()) {
                Nodes current = stack2.pop();

                System.out.print(current.data + " ");
                if (current.left != null) {
                    stack1.push(current.left);
                }
                if (current.right != null) {
                    stack1.push(current.right);
                }
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
