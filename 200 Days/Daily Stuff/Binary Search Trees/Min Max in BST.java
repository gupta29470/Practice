/*
1. Min element will be left most element of binary search tree
2. Max element will be right most element of binary search tree
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

        System.out.println(min(root));
        System.out.println(max(root));
    }
    
    public static int min(Nodes root){
        if (root == null){
            return Integer.MIN_VALUE;
        }
        
        Nodes temp = root;
        
        while (temp.left != null){
            temp = temp.left;
        }
        return temp.data;
    }
    
    public static int max(Nodes root){
        if (root == null){
            return Integer.MIN_VALUE;
        }
        
        Nodes temp = root;
        
        while (temp.right != null){
            temp = temp.right;
        }
        return temp.data;
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
