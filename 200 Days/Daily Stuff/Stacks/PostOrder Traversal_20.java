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
        postOrder_Recursive(root);
        System.out.println("");
        postOrder_Iteration(root);
    }

    public static void postOrder_Recursive(Nodes root) {
        Nodes current = root;
        if (current == null) {
            return;
        }
        postOrder_Recursive(current.left);
        postOrder_Recursive(current.right);
        System.out.print(current.data + " ");
    }

    public static void postOrder_Iteration(Nodes root) {
        if (root == null) {
            return;
        }
        Stack<Nodes> stack = new Stack<>();
        Stack<Integer> result = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Nodes current = stack.pop();
            result.push(current.data);
            
            if (current.left != null){
                stack.push(current.left);
            }
            if (current.right != null){
                stack.push(current.right);
            }
        }
        while (!result.isEmpty()){
            System.out.print(result.pop()+" ");
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
