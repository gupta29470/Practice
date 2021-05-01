/*
1. Given inorder and postorder array
2. root will be last element in postorder array
3. so if we find that root element in inorder array. Once if we find that root 
element in inorder array, then all the elements before that root element are left 
tree of root element and all the elements after root element are right tree of root
element.

Approach
1. Create a map and put inorder array elements where key as inorder array elements
and value as index, which starts with 0
2. create start variable, end variable, Atomic Integer or create static integer = 
postorder.length - 1(we start from end because last element of postorder is root and
before root we have right tree and before right tree we have left tree).
3. pass to another function(start, end, index, preorder, map)
4. Another function:
	-> if start > end return
	-> Every element we encounter we create new Nodes
	-> initialize end index for that node(int ind = map.get(root.data)
	-> build right tree(root.right = func(ind + 1, end, index, preorder, map)
	-> build left tree(root.left = func(start, ind - 1, index, preorder, map)
	-> return root;
*/

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
 
// Data structure to store a Binary Tree node
class Node
{
    int key;
    Node left, right;
 
    Node(int key) {
        this.key = key;
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
        System.out.print(root.key + " ");
        inorderTraversal(root.right);
    }
 
    // Recursive function to perform postorder traversal of a binary tree
    public static void postorderTraversal(Node root)
    {
        if (root == null) {
            return;
        }
 
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.key + " ");
    }
 
    // Recursive function to construct a binary tree from
    // inorder and postorder traversals
    public static Node construct(int start, int end,
                   int[] postorder, AtomicInteger pIndex,
                   Map<Integer,Integer> map)
    {
        // base case
        if (start > end) {
            return null;
        }
 
        // Consider the next item from the end of given postorder sequence
        // This value would be the root node of subtree formed by inorder[start, end]
        Node root = new Node(postorder[pIndex.getAndDecrement()]);
 
        // search the index of current node in inorder sequence to determine
        // the boundary of left and right subtree
        int index = map.get(root.key);
 
        // recursively construct the right subtree
        root.right = construct(index + 1, end, postorder, pIndex, map);
 
        // recursively construct the left subtree
        root.left = construct(start, index - 1, postorder, pIndex, map);
 
        // return root node
        return root;
    }
 
    // Construct a binary tree from inorder and postorder traversals
    // This function assumes that the input is valid
    // i.e. given inorder and postorder sequence forms a binary tree
    public static Node construct(int[] inorder, int[] postorder)
    {
        // get size
        int n = inorder.length;
 
        // map is used to efficiently find the index of any element in
        // given inorder sequence
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
 
        // pIndex stores the index of next unprocessed node from the end
        // of postorder sequence
        AtomicInteger pIndex = new AtomicInteger(n - 1);
        return construct(0, n - 1, postorder, pIndex, map);
    }
 
    public static void main(String[] args)
    {
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
        int[] postorder = { 4, 2, 7, 8, 5, 6, 3, 1 };
 
        Node root = construct(inorder, postorder);
 
        // traverse the constructed tree
        System.out.print("Inorder      : "); inorderTraversal(root);
        System.out.print("\nPostorder : "); postorderTraversal(root);
    }
}

// Time --> O(n)   Space --> O(n)