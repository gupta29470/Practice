/*
Simple solution is to traverse the binary tree in preorder fashion  and for 
each encountered node, we check whether the subtree rooted at the node is a 
BST or not. If the subtree is a BST, we calculate and return the size of the 
subtree rooted at the node. Otherwise, we return the maximum size BST returned 
by the left and right subtrees.
*/

// Data structure to store a BST node
class Node
{
    // stores value of this node
    int data;
 
    // stores left and right child pointer for this node
    Node left, right;
 
    // Constructor
    Node(int data) {
        this.data = data;
    }
}
 
class Main
{
    // Recursive function to calculate the size of a given binary tree
    public static int size(Node root)
    {
        // base case: empty tree has size 0
        if (root == null) {
            return 0;
        }
 
        // recursively calculate the size of left and right subtrees and
        // return sum of size of left and right subtrees + 1 (for root node)
        return size(root.left) + 1 + size(root.right);
    }
 
    // Recursive function to determine if given Binary Tree is a BST or not
    // by keeping a valid range (starting from [MIN_VALUE, MAX_VALUE]) and
    // keep shrinking it down for each node as we go down recursively
    public static boolean isBST(Node node, int min, int max)
    {
        // base case
        if (node == null)
            return true;
 
        // if node's value fall outside valid range
        if (node.data < min || node.data > max) {
            return false;
        }
 
        // recursively check left and right subtrees with updated range
        return isBST(node.left, min, node.data) &&
            isBST(node.right, node.data, max);
    }
 
    // Recursive function to find the size of the largest BST in a given binary tree
    public static int findLargestBST(Node root)
    {
        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return size(root);
        }
 
        return Math.max(findLargestBST(root.left), findLargestBST(root.right));
    }
 
    public static void main(String[] args)
    {
        /* Construct below binary tree
                  10
                /    \
               /      \
              15       8
             /  \     / \
            /    \   /   \
           12    20 5     2
        */
 
        Node root = new Node(10);
 
        root.left = new Node(15);
        root.right = new Node(8);
 
        root.left.left = new Node(12);
        root.left.right = new Node(20);
 
        root.right.left = new Node(5);
        root.right.right = new Node(2);
 
        System.out.println("The size of the largest BST is " + findLargestBST(root));
    }
}

// Time --> O(n^2)   Space --> O(h)



/*
*************************** EFFICIENT APPROACH ****************************

We can improve time complexity to "O(n)"  by traversing the tree in bottom-up 
manner where an information is exchanged between the child nodes and parent node 
which helps in determining if subtree rooted under any node is a BST or not 
in O(1) time.

1. Left and right subtrees of every tree node are BST.
2. The value of a node should be more than the largest value in the left subtree 
and less than the smallest value in the right subtree.

So to determine if a subtree rooted under a node is a BST or not, the left 
subtree should provide information about the maximum value in it and the right 
subtree should provide information about the minimum value in it. Also, 
parent node should be notified when both left and right child are also BST.

********************** In Easy Language ***************************
Current node will be part of BST when it is greater than maximum value in left tree
and smaller than minimum value in right tree

So we have create a class SubTreeInfo which stores minimum, maximum, size of BST
till now and to check current node is BST or not isBST boolean varibale

1. for current node we check :
	-> if current node is null then pass min = Integer.MAX_VALUE, 
	max = Integer.MIN_VALUE, size = 0, true(BST) because null parent is leaf node
	and for leaf node we have to return itself leaf node as minimum, maximum, 
	size + 1 and true(BST)

	-> traverse left
	-> traverse right
	-> initialize SubTreeInfo info = null for current node information.
	-> if it is greater than maximum value in left (left.max)
		and smaller than minimum value in right (right.min) then 
		info = we mark current node is true(BST) and increase size :
	-> else we pass :
		info = minimum value = 0, maximum value = 0, max BST size till now
		(Math.max(left.size, right.size), false(not BST) for current node.

Note: for leaf node it is returning itself leaf node as minimum, maximum, size + 1
and true(BST)
*/



// Data structure to store a BST node
class Node
{
    // stores value of this node
    int data;
 
    // stores left and right child pointer for this node
    Node left, right;
 
    // Constructor
    Node(int data)
    {
        this.data = data;
        this.left = this.right = null;
    }
}
 
// Data structure to store information about binary tree rooted under a node
class SubTreeInfo
{
    // stores the min and the max value in the binary tree rooted under the current node
    // min, max fields are relevant only if isBST flag is true
    int min, max;
 
    // stores the size of largest BST in binary tree rooted under the current node
    int size;
 
    // true if binary tree rooted under the current node is a BST
    boolean isBST;
 
    // Constructor
    SubTreeInfo(int min, int max, int size, boolean isBST)
    {
        this.min = min;
        this.max = max;
        this.size = size;
        this.isBST = isBST;
    }
}
 
class Main
{
    // Recursive function to find the size of the largest BST in a given binary tree
    public static SubTreeInfo findLargestBST(Node root)
    {
        // Base case: empty tree
        if (root == null) {
            return new SubTreeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }
 
        // Recur for left subtree and right subtrees
        SubTreeInfo left = findLargestBST(root.left);
        SubTreeInfo right = findLargestBST(root.right);
 
        SubTreeInfo info = null;
 
        // Check if binary tree rooted under the current root is a BST
 
        // 1. Left and right subtree are also BST
        // 2. The value of the root node should be more than the largest value
        //    in the left subtree
        // 3. The value of the root node should be less than the smallest value
        //    in the right subtree
        if (left.isBST && right.isBST &&
            (root.data > left.max && root.data < right.min))
        {
            info = new SubTreeInfo(Math.min(root.data, Math.min(left.min, right.min)),
                                Math.max(root.data, Math.max(left.max, right.max)),
                                left.size + 1 + right.size,
                                true);
        }
        else
        {
            // If binary tree rooted under the current root is not a BST
            // return the size of largest BST in its left and right subtree
 
            info = new SubTreeInfo(0, 0, Math.max(left.size, right.size), false);
        }
 
        return info;
    }
	
	// main function to find the size of the largest BST in a given binary tree
	public static int largestBSTInBinaryTree(Nodes root) {

        SubTreeInfo largestSize = findLargestBST(root);

        return largestSize.size;
    }
 
    public static void main(String[] args)
    {
        /* Construct below binary tree
                      10
                    /    \
                   /      \
                  15       8
                 / \      / \
                /   \    /   \
               12   20  5     9
              / \      / \     \
             /   \    /   \     \
            2    14  4    7     10
        */
 
        Node root = new Node(10);
 
        root.left = new Node(15);
        root.right = new Node(8);
 
        root.left.left = new Node(12);
        root.left.right = new Node(20);
        root.right.left = new Node(5);
        root.right.right = new Node(9);
 
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(14);
        root.right.left.left = new Node(4);
        root.right.left.right = new Node(7);
 
        root.right.right.right = new Node(10);
 
        System.out.print("The size of the largest BST is " +
                                largestBSTInBinaryTree);
    }
}

// Time --> O(n)   Space --> O(h)