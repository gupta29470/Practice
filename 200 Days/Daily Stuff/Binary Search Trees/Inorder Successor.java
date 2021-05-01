/*
**************************** BRUTE FORCE APPROACH ******************
Inorder Traversal of BST gives sorted data
1. create global list to store inorder traversal
2. perform inorder traversal 
3. traverse list and if list.get(index) == key then return immediate next element
*/

import java.util.*;
import java.util.Map.Entry;

public class vit {
	
	// list to store inorder traversal of BST
    static ArrayList<Integer> inorderList = new ArrayList<>();

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

        int key = 70;
        
        succ(root, key);
        
        for (int index = 0; index < inorderList.size(); index++){
			// if we find match just return immediate next element
            if (inorderList.get(index) == key){
                System.out.println(inorderList.get(index + 1));
            }
        }
    }

	// function to store inorder in list
    public static void succ(Nodes root, int key) {
        if (root == null) {
            return;
        }

        succ(root.left, key);

        inorderList.add(root.data);

        succ(root.right, key);
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



/*
***************************** EFFECIENT *******************************
We have to deal with 2 cases:
Case 1: 
	->find key node means if key is given in "int" then find that node in "Nodes" type 
else do nothing.
	->if given node has right sub tree then go to right child and return left most 
	element of right child
Case 2:
	->if given node does not have right sub tree then search that given node from 
	root and the "node" where we take "last left" is the answer
*/

public class vit {

    static Nodes pred = null, succ = null;

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

        Nodes succs = succ(root, 50);

        System.out.println(succs.data);

    }

    public static Nodes succ(Nodes root, int key) {
        if (root == null) {
            return null;
        }

        Nodes keyNode = findKeyNode(root, key);

        if (keyNode.right != null) {
            Nodes succ = case1(keyNode.right);
            return succ;
        } else {
            Nodes succ = case2(root, key);
            return succ;
        }
    }

    public static Nodes findKeyNode(Nodes root, int key) {
        if (root == null) {
            return null;
        }

        if (root.data == key) {
            return root;
        }

        if (key < root.data) {
            return findKeyNode(root.left, key);
        } else {
            return findKeyNode(root.right, key);
        }
    }

    public static Nodes case1(Nodes keyNode) {
        Nodes temp = keyNode;

        while (temp.left != null) {
            temp = temp.left;
        }

        return temp;
    }

    public static Nodes case2(Nodes root, int key) {
        Nodes leftTurn = null;

        while (root.data != key) {
            if (key < root.data) {
                leftTurn = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return leftTurn;
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
