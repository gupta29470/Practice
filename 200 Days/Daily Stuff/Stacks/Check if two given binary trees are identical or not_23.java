// recursive
public class vit {

    public static void main(String[] args) {
        // construct first tree
        Nodes root1 = new Nodes(15);
        root1.left = new Nodes(10);
        root1.right = new Nodes(20);
        root1.left.left = new Nodes(8);
        root1.left.right = new Nodes(12);
        root1.right.left = new Nodes(16);
        root1.right.right = new Nodes(25);

        // construct second tree
        Nodes root2 = new Nodes(15);
        root2.left = new Nodes(10);
        root2.right = new Nodes(20);
        root2.left.left = new Nodes(8);
        root2.left.right = new Nodes(12);
        root2.right.left = new Nodes(16);
        root2.right.right = new Nodes(25);

        if (isIdentical(root1, root2)) {
            System.out.println("Given binary Trees are identical");
        } else {
            System.out.println("Given binary Trees are not identical");
        }
    }

    public static boolean isIdentical(Nodes root1, Nodes root2) {

        if (root1 == null && root2 == null) {
            return true;
        }
        return (root1 != null && root2 != null) && (root1.data == root2.data)
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




// Iterative --> level order traversal
import java.util.*;

public class vit {

    public static void main(String[] args) {
        // construct first tree
        Nodes root1 = new Nodes(15);
        root1.left = new Nodes(10);
        root1.right = new Nodes(20);
        root1.left.left = new Nodes(8);
        root1.left.right = new Nodes(12);
        root1.right.left = new Nodes(16);
        root1.right.right = new Nodes(25);

        // construct second tree
        Nodes root2 = new Nodes(15);
        root2.left = new Nodes(10);
        root2.right = new Nodes(20);
        root2.left.left = new Nodes(8);
        root2.left.right = new Nodes(12);
        root2.right.left = new Nodes(16);
        root2.right.right = new Nodes(25);

        if (isIdentical(root1, root2)) {
            System.out.println("Given binary Trees are identical");
        } else {
            System.out.println("Given binary Trees are not identical");
        }
    }

    public static boolean isIdentical(Nodes root1, Nodes root2) {

        Queue<Nodes> queue1 = new LinkedList<>();
        Queue<Nodes> queue2 = new LinkedList<>();

        queue1.add(root1);
        queue2.add(root2);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            Nodes temp1 = queue1.peek();
            Nodes temp2 = queue2.peek();
            if (temp1.data != temp2.data) {
                return false;
            }
            queue1.poll();
            queue2.poll();

            if (temp1.left != null && temp2.left != null) {
                queue1.add(temp1.left);
                queue2.add(temp2.left);
            } else if (temp1.left != null || temp2.left != null) {
                return false;
            }

            if (temp1.right != null && temp2.right != null) {
                queue1.add(temp1.right);
                queue2.add(temp2.right);
            } else if (temp1.right != null || temp2.right != null) {
                return false;
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
