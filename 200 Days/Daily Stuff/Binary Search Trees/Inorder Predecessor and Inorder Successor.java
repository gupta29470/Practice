/*
To find predecessor and successor of given key in BST
1. Create global pred and succ of Nodes type and initialize as null
2. Function to find predecessor and successor
	-> if root is null then return null
	-> while root is not null 
		-> if root.data is equal to key then 
			1. Finding predecessor: check if root.left is not null, if it is not
			null then update pred = root.left and start a loop to find right 
			most element of pred
			2. Finding successor:check if root.right is not null, if it is not
			null then update succ = root.right and start a loop to find left 
			most element of succ
		
		-> else if key is less than root.data then update succ = root and root =
		root.left
		-> else if key is greater than root.data then update pred = root and root =
		root.right
*/

public class vit {

    static Nodes pred = null, succ = null;

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

        pred(root, 80);

        int preds = (pred != null) ? pred.data : -1;
        int succs = (succ != null) ? succ.data : -1;

        System.out.println(preds + " " + succs);
    }

    public static void pred(Nodes root, int key) {

        if (root == null) {
            return;
        }

        while (root != null) {
            if (root.data == key) {

                if (root.left != null) {
                    pred = root.left;

                    while (pred.right != null) {
                        pred = pred.right;
                    }
                }

                if (root.right != null) {
                    succ = root.right;

                    while (succ.left != null) {
                        succ = succ.left;
                    }
                }

                return;
            } else if (key < root.data) {
                succ = root;
                root = root.left;
            } else {
                pred = root;
                root = root.right;
            }
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
