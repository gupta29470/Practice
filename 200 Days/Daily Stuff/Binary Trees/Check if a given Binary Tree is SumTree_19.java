

public class vit {

    //static Nodes root;

    public static void main(String[] args) {
        Nodes roots = new Nodes(1);
        roots.left = new Nodes(2);
        roots.right = new Nodes(3);
        roots.left.right = new Nodes(4);
        roots.right.left = new Nodes(5);
        roots.right.right = new Nodes(6);
        roots.right.left.left = new Nodes(7);
        roots.right.left.right = new Nodes(8);

        Nodes root = new Nodes(44);
        root.left = new Nodes(9);
        root.right = new Nodes(13);
        root.left.left = new Nodes(4);
        root.left.right = new Nodes(5);
        root.right.left = new Nodes(6);
        root.right.right = new Nodes(7);

        int result = sum_Tree(roots);
        if (result == 1){
            System.out.println("Yes it is a sum tree");
        }
        else{
            System.out.println("No it is not a sum tree");
        }
    }

    public static int sum_Tree(Nodes root) {
       if (root == null){
           return 0;
       }
       
       if (root.left == null && root.right == null){
           return 1;
       }
       
       int leftSum = add_AllNodes(root.left);
       int rightSum = add_AllNodes(root.right);
       
       int total = leftSum + rightSum;
       if (total == root.data){
           if ((sum_Tree(root.left) != 0) && (sum_Tree(root.right) != 0)){
               return 1;
           }
       }
       return 0;
    }

    public static int add_AllNodes(Nodes root) {
        if (root == null) {
            return 0;
        }
        int sum = root.data + add_AllNodes(root.left) + add_AllNodes(root.right);

        return sum;
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
// Time --> O(n)   Space --> O(h)



// Optimized
// Data structure to store a Binary Tree node
class Node
{
	int key;
	Node left = null, right = null;

	Node(int key) {
		this.key = key;
	}
}

class Main
{
	// Recursive function to check if given binary tree is a sum tree or not
	public static int isSumTree(Node root)
	{
		// base case: empty tree
		if (root == null) {
			return 0;
		}

		// special case: leaf node
		if (root.left == null && root.right == null) {
			return root.key;
		}

		// if root's value is equal to sum of all elements present in its
		// left and right subtree
		if (root.key == isSumTree(root.left) + isSumTree(root.right)) {
			return 2 * root.key;
		}

		return Integer.MIN_VALUE;
	}

	public static void main(String[] args)
	{
	    /* Construct below tree
		         44
		        /  \
		       /    \
		      9     13
		     / \    / \
		    4   5  6   7
	    */

		Node root = new Node(44);
		root.left = new Node(9);
		root.right = new Node(13);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		if (isSumTree(root) != Integer.MIN_VALUE) {
			System.out.print("Yes");
		} else {
			System.out.print("No");
		}
	}
}

// Time --> O(n)   Space --> O(h)