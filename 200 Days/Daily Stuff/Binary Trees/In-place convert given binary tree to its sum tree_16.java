public class vit {

    static Nodes root;

    public static void main(String[] args) {
        root = new Nodes(15);
        root.left = new Nodes(10);
        root.right = new Nodes(20);
        root.left.left = new Nodes(8);
        root.left.right = new Nodes(12);
        root.right.left = new Nodes(16);
        root.right.right = new Nodes(25);

//        // construct second tree
//        Nodes y = new Nodes(15);
//        y.left = new Nodes(10);
//        y.right = new Nodes(20);
//        y.left.left = new Nodes(8);
//        y.left.right = new Nodes(12);
//        y.right.left = new Nodes(16);
//        y.right.right = new Nodes(25);
        Nodes roots = new Nodes(1);
        roots.left = new Nodes(2);
        roots.right = new Nodes(3);
        roots.left.right = new Nodes(4);
        roots.right.left = new Nodes(5);
        roots.right.right = new Nodes(6);
        roots.right.left.left = new Nodes(7);
        roots.right.left.right = new Nodes(8);

        sum(roots);
        preOrder(roots);

    }

    public static int sum(Nodes root) {

        if (root == null) {
            return 0;
        }

        int left = sum(root.left);
        int right = sum(root.right);

        int old = root.data;

        root.data = left + right;

        return root.data + old;
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






// Data structure to store a Binary Tree node
class Node
{
	int data;
	Node left = null, right = null;

	Node(int data) {
		this.data = data;
	}
}

class Main
{
	// Function to print pre-order traversal of given tree
	public static void preorder(Node root)
	{
		if (root == null) {
			return;
		}

		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}

	// Recursive function to in-place convert the given binary tree to its
	// sum tree by traversing the tree in post-order manner
	public static int convertToSumTree(Node root)
	{
		// base case: tree is empty
		if (root == null) {
			return 0;
		}

		// recursively convert left and right subtree first before
		// processing the root node
		int left = convertToSumTree(root.left);
		int right = convertToSumTree(root.right);

		// stores current value of root node
		int old = root.data;

		// update root to sum of left and right subtree
		root.data = left + right;

		// return the updated value plus old value (sum of tree rooted at root node)
		return root.data + old;
	}

	public static void main(String[] args)
	{
		Node root = null;
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.left.right = new Node(8);

		convertToSumTree(root);
		preorder(root);
	}
}