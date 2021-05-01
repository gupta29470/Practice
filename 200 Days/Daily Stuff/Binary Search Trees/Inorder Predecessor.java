/*
********************* BRUTE FORCE APPROACH ******************************
*/

public class vit {

    static Nodes prev = null;

    public static void main(String[] args) {

        /* Construct below tree
		          4
		        /   \
		       /     \
		      2       6
		     /\       / \
		    /  \     /   \
		   1    3   5     7
		              		                     
         */
        Nodes root = new Nodes(4);
        root.left = new Nodes(2);
        root.right = new Nodes(6);
        root.left.left = new Nodes(1);
        root.left.right = new Nodes(3);
        root.right.left = new Nodes(5);
        root.right.right = new Nodes(7);

        inorder(root, 4);
        System.out.println(prev.data);
    }

    public static Nodes inorder(Nodes root, int pred) {
        if (root == null) {
            return null;
        }

        inorder(root.left, pred);

        // if we found key then we return previous element of key
        if (root.data == pred) { 
            return prev;
        } 
        // else we update prev
        else {
            prev = root;
        }

        return inorder(root.right, pred);

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


/*
************************* EFFICIENT ************************************
We have to deal with 2 cases:
Case 1: 
	->find key node means if key is given in "int" then find that node in "Nodes" type 
else do nothing.
	->if given node has left sub tree then go to left child and return right most element
of left child
Case 2:
	->if given node does not have left sub tree then search that given node from root and
the "node" where we take "last right" is the answer
*/


public class vit {

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

        Nodes pred = pred(root, 60);
        System.out.println(pred.data);
    }

    public static Nodes pred(Nodes root, int key) {
        if (root == null) {
            return null;
        }

        Nodes keyNode = findKeyNode(root, key);

        // if keyNode.left is not empty then return right most node of keyNode.left
        if (keyNode.left != null) {
            Nodes pred = case1(keyNode.left);
            return pred;
        } 
         // if keyNode.left == null then search that KeyNode from root and that node from where we take the last right
        else {
            Nodes pred = case2(root, key);
            return pred;
        }
    }

    public static Nodes findKeyNode(Nodes root, int key) {
        if (root == null) {
            return null;
        }

        if (root.data == key) {
            return root;
        }

        if (key < root.data) {
            return findKeyNode(root.left, key);
        } else {
            return findKeyNode(root.right, key);
        }
    }

    public static Nodes case1(Nodes keyNode) {
        Nodes temp = keyNode;

        while (temp.right != null) {
            temp = temp.right;
        }

        return temp;
    }

    public static Nodes case2(Nodes root, int key) {
        Nodes rightTurn = null;

        while (root.data != key) {
            // if root.data is big than key is small we turn to left
            if (key < root.data) {
                root = root.left;
            } 
            // if root.data is less than key we first store that root and move right
            else {
                rightTurn = root;
                root = root.right;
            }
        }

        return rightTurn;
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
