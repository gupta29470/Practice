/*
Inorder traversal of BST outputs sorted data
1. Create a tree set to store binary tree keys in set in sorted order
2. pass to an inorder function storeInToSetInorder to store keys in set
3. create an iterator for set
4. pass to an inorder function convertingInorder to replace binary tree keys with
set keys.
5. return root
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

        root = new Nodes(8);
        root.left = new Nodes(3);
        root.right = new Nodes(5);
        root.left.left = new Nodes(10);
        root.left.right = new Nodes(2);
        root.right.left = new Nodes(4);
        root.right.right = new Nodes(6);

        Nodes result = convertToBST(root);
        preorder(result);
    }
    
    public static Nodes convertToBST(Nodes root){
        if (root == null){
            return null;
        }
        
        Set<Integer> set = new TreeSet<>();
        
        storeInToSetInorder(root, set);
        
        Iterator<Integer> iterator = set.iterator();
        
        converting(root, iterator);
        
        return root;
    }
    
	//Iterative Inorder
	// Function to traverse the binary tree and store its data in a set
    public static void storeInToSetInorder(Nodes root, Set<Integer> set){
        if (root == null){
            return;
        }
        
        Stack<Nodes> stack = new Stack<>();
        Nodes current = root;
        
        while (!stack.isEmpty() || current != null){
            if (current != null){
                stack.add(current);
                current = current.left;
            }
            else{
                current = stack.pop();
                set.add(current.data);
                current = current.right;
            }
        }
    }
    
	// Recursive Inorder
	// Function to put back keys in set in their correct order in BST
    // by doing in-order traversal
    public static void convertingInorder(Nodes root, Iterator<Integer> iterator){
        if (root == null){
            return;
        }
        
        convertingInorder(root.left, iterator);
        
        root.data = iterator.hasNext()? iterator.next() : -1;
        
        convertingInorder(root.right, iterator);
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
