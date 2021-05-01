/*
1. Create a Count class with count variable to keep track of count
2. We will traverse in postorder fashion, because we have to check child == parent
	-> if root is a leaf node, increase the count and return root node data
	-> recur for left subtree and right subtree
	-> 1. left subtree is empty & right subtree data matches with root
	   2. right subtree is empty & left subtree data matches with root
	   3. both left & right subtree are non-empty & their data matches with root
3. return -1 if root's data doesn't match with left or right subtree
*/


public class vit {

    static Integer prev;

    public static void main(String[] args) {

        /* Construct below tree
              15
            /    \
           /      \
          10       20
         / \      /  \
        8   12   16  25
                /
               18
         */
        Nodes root = new Nodes(5);
        root.left = new Nodes(4);
        root.right = new Nodes(5);
        root.left.left = new Nodes(4);
        root.left.right = new Nodes(4);
        root.right.right = new Nodes(5);

        System.out.println(sameTree(root));
    }

    public static int sameTree(Nodes root) {
        if (root == null) {
            return 0;
        }

        Count count = new Count();

        return sameTree(root, count);
    }

    public static int sameTree(Nodes root, Count count) {
        if (root == null) {
            return -1;
        }

        // if root is a leaf node, increase the count and return root node data
        if (root.left == null && root.right == null) {
            count.count++;
            return root.data;
        }

        // recur for left subtree and right subtree
        int left = sameTree(root.left, count);
        int right = sameTree(root.right, count);

        // 1. left subtree is empty & right subtree data matches with root
        // 2. right subtree is empty & left subtree data matches with root
        // 3. both left & right subtree are non-empty & their data matches with root
        if ((left == -1 && right == root.data)
                || (right == -1 && left == root.data)
                || left == right && left == root.data) {
            count.count++;
            return root.data;
        }
        
        // return -1 if root's data doesn't match with left or right subtree
        return count.count != 0 ? count.count : -1;
    }
}

class Count {

    int count = 0;
}

class Height {

    int height = 0;
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
