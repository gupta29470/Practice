import java.util.*;

public class vit {

    public static void main(String[] args) {
        /* Construct below tree
				  1
				/   \
			   /     \
			  2       3
			 / \     / \
			4   5   6   7
         */

        Nodes root = new Nodes(1);
        root.left = new Nodes(2);
        root.right = new Nodes(3);
        root.left.left = new Nodes(4);
        root.left.right = new Nodes(5);
        root.right.left = new Nodes(6);
        root.right.right = new Nodes(7);

        invertBinaryTree(root);
        preOrder(root);
    }

    public static void preOrder(Nodes root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void swapNodes(Nodes root) {
        if (root == null) {
            return;
        }
        Nodes temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void invertBinaryTree(Nodes root) {
        if (root == null) {
            return;
        }

        swapNodes(root);
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }
}

class Nodes {

    int data;
    Nodes left = null, right = null;

    Nodes(int data) {
        this.data = data;
    }
}

// Time --> O(n)




import java.util.*;

public class vit {

    public static void main(String[] args) {
        /* Construct below tree
				  1
				/   \
			   /     \
			  2       3
			 / \     / \
			4   5   6   7
         */

        Nodes root = new Nodes(1);
        root.left = new Nodes(2);
        root.right = new Nodes(3);
        root.left.left = new Nodes(4);
        root.left.right = new Nodes(5);
        root.right.left = new Nodes(6);
        root.right.right = new Nodes(7);

        invertBinaryTree(root);
        preOrder(root);
    }

    public static void preOrder(Nodes root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void swapNodes(Nodes root) {
        if (root == null) {
            return;
        }
        Nodes temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void invertBinaryTree(Nodes root) {
        if (root == null) {
            return;
        }

        Queue<Nodes> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Nodes current = queue.poll();

            swapNodes(current);

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
}

class Nodes {

    int data;
    Nodes left = null, right = null;

    Nodes(int data) {
        this.data = data;
    }
}

// Time --> O(n)   Space --> O(height)