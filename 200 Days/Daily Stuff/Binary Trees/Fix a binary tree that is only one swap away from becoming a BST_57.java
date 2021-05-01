/*
We know that an in-order traversal of a binary search tree returns the nodes in 
sorted order.
1. Create NodeWrapper class and create two constructor:
	-> One with no arguement
	-> Second with int arguement
2. Create 3 objects of NodeWrapper class
	-> Object 1 : swap1
	-> Object 2 : swap2
	-> Object 3 : previous (with int constructor : passing MIN_VALUE)
3. Passing (root, swap1, swap2, previous) to util function.
4. Traverse in inorder fashion:
	-> if root null : return
	-> traverse left
	-> if root.data < previous.node.data(current < previous) then
		--> if swap1 is null then swap1.node = prev(swap1 = previous node)
		--> swap2 = root(swap2 will be current node)
	-> updating previous.node = root(previous = current)
	-> travserse right
5. return to function then check:
	-> if swap1.node != null && swap2.node != null(swap1 and swap2 is not null)
		-> swap(swap1.node.data, swap2.node.data)
*/

// class to store a Binary Tree node
class Node {
    int data;
    Node left, right;
 
    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
 
class Main
{
    // Wrapper over the Node class
    static class NodeWrapper {
        public Node node;
 
        NodeWrapper() {
            this.node = null;
        }
 
        NodeWrapper(int data) {
            this.node = new Node(data);
        }
    }
 
    // Function to perform in-order traversal of the tree
    public static void inorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
 
    // Function to exchange data of given linked list nodes
    public static void swapData(Node first, Node second)
    {
        int data = first.data;
        first.data = second.data;
        second.data = data;
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
 
    // Recursive function to fix a binary tree that is only one swap
    // away from becoming a BST. Here, prev is previous processed node in
    // in-order traversal and x, y stores node to be swapped (if any)
    public static void correctBST(Node root, NodeWrapper x, NodeWrapper y, NodeWrapper prev)
    {
        // base case
        if (root == null) {
            return;
        }
 
        // recur for left subtree
        correctBST(root.left, x, y, prev);
 
        // if current node is less than the previous node
        if (root.data < prev.node.data)
        {
            // if this is first occurrence, update x and y to previous node
            // and current node respectively
            if (x.node == null) {
                x.node = prev.node;
            }
 
            // if this is second occurrence, update y to current node
            y.node = root;
        }
 
        // update previous node and recur for right subtree
        prev.node = root;
        correctBST(root.right, x, y, prev);
    }
 
    // Fix given binary tree that is only one swap away from becoming a BST
    public static void correctBST(Node root)
    {
        // Wrap x, y, prev nodes so their reference can be changed
        // inside the correctBST() method
 
        // x and y stores node to be swapped
        NodeWrapper x = new NodeWrapper();
        NodeWrapper y = new NodeWrapper();
 
        // stores previous processed node in in-order traversal
        // initialize it by minus infinity
        NodeWrapper prev = new NodeWrapper(Integer.MIN_VALUE);
 
        // fix the binary tree
        correctBST(root, x, y, prev);
 
        // swap the nodes
        if (x.node != null && y.node != null ) {
            swapData(x.node, y.node);
        }
    }
 
    public static void main(String[] args)
    {
        Node root = null;
        /* Construct below BST
                  15
                /    \
               /      \
              10       20
             /  \     /  \
            /    \   /    \
           8     12 16    25
        */
 
        int[] keys = {15, 10, 20, 8, 12, 16, 25};
 
        for (int key : keys) {
            root = insert(root, key);
        }
 
        // swap any two nodes values
        swapData(root.left, root.right.right);
 
        // fix the BST
        correctBST(root);
 
        // print the BST after fixing it
        inorder(root);
    }
}