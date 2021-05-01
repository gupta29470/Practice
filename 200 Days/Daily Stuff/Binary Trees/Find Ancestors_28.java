/*
Recommended
if target node found we return 1.
if target node found in left or right subtree we return each ancestors until root.
*/

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class vit {

    public static void main(String[] args) {
        /* Construct below tree
		          6
		        /   \
		       /     \
		      23      8
		     /       /   \
		    /       /     \
		   5       4       2
		        /   \      \
		       /     \      \
		      1       7      3
         */

        Nodes root = new Nodes(6);
        root.left = new Nodes(23);
        root.left.left = new Nodes(5);
        root.right = new Nodes(8);
        root.right.left = new Nodes(4);
        root.right.right = new Nodes(2);
        root.right.left.left = new Nodes(1);
        root.right.left.right = new Nodes(7);
        root.right.right.right = new Nodes(3);
        
        ancestors(root, 5);

    }
    
    public static int ancestors(Nodes root, int target){
        if (root == null){
            return 0;
        }
        
        if(root.data == target){
            return 1;
        }
        
        if (ancestors(root.left, target) == 1 || 
                ancestors(root.left, target) == 1){
            System.out.print(root.data+" ");
            return 1;
        }
        return 0;
    }

}

//6 23 8 4 1 7 2 3
class Nodes {

    int data, distance;
    Nodes left, right;

    public Nodes(int data) {
        this.data = data;
        distance = Integer.MAX_VALUE;
        left = right = null;
    }
}
// Time --> O(n)    Space --> O(h)




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
	// Recursive function to print all ancestors of given node in a binary tree. The
	// function returns true if node is found in subtree rooted at given root node
	public static boolean printAncestors(Node root, int node)
	{
		// base case
		if (root == null) {
			return false;
		}

		// return true if given node is found
		if (root.data == node) {
			return true;
		}

		// search node in left subtree
		boolean left = printAncestors(root.left, node);

		// search node in right subtree
		boolean right = false;
		if (!left) {
			right = printAncestors(root.right, node);
		}

		// if given node is found in either left or right subtree,
		// current node is an ancestor of given node
		if (left || right) {
			System.out.print(root.data + " ");
		}

		// return true if node is found
		return left || right;
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

// Time --> O(n)    Space --> O(h)



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
		// create an empty stack and push root node to it
	public static void setParent(Node root, Map<Integer, Integer> parent)
	{
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

// Time --> O(n)    Space --> O(n)