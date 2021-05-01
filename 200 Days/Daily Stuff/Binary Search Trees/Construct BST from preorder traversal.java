/*
*************************** BRUTE FORCE ***************************
1. create global index to extract value from array
2. constructBST function:
	-> initialize size = array.size, low = 0, high = size - 1
	-> pass(preorder array, low, high, size) to another function
	-> Another function:
		-> if index >= size or low > high return null
		-> first element of preorder array is root so, Node root = new Node
		(preorder[index])
		-> if low == high then there is no child left return root, if this condition
		false then
		-> As per preorder it visits root then left tree and then right tree.
		In BST left tree has  smaller elements than root and right tree has 
		greater elements than root. create ind variable to store index of
		start of right tree.
		So using loop and find the first immediate element greater than root
		if found then break loop
		-> build left tree = root.left = constructBST(preorder, index, ind - 1, size)
		-> build right tree = root.right = constructBST(preorder, ind, high, size)
		
*/

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

        int[] preorder = {50, 30, 20, 40, 70, 60, 80};

        root = constructBST(preorder);
        
        preorder(root);

    }

    public static Nodes constructBST(int[] preorder) {
        int size = preorder.length;

        int low = 0, high = size - 1;
        return constructBST(preorder, low, high, size);
    }

    public static Nodes constructBST(int[] preorder, int low, int high,
            int size) {
        if (index >= size || low > high) {
            return null;
        }
		
		// The first node in preorder traversal is root. So
        // take the node at index from preorder[] and make it
        // root, and increment index
        Nodes root = new Nodes(preorder[index]);
        index = index + 1;
		
		// If the current subarry has only one element, no
        // need to recur
        if (low == high) {
            return root;
        }
		
		// Search for the first element greater than root
        int ind;

        for (ind = low; ind <= high; ind++) {
            if (preorder[ind] > root.data) {
                break;
            }
        }
		
		// Use the index of element found in preorder to
        // divide preorder array in two parts. Left subtree
        // and right subtree
        root.left = constructBST(preorder, index, ind - 1, size);

        root.right = constructBST(preorder, ind, high, size);

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

// Time --> O(n^2)   Space --> O(1)(recursive stack --> O(n)



/*
The trick is to set a range {min .. max} for every node. Initialize the range as 
{INT_MIN .. INT_MAX}. The first node will definitely be in range, so create root 
node. To construct the left subtree, set the range as {INT_MIN …root->data}. 
If a values is in the range {INT_MIN .. root->data}, the values is part part of 
left subtree. To construct the right subtree, set the range as 
{root->data..max .. INT_MAX}. 
*/
class Node 
{
 
    int data;
    Node left, right;
 
    Node(int d)
    {
        data = d;
        left = right = null;
    }
}
 
class BinaryTree 
{
 
    int index = 0;
 
    // A recursive function to construct BST from pre[].
    // preIndex is used to keep track of index in pre[].
    Node constructTreeUtil(int pre[], int key, int min, int max,
                           int size)
    {
 
        // Base case
        if (index >= size) 
        {
            return null;
        }
 
        Node root = null;
 
        // If current element of pre[] is in range, then
        // only it is part of current subtree
        if (key > min && key < max) 
        {
 
            // Allocate memory for root of this
            // subtree and increment *preIndex
            root = new Node(key);
            index = index + 1;
 
            if (preIndex.index < size) 
            {
 
                // Construct the subtree under root
                // All nodes which are in range {min .. key}
                // will go in left subtree, and first such
                // node will be root of left subtree.
                root.left = constructTreeUtil(
                    pre, pre[index], min,
                    key, size);
            }
            if (preIndex.index < size) 
            {
                // All nodes which are in range {key..max}
                // will go in right subtree, and first such
                // node will be root of right subtree.
                root.right = constructTreeUtil(
                    pre, pre[index], key,
                    max, size);
            }
        }
 
        return root;
    }
 
    // The main function to construct BST from given
    // preorder traversal. This function mainly uses
    // constructTreeUtil()
    Node constructTree(int pre[], int size)
    {
        int size = preorder.length;

        int key = preorder[0];

        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;

        return constructBSTTreeUtil(preorder, key, min, max, size);
    }
 
    // A utility function to print inorder traversal of a
    // Binary Tree
    void printInorder(Node node)
    {
        if (node == null) 
        {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
 
    // Driver code
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        int pre[] = new int[] { 10, 5, 1, 7, 40, 50 };
        int size = pre.length;
       
        // Function call
        Node root = tree.constructTree(pre, size);
        System.out.println(
            "Inorder traversal of the constructed tree is ");
        tree.printInorder(root);
    }
}

// Time --> O(n)   Space --> O(1)(recursive stack --> O(n)




/*
*************************** EFFICIENT *******************************
We already know how to build BST from valid preorder. So we gonna use efficient 
technique to to build BST from valid preorder as we had done before

But return type of validPreorder is boolean as we check if global index is equal
to preorder array.
1. If yes that means that given array is valid preorder and we have build BST and
index will be equal to array size
2. If not that means that given array is not valid preorder as it array is 
invalid and it voilates preoperty of BST so we have return in middle of array
*/

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

        int array[] = {50, 30, 20, 40, 70, 60, 80};

        System.out.println(validPreorder(array));
    }

    public static boolean validPreorder(int[] array) {

        int min = 1, max = Integer.MAX_VALUE, size = array.length;

        buildBST(array, min, max, size);

        return index == size;
    }

    public static Nodes buildBST(int[] array, int min, int max, int size) {
        if (index >= size) {
            return null;
        }

        Nodes root = null;

        if (min < array[index] && array[index] < max) {
            root = new Nodes(array[index]);
            index += 1;

            if (index < size) {
                root.left = buildBST(array, min, root.data - 1, size);
            }
            if (index < size) {
                root.right = buildBST(array, root.data + 1, max, size);
            }
        }
        return root;
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

