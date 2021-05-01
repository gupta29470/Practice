/*

The idea is very simple. The tree has symmetric structure if left subtree and right 
subtree are mirror images of each other. Two trees are mirror images of each other if
1. both trees are empty or both are non-empty and
2. left subtree is mirror image of right subtree and
3. right subtree is mirror image of left subtree
*/

public class vit {

    //static Nodes root;
    public static void main(String[] args) {

        Nodes root = new Nodes(5);
        root.left = new Nodes(1);
        root.right = new Nodes(1);
        root.left.left = new Nodes(2);
        root.right.right = new Nodes(2);

        boolean result = isSymmetric(root);
        if (result) {
            System.out.println("Tree is symmetric");
        } else {
            System.out.println("Tree is not symmetric");
        }
    }

    public static boolean isSymmetric(Nodes root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(Nodes root1, Nodes root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 != null && root2 != null && root1.data == root2.data) {
            return isMirror(root1.left, root2.right)
                    && isMirror(root1.right, root2.left);
        }
        return false;
    }

    public static void preOrder(Nodes root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

}

class Nodes {

    int data, distance;
    Nodes left, right;

    public Nodes(int data) {
        this.data = data;
        distance = Integer.MAX_VALUE;
        left = right = null;
    }
}


// Time --> O(n)   Space --> O(h)