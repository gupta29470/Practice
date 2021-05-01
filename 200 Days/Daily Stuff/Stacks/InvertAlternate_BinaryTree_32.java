import java.util.*;

public class vit {

    public static void main(String[] args) {
        /* Construct below tree
	                1
	              /   \
	            /       \
	          2           3
	        /   \       /   \
	       4     5     6     7
	      / \   / \   / \   / \
	     8   9 10 11 12 13 14 15
         */

        Nodes root = new Nodes(1);
        root.left = new Nodes(2);
        root.right = new Nodes(3);
        root.left.left = new Nodes(4);
        root.left.right = new Nodes(5);
        root.right.left = new Nodes(6);
        root.right.right = new Nodes(7);
        root.left.left.left = new Nodes(8);
        root.left.left.right = new Nodes(9);
        root.left.right.left = new Nodes(10);
        root.left.right.right = new Nodes(11);
        root.right.left.left = new Nodes(12);
        root.right.left.right = new Nodes(13);
        root.right.right.left = new Nodes(14);
        root.right.right.right = new Nodes(15);

        invertAlternate_BinaryTree(root);
        print_LevelOrder(root);

    }

    public static void invertAlternate_BinaryTree(Nodes root) {
        if (root == null) {
            return;
        }
        invertAlternate_BinaryTree(root.left, root.right, 0);
    }

    public static void invertAlternate_BinaryTree(Nodes root1, Nodes root2, int level) {
        if (root1 == null || root2 == null) {
            return;
        }

        // Swapping odd level and divide by 2 beacuse we ignore root
        if (level % 2 == 0) {
            swapNodes(root1, root2);
        }

        invertAlternate_BinaryTree(root1.left, root2.right, level + 1);
        invertAlternate_BinaryTree(root1.right, root2.left, level + 1);
    }

    public static void swapNodes(Nodes root1, Nodes root2) {
        int temp = root1.data;
        root1.data = root2.data;
        root2.data = temp;
    }

    public static void print_LevelOrder(Nodes root) {
        if (root == null) {
            return;
        }

        Queue<Nodes> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Nodes currentNode = queue.poll();

            System.out.print(currentNode.data + " ");

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.add(currentNode.right);
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
