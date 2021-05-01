/*
Find Maximum sum path.
We have to handle three cases:
	1. Current node is in path of maximum sum 

	2. Current node is root of maximum sum path
		
	3. Current node is not in path of maximum sum path.

We will travel in post order fashion
*/

// Leetcode
class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null){
            return -1;
        }
        
        Maximum max = new Maximum(); // for passing call by reference
        
        maxPathSumUtil(root, max);
        
        return max.max;
    }
    
    public int maxPathSumUtil(TreeNode root, Maximum max){
        if (root == null){
            return 0;
        }
        
		//post order fashion
        int left = maxPathSumUtil(root.left, max); 
        int right = maxPathSumUtil(root.right, max);
        
		// case 1:
        int sumPath = Math.max(Math.max(left, right) + root.val, root.val);
		
		// case 2 and 3:
        int sumRoot = Math.max(sumPath, left + right + root.val);
        
		// keeping track of maximum till now
        max.max = Math.max(max.max, sumRoot);
        
		// we return sumPath for traversing up
        return sumPath;
    }
}

class Maximum{
    int max = Integer.MIN_VALUE;
}



public class vit {

    static Integer prev;

    public static void main(String[] args) {

        /* Construct below tree
              1
            /   \
           /     \
          2       3
           \     / \
           4   5   6
               / \
              7   8
         */
        Nodes root = new Nodes(1);
        root.left = new Nodes(2);
        root.right = new Nodes(3);
        root.left.right = new Nodes(-4);
        root.right.left = new Nodes(5);
        root.right.right = new Nodes(6);
        root.right.left.left = new Nodes(7);
        root.right.left.right = new Nodes(8);

        System.out.println(maxSum(root));
    }

    public static int maxSum(Nodes root) {
        if (root == null) {
            return 0;
        }

        Maximum max = new Maximum();

        maxSumUtil(root, max);
        
        return max.max;
    }

    public static int maxSumUtil(Nodes root, Maximum max) {
        if (root == null){
            return 0;
        }
        
        int left = maxSumUtil(root.left, max);
        int right = maxSumUtil(root.right, max);
        
        int sumPath = Math.max(Math.max(left, right) + root.data, root.data);
        
        int sumRoot = Math.max(sumPath, left + right + root.data);
        
        max.max = Math.max(max.max, sumRoot);
        
        return sumPath;
    }

    public static void inorder(Nodes node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

}

class Maximum {

    int max = Integer.MIN_VALUE;
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

