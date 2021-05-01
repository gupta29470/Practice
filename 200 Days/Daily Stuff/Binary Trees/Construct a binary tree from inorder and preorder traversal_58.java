/*
1. Given inorder and preorder array
2. root will be first element in preorder array
3. so if we find that root element in inorder array. Once if we find that root 
element in inorder array, then all the elements before that root element are left 
tree of root element and all the elements after root element are right tree of root
element.

Approach
1. Create a map and put inorder array elements where key as inorder array elements
and value as index, which starts with 0
2. create start variable, end variable, Atomic Integer or create static integer = 0.
3. pass to another function(start, end, index, preorder, map)
4. Another function:
	-> if start > end return
	-> Every element we encounter we create new Nodes
	-> initialize end index for that node(int ind = map.get(root.data)
	-> build left tree(root.left = func(start, ind - 1, index, preorder, map)
	-> build right tree(root.right = func(ind + 1, end, index, preorder, map)
	-> return root;
*/

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
 
// Data structure to store a Binary Tree node
class Node {
    int key;
    Node left, right;
 
    public Node(int key) {
        this.key = key;
        left = right = null;
    }
}
 
class Main
{
    // Recursive function to perform inorder traversal of a binary tree
    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
 
        inorderTraversal(root.left);
        System.out.print(root.key + " ");
        inorderTraversal(root.right);
    }
 
    // Recursive function to perform postorder traversal of a binary tree
    public static void preorderTraversal(Node root) {
        if (root == null) {
            return;
        }
 
        System.out.print(root.key + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
 
    // Recursive function to construct a binary tree from given
    // inorder and preorder sequence
    public static Node construct(int start, int end,
                                 int[] preorder, AtomicInteger pIndex,
                                 Map<Integer, Integer> map) {
        // base case
        if (start > end) {
            return null;
        }
 
        // The next element in preorder[] will be the root node of subtree
        // formed by inorder[start, end]
        Node root = new Node(preorder[pIndex.getAndIncrement()]);
 
        // get the index of root node in inorder[] to determine the
        // boundary of left and right subtree
        int index = map.get(root.key);
 
        // recursively construct the left subtree
        root.left = construct(start, index - 1, preorder, pIndex, map);
 
        // recursively construct the right subtree
        root.right = construct(index + 1, end, preorder, pIndex, map);
 
        // return current node
        return root;
    }
 
    // Construct a binary tree from inorder and preorder traversals
    // This function assumes that the input is valid
    // i.e. given inorder and preorder sequence forms a binary tree
    public static Node construct(int[] inorder, int[] preorder)
    {
        // create a map to efficiently find the index of any element in
        // given inorder sequence
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
 
        // pIndex stores index of next unprocessed node in preorder sequence
        // start with root node (present at 0'th index)
        AtomicInteger pIndex = new AtomicInteger(0);
 
        return construct(0, inorder.length - 1, preorder, pIndex, map);
    }
 
    public static void main(String[] args) {
        /* Consider below tree
                  1
                /   \
               /     \
              2       3
             /       / \
            /       /   \
           4       5     6
                  / \
                 /   \
                7     8
        */
 
        int[] inorder = { 4, 2, 1, 7, 5, 8, 3, 6 };
        int[] preorder = { 1, 2, 4, 3, 5, 7, 8, 6 };
 
        Node root = construct(inorder, preorder);
 
        // traverse the constructed tree
        System.out.print("Inorder  : ");
        inorderTraversal(root);
 
        System.out.print("\nPreorder : ");
        preorderTraversal(root);
    }
}

// Time -> O(n)   Space -> O(n)



public class vit {

    static int index = 0;

    public static void main(String[] args) {

        /* Construct below BST
                  5
                /    \
               /      \
              3        8
             /  \     /  \
            /    \   /    \
           4      2  6    10
         */
        Nodes root = new Nodes(5);
        root.left = new Nodes(3);
        root.right = new Nodes(8);
        root.left.left = new Nodes(4);
        root.left.right = new Nodes(2);
        root.right.left = new Nodes(6);
        root.right.right = new Nodes(10);

        int[] inorder = {10, 1, 30, 40, 20};
        int[] preorder = {1, 10, 20, 30, 40,};

        root = construct(preorder, inorder);
        inorder(root);
    }

    public static Nodes construct(int[] preorder, int[] inorder) {

        Map<Integer, Integer> map = new HashMap<>();
        
        for (int index = 0; index < inorder.length; index++){
            map.put(inorder[index], index);
        }

        int start = 0, end = inorder.length - 1;

        return construct(start, end, preorder, map);
    }

    public static Nodes construct(int start, int end, int[] preorder,
            Map<Integer, Integer> map) {
        if (start > end || index > preorder.length - 1) {
            return null;
        }

        Nodes root = new Nodes(preorder[index++]);

        int ind = map.get(root.data);

        root.left = construct(start, ind - 1, preorder, map);

        root.right = construct(ind + 1, end, preorder, map);

        return root;
    }

    public static void inorder(Nodes node) {
        if (node != null) {
            inorder(node.left);
            inorder(node.right);
            System.out.print(node.data + " ");

        }
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