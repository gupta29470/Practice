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
        
        print_AllCousins(roots, roots.left.right);
    }

    public static int findLevel(Nodes root, Nodes input, int index, int inputlevel) {
        if (root == null || inputlevel != 0){
            return inputlevel;
        }
        
        if (root == input){
            inputlevel = index;
        }
        
        inputlevel = findLevel(root.left, input, index + 1, inputlevel);
        inputlevel = findLevel(root.right, input, index + 1, inputlevel);
        
        return inputlevel;
    }

    public static void print_AllCousins(Nodes root, Nodes input) {
        if (root == null){
            return;
        }
        int index = 1, inputlevel = 0;
        int level = findLevel(root, input, index, inputlevel);
        
        preOrder(root, input, level);
    }

    public static void preOrder(Nodes root, Nodes input, int level) {
        if (root == null){
            return;
        }
        
        if (level == 1){
            System.out.print(root.data+" ");
            return;
        }
        
        if ((root.left != null && root.left != input) ||
                (root.right != null && root.right != input)){
            preOrder(root.left, input, level - 1);
            preOrder(root.right, input, level - 1);
        }
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

// Time--> O(n)    Space O(h)





// Data structure to store a Binary Tree node
class Node
{
	int key;
	Node left = null, right = null;

	Node(int key) {
		this.key = key;
	}
}

class Main
{
	// Function to find level of given node x
	public static int findLevel(Node root, Node x, int index, int level)
	{
		// return if tree is empty or level is already found
		if (root == null || level != 0) {
			return level;
		}

		// if given node is found, update its level
		if (root == x) {
			level = index;
		}

		// recur for left and right subtree
		level = findLevel(root.left, x, index + 1, level);
		level = findLevel(root.right, x, index + 1, level);

		return level;
	}

	public static void printLevel(Node root, Node node, int level)
	{
		// base case
		if (root == null) {
			return;
		}

		// print cousins
		if (level == 1) {
			System.out.print(root.key + " ");
			return;
		}

		// recur for left and right subtree if given node is not child of the root
		if (!(root.left != null && root.left == node ||
				root.right != null && root.right == node))
		{
			printLevel(root.left, node, level - 1);
			printLevel(root.right, node, level - 1);
		}
	}

	// Function to print all cousins of given node
	public static void printAllCousins(Node root, Node node)
	{
		// find level of given node
		int level = findLevel(root, node, 1, 0);

		// print all cousins of given node using its level number
		printLevel(root, node, level);
	}

	public static void main(String[] args)
	{
		/* Construct below tree
		          1
		       /     \
		      2       3
		     / \     / \
		    4   5   6   7
		*/

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		printAllCousins(root, root.right.left);
	}
}