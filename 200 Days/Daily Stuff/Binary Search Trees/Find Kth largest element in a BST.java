/*
for kth smallest we create a count variable and do inorder and if count == k 
we return current node.
So for kth largest we also create a count variable and do reverse inorder 
traversal if count == k we return current node
*/

import java.util.*;

public class vit {

    static int count = 0;

    public static void main(String[] args) {

        /* Construct below tree
		          50
		        /   \
		       /     \
		      30      70
		     /\       / \
		    /  \     /   \
		   20   40  60    80
		              		                     
         */
        Nodes root = new Nodes(50);
        root.left = new Nodes(30);
        root.right = new Nodes(70);
        root.left.left = new Nodes(20);
        root.left.right = new Nodes(40);
        root.right.left = new Nodes(60);
        root.right.right = new Nodes(80);

        System.out.println(kthLargest(root, 3));
    }

    // Function to find k'th Smallest element in BST
	public static int kthLargest(Nodes root, int k){
        if (root == null){
            return Integer.MIN_VALUE;
        }
        
        Nodes result = kthLargestUtil(root, k);
        
        return result.data;
    }
    
    
	// Function to find k'th Smallest element in BST
    // Here count denotes the number 
    // of nodes processed so far
	// reverse inorder traversal
	public static Nodes kthLargestUtil(Nodes root, int k){
        // base case
		if (root == null){
            return null;
        }
        
        // search in right subtree
		Nodes right = kthLargestUtil(root.right, k);
        
        // if k'th smallest is found in right subtree, return it
		if (right != null){
            return right;
        }
        
        // if current element is k'th largest, return it
		count++;
        if (count == k){
            return root;
        }
        
        // else search in left subtree
		return kthLargestUtil(root.left, k);
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
