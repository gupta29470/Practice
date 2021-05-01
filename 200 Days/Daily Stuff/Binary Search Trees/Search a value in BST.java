/*
*************************** ITERATIVE *************************************
1. Finding the parent of given key
2. if key < parent.data then return key must be on left of parent return parent.letf
3. else return parent.right
*/

public class vit {

    static Integer prev;

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

        int key = 7;
        Nodes result = search(root, key);

        if (result.data == key) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public static Nodes search(Nodes root, int key) {
        if (root == null){
            return root;
        }
        
        Nodes current = root, parent = null;
        
        while (current != null && current.data != key){
            parent = current;
            
            if (key < current.data){
                current = current.left;
            }
            else{
                current = current.right;
            }
        }
        
        if (key < parent.data){
           return parent.left;
        }
        else{
            return parent.right;
        }
    }

    public static void inorder(Nodes root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
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


// *********************** RECURSIVE ******************************

public class vit {

    static Integer prev;

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

        int key = 7;
        Nodes result = search(root, key);

        if (result.data == key) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public static Nodes search(Nodes root, int key) {
        if (root == null || root.data == key){
            return root;
        }
        
        if (key < root.data){
            return search(root.left, key);
        }
        
        else{
            return search(root.right, key);
        }
    }

    public static void inorder(Nodes root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
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

