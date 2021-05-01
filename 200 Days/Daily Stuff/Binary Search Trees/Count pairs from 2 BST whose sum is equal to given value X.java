/*
************************* BRUTE FORCE ********************************
 1. Create static count variable.
 2. countPairs function:
	-> pass root1, root2 and x to preorderBST1 function
		-> preorderBST1 function:
			-> if root null then return
			-> For each node value "a" in BST 1, search the value (x – a) in BST 2. 
			   If value found then increment the count using searchinBST2 function
			-> traverse left for root1
			-> traverse right for root2
		-> searchinBST2 function:
			-> if root null then return null
			-> if current node.data == (x - a) then return root
			-> if (x - a) less than current node.data return turn left
			-> else turn right
 For each node value a in BST 1, search the value (x – a) in BST 2. 
 If value found then increment the count
*/

public class vit {

    static int count = 0;

    public static void main(String[] args) {

        /* Construct below tree
		          50
		        /   \
		       /     \
		      30      70
		     /\       / \
		    /  \     /   \
		   20   40  60    80
		              		                     
         
        Nodes root = new Nodes(50);
        root.left = new Nodes(30);
        root.right = new Nodes(70);
        root.left.left = new Nodes(20);
        root.left.right = new Nodes(40);
        root.right.left = new Nodes(60);
        root.right.right = new Nodes(80);
         */
        Nodes root1 = new Nodes(5);
        root1.left = new Nodes(3);
        root1.right = new Nodes(7);
        root1.left.left = new Nodes(2);
        root1.left.right = new Nodes(4);
        root1.right.left = new Nodes(6);
        root1.right.right = new Nodes(8);

        // formation of BST 2
        Nodes root2 = new Nodes(10);
        root2.left = new Nodes(6);
        root2.right = new Nodes(15);
        root2.left.left = new Nodes(3);
        root2.left.right = new Nodes(8);
        root2.right.left = new Nodes(11);
        root2.right.right = new Nodes(18);

        int X = 16;

        System.out.println(countPairs(root1, root2, X));

    }

    public static int countPairs(Nodes root1, Nodes root2, int X) {
        if (root1 == null || root2 == null) {
            return 0;
        }

        preorderBST1(root1, root2, X);

        return count;
    }
	
	// preorder traversal for BST 1
    public static void preorderBST1(Nodes root1, Nodes root2, int X) {
        if (root1 == null) {
            return;
        }
		
		// if (x -a) found then increment count
        Nodes temp = searchinBST2(root2, root1.data, X);
        if (temp != null) {
            count++;
        }

        preorderBST1(root1.left, root2, X);
        preorderBST1(root1.right, root2, X);
    }

    public static Nodes searchinBST2(Nodes root, int bst1, int X) {
        if (root == null) {
            return null;
        }
		
		// if found (x - a) return root
        if (root.data == (X - bst1)) {
            return root;
        }

        if ((X - bst1) < root.data) {
            return searchinBST2(root.left, bst1, X);
        } else {
            return searchinBST2(root.right, bst1, X);
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

/* Time complexity: O(n1 * h2), here n1 is number of nodes in first BST and h2 
is height of second BST.
*/



/*
************************** EFFICIENT APPROACH *****************************
1. countPairs function:
	-> create 2 stack for two BST's
	-> create count variable to track count of pairs
	-> create top1 and top2 of node type
	-> while true:
		-> traverse BST 1 as iterative inorder traversal
		-> traverse BST 2 as reverse iterative increment traversal
		-> if any of one stack is empty then break while loop
		-> initialize top1 = top element of stack1 and top2 = top element of
		stack 2
		-> if top1.data + top2.data == x then pop element from both stack
		and assign root1 = top1.right and root2 = top2.left to insert next possible
		node in stack
		-> else if top1.data + top2.data < x then pop element from stack1 and
		assign root1 = top1.right
		-> else pop element from stack2 and assign root2 = top2.left
		-> return count
*/

// Java implementation to count pairs from two
// BSTs whose sum is equal to a given  value x
import java.util.Stack;
public class GFG {
 
    // structure of a node of BST
    static class Node {
        int data;
        Node left, right;
         
        // constructor
        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
     
    static Node root1;
    static Node root2;
    // function to count pairs from two BSTs
    // whose sum is equal to a given value x
    static int countPairs(Node root1, Node root2,
                                           int x)
    {
        // if either of the tree is empty
        if (root1 == null || root2 == null)
            return 0;
      
        // stack 'st1' used for the inorder
        // traversal of BST 1
        // stack 'st2' used for the reverse
        // inorder traversal of BST 2
        //stack<Node*> st1, st2;
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        Node top1, top2;
      
        int count = 0;
      
        // the loop will break when either of two
        // traversals gets completed
        while (true) {
      
            // to find next node in inorder
            // traversal of BST 1
            while (root1 != null) {
                st1.push(root1);
                root1 = root1.left;
            }
      
            // to find next node in reverse
            // inorder traversal of BST 2
            while (root2 != null) {
                st2.push(root2);
                root2 = root2.right;
            }
      
            // if either gets empty then corresponding
            // tree traversal is completed
            if (st1.empty() || st2.empty())
                break;
      
            top1 = st1.peek();
            top2 = st2.peek();
      
            // if the sum of the node's is equal to 'x'
            if ((top1.data + top2.data) == x) {
                // increment count
                count++;
      
                // pop nodes from the respective stacks
                st1.pop();
                st2.pop();
      
                // insert next possible node in the
                // respective stacks
                root1 = top1.right;
                root2 = top2.left;
            }
      
            // move to next possible node in the
            // inoder traversal of BST 1
            else if ((top1.data + top2.data) < x) {
                st1.pop();
                root1 = top1.right;
            }
      
            // move to next possible node in the
            // reverse inoder traversal of BST 2
            else {
                st2.pop();
                root2 = top2.left;
            }
        }
      
        // required count of pairs
        return count;
    }
      
    // Driver program to test above
    public static void main(String args[])
    {
        // formation of BST 1
        root1 = new Node(5);       /*             5        */
        root1.left = new Node(3); /*           /   \      */
        root1.right = new Node(7); /*         3     7     */
        root1.left.left = new Node(2); /*    / \   / \    */
        root1.left.right = new Node(4); /*  2   4 6   8    */
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);
      
        // formation of BST 2
        root2 = new Node(10);        /*           10         */
        root2.left = new Node(6); /*           /   \        */
        root2.right = new Node(15); /*        6     15      */
        root2.left.left = new Node(3); /*    / \   /  \     */
        root2.left.right = new Node(8); /*  3  8  11  18    */
        root2.right.left = new Node(11);
        root2.right.right = new Node(18);
      
        int x = 16;
        System.out.println("Pairs = "
             + countPairs(root1, root2, x));
    }
}

// Time Complexity: O(n1 + n2) 
// Auxiliary Space: O(n1 + n2)