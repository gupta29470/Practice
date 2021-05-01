// Leetcode
class Solution {
    public boolean validate(TreeNode root, Integer low, Integer high) {
        // Empty trees are valid BSTs.
        if (root == null) {
            return true;
        }
        // The current node's value must be between low and high.
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }
        // The left and right subtree must also be valid.
        return validate(root.right, root.val, high) && validate(root.left, low, root.val);
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
}
/*--------------------------------------------------------------------------------*/

// GFG

boolean isBST()  { 
        return isBSTUtil(root, Integer.MIN_VALUE, 
                               Integer.MAX_VALUE); 
    } 
  
    /* Returns true if the given tree is a BST and its 
      values are >= min and <= max. */
    boolean isBSTUtil(Node node, int min, int max) 
    { 
        /* an empty tree is BST */
        if (node == null) 
            return true; 
  
        /* false if this node violates the min/max constraints */
        if (node.data < min || node.data > max) 
            return false; 
  
        /* otherwise check the subtrees recursively 
        tightening the min/max constraints */
        // Allow only distinct values 
        return (isBSTUtil(node.left, min, node.data-1) && 
                isBSTUtil(node.right, node.data+1, max)); 
    } 
	
// O(n) in Time and Space

/*--------------------------------------------------------------------------------*/

/*
1. if the node is the left child of its parent, then it must be smaller than 
(or equal to) the parent and it must pass down the value from its parent to its 
right subtree to make sure none of the nodes in that subtree is greater than the 
parent.

2. if the node is the right child of its parent, then it must be larger than the 
parent and it must pass down the value from its parent to its left subtree to 
make sure none of the nodes in that subtree is lesser than the parent.
*/

// Data structure to store a Binary Search Tree node
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
    // Recursive function to insert a key into BST
    public static Node insert(Node root, int key)
    {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new Node(key);
        }
 
        // if given key is less than the root node, recur for left subtree
        if (key < root.data) {
            root.left = insert(root.left, key);
        }
        // if given key is more than the root node, recur for right subtree
        else {
            root.right = insert(root.right, key);
        }
 
        return root;
    }
 
    // Function to determine if given Binary Tree is a BST or not by keeping a
    // valid range (starting from [MIN_VALUE, MAX_VALUE]) and keep shrinking
    // it down for each node as we go down recursively
    public static boolean isBST(Node node, int minKey, int maxKey)
    {
        // base case
        if (node == null) {
            return true;
        }
 
        // if node's value fall outside valid range
        if (node.data < minKey || node.data > maxKey) {
            return false;
        }
 
        // recursively check left and right subtrees with updated range
        return isBST(node.left, minKey, node.data) &&
            isBST(node.right, node.data, maxKey);
    }
 
    // Function to determine if given Binary Tree is a BST or not
    public static void isBST(Node root)
    {
        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            System.out.println("This is a BST.");
        } else {
            System.out.println("This is NOT a BST!");
        }
    }
 
    private static void swap(Node root) {
        Node left = root.left;
        root.left = root.right;
        root.right = left;
    }
 
    public static void main(String[] args)
    {
        Node root = null;
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
 
        for (int key : keys) {
            root = insert(root, key);
        }
 
        // swap left and right nodes
        swap(root);
        isBST(root);
    }
}


/*--------------------------------------------------------------------------------*/


/*
We know that an in-order traversal of a binary search tree returns the nodes in 
sorted order. Thus, to determine if given binary tree is BST or not, 
we can perform in-order traversal and keep track of the last visited node 
while traversing the tree and check whether its key is smaller (or smaller/equal, 
if duplicates are to be allowed in the tree) compared to the current key.
*/

// Data structure to store a Binary Search Tree node
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
	// Recursive function to insert a key into BST
	public static Node insert(Node root, int key)
	{
		// if the root is null, create a new node and return it
		if (root == null) {
			return new Node(key);
		}

		// if given key is less than the root node, recur for left subtree
		if (key < root.data) {
			root.left = insert(root.left, key);
		}

		// if given key is more than the root node, recur for right subtree
		else {
			root.right = insert(root.right, key);
		}

		return root;
	}


	// Function to perform inorder traversal of the given binary tree and
	// check if it is a BST or not. Here prev is previous processed node
	public static boolean isBST(Node root, Node prev)
	{
		// base case: empty tree is a BST
		if (root == null) {
			return true;
		}

		// check if left subtree is BST or not
		boolean left = isBST(root.left, prev);

		// value of current node should be more than that of previous node
		if (root.data <= prev.data) {
			return false;
		}

		// update previous node data and check if right subtree is BST or not
		prev.data = root.data;

		return left && isBST(root.right, prev);
	}

	// Function to determine if given Binary Tree is a BST or not
	public static void isBST(Node node)
	{
		// pointer to store previous processed node in inorder traversal
		Node prev = new Node(Integer.MIN_VALUE);

		// check if nodes are nodes are processed in sorted order
		if (isBST(node, prev)) {
			System.out.println("This is a BST.");
		} else {
			System.out.println("This is NOT a BST!");
		}
	}

	private static void swap(Node root) {
		Node left = root.left;
		root.left = root.right;
		root.right = left;
	}

	public static void main(String[] args)
	{
		Node root = null;
		int[] keys = { 15, 10, 20, 8, 12, 16, 25 };

		for (int key : keys) {
			root = insert(root, key);
		}

		// swap nodes
		swap(root);
		isBST(root);
	}
}

// Time --> O(n)   