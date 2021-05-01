/*
Given two roots of two BST's
1. mergeBSTs function:
	-> if any one root is null then return
	-> Create two vectors to store BST keys using inorder traversal
	-> create one more vector to merge two BST's vector and store it(as both 
		vectors are sorted so we merge it in sorted order using while loop)
	-> pass merge vector to buildBST function to create a new BST and return root
*/

import java.util.*;

public class vit {

    public static void main(String[] args) {
		
		/* Creating following tree as First balanced BST
                100
                / \
                50 300
                / \
               20 70
        */
 
        Nodes root1 = new Nodes(100);
        root1.left = new Nodes(50);
        root1.right = new Nodes(300);
        root1.left.left = new Nodes(20);
        root1.left.right = new Nodes(70);
		
		/* Creating following tree as second balanced BST
                80
                / \
              40 120
        */

        Nodes root2 = new Nodes(80);
        root2.left = new Nodes(40);
        root2.right = new Nodes(120);

        Nodes result = mergeBSTs(root1, root2);
        inorder(result);
    }

    public static Nodes mergeBSTs(Nodes root1, Nodes root2) {
		
        if (root1 == null || root2 == null) {
            return root1 != null ? root1 : root2;
        }
		
		// for 1st BST 
        Vector<Integer> storeKeys_1 = new Vector<>();
        storeBSTKeys(root1, storeKeys_1);
		
		// for 2nd BST
        Vector<Integer> storeKeys_2 = new Vector<>();
        storeBSTKeys(root2, storeKeys_2);
		
		// merging both vectors
        Vector<Integer> storeKeys = new Vector<>();
        mergeVectors(storeKeys_1, storeKeys_2, storeKeys);

        // building new BST
		int start = 0, end = storeKeys.size() - 1;
        Nodes root = buildBST(storeKeys, start, end);
		
        return root;
		
    }
	
	// store BST keys in vector using inorder traversal
    public static void storeBSTKeys(Nodes root, Vector<Integer> storeKeys) {
        if (root == null) {
            return;
        }
        storeBSTKeys(root.left, storeKeys);
        storeKeys.add(root.data);
        storeBSTKeys(root.right, storeKeys);
    }
	
	// merging both vectors in another vector
    public static void mergeVectors(Vector<Integer> storeKeys_1,
            Vector<Integer> storeKeys_2, Vector<Integer> storeKeys) {
        int index1 = 0, index2 = 0;

        while (index1 < storeKeys_1.size() && index2 < storeKeys_2.size()) {
            if (storeKeys_1.get(index1) < storeKeys_2.get(index2)) {
                storeKeys.add(storeKeys_1.get(index1));
                index1++;
            } else {
                storeKeys.add(storeKeys_2.get(index2));
                index2++;
            }
        }
    }

    // building a new BST
	public static Nodes buildBST(Vector<Integer> storeKeys, int start, int end) {
        if (start > end) {
            return null;
        }

        int middle = (start + end) / 2;

        Nodes root = new Nodes(storeKeys.get(middle));

        root.left = buildBST(storeKeys, start, middle - 1);
        root.right = buildBST(storeKeys, middle + 1, end);

        return root;
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

/*
n = size of 1st tree, m = size of 2nd tree
Time --> O(n + m)    Space --> O(n + m)
*/