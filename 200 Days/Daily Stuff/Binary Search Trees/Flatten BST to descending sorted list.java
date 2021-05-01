/*
1. create previous and head of node type to track of previous node and first node
2. flattenBSTToSortedList function: passing root
	-> flattenBSTToSortedListUtil function: traverse reverse inorder fashion
	-> if root null then return null
	-> traverse right
	-> if head and previous is null means it is largest node or right most node
	then update head = root and previous = root : else assign root to 
	previous.left and update previous = previous.left
	-> traverse left
	-> return head
*/

public class vit {

    static Nodes previous = null, head = null;

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

        Nodes result = flattenBSTToSortedList(root);

        print(result);
    }

    public static Nodes flattenBSTToSortedList(Nodes root) {
        if (root == null) {
            return null;
        }

        Nodes result = flattenBSTToSortedListUtil(root);

        return result;
    }

    public static Nodes flattenBSTToSortedListUtil(Nodes root) {
        if (root == null) {
            return null;
        }

        flattenBSTToSortedListUtil(root.right);

        if (previous == null && head == null) {
            previous = root;
            head = root;
        } else {
            previous.left = root;
            previous = previous.left;
        }

        flattenBSTToSortedListUtil(root.left);

        return head;
    }

    public static void print(Nodes root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        print(root.left);
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

// Time --> O(n)    Space --> O(h)