/*
While deletion we face three situation
1. if deletion node is leaf node then we simple mark as null or return null
2. if deletion node is parent of 2 children then we find inorder predecessor of 
deletion node and replace deletion node with inorder predecessor node and delete 
inorder predecessor root(duplication)
3. if deletion node has only one child then we simple update deletion node with
non -empty child.
*/

// Data structure to store a Binary Search Tree node
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
    // Function to perform inorder traversal of the BST
    public static void inorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
 
    // Helper function to find maximum value node in subtree rooted at ptr
    public static Node inorder_predecessor(Node ptr)
    {
        while (ptr.right != null) {
            ptr = ptr.right;
        }
        return ptr;
    }
 
    // Recursive function to insert a key into BST
    public static Node insert(Node root, int key)
    {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new Node(key);
        }
 
        // if given key is less than the root node, recur for left subtree
        if (key < root.data) {
            root.left = insert(root.left, key);
        }
 
        // if given key is more than the root node, recur for right subtree
        else {
            root.right = insert(root.right, key);
        }
 
        return root;
    }
 
    // Function to delete node from a BST
    public static Node deleteNode(Node root, int key)
    {
        // base case: key not found in tree
        if (root == null) {
            return null;
        }
 
        // if given key is less than the root node, recur for left subtree
        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        }
 
        // if given key is more than the root node, recur for right subtree
        else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        }
 
        // key found
        else
        {
            // Case 1: node to be deleted has no children (it is a leaf node)
            if (root.left == null && root.right == null) {
                // update root to null
                return null;
            }
 
            // Case 2: node to be deleted has two children
            else if (root.left != null && root.right != null)
            {
                // find its in-order predecessor node
                Node predecessor = inorder_predecessor(root.left);
 
                // Copy the value of predecessor to current node
                root.data = predecessor.data;
 
                // recursively delete the predecessor. Note that the
                // predecessor will have at-most one child (left child)
                root.left = deleteNode(root.left, predecessor.data);
            }
 
            // Case 3: node to be deleted has only one child
            else
            {
                // find child node
                Node child = (root.left != null) ? root.left: root.right;
                root = child;
            }
        }
 
        return root;
    }
 
    public static void main(String[] args)
    {
        Node root = null;
        int[] keys = { 15, 10, 20, 8, 12, 25 };
 
        for (int key : keys) {
            root = insert(root, key);
        }
 
        root = deleteNode(root, 12);
        inorder(root);
    }
}







