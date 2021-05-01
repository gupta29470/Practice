/*
1. list representation of binary tree(using level order). We can also do with 
recursion by entering left child on (index * 2 + 1) and right child on
(index * 2 + 2)

2. Using two loops we find max difference.
*/

public class vit {

    static Integer prev;

    public static void main(String[] args) {

        /* Construct below tree
              15
            /    \
           /      \
          10       20
         / \      /  \
        8   12   16  25
                /
               18
         */
        
        Nodes root = new Nodes(6);
        root.left = new Nodes(3);
        root.right = new Nodes(8);
        root.right.left = new Nodes(2);
        root.right.right = new Nodes(4);
        root.right.left.left = new Nodes(1);
        root.right.left.right = new Nodes(7);

        System.out.println(maxDiff(root));
    }

    public static int maxDiff(Nodes root) {
        if (root == null) {
            return 0;
        }

        // list representation of binary tree
        ArrayList<Integer> list = new ArrayList<>();

        //` using level order we store in list
        levelOrder(root, list, 0);

        // using 2 loops we are finding max difference
        return findMax(list);
    }

    // level order traversal to store tree in list
    public static void levelOrder(Nodes root, ArrayList<Integer> list, int index) {
        Queue<Nodes> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Nodes current = queue.poll();

            list.add(current.data);

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    // function to find max difference
    public static int findMax(ArrayList<Integer> list) {
        int max = 0;

        for (int index1 = 0; index1 < list.size(); index1++) {
            for (int index2 = index1 + 1; index2 < list.size(); index2++) {
                if (max < (list.get(index1) - list.get(index2))) {
                    max = list.get(index1) - list.get(index2);

                }
            }
        }
        return max;
    }

    public static int size(Nodes root) {
        if (root == null) {
            return 0;
        }

        return 1 + size(root.left) + size(root.right);
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

// Time -> O(n^2)    Space -> O(n)



/*
1. Create Wrapper class (Res) to pass variable as reference.
2. We traverse post order fashion.
	 1. if current node is null we return Integer.MAX_VALUE
	 2. if current node is leaf we return current node
	 3. for every root we have to calculate minimum value between left and right 
	 child in both left and right subtree
	 4. we are storing maximum difference in wrapper class variable(res.r)
	 5. at last we return minimum value of current node and minimum value of
	 left and right // return Math.min(val, Math.min(left, right)); 

*/



/* Java program to find maximum difference between node 
   and its ancestor */
   
// A binary tree node has key, pointer to left  
// and right child  
class Node  
{ 
    int key; 
    Node left, right; 
   
    public Node(int key)  
    { 
        this.key = key; 
        left = right = null; 
    } 
} 
   
/* Class Res created to implement pass by reference 
   of 'res' variable */
class Res  
{ 
    int r = Integer.MIN_VALUE; 
} 
   
public class BinaryTree  
{ 
    Node root; 
   
    /* Recursive function to calculate maximum ancestor-node 
       difference in  binary tree. It updates value at 'res' 
       to store the result.  The returned value of this function 
       is minimum value in subtree rooted with 't' */
    int maxDiffUtil(Node t, Res res)  
    { 
        /* Returning Maximum int value if node is not 
           there (one child case)  */
        if (t == null) 
            return Integer.MAX_VALUE; 
           
        /* If leaf node then just return node's value  */
        if (t.left == null && t.right == null) 
            return t.key; 
   
        /* Recursively calling left and right subtree 
           for minimum value  */
        int left = maxDiffUtil(t.left, res);
		int right = maxDiffUtil(t.right, res);
		
		// calculate difference for each time
		int differ = t.data - Math.min(left, right);
		
        /* Updating res if (node value - minimum value 
           from subtree) is bigger than res  */
        res.r = Math.max(res.r, differ); 
   
        /* Returning minimum value got so far */
        return Math.min(Math.min(left, right), t.data);
    } 
   
    /* This function mainly calls maxDiffUtil() */
    int maxDiff(Node root)  
    { 
        // Initialising result with minimum int value 
        Res res = new Res(); 
        maxDiffUtil(root, res); 
   
        return res.r; 
    } 
   
    /* Helper function to print inorder traversal of 
       binary tree   */
    void inorder(Node root)  
    { 
        if (root != null)  
        { 
            inorder(root.left); 
            System.out.print(root.key + ""); 
            inorder(root.right); 
        } 
    } 
   
    // Driver program to test the above functions 
    public static void main(String[] args)  
    { 
        BinaryTree tree = new BinaryTree(); 
   
        // Making above given diagram's binary tree 
        tree.root = new Node(8); 
        tree.root.left = new Node(3); 
        tree.root.left.left = new Node(1); 
        tree.root.left.right = new Node(6); 
        tree.root.left.right.left = new Node(4); 
        tree.root.left.right.right = new Node(7); 
   
        tree.root.right = new Node(10); 
        tree.root.right.right = new Node(14); 
        tree.root.right.right.left = new Node(13); 
   
        System.out.println("Maximum difference between a node and"
                + " its ancestor is : " + tree.maxDiff(tree.root)); 
    } 
} 