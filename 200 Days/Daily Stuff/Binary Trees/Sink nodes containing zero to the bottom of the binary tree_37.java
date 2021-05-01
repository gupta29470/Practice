/*	1. Traverse Post-Order Traversal.
		If we found 0(zero) we will heapify
*/

public class vit {

    public static void main(String[] args) {

        /* Construct below tree
				  0
				/   \
			   /	 \
			  1	   0
					/   \
				   /	 \
				  0	   2
				/   \
			   /	 \
			  3	   4
         */
        Nodes root = new Nodes(0);
        root.left = new Nodes(1);
        root.right = new Nodes(0);
        root.right.left = new Nodes(0);
        root.right.right = new Nodes(2);
        root.right.left.left = new Nodes(3);
        root.right.left.right = new Nodes(4);

        sinkZeroNodes(root);
        inorder(root);
    }

    public static void sinkZeroNodes(Nodes root) {
        if (root == null) {
            return;
        }
        sinkZeroNodes(root.left);
        sinkZeroNodes(root.right);

        if (root.data == 0) {
            heapify(root);
        }
    }

    public static void heapify(Nodes root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.left.data != 0) {
            int temp = root.data;
            root.data = root.left.data;
            root.left.data = temp;

            heapify(root.left);
        } else if (root.right != null && root.right.data != 0) {
            int temp = root.data;
            root.data = root.right.data;
            root.right.data = temp;

            heapify(root.right);
        }
    }

    public static void inorder(Nodes root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
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

	// Function to perform in-order traversal of given binary tree
	public static void inorder(Node root)
	{
		if (root == null)
			return;

		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	// Function to sink root node having value 0 to the bottom of the tree
	// The left and right subtree (if any) of root node are already sinked
	public static void sink(Node root)
	{
		// base case: tree is empty
		if (root == null) {
			return;
		}

		// if left subtree exists & left child has non-zero value
		if (root.left != null && root.left.data != 0)
		{
			// swap data of current node with its left child
			int temp = root.data;
			root.data = root.left.data;
			root.left.data = temp;

			// recur for left subtree
			sink(root.left);
		}

		// if right subtree exists & right child has non-zero value
		else if (root.right != null && root.right.data != 0)
		{
			// swap data of current node with its right child
			int temp = root.data;
			root.data = root.right.data;
			root.right.data = temp;

			// recur for right subtree
			sink(root.right);
		}
	}

	// Main function to sink nodes having zero value to the bottom
	// of the binary tree
	public static void sinkNodes(Node root)
	{
		// base case: tree is empty
		if (root == null) {
			return;
		}

		// fix left subtree and right subtree first
		sinkNodes(root.left);
		sinkNodes(root.right);

		// sink current node it has value 0
		if (root.data == 0) {
			sink(root);
		}
	}

	public static void main(String[] args)
	{
		/* Construct below tree
				  0
				/   \
			   /	 \
			  1	   0
					/   \
				   /	 \
				  0	   2
				/   \
			   /	 \
			  3	   4
		*/

		Node root = new Node(0);
		root.left = new Node(1);
		root.right = new Node(0);
		root.right.left = new Node(0);
		root.right.right = new Node(2);
		root.right.left.left = new Node(3);
		root.right.left.right  = new Node(4);

		sinkNodes(root);

		inorder(root);
	}
}


// Time --> O(n^2)  Space --> O(h)