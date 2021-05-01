/*
1. crate vector as it is dynamic array and pass to function storeBSTKeysInorder
store all BST keys in it by traverse in inorder fashion
2. pass vector, start = 0 and end = vector.size() - 1 to balancingBST function
	-> In balancingBST function:
		-> 1) Get the Middle of the array and make it root.
		   2) Recursively do same for left half and right half.
				a) build left tree: 
					root.left = passing vector, start and middle - 1
				b) build right tree: 
					root.right = passing vector, middle + 1 and end
*/
import java.util.*;

public class vit {

    static int index = 0;

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

        root = new Nodes(10);
        root.left = new Nodes(8);
        root.left.left = new Nodes(7);
        root.left.left.left = new Nodes(6);
        root.left.left.left.left = new Nodes(5);

        Nodes result = balancedBST(root);
        
        preorder(result);
    }
    
    public static Nodes balancedBST(Nodes root){
        if (root == null){
            return null;
        }
        
        Vector<Nodes> BSTKeys = new Vector<>();
        
        storeBSTKeysInorder(root, BSTKeys);
        
        int start = 0, end = BSTKeys.size() - 1;
        Nodes result = balancingBST(BSTKeys, start, end);
        
        return result;
    }
    
	// storing BST in keys in vector
    public static void storeBSTKeysInorder(Nodes root, Vector<Nodes> BSTKeys){
        if (root == null){
            return;
        }
        
        storeBSTKeysInorder(root.left, BSTKeys);
        
        BSTKeys.add(root);
        
        storeBSTKeysInorder(root.right, BSTKeys);
    }
    
	// balancing BST
    public static Nodes balancingBST(Vector<Nodes> BSTKeys, int start, int end){
        if (start > end){
            return null;
        }
        
        int middle = (start + end) / 2;
        
        Nodes root = BSTKeys.get(middle);
        
        root.left = balancingBST(BSTKeys, start, middle - 1);
        root.right = balancingBST(BSTKeys, middle + 1, end);
        
        return root;
    }

    public static void preorder(Nodes root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");

        preorder(root.left);

        preorder(root.right);
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
