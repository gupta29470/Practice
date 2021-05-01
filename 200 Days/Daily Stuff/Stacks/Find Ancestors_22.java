public class vit {

    static Nodes root;

    public vit(int data) {
        root = new Nodes(data);
    }

    public static void main(String[] args) {
        root = new Nodes(1);
        root.left = new Nodes(2);
        root.right = new Nodes(3);
        root.left.left = new Nodes(4);
        root.right.left = new Nodes(5);
        root.right.right = new Nodes(6);
        root.right.left.left = new Nodes(7);
        root.right.left.right = new Nodes(8);
        int node = 7;
        findAncestors(root, node);
    }

    public static boolean findAncestors(Nodes root, int node) {

        if (root == null) {
            return false;
        }
        if (root.data == node) {
            return true;
        }

        if (findAncestors(root.left, node)
                || findAncestors(root.right, node)) {
            System.out.print(root.data + " ");
            return true;
        }
        return false;
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




import java.util.*;

public class vit {

    static Nodes root;

    public vit(int data) {
        root = new Nodes(data);
    }

    public static void main(String[] args) {
        root = new Nodes(1);
        root.left = new Nodes(2);
        root.right = new Nodes(3);
        root.left.left = new Nodes(4);
        root.right.left = new Nodes(5);
        root.right.right = new Nodes(6);
        root.right.left.left = new Nodes(7);
        root.right.left.right = new Nodes(8);
        int node = 7;
        System.out.println(printAncestors(root, node));
    }

    public static boolean findAncestors(Nodes root, int node, ArrayList<Integer> result) {

        if (root == null) {
            return false;
        }
        if (root.data == node) {
            return true;
        }

        if (findAncestors(root.left, node, result)
                || findAncestors(root.right, node, result)) {
            result.add(root.data);
            return true;
        }
        return false;
    }

    public static ArrayList<Integer> printAncestors(Nodes root, int node) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        findAncestors(root, node, result);
        return result;
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


// Iterative
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

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
	// Function to print root to leaf paths without using recursion
	public static void printTopToBottomPath(Map<Integer, Integer> parent, int key)
	{
		while ((key = parent.get(key)) != 0) {
			System.out.print(key + " ");
		}
	}

	// iterative function to set parent nodes for all nodes of binary tree
	// in given map. The function is similar to iterative pre-order traversal
	public static void setParent(Node root, Map<Integer, Integer> parent)
	{
		// create an empty stack and push root node to it
		Deque<Node> stack = new ArrayDeque<>();
		stack.add(root);

		// loop till stack is empty
		while (!stack.isEmpty())
		{
			// Pop the top item from stack
			Node curr = stack.pollLast();

			// push its right child to stack and set its parent in the map
			if (curr.right != null) {
				parent.put(curr.right.data, curr.data);
				stack.add(curr.right);
			}

			// push its left child to stack and set its parent in the map
			if (curr.left != null) {
				parent.put(curr.left.data, curr.data);
				stack.add(curr.left);
			}
		}
	}

	// Iterative function to print all ancestors of given node in a binary tree
	public static void printAncestors(Node root, int node)
	{
		// Base Case
		if (root == null)
			return;

		// create an empty map to store parent pointers of binary tree nodes
		Map<Integer, Integer> parent = new HashMap<>();

		// set parent of root node as null
		parent.put(root.data, 0);

		// set parent nodes for all nodes of binary tree
		setParent(root, parent);

		// print ancestors of given node using parent map
		printTopToBottomPath(parent, node);
	}

	public static void main(String[] args)
	{
	    /* Construct below tree
	          1
	        /   \
	       /     \
	      2          3
	       \     / \
	        4   5   6
	           / \
	          7   8
	    */

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.right.right = new Node(8);

		int node = 7;
		printAncestors(root, node);
	}
}
