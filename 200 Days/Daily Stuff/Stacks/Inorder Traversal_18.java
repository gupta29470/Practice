import java.util.*;

public class vit {

    static Nodes root;
    
    public vit(int data){
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
        inOrder_Recursive(root);
        System.out.println("");
        inOrder_Iteration(root);
    }
    public static void inOrder_Recursive(Nodes root){
        Nodes current = root;
        if (current == null){
            return;
        }
        inOrder_Recursive(current.left);
        System.out.print(current.data+" ");
        inOrder_Recursive(current.right);
    }
    public static void inOrder_Iteration(Nodes root){
        Nodes current = root;
        Stack<Nodes> stack = new Stack<>();
        while (!stack.isEmpty() || current != null){
            if (current != null){
                stack.push(current);
                current = current.left;
            }
            else{
                current = stack.pop();
                System.out.print(current.data+" ");
                current = current.right;
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
