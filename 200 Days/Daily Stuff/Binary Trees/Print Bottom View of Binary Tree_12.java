import java.util.Map;
import java.util.TreeMap;

// Data structure to store a Binary Tree node
class Node
{
	int key;
	Node left = null, right = null;

	Node(int key) {
		this.key = key;
	}
}

// Pair class
class Pair<U, V>
{
	public final U first;   	// first field of a Pair
	public final V second;  	// second field of a Pair

	// Constructs a new Pair with specified values
	private Pair(U first, V second)
	{
		this.first = first;
		this.second = second;
	}

	// Factory method for creating a Typed Pair immutable instance
	public static <U, V> Pair <U, V> of(U a, V b)
	{
		// calls private constructor
		return new Pair<>(a, b);
	}
}

class Main
{
	// Recursive function to do a pre-order traversal of the tree and fill the map
	// Here node has 'dist' horizontal distance from the root of the
	// tree and level represent level of the node

	public static void printBottom(Node root, int dist, int level,
								   Map<Integer, Pair<Integer, Integer>> map)
	{
		// base case: empty tree
		if (root == null) {
			return;
		}

		// if current level is more than or equal to maximum level seen so far
		// for the same horizontal distance or horizontal distance is seen for
		// the first time, update the map

		if (!map.containsKey(dist) || level >= map.get(dist).second)
		{
			// update value and level for current distance
			map.put(dist, Pair.of(root.key, level));
		}

		// recur for left subtree by decreasing horizontal distance and
		// increasing level by 1
		printBottom(root.left, dist - 1, level + 1, map);

		// recur for right subtree by increasing both level and
		// horizontal distance by 1
		printBottom(root.right, dist + 1, level + 1, map);
	}

	// Function to print the bottom view of given binary tree
	public static void printBottom(Node root)
	{
		// create a TreeMap where
		// key -> relative horizontal distance of the node from root node and
		// value -> pair containing node's value and its level
		// to sort according to distance
		Map<Integer, Pair<Integer, Integer>> map = new TreeMap<>();

		// do pre-order traversal of the tree and fill the map
		printBottom(root, 0, 0, map);

		// traverse the TreeMap and print bottom view
		for (Pair<Integer, Integer> it: map.values()) {
			System.out.print(it.first + " ");
		}
	}

	public static void main(String[] args)
	{
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.left.right = new Node(8);

		printBottom(root);
	}
}







import java.util.*;

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
		
        printBottom(root);
    }

    public static void printBottom(Nodes root) {
        if (root == null) {
            return;
        }

        int distance = 0, level = 0;

        // 1st parameter  distance
        // 2nd (a) data (b) level
        Map<Integer, Pair<Integer, Integer>> map = new TreeMap<>();

        storeBottom(root, level, distance, map);
        
        for (Pair<Integer, Integer> iterator : map.values()){
            System.out.print(iterator.first+" ");
        }
    }

    public static void storeBottom(Nodes root, int level, int distance,
            Map<Integer, Pair<Integer, Integer>> map) {
        if (root == null) {
            return;
        }

        if (!map.containsKey(distance) || level >= map.get(distance).second) {
            map.put(distance, Pair.of(root.data, level));
        }

        storeBottom(root.left, level + 1, distance - 1, map);
        storeBottom(root.right, level + 1, distance + 1, map);
    }

}

class Nodes {

    int data;
    Nodes left, right;

    public Nodes(int data) {
        this.data = data;
        left = right = null;
    }
}

class Pair<U, V> {

    U first;
    V second;

    private Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    // static factory method to create immutable instance
    // because we need to call same structured constructer very often
    public static <U, V> Pair<U, V> of(U first, V second) { // can give any method name
        return new Pair(first, second);
    }
}
// Time --> O(nlogn)   Space --> O(n)



import java.util.*; 
import java.util.Map.Entry; 
  
// Tree node class 
class Node 
{ 
    int data; //data of the node 
    int hd; //horizontal distance of the node 
    Node left, right; //left and right references 
  
    // Constructor of tree node 
    public Node(int key) 
    { 
        data = key; 
        hd = Integer.MAX_VALUE; 
        left = right = null; 
    } 
} 
  
//Tree class 
class Tree 
{ 
    Node root; //root node of tree 
  
    // Default constructor 
    public Tree() {} 
  
    // Parameterized tree constructor 
    public Tree(Node node) 
    { 
        root = node; 
    } 
  
    // Method that prints the bottom view. 
    public void bottomView() 
    { 
        if (root == null) 
            return; 
  
        // Initialize a variable 'hd' with 0 for the root element. 
        int hd = 0; 
  
        // TreeMap which stores key value pair sorted on key value 
        Map<Integer, Integer> map = new TreeMap<>(); 
  
         // Queue to store tree nodes in level order traversal 
        Queue<Node> queue = new LinkedList<Node>(); 
  
        // Assign initialized horizontal distance value to root 
        // node and add it to the queue. 
        root.hd = hd; 
        queue.add(root); 
  
        // Loop until the queue is empty (standard level order loop) 
        while (!queue.isEmpty()) 
        { 
            Node temp = queue.remove(); 
  
            // Extract the horizontal distance value from the 
            // dequeued tree node. 
            hd = temp.hd; 
  
            // Put the dequeued tree node to TreeMap having key 
            // as horizontal distance. Every time we find a node 
            // having same horizontal distance we need to replace 
            // the data in the map. 
            map.put(hd, temp.data); 
  
            // If the dequeued node has a left child add it to the 
            // queue with a horizontal distance hd-1. 
            if (temp.left != null) 
            { 
                temp.left.hd = hd-1; 
                queue.add(temp.left); 
            } 
            // If the dequeued node has a left child add it to the 
            // queue with a horizontal distance hd+1. 
            if (temp.right != null) 
            { 
                temp.right.hd = hd+1; 
                queue.add(temp.right); 
            } 
        } 
  
        // Extract the entries of map into a set to traverse 
        // an iterator over that. 
        Set<Entry<Integer, Integer>> set = map.entrySet(); 
  
        // Make an iterator 
        Iterator<Entry<Integer, Integer>> iterator = set.iterator(); 
  
        // Traverse the map elements using the iterator. 
        while (iterator.hasNext()) 
        { 
            Map.Entry<Integer, Integer> me = iterator.next(); 
            System.out.print(me.getValue()+" "); 
        } 
    } 
} 
  
// Main driver class 
public class BottomView 
{ 
    public static void main(String[] args) 
    { 
        Node root = new Node(20); 
        root.left = new Node(8); 
        root.right = new Node(22); 
        root.left.left = new Node(5); 
        root.left.right = new Node(3); 
        root.right.left = new Node(4); 
        root.right.right = new Node(25); 
        root.left.right.left = new Node(10); 
        root.left.right.right = new Node(14); 
        Tree tree = new Tree(root); 
        System.out.println("Bottom view of the given binary tree:"); 
        tree.bottomView(); 
    } 
} 