// Recursive
public class vit {

    public static void main(String[] args) {
        Nodes x = new Nodes(15);
        x.left = new Nodes(10);
        x.right = new Nodes(20);
        x.left.left = new Nodes(8);
        x.left.right = new Nodes(12);
        x.right.left = new Nodes(16);
        x.right.right = new Nodes(25);

        // construct second tree
        Nodes y = new Nodes(15);
        y.left = new Nodes(10);
        y.right = new Nodes(20);
        y.left.left = new Nodes(8);
        y.left.right = new Nodes(12);
        y.right.left = new Nodes(16);
        y.right.right = new Nodes(25);

        boolean result = isIdentical(x, y);
        if (result) {
            System.out.println("Tree is Identical");
        } else {
            System.out.println("Tree is not Identical");
        }
    }

    public static boolean isIdentical(Nodes root1, Nodes root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        return (root1 != null && root2 != null)
                && (root1.data == root2.data)
                && isIdentical(root1.left, root2.left)
                && isIdentical(root1.right, root2.right);
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




// Iterative using 2 Queues
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

        // construct second tree
        Nodes y = new Nodes(15);
        y.left = new Nodes(10);
        y.right = new Nodes(20);
        y.left.left = new Nodes(8);
        y.left.right = new Nodes(12);
        y.right.left = new Nodes(16);
        y.right.right = new Nodes(25);

        boolean result = isIdentical(x, y);
        if (result) {
            System.out.println("Tree is Identical");
        } else {
            System.out.println("Tree is not Identical");
        }
    }

    public static boolean isIdentical(Nodes root1, Nodes root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        Queue<Nodes> queue1 = new LinkedList<>();
        Queue<Nodes> queue2 = new LinkedList<>();

        queue1.add(root1);
        queue2.add(root2);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            Nodes current1 = queue1.poll();
            Nodes current2 = queue2.poll();

            if (current1.data != current2.data) {
                return false;
            }
            if (current1.left != null && current2.left != null) {
                queue1.add(current1.left);
                queue2.add(current2.left);
            }
            if (current1.right != null && current2.right != null) {
                queue1.add(current1.right);
                queue2.add(current2.right);
            }
        }
        return true;
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
