/*
1. Given inorder and level order array
2. Create map and put level order elements with index value start with 0
3. Initialize start = 0, end = inorder.length - 1
4. Pass to another function(start, end, inord, map)
5. Another Function:
	-> If start > end return null
	-> initialize variable index = start
	-> traverse inorder array and find minimum value. 
	(if map.get(inorder[j] < map.get(inorder[index] then index = j)
	-> use this index variable and find element using index from inorder array
	and that element will be root
	-> all the element before index are in left tree and all the element after index
	are in right tree
	-> root.left = buildTree(start, index - 1, inord, map)
	-> root.right = buildTree(index + 1, end, inord, map)
	-> return root
*/


import java.util.HashMap;
import java.util.Map;
 
// Data structure to store a Binary Tree node
class Node {
    int data;
    Node left, right;
 
    Node(int data) {
        this.data = data;
    }
}
 
class Main
{
    // Recursive function to perform inorder traversal of a binary tree
    public static void inorderTraversal(Node root)
    {
        if (root == null) {
            return;
        }
 
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }
 
    // Recursive function to construct a binary tree from in-order and
    // level-order traversals
    public static Node buildTree(int[] inorder, int start, int end,
                                Map<Integer, Integer> map)
    {
        // base case
        if (start > end) {
            return null;
        }
 
        // find the index of root node in inorder[] to determine the
        // boundary of left and right subtree
        int index = start;
        for (int j = start + 1; j <= end; j++)
        {
            // find node with minimum index in level order traversal
            // That would be the root node of inorder[start, end]
            if (map.get(inorder[j]) < map.get(inorder[index])) {
                index = j;
            }
        }
 
        // construct the root node
        Node root = new Node(inorder[index]);
 
        // recursively construct the left subtree
        root.left = buildTree(inorder, start, index - 1, map);
 
        // recursively construct the right subtree
        root.right = buildTree(inorder, index + 1, end, map);
 
        // return root node
        return root;
    }
 
    // Construct a binary tree from in-order and level-order traversals
    public static Node buildTree(int[] in, int[] level)
    {
        // create a map to efficiently find index of an element in
        // level-order sequence
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(level[i], i);
        }
 
        // Construct the tree and return it
        return buildTree(in, 0, in.length - 1, map);
    }
 
    public static void main(String[] args)
    {
        int[] inorder = { 4, 2, 5, 1, 6, 3, 7 };
        int[] level    = { 1, 2, 3, 4, 5, 6, 7 };
 
        Node root = buildTree(inorder, level);
 
        System.out.print("Inorder traversal of the constructed tree: ");
        inorderTraversal(root);
    }
}

// Time --> O(n^2)  Space --> O(n)