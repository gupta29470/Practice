public class vit {

    public static void main(String[] args) {
        Nodes x = new Nodes(15);
        x.left = new Nodes(10);
        x.right = new Nodes(20);
        x.left.left = new Nodes(8);
        x.left.right = new Nodes(12);
        x.right.left = new Nodes(16);
        x.right.right = new Nodes(25);

//        // construct second tree
//        Nodes y = new Nodes(15);
//        y.left = new Nodes(10);
//        y.right = new Nodes(20);
//        y.left.left = new Nodes(8);
//        y.left.right = new Nodes(12);
//        y.right.left = new Nodes(16);
//        y.right.right = new Nodes(25);
        int height = height(x);
        System.out.println("Height of binary tree is : " + height);

    }

    public static int height(Nodes root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
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



// Iterative
import java.util.*;

public class vit {

    public static void main(String[] args) {
        Nodes x = new Nodes(15);
        x.left = new Nodes(10);
        x.right = new Nodes(20);
        x.left.left = new Nodes(8);
        x.left.right = new Nodes(12);
        x.right.left = new Nodes(16);
        x.right.right = new Nodes(25);

//        // construct second tree
//        Nodes y = new Nodes(15);
//        y.left = new Nodes(10);
//        y.right = new Nodes(20);
//        y.left.left = new Nodes(8);
//        y.left.right = new Nodes(12);
//        y.right.left = new Nodes(16);
//        y.right.right = new Nodes(25);
        int height = height(x);
        System.out.println("Height of binary tree is : " + height);

    }

    public static int height(Nodes root) {
        if (root == null) {
            return 0;
        }

        Queue<Nodes> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                Nodes current = queue.poll();

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            height++;
        }
        return height;
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
