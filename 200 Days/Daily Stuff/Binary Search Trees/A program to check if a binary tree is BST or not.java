/*
Inorder traversal of BST returns sorted data. If given tree is BST then its previous
element is smaller than current element.
1. create global previous of Node type = null
2. perform inorder traversal of given tree.
	-> if you find current data is less than or equals to previous data (root.data <= previous.data) 
	then return false else return true
*/
public class vit {

    static Nodes prev = null;

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

        System.out.println(isBST(root));

    }

    public static boolean isBST(Nodes root) {
        if (root == null) {
            return true;
        }

        boolean left = isBST(root.left);

        if (prev != null && root.data <= prev.data) {
            return false;
        }

        prev = root;

        return left && isBST(root.right);
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
// Time --> O(n)   Space --> O(n)


/*
********************** APPROACH 2 ******************************
1. Passing root, Integer.MIN_VALUE and Integer.MAX_VALUE
2. isBST function
	-> if root is null then return null
	-> left tree contains minimum value than root and right tree contains 
	maximum value than root
	-> check if root.data < min or root.data > max return false
	-> then return 
		1. root, min, root.data - 1(for left tree)
		2. root, root.data + 1, max(for right tree)
*/

public class vit {

    static Nodes prev = null;

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

        System.out.println(isBST(root, Integer.MIN_VALUE, 
                Integer.MAX_VALUE));

    }

    public static boolean isBST(Nodes root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.data < min || root.data > max){
            return false;
        }
        
        return isBST(root.left, min, root.data - 1) && 
                isBST(root.right, root.data + 1, max);
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



