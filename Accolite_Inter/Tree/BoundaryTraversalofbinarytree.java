import java.util.*;

public class BoundaryTraversalofbinarytree {

    static Nodes root;

    public static void main(String args[]) {
        root = new Nodes(10);
        root.left = new Nodes(20);
        root.right = new Nodes(30);
        root.left.left = new Nodes(40);
        root.left.right = new Nodes(60);
        Boundary(root);

    }

    static void printLeaves(Nodes root) {
        if (root == null) {
            return;
        }
        printLeaves(root.left);
        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        }
        printLeaves(root.right);
    }

    static void LeftBoundary(Nodes root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            System.out.print(root.data + " ");
            LeftBoundary(root.left);
        } else if (root.right != null) {
            System.out.println(root.data);
            LeftBoundary(root.right);
        }

    }

    static void RightBoundary(Nodes root) {
        if(root==null)
            return;
        if(root.right!=null){
            RightBoundary(root.right);
            System.out.println(root.data);
        }
        else if(root.left!=null){
            RightBoundary(root.left);
            System.out.println(root.data);
        }

    }

    static void Boundary(Nodes root) {
        if(root==null)
            return;
        System.out.print(root.data+" ");
        LeftBoundary(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        RightBoundary(root.right);
    }
}

class Nodes {

    int data;
    Nodes left, right;

    Nodes(int item) {
        data = item;
        left = right = null;
    }
}
