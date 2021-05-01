public class vit {

    static Nodes root;

    public static void main(String[] args) {
        root = new Nodes(15);
        root.left = new Nodes(10);
        root.right = new Nodes(20);
        root.left.left = new Nodes(8);
        root.left.right = new Nodes(12);
        root.right.left = new Nodes(16);
        root.right.right = new Nodes(25);

//        // construct second tree
//        Nodes y = new Nodes(15);
//        y.left = new Nodes(10);
//        y.right = new Nodes(20);
//        y.left.left = new Nodes(8);
//        y.left.right = new Nodes(12);
//        y.right.left = new Nodes(16);
//        y.right.right = new Nodes(25);
        Nodes roots = new Nodes(1);
        roots.left = new Nodes(2);
        roots.right = new Nodes(3);
        roots.left.right = new Nodes(4);
        roots.right.left = new Nodes(5);
        roots.right.right = new Nodes(6);
        roots.right.left.left = new Nodes(7);
        roots.right.left.right = new Nodes(8);

        int element1 = 4, element2 = 5;
        boolean result = findCousin(roots, element1, element2);

        if (result) {
            System.out.println("Yes, they are cousin");
        } else {
            System.out.println("No, they are not cousin");
        }

    }

    public static boolean findCousin(Nodes root, int element1, int element2) {
        if (root == null) {
            return false;
        }

        int level = 1;
        Nodes parent = null;

        NodeInfo node1 = new NodeInfo(element1, level, parent);
        NodeInfo node2 = new NodeInfo(element2, level, parent);

        level = 1;
        parent = null;

        inOrder(root, level, parent, node1, node2);

        return !(node1.level != node2.level || node1.parent == node2.parent);
    }

    public static void inOrder(Nodes root, int level, Nodes parent,
            NodeInfo node1, NodeInfo node2) {
        if (root == null) {
            return;
        }

        inOrder(root.left, level + 1, root, node1, node2);

        if (root.data == node1.data) {
            node1.level = level;
            node1.parent = parent;
        }

        if (root.data == node2.data) {
            node2.level = level;
            node2.parent = parent;
        }

        inOrder(root.right, level + 1, root, node1, node2);
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

class NodeInfo {

    int data, level;
    Nodes parent;

    public NodeInfo(int data, int level, Nodes parent) {
        this.data = data;
        this.level = level;
        this.parent = parent;
    }
}

// Time--> O(n)    Space O(h)






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
	// Data structure to store a Binary Tree node along
	// with its level and parent information
	static class NodeInfo
	{
		int key;
		int level;
		Node parent = null;

		NodeInfo(int key, int level, Node parent) {
			this.key = key;
			this.level = level;
			this.parent = parent;
		}
	}

	// Perform in-order traversal of the binary tree and update x and y
	public static void inorder(Node root, Node parent, int level, NodeInfo x, NodeInfo y)
	{
		// base case: tree is empty
		if (root == null) {
			return;
		}

		// traverse left subtree
		inorder(root.left, root, level + 1, x, y);

		// if first element is found, save its level and parent node
		if (root.key == x.key)
		{
			x.level = level;
			x.parent = parent;
		}

		// if second element is found, save its level and parent node
		if (root.key == y.key)
		{
			y.level = level;
			y.parent = parent;
		}

		// traverse right subtree
		inorder(root.right, root, level + 1, x, y);
	}

	// Function to determine if two given nodes are cousins of each other
	public static boolean iterative(Node root, int elem1, int elem2)
	{
		// return if tree is empty
		if (root == null) {
			return false;
		}

		int level = 1;				// level of root is 1
		Node parent = null;		// parent of root is null

		NodeInfo x = new NodeInfo(elem1, level, parent);
		NodeInfo y = new NodeInfo(elem2, level, parent);

		// perform in-order traversal of the array and update x and y
		inorder(root, null, 1, x, y);

		// return false if x and y have different level or same parent
		if (x.level != y.level || x.parent == y.parent) {
			return false;
		}

		return true;
	}

	public static void main(String[] args)
	{
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		if (iterative(root, 5, 6)) {
			System.out.print("Given nodes are cousins");
		} else {
			System.out.print("Given nodes are not cousins");
		}
	}
}